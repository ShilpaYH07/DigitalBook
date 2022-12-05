package com.signup.model;

public class LoginResponse {

    private boolean isAuth;
    private int role;

    public LoginResponse(boolean isAuth, int role) {
        this.isAuth = isAuth;
        this.role = role;
    }

    public LoginResponse() {
    }

    public boolean isAuth() {
        return isAuth;
    }


    public void setAuth(boolean auth) {
        isAuth = auth;
    }

    public int getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "isAuth=" + isAuth +
                ", role=" + role +
                '}';
    }

    public void setRole(int role) {
        this.role = role;
    }
}
