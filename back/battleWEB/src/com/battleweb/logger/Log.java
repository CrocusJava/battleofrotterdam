package com.battleweb.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * 
 *@author rtkachuk
 * 
 *Class Log - for write to log file using static methods
 * 
 */
public class Log {
	
	static{
		DOMConfigurator.configure("conf/log4j.xml");
	}
	
	public enum MessageType {
		DEBUG, INFO, WARN, ERROR
	};

	private static final String endOfLine = "\n";

	public static void debug(String aParam) {
		debug(null, aParam);
	}

	public static void debug(Object object, String param) {
		log(MessageType.DEBUG, object, param);
	}

	public static void error(Object object, String param) {
		log(MessageType.ERROR, object, param);
	}

	public static void error(Object object, Throwable problem, String param) {
		log(MessageType.ERROR, object, problemToString(param, problem));
	}

	public static void info(Object object, String param) {
		log(MessageType.INFO, object, param);
	}

	public static void warn(Object object, String param) {
		log(MessageType.WARN, object, param);
	}

	public static void warn(Object object, Throwable problem, String param) {
		warn(object, problemToString(param, problem));
	}

	private static void log(MessageType messageType, Object object, String param) {
		String className = getLoggerName(object);
		Logger log = Logger.getLogger(className);
		if (MessageType.DEBUG.equals(messageType)) {
			log.debug(param);
		} else if (MessageType.INFO.equals(messageType)) {
			log.info(param);
		} else if (MessageType.WARN.equals(messageType)) {
			log.warn(param);
		} else {
			log.error(param);
		}
	}

	private static String getLoggerName(Object object) {
		if (object == null) {
			return Log.class.getName();
		}
		if (object instanceof String) {
			return ((String) object);
		}
		if (object instanceof Class) {
			return ((Class) object).getName();
		}
		return object.getClass().getName();
	}

	private static String problemToString(String param, Throwable problem) {
		StringBuilder sb = new StringBuilder();
		if (param != null) {
			sb.append(param).append('\n');
		}
		sb.append("Error is: ").append(problem.getClass().getName())
				.append(" Message: ").append(problem.getMessage()).append('\n');
		makeGoodTrace(sb, problem.getStackTrace());
		Throwable cause = problem.getCause();
		while (cause != null) {
			sb.append("The cause is ").append(cause.getClass().getName())
					.append(" Message: ").append(problem.getMessage())
					.append('\n');
			makeGoodTrace(sb, cause.getStackTrace());
			cause = cause.getCause();
		}
		return sb.toString();
	}

	private static void makeGoodTrace(StringBuilder sb,
			StackTraceElement[] trace) {
		for (StackTraceElement entry : trace) {
			if (entry.getClassName().startsWith("com.battle")) {
				sb.append("\t-->");
			} else {
				sb.append('\t');
			}
			sb.append(entry).append('\n');
		}
	}
}
