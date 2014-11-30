package org.llh.ssl.aciton;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.llh.ssl.bean.Role;
import org.llh.ssl.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexAction {

	@RequestMapping("")
	@ResponseBody
	public String index() {
		return "index";
	}
	
	@RequestMapping("login")
	@ResponseBody
	public String login(){
		return "please login!";
	}
	
	@RequestMapping("toLogin")
	public String toLogin() {
		String username = "shiro";
		String password = "123456";
		User user = new User("shiro", "123456");
		user.setRole(new Role("user"));
		try {
			// 如果登陆成功
			if (user.getName().equals(username)
					&& user.getPassword().equals(password)) {
				UsernamePasswordToken token = new UsernamePasswordToken(
						user.getName(), user.getPassword().toString());
				Subject subject = SecurityUtils.getSubject();
				subject.login(token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/user/secret";
	}
	
	@RequestMapping("logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/";
	}
	
}
