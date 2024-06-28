package dev.rhcehd123.gachasaver.service

import dev.rhcehd123.gachasaver.model.entity.User
import dev.rhcehd123.gachasaver.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository,
) {
    fun saveUser(user: User) = userRepository.save(user)
    fun findUserByIdOrNull(id: String): User? = userRepository.findByIdOrNull(id)

}