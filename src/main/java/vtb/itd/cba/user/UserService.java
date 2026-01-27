package vtb.itd.cba.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {
    private final UserRepository mainRepo;


    @Override
    public User save(User user) {
        Optional<User> user1 = mainRepo.findById(user.getUserName());
        if (user1.isEmpty()){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            user.setRole("MEMBER");
            mainRepo.save(user);
        }
        return user;
    }
}
