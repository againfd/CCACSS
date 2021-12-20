package Dao;

import pojo.User;

public interface UserDao {
    public User queryOneUser(User user);
    public int insertUser(User user);
    public boolean queryUserByUsername(String username);
}
