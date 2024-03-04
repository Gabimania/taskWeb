<%@ page import="com.gabriel.taskweb.models.ModeloBase" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
    //Código para evitar el fallo de conexión con la base de datos.
    //Alternativa, configurar un pool de conexiones en el servidor tomcat
    ModeloBase modeloBase=new ModeloBase() {
        @Override
        protected String getNombreTabla() {
            return null;
        }
    };
    modeloBase.getConnection();
%>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>