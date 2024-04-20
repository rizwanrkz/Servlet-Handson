package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out= res.getWriter();
        out.println("<h2>Welcome to Register Servlet</h2>");
        
        String name = req.getParameter("user_name");
        String cond = req.getParameter("condition");
               
        if(cond!=null){
            if(cond.equals("checked")){
                //out.println("<h2>Registered Successfully</h2>");
                
                //Assume data isaved in DB
                RequestDispatcher rd = req.getRequestDispatcher("success");
                rd.forward(req, res);
            }
            else{
                out.println("<h2>You have not accepted T&C</h2>");
            }
        }
            else{
            out.println("<h2>You have not accepted T&C</h2>");
            
            //to include index.html in output
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, res);
        }
        }
}
    
    
