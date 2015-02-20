package br.getset.tapioca.modelo;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.getset.tapioca.dao.UsuarioDAO;

public class AdicionaUsuarioLogica implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		Usuario user = new Usuario();
		user.setNm_usuario(req.getParameter("nome"));
		user.setTp_usuario(req.getParameter("tipo"));
		user.setNm_login(req.getParameter("login"));
		user.setDs_senha(req.getParameter("senha"));
		
		Connection conn = (Connection)req.getAttribute("conexao");
		
		UsuarioDAO dao = new UsuarioDAO(conn);
		dao.cadastraUsuario(user);
		
		

	}

}
