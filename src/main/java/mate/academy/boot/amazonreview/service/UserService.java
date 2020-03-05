package mate.academy.boot.amazonreview.service;

import mate.academy.boot.amazonreview.entity.User;

public interface UserService {
    User findUserByUsername(String username);

    User save(User user);
}
