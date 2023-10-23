package com.example.upangeats.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class StallDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context,
        DATABASE_NAME, null,
        DATABASE_VERSION
    ) {

    companion object {
        private const val DATABASE_NAME = "upangeats.db"
        private const val DATABASE_VERSION = 1
        private const val STALL_TABLE_NAME = "UserInformation"
        private const val STALL_ID = "user_id"
        private const val STALL_NAME = "user_name"
        private const val STALL_RATING = "user_email"
        private const val STALL_DESCRIPTION = "user_number"

    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $STALL_TABLE_NAME (" +
                "$STALL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$STALL_NAME VARCHAR(255) NOT NULL, " +
                "$STALL_RATING VARCHAR(255), " +
                "$STALL_DESCRIPTION VARCHAR(255));"

        p0?.execSQL(createTableQuery)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $STALL_TABLE_NAME"
        p0?.execSQL(dropTableQuery)
        onCreate(p0)
    }

}