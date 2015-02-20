package br.getset.tapoica.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.getset.tapioca.modelo.Logica;

@WebServlet("/sistema")
public class ServletSistema extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res)
					throws ServletException, IOException{
		
			String classeName = "br.getset.tapioca.modelo."+req.getParameter("acao")+"Logica";
			try {
				Class<?> classe = Class.forName(classeName);
				Logica logica = (Logica) classe.newInstance();				
				logica.executa(req, res);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		
	}
	
}
