package com.my.common.exception;

import com.my.common.constant.CommonConstant;
import com.my.common.util.StringUtil;
import com.my.common.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.MissingResourceException;

/**
 * 全局异常处理器
 * @author studyharder
 */
@RestControllerAdvice
public class MyExceptionHandler {

    private static Logger log = LoggerFactory.getLogger("errorLog");

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(MyException.class)
    public Result<?> handleRRException(MyException e) {
        log.error(e.toString(),e);
        return Result.error(CommonConstant.ERROR, e.getMessage(), StringUtil.getStackTrace(e));
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<?> handlerNoFoundException(Exception e) {
        log.error(e.toString(),e);
        return Result.error("404", "路径不存在，请检查路径是否正确");
    }


    @ExceptionHandler(EOFException.class)
    public Result<?> handleEOFException(EOFException e) {
        log.error(e.toString(),e);
        return Result.error(CommonConstant.ERROR,"IO异常",StringUtil.getStackTrace(e));
    }

    @ExceptionHandler(FileNotFoundException.class)
    public Result<?> handleFileNotFoundException(FileNotFoundException e) {
        log.error(e.toString(),e);
        return Result.error(CommonConstant.ERROR,"文件未找到",StringUtil.getStackTrace(e));
    }

    @ExceptionHandler(SQLException.class)
    public Result<?> handleSQLException(SQLException e) {
        log.error(e.toString(),e);
        return Result.error(CommonConstant.ERROR,"数据库异常",StringUtil.getStackTrace(e));
    }

    @ExceptionHandler(ArithmeticException.class)
    public Result<?> handleArithmeticException(ArithmeticException e) {
        log.error(e.toString(),e);
        return Result.error(CommonConstant.ERROR,"算术异常",StringUtil.getStackTrace(e));
    }

    @ExceptionHandler(MissingResourceException.class)
    public Result<?> handleMissingResourceException(MissingResourceException e) {
        log.error(e.toString(),e);
        return Result.error(CommonConstant.ERROR,"资源丢失异常",StringUtil.getStackTrace(e));
    }

    @ExceptionHandler(ClassNotFoundException.class)
    public Result<?> handleClassNotFoundException(ClassNotFoundException e) {
        log.error(e.toString(),e);
        return Result.error(CommonConstant.ERROR,"未找到类",StringUtil.getStackTrace(e));
    }

    @ExceptionHandler(NullPointerException.class)
    public Result<?> handleNullPointerException(NullPointerException e) {
        log.error(e.toString(),e);
        return Result.error(CommonConstant.ERROR,"空指针异常",StringUtil.getStackTrace(e));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result<?> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(e.toString(),e);
        return Result.error(CommonConstant.ERROR,"非法参数异常",StringUtil.getStackTrace(e));
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public Result<?> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException e) {
        log.error(e.toString(),e);
        return Result.error(CommonConstant.ERROR,"数组越界",StringUtil.getStackTrace(e));
    }


    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        log.error(e.toString(),e);
        return Result.error(CommonConstant.ERROR,"系统内部异常",StringUtil.getStackTrace(e));

    }
}
