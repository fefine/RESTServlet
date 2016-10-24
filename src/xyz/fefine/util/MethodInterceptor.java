package xyz.fefine.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.fefine.entity.RequestHandler;

public class MethodInterceptor implements InvocationHandler{
	
	private Object target;
	private Interceptor interceptor;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestHandler handler;

	private Logger LOG = Logger.getLogger(this.getClass().getName(), null);
	
	public MethodInterceptor(RequestHandler handler , Interceptor interceptor,HttpServletRequest request,HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.interceptor = interceptor;
		this.request = request;
		this.response = response;
		this.target = Class.forName(handler.getClassName()).newInstance();
		this.handler = handler;
	}

	/**
	 *
	 * @return 执行method返回
	 * @throws Throwable
     */
	public Object invokeMethod() throws Throwable{
		
		return invoke(null, this.handler.getMethod(), this.handler.getObjs());
		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Object result = null;

		try{
			interceptor.before(request, response, method, args);
			
			result = method.invoke(target, args);
			
			interceptor.after(request, response, method, args);
			
			
		}catch(Throwable throwable){
			LOG.log(Level.WARNING,"the argument doesn't match");
			interceptor.afterThrowing(request, response, method, args, throwable);

		}finally{
			interceptor.afterFinally(request, response, method, args);
		}
		return result;
	}

}
