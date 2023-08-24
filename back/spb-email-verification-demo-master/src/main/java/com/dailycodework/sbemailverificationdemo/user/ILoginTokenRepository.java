package com.dailycodework.sbemailverificationdemo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginTokenRepository extends JpaRepository<LoginToken, Long> {
	LoginToken findByToken(String token);
}
