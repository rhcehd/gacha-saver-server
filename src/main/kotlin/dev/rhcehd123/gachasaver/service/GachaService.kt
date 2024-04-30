package dev.rhcehd123.gachasaver.service

import dev.rhcehd123.gachasaver.model.GachaItem
import dev.rhcehd123.gachasaver.model.GachaResult
import dev.rhcehd123.gachasaver.model.User
import dev.rhcehd123.gachasaver.repository.GachaItemRepository
import dev.rhcehd123.gachasaver.repository.GachaRepository
import dev.rhcehd123.gachasaver.repository.GachaResultRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.math.BigDecimal
import kotlin.random.Random


@Service
class GachaService @Autowired constructor(
    private val gachaRepository: GachaRepository,
    private val gachaItemRepository: GachaItemRepository,
    private val gachaResultRepository: GachaResultRepository,
    private val userService: UserService,
) {
    fun requestGacha(apiKey: String, gachaId: Long, userId: String): GachaResult {
        val gacha = gachaRepository.findByIdOrNull(gachaId) ?: throw Exception("gacha is not exist")
        val gachaItem = getGachaResult(gacha.gachaItems)
        var user = userService.findUserByIdOrNull(userId)
        if(user == null) {
            user = User().apply {
                this.id = userId
                this.name = ""
                this.gachaResults = listOf()
            }
            userService.saveUser(user)
        }

        val gachaResult = GachaResult().apply {
            this.id = gachaId
            this.user = user
            this.gachaItem = gachaItem
        }

        return gachaResultRepository.save(gachaResult)
    }

    fun getGachaResult(gachaItems: List<GachaItem>): GachaItem {
        val randomDouble: BigDecimal = BigDecimal((Random.nextDouble() * 100))
        var minValue = BigDecimal("0")
        var maxValue = BigDecimal("0")
        minValue.subtract(BigDecimal(gachaItems[0].rate))
        for (gachaItem in gachaItems) {
            val value = BigDecimal(gachaItem.rate)
            minValue = maxValue
            maxValue = maxValue.add(value)
            if (randomDouble.compareTo(minValue) == 1 && randomDouble.compareTo(maxValue) == -1) {
                return gachaItem
            }
        }
        return gachaItems[gachaItems.size - 1]
    }
}