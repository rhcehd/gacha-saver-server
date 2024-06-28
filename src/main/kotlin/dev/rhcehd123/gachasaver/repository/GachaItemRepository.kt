package dev.rhcehd123.gachasaver.repository

import dev.rhcehd123.gachasaver.model.entity.GachaItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GachaItemRepository: JpaRepository<GachaItem, Long>