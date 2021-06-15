package com.example.robertus_bffa_2

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.robertus_bffa_2.R

@BindingAdapter("avatar")
fun avatar(imageView: ImageView, avatar: String) =
    Glide.with(imageView)
        .load(avatar)
        .apply(RequestOptions.circleCropTransform().placeholder(R.drawable.ic_user))
        .into(imageView)