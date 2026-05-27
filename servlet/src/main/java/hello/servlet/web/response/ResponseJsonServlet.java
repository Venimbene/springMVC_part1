package hello.servlet.web.response;

import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;


@WebServlet(name="responseJsonServlet",urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: application/json

        response.setHeader("content-type", "application/json");
        response.setCharacterEncoding("UTF-8");

        HelloData data = new HelloData();
        data.setUsername("kim");
        data.setAge(30);

        //{"username":"kim","age":30}
        String result = objectMapper.writeValueAsString(data);
        response.getWriter().write(result);
    }
}
