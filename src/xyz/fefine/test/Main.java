package xyz.fefine.test;

import xyz.fefine.annotations.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: wkzq
 * Date: 16-6-8.
 * Time: 下午9:18
 */
@Path("/main")
public class Main {

    @Path(value = "/te",requestMethod = "get")
    public void Test(HttpServletRequest request, HttpServletResponse response){

        System.out.println("Test success!");

    }

}
