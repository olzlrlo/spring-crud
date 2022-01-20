package olzlrlo.springcrud.service;

import olzlrlo.springcrud.dao.UserDao;
import olzlrlo.springcrud.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public UserDto select(String id) {
        return userDao.selectUser(id);
    }

    @Override
    public List<UserDto> list() {
        return userDao.selectUsers();
    }

    @Override
    public int insert(String name) {
        return userDao.insertUser(name);
    }

    @Override
    public int delete(String name) {
        return userDao.delete(name);
    }

    @Override
    public int update(UserDto dto) {
        return userDao.update(dto);
    }
}
