package com.example.snackparadiseapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "users.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT UNIQUE, email TEXT, password TEXT)"
        )
        // Usuário padrão para teste
        db.execSQL("INSERT INTO users (username, email, password) VALUES ('admin', 'admin@teste.com', '123456')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun authenticate(username: String, password: String): Boolean {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT id FROM users WHERE username=? AND password=?",
            arrayOf(username, password)
        )
        val authenticated = cursor.count > 0
        cursor.close()
        return authenticated
    }

    fun insertUser(username: String, email: String, password: String): Boolean {
        return try {
            val db = writableDatabase
            val values = ContentValues().apply {
                put("username", username)
                put("email", email)
                put("password", password)
            }
            val result = db.insert("users", null, values)
            result != -1L
        } catch (e: Exception) {
            false
        }
    }
}