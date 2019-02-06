/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.servlets;
import static com.mycompany.practicafinal.database.CRUD.Crud.getSchedule;
import static com.mycompany.practicafinal.database.CRUD.Crud.login;
import com.mycompany.practicafinal.database.Entities.User;
import com.mycompany.practicafinal.servlets.ejb.EJBLoginLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author admin
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Resource
    Validator validator;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String user = request.getParameter("user");
            String password = request.getParameter("pass");

            EJBLoginLocal bean = (EJBLoginLocal) new InitialContext().lookup("java:module/EJBLogin");
            bean.setUser(user);
            bean.setPassword(password);

            if (validator.validate(bean).isEmpty()) {

                User uP = new User();
                uP.setUser(user);
                uP.setPassword(password);
                
                if(login(uP)){
                    request.getSession().setAttribute("user", user);
                    request.setAttribute("horario", getSchedule(user));
                    request.getRequestDispatcher("WEB-INF/horarios.jsp").forward(request, response);
                } else {
                    request.setAttribute("info", "El nombre de usuario o la contraseña estan equivocados");
                    request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
                }
                                    
            } else {
                String info = "";
                for(ConstraintViolation cv : validator.validate(bean)){
                    info += cv.getMessage() + "<br>";
                }
                request.setAttribute("info", info);
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
            
        } catch (NamingException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
