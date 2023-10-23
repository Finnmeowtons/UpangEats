package com.example.upangeats.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.upangeats.dataclass.UserInformation

class UserInformationDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "upangeats.db"
        private const val DATABASE_VERSION = 1
        private const val USER_INFO_TABLE_NAME = "UserInformation"
        private const val USER_INFO_ID = "user_id"
        private const val USER_INFO_NAME = "user_name"
        private const val USER_INFO_EMAIL = "user_email"
        private const val USER_INFO_PHONE_NUMBER = "user_number"
        private const val USER_INFO_FIREBASE_ID = "user_firebase_id"

    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val createTableQuery =
            "CREATE TABLE $USER_INFO_TABLE_NAME ($USER_INFO_ID INTEGER PRIMARY KEY AUTOINCREMENT ,$USER_INFO_NAME VARCHAR(255) NOT NULL,$USER_INFO_EMAIL VARCHAR(255) NOT NULL,$USER_INFO_PHONE_NUMBER VARCHAR(20), $USER_INFO_FIREBASE_ID VARCHAR(255),UNIQUE ($USER_INFO_EMAIL));"
        p0?.execSQL(createTableQuery)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $USER_INFO_TABLE_NAME"
        p0?.execSQL(dropTableQuery)
        onCreate(p0)
    }

    fun signUp(userInfo: UserInformation): String {
        val db = writableDatabase

        try {
            // Check if the email already exists
            if (emailExists(userInfo.userEmail)) {
                Log.e("MyTag", "Email already exists: ${userInfo.userEmail}")
                return "Email already exists"
            }

            val values = ContentValues().apply {
                put(USER_INFO_NAME, userInfo.userName)
                put(USER_INFO_EMAIL, userInfo.userEmail)
                put(USER_INFO_PHONE_NUMBER, userInfo.userPhoneNumber)
                put(USER_INFO_FIREBASE_ID, userInfo.userFirebaseId)
            }

            val rowId = db.insert(USER_INFO_TABLE_NAME, null, values)

            return if (rowId != -1L) {
                Log.e("MyTag", "Insertion successful: Row ID $rowId")
                "Success"
            } else {
                Log.e("MyTag", "Insertion failed")
                "Failed to sign up"
            }

        } catch (e: Exception) {
            Log.e("MyTag", "Error during insertion: ${e.message}")
            return "Failed to sign up"
        } finally {

            Log.e("MyTag", "Closing the database")
            db.close()

        }
    }

    fun dropTable() {
        val db = writableDatabase

        try {
            // Delete all rows from the table
            db.delete(USER_INFO_TABLE_NAME, null, null)
            Log.e("MyTag", "Table content deleted")
        } catch (e: Exception) {
            Log.e("MyTag", "Error during table content deletion: ${e.message}")
        } finally {
            Log.e("MyTag", "Closing the database")
            db.close()

        }
    }


    private fun emailExists(email: String): Boolean {
        val db = readableDatabase

        val selection = "$USER_INFO_EMAIL = ?"
        val selectionArgs = arrayOf(email)

        val cursor = db.query(
            USER_INFO_TABLE_NAME,
            null,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        val exists = cursor.count > 0

        cursor.close()

        return exists
    }

    fun count(email : String, password : String){

    }
}