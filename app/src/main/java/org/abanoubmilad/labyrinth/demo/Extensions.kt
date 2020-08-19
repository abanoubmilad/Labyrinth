/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 3:45 PM
 *  * Last modified 5/1/20 11:06 PM
 *
 */

package org.abanoubmilad.labyrinth.demo

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


fun Context?.activity(): Activity? = when (this) {
    is Activity -> this
    else -> (this as? ContextWrapper)?.baseContext?.activity()
}

fun Fragment.showSnackbar(msg: String) {
    activity?.let {
        val snack = Snackbar.make(
            it.findViewById(android.R.id.content),
            msg,
            Snackbar.LENGTH_SHORT
        )
        snack.setDuration(500)
        snack.show()
    }
}
