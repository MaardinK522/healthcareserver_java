package com.mkproductions.healthcareserver.repositories

import com.mkproductions.healthcareserver.pojos.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : CrudRepository<User, Int> {
}