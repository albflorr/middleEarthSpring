    # D&D 5e Character Generator

Generador de personajes de **Dungeons & Dragons 5ª edición (2024)** con 3 microservicios independientes, arquitectura hexagonal y Spring Boot 3.4.1.

## Stack tecnológico ST

| Componente | Versión |
|---|---|
| Java | 17 |
| Spring Boot | 3.4.1 |
| Spring Data JPA | Hibernate 6 |
| MySQL | 8+ (mysql-connector-j) |
| Frontend | HTML + CSS + JS vanilla |
| Build | Maven multi-módulo |

## Arquitectura

```
middleEarthSpring_JPA/
├── pom.xml                          # POM padre multi-módulo
├── shared/                          # DTOs compartidos (JAR, no ejecutable)
├── character-service/               # Microservicio principal (puerto 8081)
├── race-service/                    # Microservicio de razas (puerto 8082)
└── class-service/                   # Microservicio de clases (puerto 8083)
```

Cada microservicio sigue **Arquitectura Hexagonal (Ports & Adapters)**:

```
┌─────────────────────────────────────────┐
│  Infrastructure                          │
│  ┌───────────────────────────────────┐   │
│  │  Application                      │   │
│  │  ┌─────────────────────────────┐   │   │
│  │  │  Domain                     │   │   │
│  │  │  (entities, value objects)   │   │   │
│  │  └─────────────────────────────┘   │   │
│  │  ┌──────────┐  ┌───────────────┐   │   │
│  │  │  Input   │  │ Output Ports   │   │   │
│  │  │  Ports   │  │ (interfaces)   │   │   │
│  │  └──────────┘  └───────────────┘   │   │
│  └───────────────────────────────────┘   │
│  ┌──────────────┐  ┌─────────────────┐   │
│  │  Controllers  │  │ JPA / HTTP      │   │
│  └──────────────┘  └─────────────────┘   │
└─────────────────────────────────────────┘
```

### Comunicación inter-servicios

```
character-service (8081) ──HTTP──▶ race-service (8082)  GET /api/races/name/{name}
character-service (8081) ──HTTP──▶ class-service (8083) GET /api/classes/name/{name}
```

## Bases de datos

Se requieren 3 bases de datos MySQL independientes:

```sql
CREATE DATABASE dnd_character_db;
CREATE DATABASE dnd_race_db;
CREATE DATABASE dnd_class_db;
```

JPA crea las tablas automáticamente con `spring.jpa.hibernate.ddl-auto=update`.

## Microservicios

### character-service (puerto 8081)

Obtiene raza y clase vía HTTP, genera estadísticas (Standard Array o 4d6 drop lowest), aplica bonuses raciales y persiste el personaje.

| Método | Endpoint | Body | Descripción |
|--------|----------|------|-------------|
| `POST` | `/api/characters` | `{"name":"Gimli","race":"Dwarf","className":"Fighter","method":"standard"}` | Crear personaje |
| `GET` | `/api/characters` | - | Listar personajes |
| `GET` | `/api/characters/{id}` | - | Obtener por ID |

**Métodos de generación:**
- `standard` — Baraja `[15, 14, 13, 12, 10, 8]` aleatoriamente
- `rolled` — 4d6 descartando el menor, 6 veces

### race-service (puerto 8082)

CRUD de razas con bonuses de habilidad (STR, DEX, CON, INT, WIS, CHA).

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/races` | Crear raza |
| `GET` | `/api/races` | Listar razas |
| `GET` | `/api/races/{id}` | Obtener por ID |
| `GET` | `/api/races/name/{name}` | Obtener por nombre |

**Razas incluidas:** Dwarf, Elf, Halfling, Human, Dragonborn, Gnome, Half-Elf, Half-Orc, Tiefling.

### class-service (puerto 8083)

CRUD de clases (hit die, primary ability, saving throws).

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/classes` | Crear clase |
| `GET` | `/api/classes` | Listar clases |
| `GET` | `/api/classes/{id}` | Obtener por ID |
| `GET` | `/api/classes/name/{name}` | Obtener por nombre |

**Clases incluidas:** Barbarian, Bard, Cleric, Druid, Fighter, Monk, Paladin, Ranger, Rogue, Sorcerer, Warlock, Wizard.

## Frontend

Interface web en `http://localhost:8081` con 3 pestañas:
- **Races** — Crear y listar razas
- **Classes** — Crear y listar clases
- **Characters** — Generar personajes seleccionando raza/clase y método

## Requisitos previos

- JDK 17
- MySQL 8+ en `localhost:3306`
- Maven

## Ejecución

```bash
# Compilar todo
mvn clean install -DskipTests

# Iniciar servicios (3 terminales separadas, en este orden):
cd race-service       && mvn spring-boot:run   # Puerto 8082
cd class-service      && mvn spring-boot:run   # Puerto 8083
cd character-service  && mvn spring-boot:run   # Puerto 8081

# Abrir navegador en http://localhost:8081
```

### Poblar datos iniciales

```bash
# Razas
curl -X POST http://localhost:8082/api/races -H "Content-Type: application/json" -d "{\"name\":\"Dwarf\",\"description\":\"Hardy folk\",\"strengthBonus\":2,\"dexterityBonus\":0,\"constitutionBonus\":2,\"intelligenceBonus\":0,\"wisdomBonus\":0,\"charismaBonus\":0,\"traits\":\"Darkvision, Dwarven Resilience\"}"

curl -X POST http://localhost:8082/api/races -H "Content-Type: application/json" -d "{\"name\":\"Human\",\"description\":\"Adaptable\",\"strengthBonus\":1,\"dexterityBonus\":1,\"constitutionBonus\":1,\"intelligenceBonus\":1,\"wisdomBonus\":1,\"charismaBonus\":1,\"traits\":\"Skillful, Versatile\"}"

# Clases
curl -X POST http://localhost:8083/api/classes -H "Content-Type: application/json" -d "{\"name\":\"Fighter\",\"description\":\"Master of combat\",\"hitDie\":10,\"primaryAbility\":\"Strength\",\"savingThrows\":\"STR, CON\"}"

# Personaje de prueba
curl -X POST http://localhost:8081/api/characters -H "Content-Type: application/json" -d "{\"name\":\"Gimli\",\"race\":\"Dwarf\",\"className\":\"Fighter\",\"method\":\"standard\"}"
```

## Tests

```bash
mvn test -pl character-service
```

## Documentación adicional

- `guia.md` — Guía de transformación del monolito original a microservicios
- `GUIA_CLASES.md` — Paso a paso para replicar el proyecto en clases
