package com.composetutorail

import android.content.Context
import android.widget.Toast

object Util {

     fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

}