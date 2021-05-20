package jp.co.ex_beginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.ex_beginner.domain.User;
import jp.co.ex_beginner.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}

	@RequestMapping("")
	public String index() {
		return "exam04";
	}

	@RequestMapping("/userReceive")
	public String userReceiveForm(@Validated UserForm userReceive,
								BindingResult result,
								Model model) {
		
		
		if(result.hasErrors()) {
			return "exam04";
		}
		
		User user = new User();
		user.setName(userReceive.getName());
		user.setAge(userReceive.getAge());
		user.setComment(userReceive.getComment());
		model.addAttribute("user",user);

		return "exam04-result";
	}
}
