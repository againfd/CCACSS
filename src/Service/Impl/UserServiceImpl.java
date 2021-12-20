package Service.Impl;

import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import Service.UserService;
import pojo.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.queryOneUser(user);
    }

    @Override
    public boolean register(User user) {
        int row=userDao.insertUser(user);
        if(row>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }
}
