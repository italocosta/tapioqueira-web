package br.getset.tapioca.dao;

import java.sql.Connection;

public class TestaCon {

	public static void main(String[] args) {
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("Conectou !");
	}

}
