package zx9.web.dao;

import zx9.web.vo.BankVO;

public interface BankDao {

	BankVO select_bank(String Smajor);

	void update_rest(BankVO newbv);

}
