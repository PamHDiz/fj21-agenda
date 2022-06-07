package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.jdbc.Contato;
import br.com.caelum.agenda.jdbc.ContatoDao;

/**
 * Implementação da Servlet AdicionaContato que será responsável por capturar os dados digitados pelo usuário na página
 * html adiciona-contato.html e gravá-los no BD.
 */

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// busca o writer
			PrintWriter out = response.getWriter();
			
			//recebem os parametros da página usando request
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String email = request.getParameter("email");
			String dataEmTexto = request.getParameter("dataNascimento");
			Calendar dataNascimento = null;
			
			// conversão da String data para formato Date
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(date);
			} catch (ParseException e) {
				out.println("Erro de conversão da data");
				return;
			}
			
			//Cria o objeto tipo Contato
			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setEndereco(endereco);
			contato.setEmail(email);
			contato.setDataNascimento(dataNascimento);
			
			// salva o contato no Banco de Dados
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			
			
			// imprime na página da web o nome do contato que foi gravado
			out.println("<html>");
			out.println("<body>");
			out.println("Contato " + contato.getNome() + " adicionado com sucesso");
			out.println("</body>");
			out.println("</html>");
		}

}
