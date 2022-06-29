<%@ page import="java.util.* ,
		br.com.caelum.agenda.jdbc.*,
		java.text.SimpleDateFormat"%>
<!DOCTYPE html>
	<html>
		<head>
		<title>Lista de Contatos</title>
		</head>
		<body>
			<table>
			<%
				ContatoDao dao = new ContatoDao();
				List<Contato> contatos = dao.getLista();
				SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
				
				for(Contato contato : contatos) {
			%>
				<tr>
					<td><%= contato.getNome() %></td>
					<td><%= contato.getEmail() %></td>
					<td><%= contato.getEndereco() %></td>
					<td><%= date.format(contato.getDataNascimento().getTime()) %></td>
				</tr>
			<%
				}
			%>
			</table>
		</body>
	</html>