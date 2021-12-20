package Service;

import pojo.User;

public interface UserService {
    public User login(User user);
    public boolean register(User user);
    public boolean queryUserByUsername(String username);
}
