package com.codesroots.mac.cardss.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.codesroots.mac.cardss.models.Buypackge
import com.codesroots.mac.cardss.models.Pencode


@Dao
interface CardDao {

    @Insert
     fun insertPackege(user: Buypackge)

    @Insert
     fun insertPetList(pets: List<Pencode>)

    @Query("SELECT * FROM Buypackge WHERE opno =:id")
    suspend fun getUser(id: Int): Buypackge

    @Query("SELECT * FROM Buypackge")
    suspend fun GetAllData():  List<Buypackge>

    @Query("SELECT * FROM pencode WHERE buypackageid =:userId")
    suspend fun getPetList(userId: Int): List<Pencode>

    @Query("Delete  FROM Buypackge WHERE opno =:user")
    suspend fun deleteCard(user: Int)

}