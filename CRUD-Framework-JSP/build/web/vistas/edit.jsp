
<%@page import="Modelo.Persona"%>
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
            <div class="w-full lg:w-1/2 mx-auto">
              <%
              PersonaDAO dao=new PersonaDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Persona p=(Persona)dao.list(id);
          %>
            <h1 class="text-4xl font-bold mb-4">Modificar Persona</h1>
            <form action="Controlador">
                DNI:<br>
                <input class="form-control px-3 py-2 border rounded" type="text" name="txtDni" value="<%= p.getAtrDni()%>"><br>
                Nombres: <br>
                <input class="form-control px-3 py-2 border rounded" type="text" name="txtNom" value="<%= p.getAtrName()%>"><br>
                Apellidos:<br>
                <input class="form-control px-3 py-2 border rounded" type="text" name="txtApe" value="<%= p.getAtrLstName()%>"><br>
                Telefono: <br>
                <input class="form-control px-3 py-2 border rounded" type="text" name="txtTel" value="<%= p.getAtrPhone()%>"><br>
                Email:<br>
                <input class="form-control px-3 py-2 border rounded" type="text" name="txtEma" value="<%= p.getAtrEmail()%>"><br>
                Residencia: <br>
                <input class="form-control px-3 py-2 border rounded" type="text" name="txtRes" value="<%= p.getAtrResid()%>"><br>

                <input type="hidden" name="txtid" value="<%= p.getAtrId()%>">
                <input class="inline-block px-6 py-2 text-lg text-white bg-blue-500 rounded hover:bg-blue-600 mt-4" type="submit" name="accion" value="Actualizar"> 
                <a class="inline-block px-6 py-2 text-lg bg-gray-300 rounded hover:bg-gray-400 mt-4 ml-4" href="Controlador?accion=listar">Regresar</a>
            </form>
          </div>

        </div>
    </body>
</html>


