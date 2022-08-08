package com.a90ms.mstoast

import android.content.Context
import android.widget.Toast

class MsToast {

    companion object {

        fun Context.toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }
}