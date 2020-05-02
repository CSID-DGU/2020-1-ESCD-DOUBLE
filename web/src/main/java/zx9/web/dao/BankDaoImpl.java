package zx9.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zx9.web.vo.BankVO;
import zx9.web.vo.BlistVO;

@Repository
public class BankDaoImpl implements BankDao {


	@Autowired
	private SqlSession sqlSession;// 자동 의존성 주입 => mybatis쿼리문 수행객체

	@Override
	public BankVO select_bank(String Smajor) {

		return sqlSession.selectOne("select_bank", Smajor);
		
		
	}

	@Override
	public void update_rest(BankVO newbv) {
		// TODO Auto-generated method stub

		sqlSession.update("update_Brest",newbv);
		
	}



}
