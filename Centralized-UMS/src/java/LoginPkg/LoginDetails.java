/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Extream programmer
 */
@WebServlet(name = "LoginDetails", urlPatterns = {"/LoginDetails"})
public class LoginDetails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        CreateHash obj = new CreateHash();
       
        String referer = request.getHeader("referer");
        String user ="";
        out.println("referer = "+request.getHeader("referer"));
        DatabaseConnection obj1 = new DatabaseConnection ();
        String verify ="";
        if(referer.equals("http://localhost:8080/Centralized-UMS/StudentLogin.html")){
          
            verify = obj1.checkDB("student", username, password);
            if(verify.equals("correct")){
                //out.println(verify);
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("StudentHome.jsp");
            }
            else{
                out.println(verify);
            }
        }
        else if(referer.equals("http://localhost:8080/Webfinal/IndustryLogin.html"))
        {
            verify = obj1.checkDB("industry", username, password);
             if(verify.equals("correct")){
                 out.println(verify);
                 HttpSession session = request.getSession();
                session.setAttribute("username", username);
                //redirect
            }
            else{
                out.println(verify);
            }   
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
