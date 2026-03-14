package com.mycomp.krishi.user.requests;

public class LoginResponse {
    private String token;
    private UserWeb userDetails;

    public LoginResponse(String token, UserWeb userDetails) {
        this.token = token;
        this.userDetails = userDetails;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserWeb getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserWeb userDetails) {
        this.userDetails = userDetails;
    }
}
