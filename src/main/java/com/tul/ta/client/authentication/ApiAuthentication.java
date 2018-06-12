package com.tul.ta.client.authentication;

public interface ApiAuthentication {
    String getAccessToken() ;
    String getAuthHeader() ;
    boolean updateAccessToken();
}
