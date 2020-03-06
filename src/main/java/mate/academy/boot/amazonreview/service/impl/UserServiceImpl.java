package mate.academy.boot.amazonreview.service.impl;

import java.util.NoSuchElementException;
import mate.academy.boot.amazonreview.entity.User;
import mate.academy.boot.amazonreview.repository.UserRepository;
import mate.academy.boot.amazonreview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
