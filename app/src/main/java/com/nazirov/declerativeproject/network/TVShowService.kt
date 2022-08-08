package com.nazirov.declerativeproject.network
import com.nazirov.declerativeproject.model.TVShowDetails
import com.nazirov.declerativeproject.model.TVShowPopular
import retrofit2.Response
import retrofit2.http.*

interface TVShowService {

    @GET("api/most-popular")
    suspend fun apiTVShowPopular(@Query("page") page: Int): Response<TVShowPopular>

    @GET("api/show-details")
    suspend fun apiTVShowDetails(@Query("q") q: Int): Response<TVShowDetails>

}