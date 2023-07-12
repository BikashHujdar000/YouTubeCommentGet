package com.example.sagarproject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeService {

    @GET("commentThreads/")
    fun getComments(
        @Query("part") part: String,
        @Query("videoId") videoId: String,
        @Query("key") key: String
    ): Call<CommentResponse>
}