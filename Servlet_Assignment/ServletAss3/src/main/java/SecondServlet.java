import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get session and retrieve attributes
        HttpSession session = request.getSession(false); // false = don’t create if it doesn’t exist

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        if (session != null) {
            String name = (String) session.getAttribute("name");
            String password = (String) session.getAttribute("password");

            out.println("<h2>Data from Session</h2>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Password: " + password + "</p>");
        } else {
            out.println("<h2>No session found</h2>");
        }
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
