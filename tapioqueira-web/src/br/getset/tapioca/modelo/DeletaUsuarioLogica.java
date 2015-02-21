package br.getset.tapioca.modelo;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.getset.tapioca.dao.UsuarioDAO;

public class DeletaUsuarioLogica implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Connection conn = (Connection) req.getAttribute("conexao");
		UsuarioDAO dao = new UsuarioDAO(conn);
		dao.deletaUsuario(Long.parseLong(req.getParameter("cod")));		
		res.sendRedirect("sistema?acao=ListaUsuario");

	}

}
