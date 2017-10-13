<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="modelo.GestionTemas,javabeans.Tema,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Ahora viene lo bueno</h1>
		
		<%
		GestionTemas temas=new GestionTemas();
        List<Tema> temitas =temas.recuperarTemas();
	
%>

         <select name="tema">
            <option>Seleccione tema</option>
            
				<% for(Tema t: temitas){%>
				<option value="<%=t.getIdTema() %>"><%=t.getTema() %></option>
					
				<% }%>
        </select>	
        <br><br><br><br><br><br>
        <a href="Controller?op=toLogin"><h2>Volver</h2></a>
        <a href="Controller?op=doListado&tema"><h2>Ver libros</h2></a>
        
	</center>
</body>
</html>