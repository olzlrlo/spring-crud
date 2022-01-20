package olzlrlo.springcrud.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class UserDto implements Serializable {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;
}
