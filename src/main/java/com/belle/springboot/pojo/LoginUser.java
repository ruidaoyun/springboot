package com.belle.springboot.pojo;

public class LoginUser {
    private Integer id;
    private String username;
    private String telephone;
    private String email;

    public String getTelephone() {
        return telephone;
    }

    public LoginUser setTelephone(String telephone) {
        this.telephone=telephone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LoginUser setEmail(String email) {
        this.email=email;
        return this;
    }

    private String password;

    @Override
    public String toString() {
        return "LoginUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public LoginUser setId(Integer id) {
        this.id=id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoginUser setUsername(String username) {
        this.username=username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginUser setPassword(String password) {
        this.password=password;
        return this;
    }
}
