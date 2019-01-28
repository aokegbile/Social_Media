package social.servlets;

import social.dao.FriendsDAO;
import social.dao.PostDAO;
import social.model.Post;

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
@WebServlet(name="NewPost",  urlPatterns= {"/NewPost"})
public class NewPost extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPost() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.getRequestDispatcher("/index").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Map<String, String> messages = new HashMap<String, String>();
        String newPostString = request.getParameter("newPostPayload");
        //DAO save newPost
        Post newPost = new Post();
        newPost.

        PostDAO pd = new PostDAO();
        pd.postOnWall(newPost);
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