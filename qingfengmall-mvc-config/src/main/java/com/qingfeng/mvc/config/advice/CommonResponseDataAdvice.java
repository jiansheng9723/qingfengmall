package com.qingfeng.mvc.config.advice;

import com.qingfeng.common.vo.CommonResponse;
import com.qingfeng.mvc.config.annotation.IgnoreResponseAdvice;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <h1>实现统一响应处理</h1>
 */
@RestControllerAdvice ( value = "com.qingfeng" )
public class CommonResponseDataAdvice implements ResponseBodyAdvice < Object > {

        /**
         * <h2>判断是否需要对响应进行处理</h2>
         *
         * @param methodParameter
         * @param aClass
         * @return
         */
        @Override
        public boolean supports ( MethodParameter methodParameter , Class < ? extends HttpMessageConverter < ? > > aClass ) {

                if ( methodParameter.getDeclaringClass ( ).isAnnotationPresent ( IgnoreResponseAdvice.class ) ) {
                        return false;
                }
                if(methodParameter.getMethod ().isAnnotationPresent ( IgnoreResponseAdvice.class )){
                        return  false;
                }
                return true;
        }

        /**
         *在响应返回给客户端之前进行处理
         * @param o
         * @param methodParameter
         * @param mediaType
         * @param aClass
         * @param serverHttpRequest
         * @param serverHttpResponse
         * @return
         */
        @Override
        public Object beforeBodyWrite ( Object o , MethodParameter methodParameter , MediaType mediaType , Class < ? extends HttpMessageConverter < ? > > aClass , ServerHttpRequest serverHttpRequest , ServerHttpResponse serverHttpResponse ) {
                CommonResponse<Object> commonResponse = new CommonResponse <> ( 100,"成功" );
                if(o == null){
                        return  commonResponse;
                }else if( o instanceof  CommonResponse){
                        commonResponse = ( CommonResponse < Object > ) o;
                }else {
                        commonResponse.setResult ( o );
                }
                return commonResponse;
        }
}
