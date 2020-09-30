package com.adedom.androidexposedmysql

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Chats : Table(name = "chat") {

    val chatId = integer("chat_id").autoIncrement()
    val name = varchar("name", length = 45)
    val message = varchar("message", length = 300)

    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(chatId, name = "PK_Chat_ID")

    fun toChat(row: ResultRow) = ChatItem(
        chatId = row[chatId],
        name = row[name],
        message = row[message],
    )

}
