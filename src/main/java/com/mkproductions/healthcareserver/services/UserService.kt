package com.mkproductions.healthcareserver.services

import com.mkproductions.healthcareserver.exceptions.UserNotFoundException
import com.mkproductions.healthcareserver.pojos.User
import com.mkproductions.healthcareserver.repositories.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserService {
    @Autowired
    lateinit var userDao: UserDao
    fun addUser(user: User): User {
        userDao.save(user);return user
    }

    fun userCount(): Int = userDao.count().toInt()


    fun getUsers(): List<User> {
        val users = ArrayList<User>()
        for (user in userDao.findAll()) {
            users.add(user)
        }
        return users
    }

    fun getUser(userID: Int): User {
        val user = userDao.findById(userID)
        if (!user.isPresent)
            throw UserNotFoundException("User Not Found")
        return user.get()
    }

    fun setUser(userID: Int, user: User): User {
        user.userID = userID
        return userDao.save(user)
    }

    fun deleteUser(userID: Int) {
        userDao.deleteById(userID)
    }
}