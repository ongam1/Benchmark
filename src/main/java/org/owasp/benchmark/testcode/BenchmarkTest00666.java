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

@WebServlet("/BenchmarkTest00666")
public class BenchmarkTest00666 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("vector");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a14068 = param; //assign
		StringBuilder b14068 = new StringBuilder(a14068);  // stick in stringbuilder
		b14068.append(" SafeStuff"); // append some safe content
		b14068.replace(b14068.length()-"Chars".length(),b14068.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14068 = new java.util.HashMap<String,Object>();
		map14068.put("key14068", b14068.toString()); // put in a collection
		String c14068 = (String)map14068.get("key14068"); // get it back out
		String d14068 = c14068.substring(0,c14068.length()-1); // extract most of it
		String e14068 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14068.getBytes() ) )); // B64 encode and decode it
		String f14068 = e14068.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f14068); // reflection
		
		
		int randNumber = new java.util.Random().nextInt(99);
		String rememberMeKey = Integer.toString(randNumber);
		
		String user = "Inga";
		String fullClassName = this.getClass().getName();
		String testCaseNumber = fullClassName.substring(fullClassName.lastIndexOf('.')+1+"BenchmarkTest".length());
		user+= testCaseNumber;
		
		String cookieName = "rememberMe" + testCaseNumber;
		
		boolean foundUser = false;
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && ++i < cookies.length && !foundUser;) {
			javax.servlet.http.Cookie cookie = cookies[i];
			if (cookieName.equals(cookie.getName())) {
				if (cookie.getValue().equals(request.getSession().getAttribute(cookieName))) {
					foundUser = true;
				}
			}
		}
		
		if (foundUser) {
			response.getWriter().println("Welcome back: " + user + "<br/>");			
		} else {			
			javax.servlet.http.Cookie rememberMe = new javax.servlet.http.Cookie(cookieName, rememberMeKey);
			rememberMe.setSecure(true);
			request.getSession().setAttribute(cookieName, rememberMeKey);
			response.addCookie(rememberMe);
			response.getWriter().println(user + " has been remembered with cookie: " + rememberMe.getName() 
					+ " whose value is: " + rememberMe.getValue() + "<br/>");
		}
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}
}
