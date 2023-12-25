package com.tclab.weixinappletcommon.config;

import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 事务异常
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public JsonResVo returnReqParamErrorJsonResVo(ConstraintViolationException e){
        StringBuffer sb = new StringBuffer();
        for (ConstraintViolation violation:e.getConstraintViolations()) {
            sb.append(violation.getMessage());
        }
        logger.info("事务异常: "+sb.toString());
        e.printStackTrace();
        return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"参数异常");
    }

    /**
     * 服务异常
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResVo returnErrorJsonResVo(Exception e){

        String msg = e.getMessage();

        logger.info(msg);

        if (msg == null || msg.equals("")) {
            msg = "服务出错";
        }
        logger.info("服务异常: "+e.getMessage());
        e.printStackTrace();
        return JsonResVo.buildErrorResult(ErrorEnum.SYSTEM_ERROR.getErrorCode(),msg);
    }

    /**
     * 系统异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResVo returnUnDefineResVo(Exception e){

        String msg = e.getMessage();

        logger.info(msg);
        logger.info("系统异常: "+e.getMessage());
        e.printStackTrace();
        return JsonResVo.buildErrorResult(ErrorEnum.SYSTEM_ERROR.getErrorCode(),"未知系统错误");
    }

}
