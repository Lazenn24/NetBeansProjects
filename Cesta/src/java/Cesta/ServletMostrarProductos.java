package Cesta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/ServletMostrarProductos"})
public class ServletMostrarProductos extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletMostrarProductos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletMostrarProductos at " + request.getContextPath() + "</h1>");
            
            
            String confirmar = request.getParameter("confirmar");
            GregorianCalendar calendar = new GregorianCalendar();
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            
            if(confirmar.equals("Confirmar")){
                Cookie cookies[] = request.getCookies();
                UserCompra uC = new UserCompra(cookies[0].getValue(), cookies[1].getValue(), cookies[2].getValue());
                cookies[0].setMaxAge(0);
                cookies[1].setMaxAge(0);
                cookies[2].setMaxAge(0);
                out.println("<p>" + uC.getIdTrabajador() + " " + uC.getProducto() + " " + uC.getCantidad() + " " + calendar.getTime() + "</p>");
            } else if(confirmar.equals("Cancelar")){
                rd.include(request, response);
                Cookie cookies[] = request.getCookies();
                cookies[0].setMaxAge(90);
                cookies[1].setMaxAge(90);
                cookies[2].setMaxAge(90);
                
            }
            out.println("</body>");
            out.println("</html>");
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
