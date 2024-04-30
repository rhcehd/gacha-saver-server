package dev.rhcehd123.gachasaver.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class User {
    @Id
    @Column(unique = true)
    var id: String = ""

    var name: String = ""

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    var gachaResults: List<GachaResult> = listOf()
}
