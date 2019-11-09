package com.example.testandroid.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.testandroid.R
import com.example.testandroid.User
import com.example.testandroid.ui.viewmodels.UserVM

import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*

class HomeActivity : AppCompatActivity() {

    private var mLiveDataUserVievmodel: UserVM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupModule()
    }

    fun setupModule() {
        setSupportActionBar(toolbar)
        setupLiveDataUser()
        btn.setOnClickListener { addUser() }
    }

    fun setupLiveDataUser() {
        mLiveDataUserVievmodel = ViewModelProviders.of(this).get(UserVM::class.java);
        val observerUser = Observer<List<User>> {
            var userList = ""
            for (user in it) {
                userList += user.mName + " " + user.mLastName + "\n";
            }
            texto.text = userList
        }
        mLiveDataUserVievmodel!!.getUserList()!!.observe(this, observerUser)
    }

    fun addUser() {
        val user: User = User()
        user.mName = name.text.toString()
        user.mLastName = last_name.text.toString()
        mLiveDataUserVievmodel!!.addUser(user)
    }
}
