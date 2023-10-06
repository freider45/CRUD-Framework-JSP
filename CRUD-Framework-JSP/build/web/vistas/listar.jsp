
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body class="bg-gray-200">
        <div class="container mx-auto py-12">
            <h1 class="text-4xl font-bold mb-4">Personas</h1>
            <a class="inline-block px-6 py-2 text-lg text-white bg-green-500 rounded hover:bg-green-600" href="Controlador?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table-auto w-full mt-4 divide-y divide-gray-200">
                <thead>
                    <tr class="bg-gray-300">
                        <th class="px-4 py-2">ID</th>
                        <th class="px-4 py-2">DNI</th>
                        <th class="px-4 py-2">NOMBRES</th>
                        <th class="px-4 py-2">APELLIDOS</th>
                        <th class="px-4 py-2">TELEFONO</th>
                        <th class="px-4 py-2">EMAIL</th>
                        <th class="px-4 py-2">RESIDENCIA</th>
                    </tr>
                </thead>
                <%
                    PersonaDAO dao=new PersonaDAO();
                    List<Persona>list=dao.listar();
                    Iterator<Persona>iter=list.iterator();
                    Persona per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody class="divide-y divide-gray-200">
                    <tr>
                        <td class="px-4 py-2"><%= per.getAtrId()%></td>
                        <td class="px-4 py-2"><%= per.getAtrDni()%></td>
                        <td class="px-4 py-2"><%= per.getAtrName()%></td>
                        <td class="px-4 py-2"><%= per.getAtrLstName()%></td>
                        <td class="px-4 py-2"><%= per.getAtrPhone()%></td>
                        <td class="px-4 py-2"><%= per.getAtrEmail()%></td>
                        <td class="px-4 py-2"><%= per.getAtrResid()%></td>
                        <td class="px-4 py-2">
                            <a class="inline-block px-3 py-1 text-sm text-white bg-yellow-500 rounded hover:bg-yellow-600" href="Controlador?accion=editar&id=<%= per.getAtrId()%>">Editar</a>
                            <a class="inline-block px-3 py-1 text-sm text-white bg-red-500 rounded hover:bg-red-600" href="Controlador?accion=eliminar&id=<%= per.getAtrId()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>

