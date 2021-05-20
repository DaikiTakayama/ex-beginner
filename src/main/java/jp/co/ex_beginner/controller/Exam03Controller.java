package jp.co.ex_beginner.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {

	@Autowired
	private ServletContext application;

	@RequestMapping("")
	public String input() {
		return "exam03";
	}

	@RequestMapping("/amountPrice")
	public String amoutPrice(Integer product1, Integer product2, Integer product3) {
		Integer nonTaxPrice = product1 + product2 + product3;
		Integer taxIncludePrice = (int)(nonTaxPrice * 1.1);
		
		application.setAttribute("nonTaxPrice", nonTaxPrice);
		application.setAttribute("taxIncludePrice", taxIncludePrice);
		
		return "exam03-result";
		
	}
}
