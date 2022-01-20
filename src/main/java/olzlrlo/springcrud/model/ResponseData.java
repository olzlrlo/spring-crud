package olzlrlo.springcrud.model;

import lombok.Getter;

public class ResponseData extends ResponseBase {

    @Getter
    private Object data = null;

    public ResponseData(Object data) {
        setResultCode(ResultCode.SUCCESS);
        this.data = data;
    }
}
