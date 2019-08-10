package com.wxluo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author wxluo
 * 记录日志的工具
 *
 */
public class LogTool {

	private static Logger loggerTool = LoggerFactory.getLogger(LogTool.class);
	
    //日志
    public static void logInfo(Class clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(message);
    }
	
    //info
    public static void logInfo(String message) {
        loggerTool.info(message);
    }

    /**
     * 记录错误日志
     * @param clazz 类型
     * @param message 消息
     * @param ex 异常信息
     * */
    public static void logError(Class clazz, String message, Exception ex) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(message, ex);
    }

    /**
     * 记录错误日志
     * @param clazz 类型
     * @param message 消息
     * */
	public static void logError(Class clazz, String message) {
		Logger logger = LoggerFactory.getLogger(clazz);
		logger.error(message);
	}
	
	
	/**
	 * @param message
	 */
	public static void logError(String message){
		loggerTool.error(message);
	}
	
	
}

