/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import objects.UserSchedule;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "ServletTabla", urlPatterns = {"/ServletTabla"})
public class ServletTabla extends HttpServlet {

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
            out.println("<title>Servlet ServletTabla</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletTabla at " + request.getContextPath() + "</h1>");

            RequestDispatcher noLogin;

            // Para impedir entrar sin haberse logeado
            // Para impedir entrar sin haberse logeado
            HttpSession session = request.getSession(false);
            if (session == null) {
                out.println("Debes iniciar sesión primero");
                noLogin = request.getRequestDispatcher("index.html");
                noLogin.forward(request, response);
            } else {

                ArrayList<UserSchedule> horarioUsuario;
                Hashtable<String, ArrayList<UserSchedule>> horarios;
                String user = (String) request.getSession().getAttribute("user");
                UserSchedule guardar = (UserSchedule) request.getSession().getAttribute("registro");
                RequestDispatcher rd = request.getRequestDispatcher("/ServletMostrarHorarios");
                
                if (getServletContext().getAttribute("horario") == null) {
                    user = (String) guardar.getUser();
                    horarioUsuario = new ArrayList<UserSchedule>();
                    horarios = new Hashtable();
                    horarios.put(user, horarioUsuario);
                    getServletContext().setAttribute("horario", horarios);
                } else {
                    horarios = (Hashtable<String, ArrayList<UserSchedule>>) getServletContext().getAttribute("horario");
                    if ((ArrayList<UserSchedule>) horarios.get(user) == null) {
                        horarioUsuario = new ArrayList<UserSchedule>();
                        horarios.put(user, horarioUsuario);
                    } else {
                        horarioUsuario = (ArrayList<UserSchedule>) horarios.get(user);
                    }
                }

                horarioUsuario.add(guardar);

                rd.forward(request, response);
                out.println("</body>");
                out.println("</html>");
            }
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
