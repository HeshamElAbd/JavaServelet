package com.vogella.web.filecounter.wordFreqEst;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WordFreq
 */
@WebServlet("/WordFreq")
public class WordFreq extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input =request.getParameter("input_text");
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		HashMap<String,Integer> counts= new HashMap<String,Integer>();
		out.write("<html> ");
		if (input.length()==0) {
			out.write("<h4 style= \"color:red\"> You have not provide any text!!</h4><br> ");
			out.write("<h4 style= \"color:blue\"> please provide an input text and try again!!</h4><br> ");
			return;
		} else {
			String[] words=input.split(" ");
			for(String word:words) {
				if(counts.containsKey(word)) {
					counts.replace(word, counts.get(word)+1);
				} else {
					counts.put(word,1);
				}
			}
		}
		TreeMap<String,Integer> sortedCount=new TreeMap<String,Integer>(counts);
		out.write("<div>");
		out.write("<h3 style=\"color:blue\"> Word , counts </h3> <br>");
		for(String word:sortedCount.keySet()) {
			out.write(word +" , "+ sortedCount.get(word)+" <br>");
		}
		out.write("</html>");
	}

}
