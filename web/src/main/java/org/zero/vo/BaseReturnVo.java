package org.zero.vo;

import io.swagger.annotations.ApiModelProperty;
import org.zero.enums.CodeEnum;

/**
 * @author yezhaoxing
 * @date : 2017/4/17
 */
public class BaseReturnVo {

    final static String SUCCESS_DEFAULT_DESC = "success";
    @ApiModelProperty("返回码")
    private String resCode;
    @ApiModelProperty("返回说明")
    private String resDes;

    public BaseReturnVo() {
    }

    public BaseReturnVo(CodeEnum codeEnum, String msg) {
        this.resCode = codeEnum.getCodeEnum();
        this.resDes = msg;
    }

    public static BaseReturnVo success() {
        return new BaseReturnVo(CodeEnum.SUCCESS, SUCCESS_DEFAULT_DESC);
    }

    public String getResCode() {
        return resCode;
    }

    public String getResDes() {
        return resDes;
    }

}
