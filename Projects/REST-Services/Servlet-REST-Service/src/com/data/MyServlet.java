package com.data;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served with get method at: ").append(request.getContextPath());
		String value = request.getParameter("userName");
		if(value!=null)
			response.getWriter().println("</br>The value length read in get method is  "+value.length());
		
		//read the path parameters
		PrintWriter out = response.getWriter();
		 String pathInfo = request.getPathInfo();  
		 if(pathInfo==null)
			 return;
		 System.out.println("The path parametrs are "+pathInfo);
		 String[] pathParts = pathInfo.split("/");
		 String part1 = pathParts[1];  
		 String part2 = pathParts[2]; 
		 if(part1==null && part2==null)
		 {
			 out.print("No Request Data.."); 
			 return;
		 }
		 out.print("user:"+part1);
		 out.print("</br>");
		 out.print("Name:"+part2);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served with post method at: ").append(request.getContextPath());
		String value = request.getParameter("userName");
		response.getWriter().println("</br>The value read is  "+value);
		
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served with put method at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served with delete method at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doHead(HttpServletRequest, HttpServletResponse)
	 */
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served with head method at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served with options method at: ").append(request.getContextPath());
	}

}
