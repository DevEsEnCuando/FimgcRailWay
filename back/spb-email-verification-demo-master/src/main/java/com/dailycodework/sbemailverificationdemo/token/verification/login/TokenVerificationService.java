package com.dailycodework.sbemailverificationdemo.token.verification.login;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodework.sbemailverificationdemo.user.ILoginTokenRepository;
import com.dailycodework.sbemailverificationdemo.user.LoginToken;

@Service
public class TokenVerificationService {
    private final ILoginTokenRepository tokenRepository;

    @Autowired
    public TokenVerificationService(ILoginTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }
}
