/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicafinal.servlets;

import static com.mycompany.practicafinal.database.CRUD.Crud.checkLastRegister;
import static com.mycompany.practicafinal.database.CRUD.Crud.getSchedule;
import java.io.IOException;
import static com.mycompany.practicafinal.database.CRUD.Crud.punchIn;
import com.mycompany.practicafinal.database.Entities.Schedule;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.practicafinal.EntradaSalida;

/**
 *
 * @author admin
 */
public class Botones extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String boton = request.getParameter("boton");

            if (boton.equals("Fichar entrada")) {
                //int id = getUserId((String) request.getSession().getAttribute("user"));
                String user = (String) request.getSession().getAttribute("user");
                if (checkLastRegister(user, EntradaSalida.ENTRADA)) {
                    Schedule schedule = new Schedule();
                    //schedule.setUser(new User(id));
                    schedule.setTypeOfRegister(EntradaSalida.ENTRADA);
                    schedule.setDate(new Date());
                    punchIn(schedule, user);
                    request.setAttribute("horario", getSchedule(user));
                    request.getRequestDispatcher("WEB-INF/horarios.jsp").forward(request, response);
                } else {
                    String error = "Debes fichar salida antes";
                    request.setAttribute("horario", getSchedule(user));
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("WEB-INF/horarios.jsp").forward(request, response);
                }
            } else if (boton.equals("Fichar salida")) {
                //int id = getUserId((String) request.getSession().getAttribute("user"));
                String user = (String) request.getSession().getAttribute("user");
                if (checkLastRegister(user, EntradaSalida.SALIDA)) {
                    Schedule schedule = new Schedule();
                    schedule.setTypeOfRegister(EntradaSalida.SALIDA);
                    schedule.setDate(new Date());
                    punchIn(schedule, user);
                    request.setAttribute("horario", getSchedule(user));
                    request.getRequestDispatcher("WEB-INF/horarios.jsp").forward(request, response);
                } else {
                    String error = "Debes fichar salida antes";
                    request.setAttribute("horario", getSchedule(user));
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("WEB-INF/horarios.jsp").forward(request, response);
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
