package co.usa.ciclo4.reto2.web;


import co.usa.ciclo4.reto2.model.User;
import co.usa.ciclo4.reto2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

        @GetMapping("/all")
        public List<User> getAll() {
            return userService.getAll();
        }

        @GetMapping("/emailexist/{email}")
        public boolean emailExist(@PathVariable("email") String email) {
            return userService.emailExist(email);
        }

        @GetMapping("/{email}/{password}")
        public User authenticationUser(@PathVariable("email") String email, @PathVariable("password") String password) {
            return userService.authenticationUser(email, password);
        }

        @PostMapping("/new")
        @ResponseStatus(HttpStatus.CREATED)
        public User create(@RequestBody User user) {
            return userService.create(user);
        }

        @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
        public User update(@RequestBody User user) {
            return userService.update(user);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public boolean delete(@PathVariable("id") int id) {
            return userService.delete(id);
        }
}
