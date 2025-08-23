package br.paulo.dev.user_registration.business;

import br.paulo.dev.user_registration.infraestructure.entitys.User;
import br.paulo.dev.user_registration.infraestructure.repository.UserRepository;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUserData(User user) {
        repository.saveAndFlush(user);
    }

    public User searchUserById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ExecutionException("Id not found!")
        );

    }

    public User searchUserByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email not found!")
        );

    }

    public void deleteUserByEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void updateUserId(Integer userId, User user) {
        User userEntity = repository.findById(userId).orElseThrow(
                () -> new RuntimeException("Error! Id not existent!")
        );
        User updatedUser = User.builder()
                .email((user.getEmail() != null) ?
                        user.getEmail() :
                        userEntity.getEmail())

                .name((user.getName() != null) ?
                        user.getName() :
                        userEntity.getName())

                .id(userEntity.getId())
                .build();
        repository.saveAndFlush(updatedUser);
    }
}