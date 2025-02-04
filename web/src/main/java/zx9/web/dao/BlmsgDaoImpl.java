package zx9.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zx9.web.vo.BankVO;
import zx9.web.vo.BlistVO;
import zx9.web.vo.BlmsgVO;

@Repository
public class BlmsgDaoImpl implements BlmsgDao {

	@Autowired
	private SqlSession sqlSession;// 자동 의존성 주입 => mybatis쿼리문 수행객체

	

	@Override
	public void update_rest(BlistVO blv, BankVO bv) {
		// TODO Auto-generated method stub
		blv.setBrest(bv.getBrest());
		blv.setBid(bv.getBid());
		sqlSession.update("update_Blrest",blv);
	}



	@Override
	public List<BlmsgVO> select_list(BlmsgVO bl) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("select_list_msg", bl);

	}



	@Override
	public int getCount(String bid) {
		// TODO Auto-generated method stu
		
		return sqlSession.selectOne("getlistCp",bid);
	}
	@Override
	public void sendmsg(BlistVO blv) {
		// TODO Auto-generated method stub
		sqlSession.insert("sendmsg",blv);
		
		
		
	}



	@Override
	public void delete_list(BlistVO blv, BankVO bv) {
		// TODO Auto-generated method stub
		
		blv.setBid(bv.getBid());
		sqlSession.update("delete_list_msg",blv);
	}



}
