package olzlrlo.springcrud.dao;

import olzlrlo.springcrud.dto.UserDto;
import olzlrlo.springcrud.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private SqlSession sqlSession;

    public UserDto selectUser(final String id) {
        return sqlSession
                .getMapper(UserMapper.class)
                .select(id);
    }

    public List<UserDto> selectUsers() {
        return sqlSession
                .getMapper(UserMapper.class)
                .list();
    }

    public int insertUser(final String name) {
        return sqlSession
                .getMapper(UserMapper.class)
                .insert(name);
    }

    public int delete(String name) {
        return sqlSession
                .getMapper(UserMapper.class)
                .delete(name);
    }

    public int update(UserDto dto) {
        return sqlSession
                .getMapper(UserMapper.class)
                .update(dto);
    }
}
