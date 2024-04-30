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
class GachaResult() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    var id: Long = 0

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    var user: User = User()

    @ManyToOne
    @JoinColumn(name = "gacha_item_id")
    var gachaItem: GachaItem = GachaItem()
}

