package com.myapp.tickets.dto




data class Ticket(
    val arrival: Arrival? = null,
    val badge: String? = null,
    val company: String? = null,
    val departure: Departure? = null,
    val hand_luggage: HandLuggage? = null,
    val has_transfer: Boolean? = null,
    val has_visa_transfer: Boolean? = null,
    val id: Int? = null,
    val is_exchangable: Boolean? = null,
    val is_returnable: Boolean? = null,
    val luggage: Luggage? = null,
    val price: Price? = null,
    val provider_name: String? = null
)









