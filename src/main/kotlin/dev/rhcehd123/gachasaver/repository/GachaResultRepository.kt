package dev.rhcehd123.gachasaver.repository

import dev.rhcehd123.gachasaver.model.GachaResult
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GachaResultRepository: JpaRepository<GachaResult, Long>