/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

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
@WebServlet(name = "ProyectoServlet", urlPatterns = {"/ProyectoServlet"})
public class ProyectoServlet extends HttpServlet {

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
        
        String action=request.getParameter("action");
        
        String proyectoidStr=request.getParameter("proyectoId");
        Integer proyectoId = new Integer(proyectoidStr);
        
        if (action.equals("Add")) {    
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String presupuestoStr = request.getParameter("presupuesto");
            Double presupuesto = new Double(presupuestoStr);
            String numerolocalidadStr = request.getParameter("numeroLocalidad");
            Integer numeroLocalidad = new Integer(numerolocalidadStr);
            Proyecto proyecto = new Proyecto(proyectoId,nombre,descripcion,presupuesto,localidadFacade.find(numeroLocalidad));
            
            proyectoFacade.create(proyecto);
            
            request.setAttribute("allLocalidades", localidadFacade.findAll());
            request.setAttribute("allProyectos", proyectoFacade.findAll());
            request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
        } else if(action.equals("Edit")){
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String presupuestoStr = request.getParameter("presupuesto");
            Double presupuesto = new Double(presupuestoStr);
            String numerolocalidadStr = request.getParameter("numeroLocalidad");
            Integer numeroLocalidad = new Integer(numerolocalidadStr);
            Proyecto proyecto = new Proyecto(proyectoId,nombre,descripcion,presupuesto,localidadFacade.find(numeroLocalidad));
            
            proyectoFacade.edit(proyecto);
            
            request.setAttribute("allLocalidades", localidadFacade.findAll());
            request.setAttribute("allProyectos", proyectoFacade.findAll());
            request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
        } else if(action.equals("Delete")){
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String presupuestoStr = request.getParameter("presupuesto");
            Double presupuesto = new Double(presupuestoStr);
            String numerolocalidadStr = request.getParameter("numeroLocalidad");
            Integer numeroLocalidad = new Integer(numerolocalidadStr);
            Proyecto proyecto = new Proyecto(proyectoId,nombre,descripcion,presupuesto,localidadFacade.find(numeroLocalidad));
            
            proyectoFacade.remove(proyecto);
            
            request.setAttribute("allLocalidades", localidadFacade.findAll());
            request.setAttribute("allProyectos", proyectoFacade.findAll());
            request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
        } else if(action.equals("Search")){
            List proyectos=new ArrayList();
            proyectos.add(proyectoFacade.find(proyectoId));
            
            request.setAttribute("allProyectos", proyectos);
            request.setAttribute("allLocalidades", localidadFacade.findAll());
            request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
        }
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ProyectoServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ProyectoServlet at " + request.getContextPath() + "</h1>");
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
