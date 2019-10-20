package com.example.androidexp

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androidexp.databinding.ActivityHomeBinding
import com.example.androidexp.model.entity.UserEntity
import com.example.mapleplayer.app.base.BaseActivity

class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

    private var user: UserEntity? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        user = UserEntity(1, "张三", 1)
        binding.user = user
    }
}


