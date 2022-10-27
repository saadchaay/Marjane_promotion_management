package com.marjan.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Authentication", value = "/authentication")
public class Authentication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("general-admin".equals(request.getParameter("role"))) {
            // execute the admin or manager auth ....

        }else{
            // execute the general admin auth ....
        }
    }
}
