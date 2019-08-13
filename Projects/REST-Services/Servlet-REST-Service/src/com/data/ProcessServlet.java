package com.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessServlet
 */
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("ProcessServlet.doGet()");
		 PrintWriter out = response.getWriter();
		 //read the request parameter
		 String data = request.getParameter("ID");
		 if(data!=null)
		 {
			 out.print("user:"+data);
			 return;
		 }
		 else
		 { 
			 //read the path parameters
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
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
