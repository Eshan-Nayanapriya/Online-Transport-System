package com.rental;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateRentServlet", urlPatterns = { "/UpdateRentServlet" })
public class UpdateRentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Uid = request.getParameter("urid");
		String Uname = request.getParameter("uname");
		String UpickLocation = request.getParameter("upick-location");
		String UdropLocation = request.getParameter("udrop-location");
		String Uemail = request.getParameter("uemail");
		String Uphone = request.getParameter("uphone");
		String Uother = request.getParameter("uotherD");

		boolean isTrue = false;
		double amount;
		isTrue = DBUtil.update(Uid, Uname, UpickLocation, UdropLocation, Uemail, Uphone, Uother);

		if (isTrue == true) {
			List<RentDetails> rentdetails = DBUtil.read();
			request.setAttribute("rentdetails", rentdetails);
			amount = DBUtil.CalculateDistance(UpickLocation, UdropLocation);//*************
			request.setAttribute("amount", amount);//*************
			if (!rentdetails.isEmpty()) {
				RequestDispatcher dil = request.getRequestDispatcher("payment.jsp");//****************
				dil.forward(request, response);//******************
				RequestDispatcher dis = request.getRequestDispatcher("payment.jsp");
				dis.forward(request, response);
			} else {
				RequestDispatcher dis = request.getRequestDispatcher("fail.jsp");
				dis.forward(request, response);
			}
		} else {
			System.out.println("Update failed.");
		}
	}
}