package dev.rhcehd123.gachasaver.repository

import dev.rhcehd123.gachasaver.model.Gacha
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GachaRepository: JpaRepository<Gacha, Long>