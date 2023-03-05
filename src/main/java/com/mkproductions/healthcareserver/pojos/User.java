package com.mkproductions.healthcareserver.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    int userID;
    @JsonProperty("user_name")
    String userName;
    @JsonProperty("user_age")
    int userAge;
    @JsonProperty("user_gender")
    char userGender;


    public User() {

    }

    public User(int userID, String userName, int userAge, char userGender) {
        this.userID = userID;
        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public char getUserGender() {
        return userGender;
    }

    public void setUserGender(char userGender) {
        this.userGender = userGender;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", userName='" + userName + '\'' + ", userAge=" + userAge + ", userGender=" + userGender + '}';
    }
}

