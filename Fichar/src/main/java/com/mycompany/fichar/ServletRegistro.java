/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fichar;

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
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author admin
 */
@WebServlet(name = "ServletRegistro", urlPatterns = {"/ServletRegistro"})
public class ServletRegistro extends HttpServlet {

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
            out.println("<title>Servlet ServletRegistro</title>");
            out.println("</head>");
            out.println("<body>");

            String user = request.getParameter("user");
            String userExists = "";

            String email = request.getParameter("email");
            String confirmaEmail = request.getParameter("confirmaEmail");

            String password = request.getParameter("pass");
            String confirmaPass = request.getParameter("confirmaPass");

            EJBSignUpLocal bean = (EJBSignUpLocal) new InitialContext().lookup("java:module/EJBSignUp");

            bean.setUser(user);
            bean.setEmail(email);
            bean.setPassword(password);

            String registroCorrecto = "/index.html";
            String registroFallo = "/registro.html";
            RequestDispatcher valido = request.getRequestDispatcher(registroCorrecto);
            RequestDispatcher noValido = request.getRequestDispatcher(registroFallo);

            if (validador.validate(bean).isEmpty() && email.equals(confirmaEmail) && password.equals(confirmaPass)) {
                /*    out.println("<script type='text/javascript'>");
                out.println("alert('Te has registrado correctamente');");
                out.println("</script>"); */
                UserPass uPSignUp = new UserPass();
                uPSignUp.setUser(user);
                uPSignUp.setPass(password);
                ArrayList<UserPass> usuarios;

                if (getServletContext().getAttribute("usuario") == null) {
                    usuarios = new ArrayList<UserPass>();
                    getServletContext().setAttribute("usuario", usuarios);
                } else {
                    usuarios = (ArrayList<UserPass>) getServletContext().getAttribute("usuario");

                }
                if (!usuarios.isEmpty()) {
                    for (UserPass uP : usuarios) {
                        if (uP.compararUser(user)) {
                            userExists = "El usuario " + user + " ya existe";
                        } else {
                            usuarios.add(uPSignUp);
                            valido.forward(request, response);
                        }

                    }

                } else {
                    usuarios.add(uPSignUp);
                    valido.forward(request, response);
                }
            }

            noValido.include(request, response);
            out.println("<p>" + userExists + "</p>");

            for (ConstraintViolation cv : validador.validate(bean)) {
                out.println("<p>" + cv.getMessage() + "</p>");

            }

            if (!email.equals(confirmaEmail)) {
                out.println("<p>El email no coincide</p>");
            }

            if (!password.equals(confirmaPass)) {
                out.println("<p>La contraseña no coincide</p>");
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
            Logger.getLogger(ServletRegistro.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletRegistro.class.getName()).log(Level.SEVERE, null, ex);
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
