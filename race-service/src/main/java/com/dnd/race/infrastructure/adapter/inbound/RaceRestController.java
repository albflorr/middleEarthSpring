package com.dnd.race.infrastructure.adapter.inbound;

import com.dnd.race.application.port.input.RaceUseCase;
import com.dnd.shared.RaceDTO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/races")
public class RaceRestController {

    private final RaceUseCase raceUseCase;

    public RaceRestController(RaceUseCase raceUseCase) {
        this.raceUseCase = raceUseCase;
    }

    @PostMapping
    public RaceDTO createRace(@RequestBody RaceDTO raceDTO) {
        return raceUseCase.createRace(raceDTO);
    }

    @GetMapping
    public List<RaceDTO> getAllRaces() {
        return raceUseCase.getAllRaces();
    }

    @GetMapping("/{id}")
    public RaceDTO getRaceById(@PathVariable Long id) {
        return raceUseCase.getRaceById(id);
    }

    @GetMapping("/name/{name}")
    public RaceDTO getRaceByName(@PathVariable String name) {
        return raceUseCase.getRaceByName(name);
    }
}
