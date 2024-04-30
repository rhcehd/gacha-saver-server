package dev.rhcehd123.gachasaver.repository

import dev.rhcehd123.gachasaver.model.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectRepository: JpaRepository<Project, Long>