package br.getset.tapioca.modelo;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.getset.tapioca.dao.UsuarioDAO;

public class CarregaAlteraUsuarioLogica implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Connection conn = (Connection) req.getAttribute("conexao");
		UsuarioDAO dao = new UsuarioDAO(conn);
		Usuario user = dao.getUsuario(Long.parseLong(req.getParameter("cod")));
		
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("/alteraUsuario.jsp");
		rd.forward(req, res);

	}

}
