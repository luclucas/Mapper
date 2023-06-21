package com.lulu.mapper.modules.login.data.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lulu.mapper.modules.login.data.model.LoginModel

class LoginVM : ViewModel(){
    val loginModel: MutableLiveData<LoginModel> = MutableLiveData(LoginModel("", ""))

    var navArguments: Bundle? = null
}
