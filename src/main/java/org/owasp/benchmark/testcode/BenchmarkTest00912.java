/**
* OWASP Benchmark Project v1.2beta
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00912")
public class BenchmarkTest00912 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("vector");
		
		
		// Chain a bunch of propagators in sequence
		String a89008 = param; //assign
		StringBuilder b89008 = new StringBuilder(a89008);  // stick in stringbuilder
		b89008.append(" SafeStuff"); // append some safe content
		b89008.replace(b89008.length()-"Chars".length(),b89008.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89008 = new java.util.HashMap<String,Object>();
		map89008.put("key89008", b89008.toString()); // put in a collection
		String c89008 = (String)map89008.get("key89008"); // get it back out
		String d89008 = c89008.substring(0,c89008.length()-1); // extract most of it
		String e89008 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89008.getBytes() ) )); // B64 encode and decode it
		String f89008 = e89008.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g89008 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g89008); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length);
		}
	}
}
