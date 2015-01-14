/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAL.Login;
import Services.LoginServices;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ikke
 */
public class LoginController extends HttpServlet {

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
        
        try{
            HttpSession session = request.getSession();
            if(null != session.getAttribute("Error")){
                session.removeAttribute("Error");
            }
            if(null != session.getAttribute("UserName")){
                session.removeAttribute("UserName");
            }
            String userName = request.getParameter("UserName");
            String passWord = request.getParameter("PassWord");
            String error = "";
            session.setAttribute("FirstLoad", "1");
            
            if(!"".equals(userName)){            
                   
                
            
                Login login = LoginServices.GetByUserName(userName);
                if(!"".equals(passWord)){
                    if(login.getPassword().equals(passWord)){
                        
                        session.removeAttribute("Error");
                        session.setAttribute("FirstLoad", "0");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/FilmController");
                        dispatcher.forward(request, response); 
                    }
                    else {
                   
                        error = "Verkeerd paswoord ingevuld!";
                    }
                }
                else {
                    error = "Paswoord is niet ingevuld!";
                }
            
                if(session.getAttribute("FirstLoad").equals("1")) {
                    session.setAttribute("UserName", userName);
                } 
            
            }
            else {            
                error = "Username is niet ingevuld!";               
            }        
                
            session.setAttribute("Error", error);
//            System.out.println("Error: "+error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        }
        catch(IOException ex){
            System.out.println("IOException: "+ex);
        }
        catch(ServletException ex){
            System.out.println("ServletException: "+ex);
        }
        
        
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
        processRequest(request, response);
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
