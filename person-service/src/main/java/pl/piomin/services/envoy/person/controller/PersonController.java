package pl.piomin.services.envoy.person.controller;

import org.springframework.web.bind.annotation.*;
import pl.piomin.services.envoy.person.model.Person;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final List<Person> persons = new ArrayList<>();

    @GetMapping
    public List<Person> findAll() {
        return persons;
    }

    @GetMapping("/{id}")
    public Person findById(@RequestParam("id") Long id) {
        return persons.stream().filter(it -> it.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @PostMapping
    public Person add(@RequestBody Person p) {
        p.setId((long) (persons.size() + 1));
        persons.add(p);
        return p;
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam("id") Long id) {
        List<Person> p = persons.stream()
                .filter(it -> it.getId().equals(id))
                .toList();
        persons.removeAll(p);
    }

    @PutMapping
    public void update(@RequestBody Person p) {
        Person person = persons.stream().filter(it -> it.getId().equals(p.getId()))
                .findFirst()
                .orElseThrow();
        persons.set(persons.indexOf(person), p);
    }

}
