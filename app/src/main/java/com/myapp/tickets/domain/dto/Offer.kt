package com.myapp.tickets.domain.dto


data class Offer(
    val id: Int? = null,
    val price: Price? = null,
    val title: String? = null,
    val town: String? = null
): ListItem()

