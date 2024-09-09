<%-- 
    Document   : proyectoInfo
    Created on : 8/09/2024, 07:34:03 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>proyecto Information</title>
    </head>
    <body>
        <h1>Informacion de la localidad</h1>
        <form action="./LocalidadServlet" method="POST"> 
            <table>
                <tr>
                    <td>Numero Localidad</td>
                    <td><input type="text" name="numeroLocalidad" value="${localidad.numerolocalidad}" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${localidad.nombre}" /></td>
                </tr>
                <tr>
                    <td>poblacion</td>
                    <td><input type="text" name="poblacion" value="${localidad.poblacion}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Numero Localidad</th>
            <th>Nombre</th>
            <th>Poblacion</th>
                <c:forEach items="${allLocalidades}" var="loc">
                <tr>
                    <td>${loc.numerolocalidad}</td>
                    <td>${loc.nombre}</td>
                    <td>${loc.poblacion}</td>
                </tr>
            </c:forEach> 
        </table>
        <br>
        <h1>Informacion del proyecto</h1>
        <form action="./ProyectoServlet" method="POST"> 
            <table>
                <tr>
                    <td>id del proyecto</td>
                    <td><input type="text" name="proyectoId" value="${proyecto.proyectoid}" /></td>
                </tr>
                <tr>
                    <td>nombre del proyecto</td>
                    <td><input type="text" name="nombre" value="${proyecto.nombre}" /></td>
                </tr>
                <tr>
                    <td>descripcion</td>
                    <td><input type="text" name="descripcion" value="${proyecto.descripcion}" /></td>
                </tr>
                <tr>
                    <td>presupuesto</td>
                    <td><input type="text" name="presupuesto" value="${proyecto.presupuesto}" /></td>
                </tr>
                <tr>
                    <td>numero de localidad</td>
                    <td><input type="text" name="numeroLocalidad" value="${curso.numerolocalidad}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Proyecto ID</th>
            <th>Nombre del proyecto</th>
            <th>Descripcion</th>
            <th>Presupuesto</th>
            <th>Numero Localidad</th>
                <c:forEach items="${allProyectos}" var="proy">
                <tr>
                    <td>${proy.proyectoid}</td>
                    <td>${proy.nombre}</td>
                    <td>${proy.descripcion}</td>
                    <td>${proy.presupuesto}</td>
                    <td>${proy.numerolocalidad}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
