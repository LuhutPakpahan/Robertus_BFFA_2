package com.example.robertus_bffa_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.robertus_bffa_2.GithubUser
import com.example.robertus_bffa_2.UserRetrofit
import com.example.robertus_bffa_2.Resource

class DetailViewModel : ViewModel() {

    private val username: MutableLiveData<String> = MutableLiveData()

    val dataDetail: LiveData<Resource<GithubUser>> = Transformations
        .switchMap(username) {
            UserRetrofit.getDetailUser(it)
        }

    fun setDetail(userid: String) {
        if (username.value == userid) {
            return
        }
        username.value = userid
    }
}