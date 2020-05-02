package zx9.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zx9.web.dao.UserDao;
import zx9.web.vo.UserVO;

@Controller
public class RegisterController {

	
	
	@Autowired
	UserDao udao;
	
	@RequestMapping("/register")
	public String register() {

		return "/register";
	}
	@RequestMapping("/register_ok")//�쉶�썝 媛��엯 -> �븫�샇�솕 ?��꾨쾲�씠 �뱾�뼱媛�寃뚮�?
	public String register_ok(UserVO a) {

		System.out.println(a.toString());
		udao.register(a);
		return "/register/register_ok";
	}
	@RequestMapping("/register_form")
	public String register_form() {
		return "/register/registerForm";
	}
	@RequestMapping("/login_form")
	public String login_form() {
		return "/register/loginForm";
		
	}	
	@RequestMapping("/login_ok")
	public String login_ok(UserVO a,Model m,HttpServletRequest request) {
		HttpSession session=request.getSession();
		boolean isLoginOk=udao.login(a);
		String msg;
		if(isLoginOk) {
			msg="환영 합니다";
			a=udao.getall(a);
			
			session.setAttribute("Sid", a.getSid());
			session.setAttribute("Sgrade", a.getSgrade());
			session.setAttribute("Siscouncil", a.getSiscouncil());
			session.setAttribute("Smajor", a.getSmajor());
			session.setAttribute("Sname", a.getSname());
			session.setAttribute("Snum", a.getSnum());
		
		}else {
			msg="id와 비밀번호를 확인해 주세요";	
			m.addAttribute("key",1);
		}
		m.addAttribute("msg", msg);
		
		return "/register/login_ok";
		
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
	HttpSession session=request.getSession();
	session.invalidate();
	return "/register/logout";	
	}

	@RequestMapping("/mypage")
	public String mypage(HttpServletRequest request,Model m) {
		HttpSession session=request.getSession();
		m.addAttribute("Sid", session.getAttribute("Sid"));
		m.addAttribute("Sgrade", session.getAttribute("Sgrade"));
		m.addAttribute("Siscouncil", session.getAttribute("Siscouncil"));
		m.addAttribute("Smajor", session.getAttribute("Smajor"));
		m.addAttribute("Sname", session.getAttribute("Sname"));
		m.addAttribute("Snum", session.getAttribute("Snum"));
		
		
		return "/register/mypage";
	}
	
	
}
