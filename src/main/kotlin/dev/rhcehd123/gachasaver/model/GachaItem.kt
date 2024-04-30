package dev.rhcehd123.gachasaver.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class GachaItem() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    var id: Long = 0

    var name: String = ""

    @ManyToOne
    @JoinColumn(name = "gacha_id")
    @JsonBackReference
    var gacha: Gacha = Gacha()

    var rate: String = ""

    constructor(name: String, rate: String) : this() {
        this.name = name
        this.rate = rate
    }
}



