package dev.rhcehd123.gachasaver.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
class Gacha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    var id: Long = 0

    var name: String = ""

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    var project: Project = Project()

    @OneToMany(mappedBy = "gacha")
    @JsonManagedReference
    var gachaItems: List<GachaItem> = listOf()
}


