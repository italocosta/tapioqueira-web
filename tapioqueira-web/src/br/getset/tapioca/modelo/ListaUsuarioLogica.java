package br.getset.tapioca.modelo;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.getset.tapioca.dao.UsuarioDAO;

public class ListaUsuarioLogica implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Connection conn = (Connection) req.getAttribute("conexao");
		UsuarioDAO dao = new UsuarioDAO(conn);
		List<Usuario> lista = dao.listaUsuario();
		
		req.setAttribute("lista", lista);
		
		RequestDispatcher rd = req.getRequestDispatcher("/listaUsuarios.jsp");
		rd.forward(req, res);

	}

}
