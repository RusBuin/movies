package com.loc.newsapp.domain.usecases.movies

import com.loc.newsapp.data.local.MovieDao
import com.loc.newsapp.domain.model.Movie
import javax.inject.Inject

class UpsertItem @Inject constructor(
    private val movieDao: MovieDao
) {

    suspend operator fun invoke(movie: Movie) {
        // Устанавливаем флаг isBookmarked в true, так как фильм добавляется в закладки
        val updatedMovie = movie.copy(isBookmarked = true)
        movieDao.upsert(movie = updatedMovie)
    }
}
