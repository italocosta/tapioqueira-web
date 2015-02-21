package br.getset.tapioca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void alteraUsuario(Usuario u){
		boolean alteraSenha = true;
		String sql = "";
		if(u.getDs_senha().equals("") ){
			sql = "update tb_usuario set nm_usuario = ?,"
					 + "nm_login = ?,"
					 + "tp_usuario = ?"
					 + "where cd_usuario = ?";
			alteraSenha = false;			
		}
		else{
			sql = "update tb_usuario set nm_usuario = ?,"
											 + "nm_login = ?,"
											 + "ds_senha = ?,"
											 + "tp_usuario = ?"
											 + "where cd_usuario = ?";
		}
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getNm_usuario());
			ps.setString(2, u.getNm_login());
			if (alteraSenha)
			ps.setString(3, u.getDs_senha());
			ps.setString(alteraSenha?4:3, u.getTp_usuario());
			ps.setLong(alteraSenha?5:4, u.getCd_usuario());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deletaUsuario(Long id){
		String sql = "delete from tb_usuario where cd_usuario = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Usuario> listaUsuario(){
		String sql = "select cd_usuario,nm_usuario,nm_login,ds_senha,tp_usuario from tb_usuario";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			List<Usuario> lista = new ArrayList<Usuario>();
			Usuario user = null;
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new Usuario();
				user.setCd_usuario(rs.getLong(1));
				user.setNm_usuario(rs.getString(2));
				user.setNm_login(rs.getString(3));
				user.setDs_senha(rs.getString(4));
				user.setTp_usuario(rs.getString(5));
				lista.add(user);
			}
			rs.close();
			ps.close();
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public Usuario getUsuario(Long id){
		String sql = "select cd_usuario,nm_usuario,nm_login,ds_senha,tp_usuario from tb_usuario where cd_usuario = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			Usuario user = new Usuario();
			ResultSet rs = ps.executeQuery();
			rs.next();
			user.setCd_usuario(rs.getLong(1));
			user.setNm_usuario(rs.getString(2));
			user.setNm_login(rs.getString(3));
			user.setDs_senha(rs.getString(4));
			user.setTp_usuario(rs.getString(5));
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
