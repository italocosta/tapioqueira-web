package br.getset.tapioca.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.getset.tapioca.dao.ConnectionFactory;

@WebFilter("/sistema")
public class FiltroConn implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest sreq, ServletResponse sres,
			FilterChain chain) throws IOException, ServletException {
		
			Connection conn = new ConnectionFactory().getConnection();
			
			HttpServletRequest req = (HttpServletRequest) sreq;
			req.setAttribute("conexao", conn);
			
			chain.doFilter(sreq, sres);
			
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
