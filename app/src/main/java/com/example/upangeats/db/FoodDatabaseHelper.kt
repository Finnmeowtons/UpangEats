package com.example.upangeats.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.upangeats.dataclass.Food

class FoodDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context,
        DATABASE_NAME, null,
        DATABASE_VERSION
    ) {

    companion object {
        private const val DATABASE_NAME = "upangeats.db"
        private const val DATABASE_VERSION = 1
        private const val FOOD_TABLE_NAME = "Food"
        private const val FOOD_ID = "food_id"
        private const val FOOD_NAME = "food_name"
        private const val FOOD_PRICE = "food_price"
        private const val FOOD_DESCRIPTION = "food_description"

    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $FOOD_TABLE_NAME (" +
                "$FOOD_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$FOOD_NAME VARCHAR(255) NOT NULL, " +
                "$FOOD_PRICE VARCHAR(255) NOT NULL, " +
                "$FOOD_DESCRIPTION VARCHAR(255));"

        p0?.execSQL(createTableQuery)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $FOOD_TABLE_NAME"
        p0?.execSQL(dropTableQuery)
        onCreate(p0)
    }

    fun addFood(food: Food){
        val db = writableDatabase

        try {
            val values = ContentValues().apply {
                put(FOOD_NAME, food.name)
                put(FOOD_PRICE, food.price)
                put(FOOD_DESCRIPTION, food.description)
            }

            db.insert(FOOD_TABLE_NAME, null, values)


        } catch (e: Exception) {
        } finally {
            db.close()
        }
    }
    @SuppressLint("Range")
    fun getFoodListFromDatabase(): List<Food> {
        val db = readableDatabase
        val foodList = mutableListOf<Food>()
        val cursor = db.rawQuery("SELECT * FROM $FOOD_TABLE_NAME", null)

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("food_id"))
            val name = cursor.getString(cursor.getColumnIndex("food_name"))
            val price = cursor.getInt(cursor.getColumnIndex("food_price"))
            val description = cursor.getString(cursor.getColumnIndex("food_description"))

            val food = Food(id, name, price, description)
            foodList.add(food)
        }

        cursor.close()
        return foodList
    }

    fun updateFood(food: Food) {
        val db = writableDatabase

        try {
            val values = ContentValues().apply {
                put(FOOD_NAME, food.name)
                put(FOOD_PRICE, food.price)
                put(FOOD_DESCRIPTION, food.description)
            }

            // Update the row with the given ID
            db.update(FOOD_TABLE_NAME, values, "$FOOD_ID = ?", arrayOf(food.id.toString()))

        } catch (e: Exception) {
        } finally {
            db.close()
        }
    }

    fun deleteFood(foodId: Int) {
        val db = writableDatabase

        try {
            // Delete the row with the given ID
            db.delete(FOOD_TABLE_NAME, "$FOOD_ID = ?", arrayOf(foodId.toString()))

        } catch (e: Exception) {
            // Handle any exceptions that might occur during deletion
        } finally {
            db.close()
        }
    }

    @SuppressLint("Range")
    fun searchFoodByName(query: String): List<Food> {
        val db = readableDatabase
        val foodList = mutableListOf<Food>()

        // Use a WHERE clause to filter by food_name
        val cursor = db.rawQuery("SELECT * FROM $FOOD_TABLE_NAME WHERE $FOOD_NAME LIKE ?", arrayOf("%$query%"))

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("food_id"))
            val name = cursor.getString(cursor.getColumnIndex("food_name"))
            val price = cursor.getInt(cursor.getColumnIndex("food_price"))
            val description = cursor.getString(cursor.getColumnIndex("food_description"))

            val food = Food(id, name, price, description)
            foodList.add(food)
        }

        cursor.close()
        return foodList
    }
}