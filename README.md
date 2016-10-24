#RESTServlet
#简介
##RestServlet是为了使servlet实现RESTful风格请求的一个简单的小插件

###只需要一个注解，即可帮助你实现，风格与SpingMVC类似（其实我就是仿照那个写的●rz）
###从此再也不用一个请求建立一个Servlet了


#使用方法
###1,新建一个sourcefolder，然后在此文件夹下新建个config.xml文件，加入将要扫描的包的地址，配置如下
<br>

        <?xml version="1.0" encoding="UTF-8"?>
        <main>
            <!--多个包顺序排开即可-->
            <packages>
                <package>xyz.fefine.controller</package>
                <package>xyz.fefine.controller2</package>
            </packages>
            <!--增加自定义拦截器  ，只需要你自定义一个类实现 class中标注类的地址-->
            <interceptor class="xyz.fefine.selfInterceptor" />
        </main>
###2,在web.xml下加入dispatcherServlet，配置如下
        <servlet>
            <servlet-name>restDispatcherServlet</servlet-name>
            <servlet-class>xyz.fefine.servlet.MainServlet</servlet-class>
            <init-param>
                <!--此param不要更改  -->
                <param-name>contextConfigLocation</param-name>
                <!-- 这里写你的配置文件的地址，就上上面的那个config.xml的地址-->
                <param-value>config.xml</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup>
        </servlet>
        <servlet-mapping>
            <servlet-name>restDispatcherServlet</servlet-name>
            <!-- 过滤的列表，尽量带后缀，否则会拦截所有请求-->
            <url-pattern>*.do</url-pattern>
        </servlet-m1apping>
    
###3,实现类 
        public class ST {
            /**
            * {a}为要传递的参数
            * 在下面用String a来进行接收
	        * 请求方式目前支持GET,POST,PUT,DELETE 默认为GET
            **/
            @Path("/main/{a}",requestMath="post")
    	    public void rest(HttpServletRequest res,HttpServletResponse resp,@RequestParam("a")String a){
    		    resp.getWriter().append("a:"+a);	
            }
        }
        
        //实现自定义拦截器
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
        

###4,配置完毕

###源码都已经放在了git上面
###因为技术原因，如有bug请向我反馈：email：feng_sh@outlook.com
###如果你对此项目感兴趣，也可以联系我。
###最后：推荐一下我的blog [fefine](http://www.fefine.xyz),[博客园](http://www.cnblogs.com/weikongziqu/)

