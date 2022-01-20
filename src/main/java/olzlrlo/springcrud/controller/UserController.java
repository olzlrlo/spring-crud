package olzlrlo.springcrud.controller;

import olzlrlo.springcrud.model.ResponseBase;
import olzlrlo.springcrud.model.ResultCode;
import olzlrlo.springcrud.service.UserService;
import olzlrlo.springcrud.dto.UserDto;
import olzlrlo.springcrud.ResponseHelper;

import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseBase> select(@PathVariable String id) {
        try {
            Map<String, String> map = new HashMap<>();
            UserDto dto = userService.select(id);
            String name = dto.getName();
            if (name == null) {
                name = "";
            }

            map.put("name", name);

            return ResponseHelper.success(map);
        } catch (MyBatisSystemException e) {
            return ResponseHelper.fail(ResultCode.JDBC_CONNECTION);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseBase> list() {
        try {
            List<Map<String, String>> list = new ArrayList<>();

            for (UserDto element : userService.list()) {
                String name = element.getName();
                if (name == null) {
                    name = "";
                }

                Map<String, String> object = new HashMap<>();
                object.put("id", element.getId());
                object.put("name", name);

                list.add(object);
            }

            return ResponseHelper.success(list);
        } catch (MyBatisSystemException e) {
            return ResponseHelper.fail(ResultCode.JDBC_CONNECTION);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }

    @RequestMapping(value="/user", method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseBase> insert(String name) {
        try {
            int result = userService.insert(name);

            if (result == 1) {
                return ResponseHelper.success();
            } else {
                return ResponseHelper.fail(ResultCode.DB_FAIL);
            }
        } catch (MyBatisSystemException e) {
            return ResponseHelper.fail(ResultCode.JDBC_CONNECTION);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }

    @RequestMapping(value="/user", method=RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<ResponseBase> delete(String name) {
        try {
            int result = userService.delete(name);

            if (result == 1) {
                return ResponseHelper.success();
            } else {
                return ResponseHelper.fail(ResultCode.DB_FAIL);
            }
        } catch (MyBatisSystemException e) {
            return ResponseHelper.fail(ResultCode.JDBC_CONNECTION);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }

    @RequestMapping(value="/user/{id}", method={RequestMethod.PUT, RequestMethod.PATCH})
    @ResponseBody
    public ResponseEntity<ResponseBase> update(@PathVariable("id") final String id,
                                               @RequestBody final UserDto update) {
        try {
            update.setId(id);

            int result = userService.update(update);
            if (result == 1) {
                return ResponseHelper.success();
            } else {
                return ResponseHelper.fail(ResultCode.DB_FAIL);
            }
        } catch (MyBatisSystemException e) {
            return ResponseHelper.fail(ResultCode.JDBC_CONNECTION);
        } catch (Exception e) {
            return ResponseHelper.fail(e);
        }
    }
}
