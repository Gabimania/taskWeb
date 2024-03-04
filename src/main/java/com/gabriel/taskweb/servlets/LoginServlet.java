package com.gabriel.taskweb.servlets;

import com.gabriel.taskweb.controller.TaskController;
import com.gabriel.taskweb.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        if (user== null){
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            if(user.getRol().getDescription().equals("admin")){
                response.sendRedirect("admin.jsp");
            }else{
                response.sendRedirect("user.jsp");
            }
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        TaskController taskController = new TaskController();
        if(taskController.login(user, password)){
            HttpSession session = request.getSession();
            session.setAttribute("user", taskController.userLogged);
            if(taskController.isAdmin()){
                response.sendRedirect("admin");
            }else{
                response.sendRedirect("user");
            }

        }else{
            request.setAttribute("mensaje", "Usuario o Password incorrecto");
            request.getRequestDispatcher("login.jsp").forward(request,response);


        }

    }

}
