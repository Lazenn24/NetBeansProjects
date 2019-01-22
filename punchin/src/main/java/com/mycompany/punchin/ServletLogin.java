/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.punchin;

import com.mycompany.punchin.EJBLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author admin
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

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
            out.println("<title>Servlet ServletLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLogin at " + request.getContextPath() + "</h1>");

            String user = request.getParameter("user");
            String password = request.getParameter("pass");

            EJBLoginLocal bean = (EJBLoginLocal) new InitialContext().lookup("java:module/EJBLogin");

            bean.setPassword(password);
            bean.setUser(user);

            ArrayList<UserPass> usuarios = (ArrayList<UserPass>) getServletContext().getAttribute("usuario");

            // Para no tener que volver a crear el usuario en ServletBotones
            String horarios = "/horarios.jsp";
            String fallo = "/login.jsp";
            String errores = "";
            RequestDispatcher valido = request.getRequestDispatcher(horarios);
            RequestDispatcher noValido = request.getRequestDispatcher(fallo);

            if (validador.validate(bean).isEmpty()) {
                if (usuarios != null) {
                    for (UserPass uP : usuarios) {
                        if (uP.compararUserPass(user, password)) {

                            // Para poder asegurar que ha habido logeo previo al entrar en los horarios.
                            HttpSession sesion = request.getSession();
                            sesion.setAttribute("user", user);

                            valido.forward(request, response);

                        }
                    }
                    
                    //Mensaje de error si el usuario no coincide con lo guardado en el ArrayList
                    errores += "La contraseña o el usuario son incorrectos";
                    request.setAttribute("error", errores);
                    noValido.forward(request, response);
                } else {
                    // Mensaje de error si el ArrayList no esta creado
                    errores += "La contraseña o el usuario son incorrectos";
                    request.setAttribute("error", errores);
                    noValido.forward(request, response);
                }
            } else {
                for (ConstraintViolation cv : validador.validate(bean)) {
                    errores += cv.getMessage() + "<br>";
                }
                request.setAttribute("error", errores);
                noValido.forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
