package com.example.graphs_nav

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Message(val amount: BigDecimal) : Parcelable {
}