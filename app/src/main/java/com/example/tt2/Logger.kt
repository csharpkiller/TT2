package com.example.tt2

import java.io.File
import java.io.FileWriter

class Logger(private val logFilePath: String = "log.txt") {
    fun log(message: String) {
        try {

            val logMessage = "$message\n"

            val file = File(logFilePath)

            if (!file.parentFile.exists()) {
                file.parentFile.mkdirs()
            }

            FileWriter(file, true).use { writer ->
                writer.append(logMessage)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun readLog(): String {
        return try {
            val file = File(logFilePath)
            if (file.exists()) {
                file.readText()
            } else {
                "Файл журнала не найден."
            }
        } catch (e: Exception) {
            "Ошибка чтения лога: ${e.message}"
        }
    }
}