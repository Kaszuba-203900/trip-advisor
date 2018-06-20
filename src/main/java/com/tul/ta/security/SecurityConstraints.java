package com.tul.ta.security;

public class SecurityConstraints {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "Token ";
    public static final long EXPIRATION_TIME = 864_000_000;
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/security/register";
}
