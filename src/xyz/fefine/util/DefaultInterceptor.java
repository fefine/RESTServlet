package xyz.fefine.util;

import java.lang.reflect.Method;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DefaultInterceptor implements Interceptor {

	@Override
	public void before(ServletRequest request, ServletResponse response, Method method, Object[] args) {
	}

	@Override
	public void after(ServletRequest request, ServletResponse response, Method method, Object[] args) {
	}

	@Override
	public void afterThrowing(ServletRequest request, ServletResponse response, Method method, Object[] args,
			Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void afterFinally(ServletRequest request, ServletResponse response, Method method, Object[] args) {
	}

}
