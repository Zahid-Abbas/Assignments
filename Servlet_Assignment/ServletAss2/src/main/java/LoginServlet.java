import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if ("admin".equals(name) && "wipro".equals(password)) {
            // Forward to SuccessServlet
            RequestDispatcher rd = request.getRequestDispatcher("SuccessServlet");
            rd.forward(request, response);
        } else {
            // Forward to Fail.html
            RequestDispatcher rd = request.getRequestDispatcher("Fail.html");
            rd.forward(request, response);
        }
    }
}
