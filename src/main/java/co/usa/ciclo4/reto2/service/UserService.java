package co.usa.ciclo4.reto2.service;


import co.usa.ciclo4.reto2.model.User;
import co.usa.ciclo4.reto2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public boolean emailExist(String email){
        return userRepository.emailExist(email);
    }

    public User authenticationUser(String email, String password) {
        Optional<User> user = userRepository.authenticationUser(email, password);

        if(user.isEmpty()) {
            return new User();
        }else {
            return user.get();
        }
    }
    public User create(User user) {
        if (user.getId() == null) {
            return user;
        }else {
            Optional<User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExist(user.getEmail())==false) {
                    return userRepository.create(user);
                }else {
                    return user;
                }
            }else {
                return user;
            }
        }
    }

    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userDB = userRepository.getUser(user.getId());
            if (!userDB.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDB.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDB.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDB.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDB.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDB.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDB.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDB.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    userDB.get().setType(user.getType());
                }
                userRepository.update(userDB.get());
                return userDB.get();
            } else {
                return user;
            }

        } else {
            return user;
        }
    }

    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
