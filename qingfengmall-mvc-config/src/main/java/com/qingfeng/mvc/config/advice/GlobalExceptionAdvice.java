package com.qingfeng.mvc.config.advice;

import com.qingfeng.common.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>全局异常捕获处理</h1>
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

        @ExceptionHandler ( value = Exception.class )
        public CommonResponse < String > handlerGlobalException ( HttpServletRequest request , Exception ex ) {
                CommonResponse < String > commonResponse = new CommonResponse <> ( - 1 , "内部异常！" );
                commonResponse.setResult ( ex.getMessage ( ) );
                log.error ( "服务器内部异常：" , ex.getMessage ( ) , ex );
                return commonResponse;
        }
}
