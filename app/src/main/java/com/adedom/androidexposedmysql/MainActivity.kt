package com.adedom.androidexposedmysql

import android.os.Bundle
import android.os.StrictMode
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        Database.connect(
            url = "jdbc:mysql://us-cdbr-east-05.cleardb.net/heroku_1393de2d66fc96b?useUnicode=true&characterEncoding=utf-8",
            driver = "com.mysql.jdbc.Driver",
            user = "bc162b7210edb9",
            password = "dae67b90",
        )

        btSelectExposed.setOnClickListener {
            val list = transaction {
                Chats.selectAll()
                    .map { Chats.toChat(it) }
                    .toList()
            }

            Toast.makeText(baseContext, list.toString(), Toast.LENGTH_SHORT).show()
        }

        btInsertExposed.setOnClickListener {
            transaction {
                Chats.insert {
                    it[Chats.name] = "Main"
                    it[Chats.message] = "MainActivity"
                }
            }
        }

        btSelectSql.setOnClickListener {
            val list = mutableListOf<ChatItem>()
            transaction {
                val sql = "SELECT * FROM chat"
                TransactionManager.current().exec(sql) {
                    while (it.next()) {
                        val chat = ChatItem(
                            chatId = it.getInt(1),
                            name = it.getString(2),
                            message = it.getString(3),
                        )
                        list.add(chat)
                    }
                }
            }

            Toast.makeText(baseContext, list.toString(), Toast.LENGTH_SHORT).show()
        }

        btInsertSql.setOnClickListener {
            transaction {
                val sql = "INSERT INTO chat (name, message) VALUES ('Main2', 'MainActivity2');"
                TransactionManager.current().exec(sql)
            }
        }

    }

}
