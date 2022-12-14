package com.example.foodordering.db

import androidx.room.*

@Dao
interface CheckoutDao {
    @Insert
    suspend fun addCheckout(checkout:Checkout)

    @Query("SELECT * FROM Checkout ORDER BY id DESC")
    suspend fun getAllCheckout():List<Checkout>

    @Insert
    suspend fun addMultipleCheckout(vararg checkout: Checkout)
    @Update
    suspend fun updateCheckout(checkout: Checkout)
    @Delete
    suspend fun deleteCheckout(checkout: Checkout)

    @Query("delete from Checkout where foodid = :fid")
    suspend fun deleteCheckoutByFoodId(fid: Int)

    @Query("delete from Checkout")
    suspend fun deleteAllCheckout()

    @Query("DELETE FROM Checkout")
    suspend fun clearTable()

}