package com.example.learnenglishapp.extension

import com.example.learnenglishapp.data.model.SettingsTile

val SettingsTile.Companion.test: List<SettingsTile>
    get() = listOf(
        SettingsTile(
            title = "Ваш часовой пояс",
            parameter = "+3 GMC Новосибирск",
        ),
        SettingsTile(
            title = "Слов в одном уведомлении",
            parameter = "2",
        ),
        SettingsTile(
            title = "Частота уведомлений",
            parameter = "Каждый час",
        ),
        SettingsTile(
            title = "Ваш часовой пояс",
            parameter = "10:00 - 22:00",
        ),
        SettingsTile(
            title = "Поделиться",
        ),
    )

