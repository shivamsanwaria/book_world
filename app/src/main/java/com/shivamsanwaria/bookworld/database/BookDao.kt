package com.shivamsanwaria.bookworld.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.shivamsanwaria.bookworld.model.Book
@Dao
interface BookDao {
    @Insert
    fun insetBook(bookEntities: BookEntities)

    @Delete
    fun deleteBook(bookEntities: BookEntities)

    @Query("SELECT * FROM books")
    fun getAllBooks():List<BookEntities>

    @Query("SELECT * FROM books WHERE book_id = :bookId")
    fun getBookbyID(bookId:String):BookEntities



}