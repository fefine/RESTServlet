package xyz.fefine.servlet;

import xyz.fefine.util.DefaultInterceptor;
import xyz.fefine.util.Interceptor;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SelfInterceptor extends DefaultInterceptor{


	@Override
	public void before(ServletRequest request, ServletResponse response, Method method, Object[] args) {
		super.before(request,response,method,args);
	}

	@Override
	public void after(ServletRequest request, ServletResponse response, Method method, Object[] args) {
		super.after(request,response,method,args);

	}

	@Override
	public void afterThrowing(ServletRequest request, ServletResponse response, Method method, Object[] args, Throwable throwable) {
		super.afterThrowing(request,response,method,args,throwable);
	}

	@Override
	public void afterFinally(ServletRequest request, ServletResponse response, Method method, Object[] args) {
		super.afterFinally(request,response,method,args);
	}
}
