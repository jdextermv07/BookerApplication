package com.exercise.manager;

import com.exercise.bean.AccountBean;
import com.exercise.dao.AccountDao;

public class AccountManager {
	AccountDao logDao = new AccountDao();

	public boolean loginDetails(AccountBean logBean) {
		boolean result = false;
		AccountBean accountBean = logDao.loginDetails(logBean);
		if (accountBean.getPassword() == null) {
			result = false;
		}else {
			if (accountBean.getPassword().equals(logBean.getPassword())) {
				result = true;
			}
		}
		
		return result;
	}

}
