package com.foodDelivery.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodDelivery.connection.DbCon;
import com.foodDelivery.dao.OrderDao;
import com.foodDelivery.model.*;


@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter()){
			SimpleDateFormat formatter=new SimpleDateFormat("yyyyy-MM-dd");
			
			Date date=new Date();
			//retrieve all cart products
			ArrayList<Cart> cart_list=(ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			//user authentication
			User auth=(User)request.getSession().getAttribute("auth");
			//check auth and cart list
			if(cart_list!=null && auth!=null) {
				for(Cart c:cart_list) {
					//prepare the order object
					Order order=new Order();
					order.setId(c.getId());
					order.setUid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));
					
					//instantiate the dao class
					OrderDao oDao=new OrderDao(DbCon.getConnection());
					
					//calling the insert method
					boolean result=oDao.insertOrder(order);
					if(!result) break;
					
				}
				cart_list.clear();
				response.sendRedirect("orders.jsp");
			}else {
				if(auth==null) {response.sendRedirect("login.jsp");}
				else{response.sendRedirect("cart.jsp");}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
