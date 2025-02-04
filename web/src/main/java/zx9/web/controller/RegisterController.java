package zx9.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pwchange.bouncy_change;
import zx9.web.dao.BankDao;
import zx9.web.dao.BlistDao;
import zx9.web.dao.BlmsgDao;
import zx9.web.dao.UserDao;
import zx9.web.vo.BankVO;
import zx9.web.vo.BlistVO;
import zx9.web.vo.BlmsgVO;
import zx9.web.vo.UserVO;

@Controller
public class RegisterController {

	
	
	@Autowired
	UserDao udao;

	@Autowired
	BlmsgDao blmdao;
	@Autowired
	BankDao bdao;
	
	
	bouncy_change crt = new bouncy_change();
	
	@RequestMapping("/register")
	public String register() {

		return "/register";
	}
	@RequestMapping("/register_ok")
	public String register_ok(UserVO a,Model m) {
		System.out.println("id"+a.getSid());
		System.out.println("name"+a.getSname());
		System.out.println("pw"+a.getSpw());
		System.out.println("major"+a.getSmajor());
		System.out.println("num"+a.getSnum());
		System.out.println("grade"+a.getSgrade());
		
		try {
		//System.out.println("?");
		
		if(a.getSid()==null||a.getSname()==null||a.getSpw()==null||a.getSmajor()==null||a.getSnum()==null||a.getSgrade()==0)
			{return "/index";}
					
		//System.out.println(a.toString());

		a.setSpw(crt.CryptoSHA3(a.getSpw(), 224));
		udao.register(a);
		return "/register/register_ok";}
		catch(Exception e) {

			String msg="공백은 불허 합니다";
			m.addAttribute("msg",msg);
			
			return "/errorhandle";
		}
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

		
		a.setSpw(crt.CryptoSHA3(a.getSpw(), 224));
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
	public String mypage(HttpServletRequest request,BankVO bvo,BlmsgVO blm,Model m) {
		HttpSession session=request.getSession();
		m.addAttribute("Sid", session.getAttribute("Sid"));
		m.addAttribute("Sgrade", session.getAttribute("Sgrade"));
		m.addAttribute("Siscouncil", session.getAttribute("Siscouncil"));
		m.addAttribute("Smajor", session.getAttribute("Smajor"));
		m.addAttribute("Sname", session.getAttribute("Sname"));
		m.addAttribute("Snum", session.getAttribute("Snum"));
		if(Integer.parseInt(session.getAttribute("Siscouncil").toString())==10)
		{
			}
		else if(Integer.parseInt(session.getAttribute("Siscouncil").toString())>1) {

			
			int page=1;// 현재 쪽 번호
			int limit=10;//한 페이지에 보여지는 목록 개수
			
			if(request.getParameter("page")!=null) {
				//전달된 page가 존재한다면
				page=Integer.parseInt(request.getParameter("page"));// 내가봤을때는 좀더 효율적으로 바꿀 수 있음
				System.out.println("list 받은 값 : "+page);
				
			}
			blm.setStartrow((page-1)*10+1);
			blm.setEndrow(blm.getStartrow()+limit-1);

			String Bid=bdao.select_bank(session.getAttribute("Smajor").toString()).getBid();
			blm.setBid(Bid);
			int totalCount=this.blmdao.getCount(Bid);// 총 게시물 개수
			
			
			System.out.println("못가져오나 계좌?mypage"+Bid);
			
			List<BlmsgVO> BL=blmdao.select_list(blm);

			int maxpage=(int)((double)totalCount/limit+0.95);
			
			//현재 페이지에 보여질 시작 페이지                               page=5라면  1.4 -1  0.4*10+1=5
			int startpage=(((int)((double)page/10+0.9))-1)*10+1;      
			int endpage=maxpage;
			if(endpage>startpage+10-1) {
				endpage=startpage+10-1;
			}
			System.out.println("total: "+ totalCount);
			System.out.println("start : "+ startpage);
			System.out.println("end: "+endpage);
			System.out.println("max : "+maxpage);
			System.out.println("p : "+page);
			m.addAttribute("totalCount",totalCount);
			m.addAttribute("startpage",startpage);
			m.addAttribute("endpage",endpage);
			m.addAttribute("maxpage", maxpage);
			m.addAttribute("page", page);
			
			m.addAttribute("bl", BL);
			
			System.out.println("blmsg: "+BL.toString());
			return "/register/mypage";
			
			
			
			
		}
		
		
		return "/register/mypage";
	}
	
	
}
