package com.rubypaper.web.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rubypaper.biz.user.UserService;
import com.rubypaper.biz.user.UserVO;

@org.springframework.stereotype.Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(UserVO vo) {
//		System.out.println(9 / 0);
		vo.setId("admin");
		vo.setPassword("admin");

		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo,  HttpSession session) {
		UserVO user = userService.getUser(vo);
		if (user != null) {
			session.setAttribute("user", user);
			return "forward:getBoardList.do";
		} else {
			return "login";
		}

	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {

		session.invalidate();

		return "forward:index.jsp";

	}

}
