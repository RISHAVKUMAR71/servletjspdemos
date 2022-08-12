package com;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class ProductStoreController
 */
public class ProductStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductStoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		float price=Float.parseFloat(request.getParameter("price"));
		product p=new product();
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		
		ProductService ps=new ProductService();
		
		String result=ps.storeProduct(p);
		pw.print(result);
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request,response);
	}

}
