package com.example.springfilterkotlin.sms

import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "spam")
class SpamJpaEntity(
    id: UUID,
    var kimden: String,
    var kime: String,
    var smsIcerigi: String,
) : BaseEntity(id) {

    constructor(
        sms: Sms
    ) : this(
        id = sms.id,
        kimden = sms.kimden,
        kime = sms.kime,
        smsIcerigi = sms.smsIcerigi)
}
