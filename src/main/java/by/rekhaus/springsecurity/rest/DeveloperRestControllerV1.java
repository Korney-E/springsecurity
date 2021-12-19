package by.rekhaus.springsecurity.rest;

import by.rekhaus.springsecurity.model.Developer;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.*;

@RestController
@RequestMapping ("/api/v1/developers")
public class DeveloperRestControllerV1 {

    private List<Developer> DEELOPERS = Stream.of(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L, "Sergey", "Sergeev"),
            new Developer(3L, "Petr", "Petrov")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll (){
        return DEELOPERS;
    }

    @GetMapping ("/{id}")
    public Developer getById (@PathVariable Long id) {
        return DEELOPERS.stream().filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @PostMapping
    public Developer create(@RequestBody Developer developer) {
        this.DEELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping ("/{id}")
    public void deleteById (@PathVariable Long id) {
        this.DEELOPERS.removeIf(developer -> developer.getId().equals(id));
    }
}
