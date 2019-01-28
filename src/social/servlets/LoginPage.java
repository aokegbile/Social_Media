package social.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet(name="LoginPage",  urlPatterns= {"/LoginPage"})
public class LoginPage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages); // Now it's available by ${messages}

        String uname = request.getParameter("uname");
        if(uname.matches("^[a-zA-Z]\\w{3,14}$")){

        }
        if (uname == null || uname.trim().isEmpty()) {
            messages.put("uname", "Please enter username");

            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
            return;
        } else if (!uname.matches("\\p{Alnum}+")) {
            messages.put("uname", "Please enter a valid username");

            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
            return;
        }

        String pass = request.getParameter("pass");
        if (pass == null || pass.trim().isEmpty()) {
            messages.put("pass", "Please enter Password");
        } else if (!pass.matches("\\d+")) {
            messages.put("pass", "Please enter a valid password");
        }

        // ...

        if (messages.isEmpty()) {
            messages.put("success", "Form successfully submitted!");
        }
        // database lookup and reject{
        //login successful

        request.getRequestDispatcher("WallPage.jsp").forward(request, response);
        //login failure

    }
}