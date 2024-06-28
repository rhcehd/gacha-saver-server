package dev.rhcehd123.gachasaver.repository

import dev.rhcehd123.gachasaver.model.entity.GachaResult
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface GachaResultRepository: JpaRepository<GachaResult, Long> {
    @Query("SELECT gr FROM GachaResult gr WHERE gr.user.id = :userId AND gr.gachaItem.gacha.project.id = :projectId")
    fun findAllByUserIdAndProjectId(@Param("userId") userId: String, @Param("projectId") projectId: Long): List<GachaResult>
}