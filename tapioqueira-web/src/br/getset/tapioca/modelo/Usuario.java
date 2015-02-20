package br.getset.tapioca.modelo;

public class Usuario {

	private Long cd_usuario;
	private String nm_usuario;
	private String nm_login;
	private String ds_senha;
	private String tp_usuario;
	public Long getCd_usuario() {
		return cd_usuario;
	}
	public void setCd_usuario(Long cd_usuario) {
		this.cd_usuario = cd_usuario;
	}
	public String getNm_usuario() {
		return nm_usuario;
	}
	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}
	public String getNm_login() {
		return nm_login;
	}
	public void setNm_login(String nm_login) {
		this.nm_login = nm_login;
	}
	public String getDs_senha() {
		return ds_senha;
	}
	public void setDs_senha(String ds_senha) {
		this.ds_senha = ds_senha;
	}
	public String getTp_usuario() {
		return tp_usuario;
	}
	public void setTp_usuario(String tp_usuario) {
		this.tp_usuario = tp_usuario;
	}
	
	
	
}
