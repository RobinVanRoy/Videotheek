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
import java.util.ArrayList;
import java.util.List;
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
public class ZoekByTitel extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /* Handelt het zoeken naar een titel en geeft een lijst terug */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            if(null != session.getAttribute("Error")){
                session.removeAttribute("Error");
            }
                
            List<Film> films = FilmServices.GetAll();
            List<Film> films2 = new ArrayList<Film>();
            String titel = request.getParameter("Titel");
            
            if(!"".equals(titel))
            {
                titel = titel.toLowerCase();
                for(Film f : films)
                {                 
                    if(f.getTitel().toLowerCase().contains(titel) == false)
                    {
                        films2.add(f);
                    }
                }
                
                films.removeAll(films2);
                
                FilmLijstVM vm = new FilmLijstVM(films);
                session.setAttribute("ViewModel", vm);
            }
            else
            {
                String error = "Verplicht een Titel in te geven!";
//                System.out.println("Error: "+error);  //Voor testing
                session.setAttribute("Error", error);
            }
            
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
