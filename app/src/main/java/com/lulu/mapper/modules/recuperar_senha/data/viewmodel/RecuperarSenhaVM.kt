package com.lulu.mapper.modules.recuperar_senha.data.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lulu.mapper.modules.recuperar_senha.data.model.RecuperarSenhaModel

class RecuperarSenhaVM : ViewModel() {
    val recuperarSenhaModel: MutableLiveData<RecuperarSenhaModel> =
        MutableLiveData(RecuperarSenhaModel())

    var navArguments: Bundle? = null
}
