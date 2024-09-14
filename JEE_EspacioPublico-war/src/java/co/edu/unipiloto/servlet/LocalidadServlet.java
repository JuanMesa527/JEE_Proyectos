/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectura.proyecto.entity.Localidad;
import co.edu.unipiloto.arquitectura.proyecto.entity.Proyecto;
import co.edu.unipiloto.arquitectura.proyecto.session.LocalidadFacadeLocal;
import co.edu.unipiloto.arquitectura.proyecto.session.ProyectoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "LocalidadServlet", urlPatterns = {"/LocalidadServlet"})
public class LocalidadServlet extends HttpServlet {

    @EJB
    private ProyectoFacadeLocal proyectoFacade;

    @EJB
    private LocalidadFacadeLocal localidadFacade;

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

        String action = request.getParameter("action");
        try {
            String numerolocalidadStr = request.getParameter("numeroLocalidad");
            Integer numeroLocalidad = new Integer(numerolocalidadStr);

            if (action.equals("Add")) {
                String nombre = request.getParameter("nombre");
                String poblacionStr = request.getParameter("poblacion");
                Integer poblacion = new Integer(poblacionStr);
                Localidad localidad = new Localidad(numeroLocalidad, nombre, poblacion);

                localidadFacade.create(localidad);

                request.setAttribute("allLocalidades", localidadFacade.findAll());
                request.setAttribute("allProyectos", proyectoFacade.findAll());
                request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
            } else if (action.equals("Edit")) {
                String nombre = request.getParameter("nombre");
                String poblacionStr = request.getParameter("poblacion");
                Integer poblacion = new Integer(poblacionStr);
                Localidad localidad = new Localidad(numeroLocalidad, nombre, poblacion);

                localidadFacade.edit(localidad);

                request.setAttribute("allLocalidades", localidadFacade.findAll());
                request.setAttribute("allProyectos", proyectoFacade.findAll());
                request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
            } else if (action.equals("Delete")) {
                String nombre = request.getParameter("nombre");
                String poblacionStr = request.getParameter("poblacion");
                Integer poblacion = new Integer(poblacionStr);
                Localidad localidad = new Localidad(numeroLocalidad, nombre, poblacion);

                localidadFacade.remove(localidad);

                request.setAttribute("allLocalidades", localidadFacade.findAll());
                request.setAttribute("allProyectos", proyectoFacade.findAll());
                request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
            } else if (action.equals("Search")) {
                List localidades = new ArrayList();
                localidades.add(localidadFacade.find(numeroLocalidad));

                request.setAttribute("allLocalidades", localidades);
                request.setAttribute("allProyectos", proyectoFacade.findAll());
                request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
            }
        } catch (java.lang.NumberFormatException e) {
            request.setAttribute("error", "Complete y verifique todos los campos, ERROR: " + e.getMessage());
            request.setAttribute("allLocalidades", localidadFacade.findAll());
            request.setAttribute("allProyectos", proyectoFacade.findAll());
            request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
        } catch (javax.ejb.EJBException e) {
            request.setAttribute("error", "ID o llave principal repetida, verifique los campos, ERROR: " + e.getMessage());
            request.setAttribute("allLocalidades", localidadFacade.findAll());
            request.setAttribute("allProyectos", proyectoFacade.findAll());
            request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
        }

//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet LocalidadServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet LocalidadServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
