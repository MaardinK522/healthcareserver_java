package com.mkproductions.healthcareserver.pojoservices

import com.mkproductions.healthcareserver.pojo.User
import com.mkproductions.healthcareserver.repository.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserService() {
    @Autowired
    private lateinit var userDao: UserDao

    fun addUser(user: User): User {

        return userDao.save(user)
    }

    fun userCount(): Long = userDao.count()


    fun getUsers(): ArrayList<User> {
        val users = ArrayList<User>()
        userDao.findAll()
            .forEach { user: User? ->
                if (user != null) {
                    users.add(User(user.userID, user.userName, user.userAge, user.userGender))
                }
            }
        return users
    }

    fun getUser(userID: Int): Optional<User> {
//        return userList.stream().filter { user: User -> user.userID == userID }.findFirst().get()
        return userDao.findById(userID)
    }

    fun setUser(userID: Int, user: User): User {
//        userList.forEach(Consumer { user: User ->
//            if (user.userID == userID) {
//                user.userID = userID
//                user.userAge = u.userAge
//                user.userName = u.userName
//                user.userGender = u.userGender
//            }
//        })
        user.userID = userID
        return userDao.save(user)
    }

    fun deleteUser(userID: Int): Int {
        userDao.deleteById(userID)
//        userList.forEach(Consumer { user: User ->
//            if (user.userID == userID) {
//                userList.remove(user)
//            }
//        })
        return userID
    }
}