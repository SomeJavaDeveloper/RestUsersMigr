package ru.users.restusers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

    private final UserRepository repository;

    public UserRestController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<User> createRestTest() {
        User testUser = new User(
                "John",
                "Smith",
                LocalDate.of(1991, 10, 3),
                "JohnnS91",
                "123456789",
                "Some guy named Smith",
                "Some house in Chicago");
        User created = repository.save(testUser);
        URI uriOfNewMeal = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("users/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewMeal).body(created);
    }

    @RequestMapping("/{id}")
    public User get(@PathVariable Long id){
        Optional<User> user = repository.findById(id);
        if(!user.isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No such user in database");
        } else {
            return user.get();
        }
    }

    @GetMapping
    public List<User> getAll(){
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        Optional<User> userFromDB = repository.findById(id);
        if (!userFromDB.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No such user in database");
        } else {
            repository.delete(userFromDB.get());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createRest(@Valid @RequestBody User user) {
        User created = repository.save(user);
        URI uriOfNewMeal = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("users/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewMeal).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody User user) {
        repository.save(user);
    }
}
