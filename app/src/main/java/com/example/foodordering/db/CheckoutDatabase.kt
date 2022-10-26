package com.example.foodordering.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Checkout::class], version = 1)
abstract class CheckoutDatabase: RoomDatabase() {
    abstract fun getCheckoutDao(): CheckoutDao

    companion object {
        // @Volatile means that this field is immediately made visible to other threads
        @Volatile
        private var instance: CheckoutDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            // Create a instance also return the instance
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        // Function to build database
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CheckoutDatabase::class.java,
            "checkoutdatabase"
        ).build()
    }

}