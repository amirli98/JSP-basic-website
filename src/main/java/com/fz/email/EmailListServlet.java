package com.fz.email;

import com.fz.business.User;
import com.fz.database.DatabaseConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "EmailListServlet")
public class EmailListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/index.html";
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }
        if(action.equals("join"))
            url = "/index.html";
        else if(action.equals("add"))
        {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
             User user = new User(firstName, lastName, email);
             request.setAttribute("user",user);
             url = "/thanks.jsp";
            try {
                Connection connection = DatabaseConnection.initializeDatabase();
                PreparedStatement statement = connection
                        .prepareStatement("insert into registeredusers values(?,?,?)"  );
                statement.setString(1,request.getParameter("name"));
                statement.setString(2,request.getParameter("surname"));
                statement.setString(3,request.getParameter("email"));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request,response);

    }
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
