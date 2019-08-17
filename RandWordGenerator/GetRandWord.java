package com.vogella.web.filecounter.randWordGenServelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.vogella.web.filecounter.randGenJava.RandWordGen;

/**
 * Servlet implementation class GetRandWord
 */
@WebServlet("/GetRandWord")
public class GetRandWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RandWordGen wordGen= new RandWordGen();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.println("Generating your random word: "+wordGen.getRandWord());
	
	
	}

}
