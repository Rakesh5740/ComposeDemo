package com.composetutorail

import androidx.annotation.StringRes
import com.composetutorial.R


/**
 * enum values that represent the screens in the app
 */
enum class ComposeScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Settings(title = R.string.settings),
    Profile(title = R.string.profile)
}
