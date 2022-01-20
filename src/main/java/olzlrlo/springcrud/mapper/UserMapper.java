package olzlrlo.springcrud.mapper;

import olzlrlo.springcrud.dto.UserDto;

import java.util.List;

public interface UserMapper {
    UserDto select(String id);
    List<UserDto> list();
    int insert(String name);
    int delete(String name);
    int update(UserDto dto);
}
