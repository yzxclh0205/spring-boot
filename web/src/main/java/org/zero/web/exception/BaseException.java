package org.zero.web.exception;


import lombok.Data;
import org.zero.enums.CodeEnum;

/**
 * @author yezhaoxing
 * @date : 2017/4/17
 */
@Data
public class BaseException extends Exception {

    private CodeEnum codeEnum;

    private String msg;

    public BaseException(CodeEnum codeEnum, String msg) {
        super(msg);
        this.codeEnum = codeEnum;
        this.msg = msg;
    }
}
