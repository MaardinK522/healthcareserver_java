package com.mkproductions.healthcareserver.pojo

import com.fasterxml.jackson.annotation.JsonProperty


class User(
    @JsonProperty("id")
    var userID: Int,
    @JsonProperty("user_name")
    var userName: String,
    @JsonProperty("user_age")
    var userAge: Int,
    @JsonProperty("user_gender")
    var userGender: Char
) {
    override fun toString(): String {
        return "User(userID=$userID, userName='$userName', userAge=$userAge, userGender=$userGender)"
    }
}




