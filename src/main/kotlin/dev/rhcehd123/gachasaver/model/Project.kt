package dev.rhcehd123.gachasaver.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var name: String = ""

    @Column(unique = true, name = "api_key")
    var apiKey: String = ""

    @OneToMany(mappedBy = "project")
    @JsonManagedReference
    var gachaList: List<Gacha> = listOf()
}