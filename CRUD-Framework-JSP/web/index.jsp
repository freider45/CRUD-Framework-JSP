<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Personas</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <style>
        
        .center-content {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh; 
        }
    </style>
</head>
<body>
    <div class="container center-content">
        <div class="jumbotron text-center">
            <h1 class="display-4">¡Bienvenido!</h1>
            <hr class="my-4">
            <p>¿Qué te gustaría hacer hoy?</p>
            <a class="btn btn-primary btn-lg mr-3" href="Controlador?accion=listar">Listar Personas</a>
            <a class="btn btn-success btn-lg" href="Controlador?accion=add">Agregar Persona</a>
        </div>
    </div>
</body>
</html>