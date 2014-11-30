package org.llh.ssl.aciton;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserAction {

	@RequestMapping("")
	@ResponseBody
	public String index() {
		return "Hello shiro";
	}
	
	@RequestMapping("secret")
	@ResponseBody
	public String secret() {
		return "This is my secret";
	}
	
}
