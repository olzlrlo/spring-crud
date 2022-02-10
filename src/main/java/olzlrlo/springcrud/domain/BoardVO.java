package olzlrlo.springcrud.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// VO(Value Object): DB의 정보를 객체화하는 용도
// DTO(Data Transfer Object): 외부 시스템과 데이터 통신하는 용도
public class BoardVO {

    @Getter
    @Setter
    private Integer bno;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private String writer;

    @Getter
    @Setter
    private Date regdate;

    @Getter
    @Setter
    private int viewcnt;
}
