package com.example.robertus_bffa_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.robertus_bffa_2.GithubUser
import com.example.robertus_bffa_2.UserRetrofit
import com.example.robertus_bffa_2.Resource

class HomeViewModel : ViewModel() {

    private val username: MutableLiveData<String> = MutableLiveData()

    val searchResult: LiveData<Resource<List<GithubUser>>> = Transformations
        .switchMap(username) {
            UserRetrofit.searchUsers(it)
        }

    fun setSearch(query: String) {
        if (username.value == query) {
            return
        }
        username.value = query
    }
}