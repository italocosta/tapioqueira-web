package br.getset.tapioca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.getset.tapioca.modelo.Usuario;

public class UsuarioDAO {
	
	Connection conn;
	
	public UsuarioDAO(Connection c){
		this.conn = c;
	}
	
	public void cadastraUsuario(Usuario u){
		String sql = "insert into tb_usuario "
				+ "(nm_usuario,nm_login,ds_senha,tp_usuario)"
				+ "values (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getNm_usuario());
			ps.setString(2, u.getNm_login());
			ps.setString(3, u.getDs_senha());
			ps.setString(4, u.getTp_usuario());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
