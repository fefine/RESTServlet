package xyz.fefine.test;

import xyz.fefine.annotations.Path;
import xyz.fefine.annotations.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: wkzq
 * Date: 16-6-10.
 * Time: 上午10:34
 */
@Path("/aa")
public class A {

    @Path("/bb/{cc}")
    public void a(HttpServletRequest request, HttpServletResponse response, @RequestParam("cc")String c) throws IOException {

        response.getWriter().write(c);

    }


    @Path("/bb/{cc}/{dd}")
    public void b(HttpServletRequest request, HttpServletResponse response, @RequestParam("cc")String c,@RequestParam("dd")String d) throws IOException {

        response.getWriter().write(c+"\t"+d);

    }

    @Path("/cc")
    public void tt(){
        System.out.println("cc");
    }

}
