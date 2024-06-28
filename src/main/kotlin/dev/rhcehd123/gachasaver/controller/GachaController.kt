package dev.rhcehd123.gachasaver.controller

import dev.rhcehd123.gachasaver.model.entity.GachaItem
import dev.rhcehd123.gachasaver.model.network.CommonResponse
import dev.rhcehd123.gachasaver.service.GachaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class GachaController @Autowired constructor(
    private val gachaService: GachaService
) {

    @PostMapping("request")
    fun requestGacha(@RequestBody requestBody: Map<String, Any>): ResponseEntity<CommonResponse> {
        val apiKey = requestBody["apiKey"] as String
        val userId = requestBody["userId"] as String
        val gachaId = (requestBody["gachaId"] as Int).toLong()
        val count = requestBody["count"] as Int

        val results = arrayListOf<GachaItem>()
        for (i in 1..count) {
            results.add(gachaService.requestGacha(apiKey, gachaId, userId).gachaItem)
        }

        val data = CommonResponse.Builder()
            .data(results)
            .build()

        return ResponseEntity(data, HttpStatus.OK)
    }

    @GetMapping("history")
    fun getGachaHistory(@RequestParam projectId: Long, @RequestParam userId: String): ResponseEntity<CommonResponse> {
        val gachaHistoryList = gachaService.getGachaHistory(userId, projectId)
        val data = CommonResponse.Builder()
            .data(gachaHistoryList)
            .build()
        return ResponseEntity(data, HttpStatus.OK)
    }
}