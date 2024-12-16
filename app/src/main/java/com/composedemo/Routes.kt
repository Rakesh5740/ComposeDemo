package com.composedemo

import androidx.annotation.StringRes


/**
 * enum values that represent the screens in the app
 */
enum class AppDestination(@StringRes val title: Int, var data: String? = null) {
    Start(title = R.string.app_name),
    Settings(title = R.string.settings),
    Profile(title = R.string.profile)
}
