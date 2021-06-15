package com.example.robertus_bffa_2

import com.example.robertus_bffa_2.GithubUser
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
        @GET("search/users")
        suspend fun searchUsers(
                @Query("q") q: String?
        ): SearchRespond

        @GET("users/{username}")
        suspend fun userDetail(
                @Path("username") username: String?
        ): GithubUser

        @GET("users/{username}/followers")
        suspend fun userFollower(
                @Path("username") username: String?
        ): List<GithubUser>

        @GET("users/{username}/following")
        suspend fun userFollowing(
                @Path("username") username: String?
        ): List<GithubUser>
}