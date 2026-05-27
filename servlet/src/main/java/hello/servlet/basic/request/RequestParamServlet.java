package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Search All parameter] - start");

        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName+"="+
                                request.getParameter(paramName)));

        System.out.println("[Search All parameter] - end");

        System.out.println("[Search single parameter] - start");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = "+username);

        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = "+age);

        System.out.println("[Search single parameter] - end");

        System.out.println("[Search multiple parameter that equal name] - start");
        System.out.println("request.getParameterValues(username)");
        String[] usernames = request.getParameterValues("username");
        for (String name: usernames){
            System.out.println("username= "+name);
        }

        System.out.println("[Search multiple parameter that equal name] - end");

        response.getWriter().write("ok");
    }
}
