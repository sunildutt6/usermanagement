package com.sunil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sunil.entities.UserAccount;

import jakarta.transaction.Transactional;

public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {

	@Modifying
	@Transactional
	@Query("update UserAccount set activeSw=:status where userId=:userId")
	public void updateUserAccStatus(Integer userId, String status);

}
