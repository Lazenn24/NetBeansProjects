package Cesta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/ServletConfirmar"})
public class ServletConfirmar extends HttpServlet {

    @Resource
    Validator validador;

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
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletConfirmar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletConfirmar at " + request.getContextPath() + "</h1>");

            String idTrabajador = request.getParameter("idTrabajador");
            String producto = request.getParameter("producto");
            String cantidad = request.getParameter("cantidad");
            Cookie ckIdTrabajador = new Cookie("idTrabajador", idTrabajador);
            Cookie ckProducto = new Cookie("producto", producto);
            Cookie ckCantidad = new Cookie("cantidad", cantidad);
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");

            EJBCestaLocal bean = (EJBCestaLocal) new InitialContext().lookup("java:module/EJBCesta");

            if (validador.validate(bean).isEmpty()) {
                response.addCookie(ckCantidad);
                response.addCookie(ckProducto);
                response.addCookie(ckIdTrabajador);

            } else {
                for (ConstraintViolation cv : validador.validate(bean)) {
                    rd.include(request, response);
                    out.println("<p>" + cv.getMessage() + "</p>");
                    
                }
            }

            out.println("<form action='ServletMostrarProductos' method='POST'>");
            out.println("<input type='submit' name='confirmar' value='Confirmar'>");
            out.println("<input type='submit' name='confirmar' value='Cancelar'>");
            out.println("</form>");
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ServletConfirmar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ServletConfirmar.class.getName()).log(Level.SEVERE, null, ex);
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
