package jp.co.ex_beginner.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {

	@Autowired
	private HttpSession session;

	@RequestMapping("")
	public String input() {
		return "exam02";
	}

	@RequestMapping("/calcAdd")
	public String calcAdd(Integer num1, Integer num2) {
		Integer ans = num1 + num2;
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("ans", ans);
		return "exam02-result";
	}
	
	@RequestMapping("/to-result2")
	public String toResult2() {
		return "exam02-result2";
	}
}
