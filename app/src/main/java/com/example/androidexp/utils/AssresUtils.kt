package com.example.androidexp.utils

import com.example.androidexp.app.MyApplication
import java.io.BufferedReader
import java.io.InputStreamReader

object AssresUtils {
    fun getFormAssets(fileName: String): String? {
        val stringBuilder = StringBuilder()
        BufferedReader(InputStreamReader(MyApplication.instance.assets.open(fileName), "UTF-8")).run {
            var line: String? = ""
            do {
                line = readLine()
                if (line != null) {
                    stringBuilder.append(line)
                } else {
                    break
                    close()
                }
            } while (true)
            return stringBuilder.toString()
        }
        return null
    }
}