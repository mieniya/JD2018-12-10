package by.it.titkovskaya.jd03_04;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter writer = res.getWriter();
        writer.println("<html>");
        writer.println(" <head>");
        writer.println("    <title>Hello title</title>");
        writer.println(" <head>");
        writer.println("    <body>");
        writer.println("    <p> Hello servlet!!! <hr>");
        writer.println("    </body>");
        writer.println("</html>");
        writer.flush();
    }
}
