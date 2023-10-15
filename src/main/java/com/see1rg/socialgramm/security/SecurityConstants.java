package com.see1rg.socialgramm.security;

public class SecurityConstants {

    /**
     * При создании класса, если не определить явно хотя бы один конструктор, Java
     * добавляет неявный public конструктор по умолчанию. Этот конструктор позволяет
     * создавать экземпляры класса, что может быть нежелательно для утилитарных классов.
     */
    private SecurityConstants() {

    }
    public static final String SIGN_UP_URL = "/api/auth/**";
    public static final String SECRET = "SecretKeyGenJWT";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 600_000; //10 minutes
}
