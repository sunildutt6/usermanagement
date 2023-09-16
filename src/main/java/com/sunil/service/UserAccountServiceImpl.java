package com.sunil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.entities.UserAccount;
import com.sunil.repository.UserAccountRepo;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountRepo userAccountRepo;

	@Override
	public String saveOrUpdateUserAcc(UserAccount userAcc) {
		Integer userId = userAcc.getUserId();
		if(userId == null) {
			userAcc.setActiveSw("Y");
		}
		userAccountRepo.save(userAcc);
		if (userId == null) {
			return "User Record Saved";
		} else {
			return "User Record updated";
		}
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		return userAccountRepo.findAll();
	}

	@Override
	public UserAccount getUserAcc(Integer userId) {
		Optional<UserAccount> findById = userAccountRepo.findById(userId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteUserAcc(Integer userId) {
		boolean existsById = userAccountRepo.existsById(userId);
		if (existsById) {
			userAccountRepo.deleteById(userId);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUserAccStatus(Integer userId, String status) {
		try {
			userAccountRepo.updateUserAccStatus(userId, status);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
