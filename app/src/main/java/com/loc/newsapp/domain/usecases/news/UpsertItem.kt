package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.data.local.MovieDao
import com.loc.newsapp.domain.model.Movie
import javax.inject.Inject

class UpsertItem @Inject constructor(
    private val movieDao: MovieDao
) {

    suspend operator fun invoke(movie: Movie){
        movieDao.upsert(movie = movie)
    }

}