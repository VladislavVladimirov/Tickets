package com.myapp.tickets.utils

import android.app.DatePickerDialog
import android.content.Context
import com.google.android.material.chip.Chip
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

object AndroidUtils {
    fun showDatePicker(chip: Chip, context: Context) {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            context,
            { _, year, monthOfYear, dayOfMonth ->
                calendar.set(year, monthOfYear, dayOfMonth)
                val formattedDate = SimpleDateFormat("dd MMM EEE ", Locale.getDefault())
                    .format(calendar.time)
                chip.text = formattedDate
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    fun formatTime(input: String): String {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        val outputFormatter = DateTimeFormatter.ofPattern("HH:mm")
        val dateTime = LocalDateTime.parse(input, inputFormatter)
        return dateTime.format(outputFormatter)
    }
    fun calculateHoursDifference(date1: String, date2: String): Double {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")

        val dateTime1 = LocalDateTime.parse(date1, formatter)
        val dateTime2 = LocalDateTime.parse(date2, formatter)

        val duration = Duration.between(dateTime1, dateTime2)

        return duration.toMinutes().toDouble() / 60
    }
}