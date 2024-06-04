package com.example.springfilterkotlin.sms

import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/sms")
class SmsCommandController(
    val smsCommandUseCase: SmsCommandUseCase,
) {
    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping
    fun ekle(
        @RequestBody smsEkleCommand: SmsEkleCommand
    ) {
        smsCommandUseCase.ekle(smsEkleCommand.toDomainEntity())
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/smsgetir/{numara}")
    fun smsGetir(
        @PathVariable numara: String
    ): List<SmsJpaEntity> {
        return smsCommandUseCase.smsGetir(numara)
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/spamgetir/{numara}")
    fun spamGetir(
        @PathVariable numara: String
    ): List<SpamJpaEntity> {
        return smsCommandUseCase.spamGetir(numara)
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/spambildir")
    fun spamBildir(
        @RequestBody sms: Sms
    )  {
        return smsCommandUseCase.spamBildir(sms)
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/smsbildir")
    fun smsBildir(
        @RequestBody sms: Sms
    )  {
        return smsCommandUseCase.smsBildir(sms)
    }
}
