/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAL.Film;
import Services.FilmServices;
import ViewModels.FilmLijstVM;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;
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
public class Uitlenen extends HttpServlet {

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
        
        
        try {
            HttpSession session = request.getSession();
            session.setAttribute("Lock", "1");
            List<Film> films = FilmServices.GetByUitgeleend();
            int id = Integer.parseInt(request.getParameter("id"));
            Boolean b = Boolean.parseBoolean(request.getParameter("bool"));
            if(b==false)
            {
                Film f = FilmServices.Lenen(id, b);
                films.remove(f);
                b=true;
                
            }
            else if(b==true)
            {
                b=false;
                
            }
            Film film = FilmServices.Lenen(id, b);
            films.add(film);
            Collections.sort(films, new Comparator(){

                @Override
                public int compare(Object o1, Object o2) {
                    Film f1 = (Film)o1;
                    Film f2 = (Film)o2;
                    return f1.getTitel().toUpperCase().compareTo(f2.getTitel().toUpperCase());
                }
            });
            FilmLijstVM vm = new FilmLijstVM(films);
            session.setAttribute("ViewModel", vm);
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("filmLijst.jsp");
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
