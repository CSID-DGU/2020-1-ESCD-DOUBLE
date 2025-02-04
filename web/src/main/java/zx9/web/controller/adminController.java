package zx9.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pwchange.bouncy_change;
import zx9.web.dao.BankDao;
import zx9.web.dao.UserDao;
import zx9.web.vo.BankVO;
import zx9.web.vo.UserVO;

@Controller
public class adminController {

	@Autowired
	UserDao udao;
	@Autowired
	BankDao bdao;
	

	bouncy_change crt = new bouncy_change();
@RequestMapping("userall")
public String userall(Model m) {
	
	List<UserVO>ul=udao.GetallUser();
	m.addAttribute("alluser", ul);
	return "/admin/admin_user";
}
@RequestMapping("addbank")
public String addbank(BankVO bvo) {
	System.out.println(bvo.getBid());
	System.out.println(bvo.getBname());
	System.out.println(bvo.getBpw());

	
	
	bdao.addbank(bvo);
	bdao.addbank_list(bvo);
	
	//return "/admin/admin_bank";

	return "redirect:/bankall";
}
@RequestMapping("bankall")
public String bankall(Model m) {
	
	List<BankVO>bvo=bdao.GetallBank();
	m.addAttribute("allbank", bvo);
	return "/admin/admin_bank";

}
@RequestMapping("adminblist")
public String adminblist(String bname) {
	
	
	return "redirect:/blistall";
}
@RequestMapping("chmod")
public String chmod(UserVO u,Model m) {
	udao.chmod(u);
String msg="변경되었습니다.";
m.addAttribute("msg",msg);
return "/admin/chmod_ok";
	
	//	return "redirect:/userall";
}
}
