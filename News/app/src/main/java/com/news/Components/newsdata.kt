package com.news.Components

import android.media.Image
import com.news.R
import java.io.FileDescriptor

data class newsdata (
    val id:Int,
    val image: Int =R.drawable.back,
    val author:String,
    val title:String,
    val description : String,
    val pusblishedAt:String
        )