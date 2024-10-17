package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/arithmeticurl")
public class ArithmeticServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// get printWriter
		PrintWriter pw = res.getWriter();
		// set response content type
		res.setContentType("text/html");
		// read additional req param value
		String s1Val = req.getParameter("s1");
		// read text boxes values and convert them floating point values when the submit
		// buttons are clicked
		float val1 = 0.0f, val2 = 0.0f;
		if (!s1Val.equalsIgnoreCase("link1") && !s1Val.equalsIgnoreCase("link2")) {
			val1 = Float.parseFloat(req.getParameter("t1"));
			val2 = Float.parseFloat(req.getParameter("t2"));
		}

		// get system date and time
		LocalDateTime ldt = LocalDateTime.now();
		// differentiate the logic for multiple submit buttons and hyperlinks
		if (s1Val.equalsIgnoreCase("add")) {
			pw.println("<h1 style='color:greeen;text-align:center'>Addition::" + (val1 + val2) + "</h1>");
		} else if (s1Val.equalsIgnoreCase("sub")) {
			pw.println("<h1 style='color:greeen;text-align:center'>Subtraction::" + (val1 - val2) + "</h1>");
		} else if (s1Val.equalsIgnoreCase("mul")) {
			pw.println("<h1 style='color:greeen;text-align:center'>Multiplication::" + (val1 * val2) + "</h1>");
		} else if (s1Val.equalsIgnoreCase("div")) {
			pw.println("<h1 style='color:greeen;text-align:center'>Divison::" + (val1 / val2) + "</h1>");
		} else if (s1Val.equalsIgnoreCase("link1")) {

			// get Current hour of the day
			int hour = ldt.getHour();// 24 hours format
			if (hour < 12) {
				pw.println("<h1 style='color:orange;text-align:center'>Good Morning</h1>");
			} else if (hour < 16) {
				pw.println("<h1 style='color:red;text-align:center'>Good Afternoon</h1>");
			} else if (hour < 20) {
				pw.println("<h1 style='color:green;text-align:center'>Good Evening</h1>");
			} else {
				pw.println("<h1 style='color:pink;text-align:center'>Good Night</h1>");
			}
		} else {
			// get current month
			int month = ldt.getMonthValue();
			if (month >= 3 && month <= 6)
				pw.println("<h1 style='color:orange;text-align:center'>Summer Season</h1>");
			else if (month >= 7 && month <= 10)
				pw.println("<h1 style='color:red;text-align:center'>Rainy Season</h1>");
			else
				pw.println("<h1 style='color:pink;text-align:center'>Winter Season</h1>");

		}
		//add home hyperlink
		pw.println("<h1 style='color:green;text-align:center'><a href='input.html'>home</a></h1>");
        //close stream
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
