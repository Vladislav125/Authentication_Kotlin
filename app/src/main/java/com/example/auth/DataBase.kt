package com.example.auth

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBase(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "data_base", factory, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE users (id INT PRIMARY KEY, login TEXT, password TEXT)")
        db.execSQL("INSERT INTO users VALUES(1, \"User1\", \"qwerty\")")
        db.execSQL("INSERT INTO users VALUES(2, \"User2\", \"12345\")")
        db.execSQL("INSERT INTO users VALUES(3, \"User3\", \"0000\")")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun getUser(user: User) : Boolean{
        val db = this.readableDatabase

        return db.rawQuery("SELECT * FROM users WHERE login = '${user.login}' AND password = '${user.password}'", null).moveToFirst()
    }
}