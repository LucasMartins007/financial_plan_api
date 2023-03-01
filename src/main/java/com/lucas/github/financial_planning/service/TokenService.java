package com.lucas.github.financial_planning.service;

import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.function.Function;

public interface TokenService {
    String generateToken(String username);

    String generateRefreshToken(String username);

    Date getExpirationDateFromToken(String token);

    <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);
}
