package controller;

import model.User;
import service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="user", urlPatterns="/user")

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //resp.getWriter().println("Bonjour la classe");
        // Charge une page de redirection
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String log = req.getParameter("log");
        String pwd = req.getParameter("pwd");
        UserDao userDao = new UserDao();
        User u =  userDao.logon(log,pwd);
        if(u!= null){
            HttpSession session = req.getSession(true);
           session.setAttribute("connectedUser",u);
           if(u.getProfil().equalsIgnoreCase("user")){
               getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(req,resp);
           }else{
               getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(req,resp);
           }
        }else{
            req.setAttribute("error","login ou password incorrecte");
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
        }
    }
}
