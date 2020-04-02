package ex_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManterCliente.do")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pEmail = request.getParameter("email");
		//instanciar o javabean
		Pais cliente = new Pais();
		cliente.setNome(pNome);
		cliente.setFone(pFone);
		cliente.setEmail(pEmail);
		//instanciar o service
		PaisService cs = new PaisService();
		cs.criar(cliente);
		cliente = cs.carregar(cliente.getId());
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>ClienteCadastrado</title></head><body>");
		out.println( "id: "+cliente.getId()+"<br>");
		out.println( "nome: "+cliente.getNome()+"<br>");
		out.println( "fone: "+cliente.getFone()+"<br>");
		out.println( "e-mail: "+cliente.getEmail()+"<br>");
		out.println("</body></html>");
	}
}