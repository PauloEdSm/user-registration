package br.paulo.dev.user_registration.controller;

import br.paulo.dev.user_registration.business.UserService;
import br.paulo.dev.user_registration.infraestructure.entitys.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService serviceUser;

    @PostMapping
    public ResponseEntity<Void> userSave(@RequestBody User user) {
        serviceUser.saveUserData(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> searchUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(serviceUser.searchUserByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEmail(@RequestParam String email) {
        serviceUser.deleteUserByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUserById(@RequestParam Integer id,
                                               @RequestBody User user) {
        serviceUser.updateUserId(id, user);
        return ResponseEntity.ok().build();
    }
}
