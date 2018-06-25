package com.manage.student.common.exception;

import com.manage.student.common.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import static com.manage.student.common.response.Response.Status.ERR_UNKNOWN;

@ControllerAdvice
class GlobalDefaultExceptionHandler {
    
    private static Log logger = LogFactory.getLog(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        if (e instanceof ControllerException) {
            ControllerException ce = (ControllerException) e;
            return new Response(ce.getStatus(), ce.getMessage(), ce.getData());
        }
        logger.error("服务器内部错误！", e);
        return new Response(ERR_UNKNOWN, "服务器内部错误！", null);
    }

}
