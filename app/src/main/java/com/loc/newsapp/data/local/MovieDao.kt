package com.loc.newsapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.loc.newsapp.domain.model.AllMovie
import com.loc.newsapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)

    @Query("SELECT * FROM movies")
    fun getMovies(): Flow<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movies: List<AllMovie>)

    @Query("SELECT * FROM all_movies")
    fun getAllMovies(): Flow<List<AllMovie>>

    @Query("SELECT * FROM movies WHERE id=:id")
    suspend fun getMovieById(id: Int): Movie?

}