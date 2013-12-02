package com.battleejb.interceptors;

import java.util.Arrays;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

import com.battleejb.interceptors.exception.TechnicalException;

public class FaultBarrierInterceptor {
	@Inject
	private Logger log;

	@AroundInvoke
	public Object intercept(final InvocationContext invocationContext)
			throws Exception {
		try {
			return invocationContext.proceed();
		} catch (RuntimeException e) {
			log.error("An uncaught exception was caught: \n-METHOD: "
					+ invocationContext.getMethod() + "\n-PARAMS: "
					+ Arrays.toString(invocationContext.getParameters()));
			throw new TechnicalException();
		}
	}
}