package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name="responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK); //200

        // [response-headers]
        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
        response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header","hello");

        // [Header 편의 메서드]
        content(response);
        cookie(response);
        redirect(response);

        // [message Body]
        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }

    private void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/basic/hello-form.html");
    }

    private void cookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600 seconds
        response.addCookie(cookie);
    }

    private void content(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
    }
}
