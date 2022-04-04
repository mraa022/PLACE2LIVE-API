package com.example.PLACE2LIVE;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
    @Id
    private Long userId;

    private String password;
    private String userName;
    private String emailAddress;
    private int isAdmin;
    public User(){
        super();
    }
    public User(@JsonProperty("id") Long userId, @JsonProperty("password") String password,
                @JsonProperty("userName") String userName,
                @JsonProperty("emailAddress") String emailAddress,
                @JsonProperty("isAdmin") int isAdmin) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.isAdmin = isAdmin;
    }


    public Long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
