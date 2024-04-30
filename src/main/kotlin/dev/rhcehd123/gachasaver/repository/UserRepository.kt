package dev.rhcehd123.gachasaver.repository

import dev.rhcehd123.gachasaver.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, String>