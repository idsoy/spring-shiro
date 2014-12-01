package org.llh.ssl.aciton;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.llh.ssl.bean.Page;
import org.llh.ssl.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描    述:
 * 作    者:lilianghui
 * 日    期:2014年12月1日下午3:33:03
 * 版权所有:深圳市鼎丰在线金融服务有限公司
 * 版    本:V1.0
 */
@Controller
@RequestMapping("page")
public class PageAction {

	@RequestMapping("")
	public String index(HttpServletRequest request) {
		
		List<User> users = new ArrayList<User>();
		
		int count = 0;
		
		while(count <10){
			users.add(new User(UUID.randomUUID().toString(), "----"));
			count++;
		}
		
		Page page = new Page();
		
		page.setUrl("page");
		
		page.setPageNo(5);
		page.setPageSize(10);
		page.setRecordCount(503);
		
		request.setAttribute("users", users);
		request.setAttribute("page", page);
		
		return "page";
	}
	
}


