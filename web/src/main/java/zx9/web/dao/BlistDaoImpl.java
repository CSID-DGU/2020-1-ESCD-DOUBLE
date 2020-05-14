package zx9.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import chain.Util;
import zx9.web.vo.BankVO;
import zx9.web.vo.BlistVO;

@Repository
public class BlistDaoImpl implements BlistDao {

	@Autowired
	private SqlSession sqlSession;// 자동 의존성 주입 => mybatis쿼리문 수행객체

	

	@Override
	public void update_rest(BlistVO blv, BankVO bv) {
		// TODO Auto-generated method stub
		blv.setBrest(bv.getBrest());
		blv.setBid(bv.getBid());
		//blv.setPrehash(prehash);
		
		int bsequence=sqlSession.selectOne("selectseq");
		BlistVO newblvo=sqlSession.selectOne("selectseqall",bsequence);

		if(newblvo!=null) {
			Integer a=newblvo.getBinout();
			Integer b=newblvo.getBrest();
		String prehash=newblvo.getBmemo()+newblvo.getBuser()+a.toString()+b.toString();
		System.out.println("pre :!!!"+newblvo.getBmemo()+","+newblvo.getBuser()+","+a.toString()+","+b.toString());
		System.out.println("pre : "+prehash);
		if(newblvo.getPrehash()!=null) {
				prehash+=newblvo.getPrehash();
				//System.out.println(prehash);
				System.out.println(newblvo.getPrehash());
			}
		blv.setPrehash(prehash);
		}
		
		
		System.out.println(blv.getPrehash());
		
		
		
		Integer a=blv.getBinout();
		Integer b=blv.getBrest();
		String thishash=blv.getBmemo()+blv.getBuser()+a.toString()+b.toString();

		System.out.println("this:!!! "+blv.getBmemo()+","+blv.getBuser()+","+a.toString()+","+b.toString());
		System.out.println("this :"+thishash);
		if(blv.getPrehash()!=null) {
		 thishash+=blv.getPrehash();
		 System.out.println(blv.getPrehash());
		// System.out.println(thishash);
		}
	
		blv.setThishash(thishash);
		
		System.out.println(blv.getThishash());
		
		
		sqlSession.update("update_Blrest",blv);
	}



	@Override
	public List<BlistVO> select_list(BlistVO bl) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("select_list", bl);

	}



	@Override
	public int getCount(String bid) {
		// TODO Auto-generated method stu
		
		return sqlSession.selectOne("getlistC",bid);
	}
	@Override
	public void sendmsg(BlistVO blv) {
		// TODO Auto-generated method stub
		sqlSession.insert("sendmsg",blv);
		
		
		
	}



	@Override
	public void fileio(BlistVO blvo) {
		// TODO Auto-generated method stub
		sqlSession.update("fileupload_bank",blvo);
	}



	@Override
	public List<String> selectallfile() {
		// TODO Auto-generated method stub

		return sqlSession.selectList("fileselect");
	}

}
