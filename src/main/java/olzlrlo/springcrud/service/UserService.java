package olzlrlo.springcrud.service;

import olzlrlo.springcrud.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto select(String id);
    List<UserDto> list();
    int insert(String name);
    int delete(String name);
    int update(UserDto dto);
}
