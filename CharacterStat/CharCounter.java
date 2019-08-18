package com.vogella.web.filecounter.langAnalysis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @ Author: Hesham El Abd
 */
@WebServlet("/CharCounter")
public class CharCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CharCounter() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input=request.getParameter("input_text");
		PrintWriter output = response.getWriter();
		response.setContentType("text/html");
		if(input==null) {
			output.println("<h1 style=\"color:red\">No input was provdied !!!</h1>");	
			return;
		} else if(input.length()<1) {
			output.println("<h2 style=\"color:red\">you have only one character!!!</h1><br>");
			output.println("<i> your character is: "+input+ " which occured once.</i><br>");
			return;
		}
		HashMap<String,Integer> CharFreq = new HashMap<String,Integer>();
		char [] inputChar = input.toCharArray();
		for (char achar:inputChar) {
			if(CharFreq.containsKey(String.valueOf(inputChar))) {
				Integer old_value= CharFreq.get(String.valueOf(achar));
				CharFreq.replace(String.valueOf(achar), old_value+1);
			}else {
				CharFreq.put(String.valueOf(achar),1);
			}
		}
		TreeMap<String,Integer> SortedRes = new TreeMap<String,Integer>(CharFreq);
		output.println("<h1 style=\"color:blue\"> Your Results: </h1>");
		output.println("<div> char	: Count <br>");
		for( String akey:SortedRes.keySet()) {
			output.println(akey+"&emsp;,&emsp;"+SortedRes.get(akey)+" <br>");
		}
		output.println("</div>");
	}

}
