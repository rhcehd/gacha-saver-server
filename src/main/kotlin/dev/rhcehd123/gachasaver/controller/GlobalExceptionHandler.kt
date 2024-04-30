package dev.rhcehd123.gachasaver.controller

import dev.rhcehd123.gachasaver.model.network.CommonResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<CommonResponse> {
        e.printStackTrace()
        val response = CommonResponse.Builder()
            .msg("An error occurred: ${e.message}\n${e.printStackTrace()}")
            .build()
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}