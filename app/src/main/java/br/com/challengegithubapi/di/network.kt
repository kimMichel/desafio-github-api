package br.com.challengegithubapi.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit(baseUrl: String): Retrofit = Retrofit
    .Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

inline fun <reified T> createService(retrofit: Retrofit): T = retrofit.create(T::class.java)