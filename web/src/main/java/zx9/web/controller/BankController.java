package zx9.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import chain.Util;
import pwchange.bouncy_change;
import zx9.web.dao.BankDao;
import zx9.web.dao.BlistDao;
import zx9.web.dao.BlmsgDao;
import zx9.web.vo.BankVO;
import zx9.web.vo.BlistVO;

@Controller
public class BankController {

	@Autowired
	BlistDao bldao;
	@Autowired
	BankDao bdao;
	
	@Autowired
	BlmsgDao blmdao;

	//bouncy_change crt = new bouncy_change();
	@RequestMapping("blockchain")
	String verify(Model m,HttpServletRequest request) {
		HttpSession session=request.getSession();
		//session.getAttribute("Smajor").toString()
		BankVO bvo=bdao.select_bank(session.getAttribute("Smajor").toString());
		List<List<BlistVO>> a=bldao.blockchain(bvo.getBid());
		List<BlistVO>blv1=a.get(0);
		List<BlistVO>blv2=a.get(1);
		List<BlistVO>blv3=a.get(2);
		
		System.out.println(blv1.size());
		System.out.println(blv2.size());
		System.out.println("1:");
		for(int i=0;i<blv1.size();i++) {
			blv1.get(i).print();
			
		}
		System.out.println("2:");
		for(int i=0;i<blv2.size();i++) {
			blv2.get(i).print();
		}
		m.addAttribute("blv1",blv1);
		m.addAttribute("blv2",blv2);
		m.addAttribute("blv3",blv3);
		
		
		return "/bank/verify";
	}
	
	@RequestMapping("/c")
	public void c(){
		// 해쉬값도 바꿔서 칼럼에는 문제 없게 바꾸기
		
		BlistVO bl=bldao.selseq(194);
		Integer a=bl.getBinout();
		Integer b=bl.getBrest();
		String thishash=bl.getBmemo()+bl.getBuser()+a.toString()+b.toString()+bl.getPrehash();
		thishash=Util.getHash(thishash);
		System.out.println(thishash);
		
	}
	
	
	@RequestMapping("/purchase")
	String purchase() {
		return "/bank/purchase";
	}
	
	@RequestMapping("/upload_ok")
	String upload_ok(BlistVO blv,BankVO bv,HttpServletRequest request,Model m,
			RedirectAttributes rttr, @RequestParam("imgFile") MultipartFile imgFile , Model model ) {
		HttpSession session=request.getSession();
if(!imgFile.isEmpty()) {
	BankVO newbv=bdao.select_bank(session.getAttribute("Smajor").toString());
	blv.setBid(newbv.getBid());
			System.out.println("냐옹");
			String savePath="C:\\Users\\bohee\\source\\dospace_web\\web\\src\\main\\webapp\\resources\\fileupdown";
			System.out.println("uploadFile");
			
			String originalFilename = imgFile.getOriginalFilename(); // fileName.jpg
		    String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
		    String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg
		 
		    String rename = onlyFileName + extension; // fileName_20150721-14-07-50.jpg
		    String fullPath = savePath + "\\" + rename;
		   
		        try {
		            byte[] bytes = imgFile.getBytes();
		            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
		            stream.write(bytes);
		            stream.close();
		          //  bldao.fileio(rename);
		            blv.setFname(rename);
		            bldao.fileio(blv);
		            
		            model.addAttribute("resultMsg", "파일을 업로드 성공!");
		            System.out.println("업로드 성공");
		        } catch (Exception e) {
		            model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
		            System.out.println("업로드 실패");
		        }
		} else {
	        model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
	    }
		
		return "redirect:/blistall";
		
		
	}
	@RequestMapping("/fee")
	String fee(BlistVO blv,BankVO bv,int money,HttpServletRequest request,Model m) {
		HttpSession session=request.getSession();
		bv=bdao.select_bank(session.getAttribute("Smajor").toString());
		blv.setBid(bv.getBid());
		blv.setBuser(session.getAttribute("Sname").toString());
		bv.setBrest(bv.getBrest()+money);
		blv.setBinout(money);
		blv.setBmemo("spon/dues");
		
		bdao.update_rest(bv);
		bldao.update_rest(blv,bv);
		String msg="후원 및 회비 납부에 감사드립니다.";
		m.addAttribute("msg", msg);
		return "/bank/purchase_ok";
	}
	@RequestMapping("/purchase_ok")
	String purchase_ok(BlistVO blv,BankVO bv,HttpServletRequest request,Model m,
			RedirectAttributes rttr, @RequestParam("imgFile") MultipartFile imgFile , Model model){
		
		HttpSession session=request.getSession();
		BankVO newbv=bdao.select_bank(session.getAttribute("Smajor").toString());
		String msg;
		System.out.println("bpw : "+newbv.getBpw());
		System.out.println("bpw = "+bv.getBpw());
		
		if(newbv.getBpw().equals(bv.getBpw())) {
			blv.setBid(newbv.getBid());
			
			if(Integer.parseInt(session.getAttribute("Siscouncil").toString())>1) {
				
		if(blv.getBuser()==null) {
			blv.setBuser(session.getAttribute("Sname").toString());
			
		}
		int rest=newbv.getBrest()-blv.getBinout();
		if(rest<0) {
			msg="금액이 부족합니다!";
			System.out.println(msg);
			m.addAttribute("msg", msg);
			return "/errorhandle";}
		
			newbv.setBrest(rest);
		bdao.update_rest(newbv);
		bldao.update_rest(blv,newbv);
if(!imgFile.isEmpty()) {
			
			String savePath="C:\\Users\\bohee\\source\\dospace_web\\web\\src\\main\\webapp\\resources\\fileupdown";
			System.out.println("uploadFile");
			
			String originalFilename = imgFile.getOriginalFilename(); // fileName.jpg
		    String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
		    String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg
		 
		    String rename = onlyFileName + extension; // fileName_20150721-14-07-50.jpg
		    String fullPath = savePath + "\\" + rename;
		   
		        try {
		            byte[] bytes = imgFile.getBytes();
		            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
		            stream.write(bytes);
		            stream.close();
		          //  bldao.fileio(rename);
		            blv.setFname(rename);
		            bldao.fileio(blv);
		            
		            model.addAttribute("resultMsg", "파일을 업로드 성공!");
		            System.out.println("업로드 성공");
		        } catch (Exception e) {
		            model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
		            System.out.println("업로드 실패");
		        }
		} else {
	        model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
	    }
		//file up
		blmdao.delete_list(blv,newbv);
		msg="구매 내역을 등록했습니다.";
		
			
			}
			else {
				blv.setBuser(session.getAttribute("Sname").toString());
				// 승인 메시지를 총무에게 보내기
				msg="총무에게 구매 요청을 보냈습니다.";
				System.out.println(msg);
				bldao.sendmsg(blv);
			}
		}else {
			msg="비밀번호를 확인하세요";
			m.addAttribute("msg", msg);
			return "/bank/purchase";
		}

		m.addAttribute("msg", msg);
		return "/bank/purchase_ok";
	}
	@RequestMapping("/blistall")
	String blistall(HttpServletRequest request,BankVO bvo,BlistVO bl,Model m) {
		HttpSession session=request.getSession();

		int page=1;// 현재 쪽 번호
		int limit=10;//한 페이지에 보여지는 목록 개수
		
		if(request.getParameter("page")!=null) {
			//전달된 page가 존재한다면
			page=Integer.parseInt(request.getParameter("page"));// 내가봤을때는 좀더 효율적으로 바꿀 수 있음
			System.out.println("list 받은 값 : "+page);
			
		}
		bl.setStartrow((page-1)*10+1);
		bl.setEndrow(bl.getStartrow()+limit-1);

		String Bid=bdao.select_bank(session.getAttribute("Smajor").toString()).getBid();
		bl.setBid(Bid);
		int totalCount=this.bldao.getCount(Bid);// 총 게시물 개수
		
		
		System.out.println("못가져오나 계좌?"+Bid);
		
		List<BlistVO> BL=bldao.select_list(bl);

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
		m.addAttribute("Siscouncil", session.getAttribute("Siscouncil").toString());
		m.addAttribute("totalCount",totalCount);
		m.addAttribute("startpage",startpage);
		m.addAttribute("endpage",endpage);
		m.addAttribute("maxpage", maxpage);
		m.addAttribute("page", page);
		
		m.addAttribute("bl", BL);
		
		return "/bank/blistall";
	}
	
	
	@RequestMapping("/fileio")
	public String fileio() {
		return "/bank/fileio";
	}
	
	// 파일 입출력시 특수기호는 불가, 한글 불가 , 
		@RequestMapping("/uploadFile")
		public String uploadFile(RedirectAttributes rttr,HttpServletRequest request, @RequestParam("imgFile") MultipartFile imgFile , Model model) {
			String savePath="C:\\Users\\bohee\\source\\dospace_web\\web\\src\\main\\webapp\\resources\\fileupdown";
			System.out.println("uploadFile");
			String originalFilename = imgFile.getOriginalFilename(); // fileName.jpg
		    String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
		    String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg
		 
		    String rename = onlyFileName + extension; // fileName_20150721-14-07-50.jpg
		    String fullPath = savePath + "\\" + rename;
		    if (!imgFile.isEmpty()) {
		        try {
		            byte[] bytes = imgFile.getBytes();
		            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
		            stream.write(bytes);
		            stream.close();
		           // bldao.fileio(blvo);
		            
		            
		            model.addAttribute("resultMsg", "파일을 업로드 성공!");
		        } catch (Exception e) {
		            model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
		        }
		    } else {
		        model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
		    }
			
			return "redirect:/updown";
		}
		
		
		@RequestMapping("/downloadFile")
		public String downloadFile(RedirectAttributes rttr,HttpServletRequest request,HttpServletResponse response,BankVO bvo,String fname) throws UnsupportedEncodingException {
	String fileName = request.getParameter("filename");
			// 파일 이름은 유일해야함
	
			// ② 경로 가져오기
			String saveDir = "C:\\Users\\bohee\\source\\dospace_web\\web\\src\\main\\webapp\\resources\\fileupdown";
			
			File file = new File(saveDir + "\\"+fname);

			response.setContentType("application/octet-stream");
			String filename = new String(fname.getBytes("UTF-8"), "8859_1");
				
				response.setHeader("Content-Disposition", "attachment;filename=" + filename);
				try {
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

					
					try {
						BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
						int data;
						while((data=bis.read()) != -1){
							bos.write(data);
							bos.flush();
						}

						// 8] 스트림 닫기
						bis.close();
						bos.close();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 6] 웹브라우저에 연결할 출력 스트림 생성 
			//	rttr.addFlashAttribute("msg","SUCCESS"); 
		
			//return "redirect:/updown";
			return "/bank/blistall";
			
			
		}
		@RequestMapping("/updown")
		public String updown(Model m) {
			List<String>fname=bldao.selectallfile();
			m.addAttribute("io", fname);

			return "/bank/updown";
		}
		
}
