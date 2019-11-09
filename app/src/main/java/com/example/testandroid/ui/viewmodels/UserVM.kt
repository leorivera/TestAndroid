package com.example.testandroid.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testandroid.User

class UserVM : ViewModel() {
    private var mUserListLiveData: MutableLiveData<List<User>>? = null
    private var mUserList: MutableList<User>? = null

    fun getUserList(): MutableLiveData<List<User>>? {
        if (mUserListLiveData == null) {
            mUserListLiveData = MutableLiveData<List<User>>()
            mUserList = ArrayList<User>()
        }
        return mUserListLiveData
    }

    fun addUser(user: User) {
        mUserList!!.add(user)
        mUserListLiveData!!.setValue(mUserList);
    }
}