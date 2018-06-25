package com.manage.student.common.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manage.student.common.exception.ControllerException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import static com.manage.student.common.response.Response.Status.ERR_UNKNOWN;
import static com.manage.student.common.response.Response.Status.OK;

@ControllerAdvice(basePackages = "com.manage.student.common.controller")
public class JsonResponseWrapper implements ResponseBodyAdvice {
    
    private static Log logger = LogFactory.getLog(JsonResponseWrapper.class);
    
    private static final String CONTENT_TYPE = "Content-Type";
    
    private static final String APPLICATION_JSON = "application/json";
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Response) {
            return body;
        }
        Response res = new Response(OK, null, body);
        if (body instanceof  String ||
            (null != returnType.getParameterType() && returnType.getParameterType().getName().equals(String.class.getName()))) {
            try {
                response.getHeaders().set(CONTENT_TYPE, APPLICATION_JSON);
                return objectMapper.writeValueAsString(res);
            } catch (JsonProcessingException e) {
                logger.error("服务器内部错误！", e);
                throw new ControllerException(ERR_UNKNOWN, "服务器内部错误");
            }
        }
        return new Response(OK, null, body);
    }

}
