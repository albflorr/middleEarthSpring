const API_BASE = 'http://localhost:9091';

// Cargar lista al iniciar
document.addEventListener('DOMContentLoaded', function() {
    cargarPersonajes();
});

// Manejar formulario
document.getElementById('formPersonaje').addEventListener('submit', function(e) {
    e.preventDefault();
    
    if (!validarFormulario()) return;
    
    const nombre = document.getElementById('nombre').value.trim();
    const raza = document.getElementById('raza').value;
    
    mostrarMensaje('Generando personaje...', 'info');
    
    fetch(`${API_BASE}/generar`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ 
            nombre: nombre, 
            raza: raza 
        })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Error ${response.status}: ${response.statusText}`);
        }
        return response.json();
    })
    .then(data => {
        mostrarMensaje('¡Personaje generado exitosamente!', 'success');
        document.getElementById('formPersonaje').reset();
        cargarPersonajes();  // Recarga lista
    })
    .catch(error => {
        console.error('Error:', error);
        mostrarMensaje('Error al generar personaje: ' + error.message, 'error');
    });
});

function cargarPersonajes() {
    fetch(`${API_BASE}/personajes`)
    .then(response => {
        if (!response.ok) {
            throw new Error(`Error ${response.status}`);
        }
        return response.json();
    })
    .then(personajes => {
        const tbody = document.getElementById('cuerpoTabla');
        tbody.innerHTML = '';
        
        if (personajes.length === 0) {
            tbody.innerHTML = '<tr><td colspan="5">No hay personajes</td></tr>';
            return;
        }
        
        personajes.forEach(p => {
            const fila = document.createElement('tr');
            fila.innerHTML = `
                <td>${p.nombre || 'N/A'}</td>
                <td>${p.tipoRaza || 'N/A'}</td>
                <td>${p.habilidadEspecial || 'N/A'}</td>
                <td>${p.estrategia?.habilidadEspecial || 'N/A'}</td>
                <td>
                    Ag:${p.atributos?.agilidad || 0}, 
                    Fue:${p.atributos?.fuerza || 0}, 
                    Sig:${p.atributos?.sigilo || 0}, 
                    Val:${p.atributos?.valor || 0}
                </td>
            `;
            tbody.appendChild(fila);
        });
    })
    .catch(error => {
        console.error('Error cargando personajes:', error);
        document.getElementById('cuerpoTabla').innerHTML = 
            '<tr><td colspan="5" style="color:red;">Error cargando datos</td></tr>';
    });
}

function validarFormulario() {
    const nombre = document.getElementById('nombre').value.trim();
    if (!nombre) {
        mostrarMensaje('El nombre es requerido', 'error');
        return false;
    }
    return true;
}

function mostrarMensaje(texto, tipo) {
    const mensaje = document.getElementById('mensaje');
    mensaje.textContent = texto;
    mensaje.className = tipo;
    setTimeout(() => {
        mensaje.textContent = '';
        mensaje.className = '';
    }, 4000);
}