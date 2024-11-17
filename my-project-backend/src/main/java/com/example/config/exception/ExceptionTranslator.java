package com.example.config.exception;

import com.example.common.BizResponse;
import com.example.config.exception.base.BizErrorCode;
import com.example.config.exception.base.BizException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public BizResponse<Void> handleBindException(BindException ex) {
        return BizResponse.error(HttpStatus.BAD_REQUEST.value(), ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    /**
     * 通用异常
     * @Author WangHan
     * @Create 3:32 下午 2020/9/18
     * @Param [ex]
     * @Return com.brc.iot.common.web.rest.response.SimpleResponse<java.lang.Void>
     */
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public BizResponse<Void> handleCommonException(BizException ex) {
        return BizResponse.error(ex.getStatus(), ex.getMessage());
    }

    /**
     * 与SpringBoot保持一致，校验不通过打印警告信息，而不是直接抛出异常
     * @param exception 验证异常
     * @return 校验结果
     */
    @ExceptionHandler(ValidationException.class)
    public BizResponse<Void> validateError(ValidationException exception) {
        return BizResponse.error(BizErrorCode.PARAM_ERROR);
    }
}
