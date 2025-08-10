import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // Store in session
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("password", password);

        // Display link to second servlet
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>User Info Stored in Session</h2>");
        out.println("<a href='SecondServlet'>Click here to go to Second Servlet</a>");
        out.println("</body></html>");
    }
}
