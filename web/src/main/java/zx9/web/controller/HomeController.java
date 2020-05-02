package zx9.web.controller;

import java.security.Provider;
import java.security.Security;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.StringFixedSaltGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zx9.web.dao.BankDao;
import zx9.web.dao.UserDao;
import zx9.web.vo.BankVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserDao udao;
	@Autowired
	BankDao bdao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		System.out.println("hello");
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("/test")
	public void test() {
	
		
		Security.addProvider(new BouncyCastleProvider());
		//PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor(); 
		//encryptor.setPassword("somePassword"); encryptor.setAlgorithm("PBEWITHSHA256AND128BITAES-CBC-BC");

		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor(); 
		encryptor.setPassword("somePassword"); encryptor.setAlgorithm("PBEWithMD5AndDES");
		String str = "testString"; String encStr = encryptor.encrypt(str); String decStr = encryptor.decrypt(encStr);
		//System.out.println("str :"+str+", encStr : "+encStr+" decStr :"+decStr);
//����� ���ට���� encStr�� ��ӹٲ�°� Ȯ�� �߰�...
		
		StandardPBEStringEncryptor encryptor2 = new StandardPBEStringEncryptor(); 
		encryptor2.setPassword("somePassword"); encryptor2.setAlgorithm("PBEWithMD5AndDES");
		encryptor2.setSaltGenerator(new StringFixedSaltGenerator("someFixedSalt"));
		 str = "testString";  encStr = encryptor2.encrypt(str);  decStr = encryptor2.decrypt(encStr);
	//	System.out.println("str :"+str+", encStr : "+encStr+" decStr :"+decStr);

		/*
		 * ��°��
		 * 
		str :testString, encStr : iRy3EI7x+o+ignCLGHZUvBcJku0bX8H6 decStr :testString
		str :testString, encStr : rEMYziBW/rGyMTc3ppqmUw== decStr :testString
		
		str :testString, encStr : Bh5jTX6TaXzDn5mXBwcbh2kKqEXEPWS6 decStr :testString
		str :testString, encStr : rEMYziBW/rGyMTc3ppqmUw== decStr :testString
		 * 
		 * */
		
		
		//��¥ bouncy ���
		
		

		
		
		PooledPBEStringEncryptor boun = new PooledPBEStringEncryptor(); 
		boun.setProvider(new BouncyCastleProvider()); 
		boun.setPassword("somePassword"); 
		boun.setAlgorithm("PBEWITHSHA256AND128BITAES-CBC-BC");		 
		boun.setPoolSize(5);
		 str = "testString";  encStr = boun.encrypt(str);  decStr = boun.decrypt(encStr);
		System.out.println("str :"+str+", encStr : "+encStr+" decStr :"+decStr);
		
		
		
		
		
		//�굵 ��µǴ°� ��� �ٲ�
		
		System.out.println("hi");
		Provider provider = Security.getProvider("BC");
		  if (provider != null){
		   System.out.println("Bouncy Castle provider is available");
		   System.out.println(provider.getInfo());
		  } else {
		   System.out.println("Bouncy Castle provider is NOT available");
		  }
		  
		
	}
	@RequestMapping("/index")
	public String index(HttpServletRequest request,Model m,BankVO b) {
		HttpSession session=request.getSession();
		System.out.println("session id : "+session.getAttribute("Sid"));
		if(session.getAttribute("Sid")!=null) {
			m.addAttribute("Sid", session.getAttribute("Sid"));
			m.addAttribute("Sgrade", session.getAttribute("Sgrade"));
			m.addAttribute("Siscouncil", session.getAttribute("Siscouncil"));
			m.addAttribute("Smajor", session.getAttribute("Smajor"));
			m.addAttribute("Sname", session.getAttribute("Sname"));
			m.addAttribute("Snum", session.getAttribute("Snum"));
			System.out.println(session.getAttribute("Sid"));
		//	if(Integer.parseInt(session.getAttribute("Siscouncil").toString())!=0) {
				b=bdao.select_bank(session.getAttribute("Smajor").toString());
				System.out.println(b.getBname());
				System.out.println("가져왔나?"+b.getBid());
				m.addAttribute("bank", b);
		//	}
		}
		
		
		
		
		
		return "template/index";
	}
	@RequestMapping("/a")
	public String instructor() {
		return "template/a";
	}
	@RequestMapping("/b")
	public String lecture() {
		return "template/b";
	}
	@RequestMapping("/bc")
	public void bc(){
		
	}
	
}
