

<html>
	<body>
		<%-- coment?rio em JSP: nossa primeira p?gina JSP --%>
		
		<%
			String mensagem = "Bem vindo ao sistema de agenda do FJ-21";
		%>
		<% out.println(mensagem); %>
		
		<br/>
		
		<%
			String desenvolvido = "Desenvoldido por Pamella";
		%>
		<%= desenvolvido %>
		
		<br/>
		
		<%
			System.out.println("Tudo foi executado!");
		%>
	</body>
</html>