package com.example.springfilterkotlin.sms

import java.util.*


class Sms(
    id: UUID,
    kimden: String,
    kime: String,
    smsIcerigi: String,

) {

    var id: UUID = id
        private set

    var kimden: String = kimden
        private set

    var kime: String = kime
        private set

    var smsIcerigi: String = smsIcerigi
        private set

}
