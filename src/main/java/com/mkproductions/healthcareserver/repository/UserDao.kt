package com.mkproductions.healthcareserver.repository

import com.mkproductions.healthcareserver.pojo.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : CrudRepository<User, Int> {
}