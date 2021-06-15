package com.example.robertus_bffa_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.robertus_bffa_2.GithubUser
import com.example.robertus_bffa_2.UserRetrofit
import com.example.robertus_bffa_2.Resource
import com.example.robertus_bffa_2.TypeView

class FollowViewModel : ViewModel() {
    private val username: MutableLiveData<String> = MutableLiveData()

    private lateinit var type: TypeView

    val dataFollow: LiveData<Resource<List<GithubUser>>> = Transformations
        .switchMap(username) {
            when (type) {
                TypeView.FOLLOWER -> {
                    UserRetrofit.getFollowers(it)
                }
                TypeView.FOLLOWING -> {
                    UserRetrofit.getFollowing(it)
                }
            }
        }

    fun setFollow(user: String, typeView: TypeView) {
        if (username.value == user) {
            return
        }
        username.value = user
        type = typeView
    }
}