/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 2:46 PM
 *  * Last modified 8/13/20 2:46 PM
 *
 */
package org.abanoubmilad.labyrinth

import androidx.fragment.app.Fragment


fun Fragment?.executeIfAdded(toExec: (fragment: Fragment) -> Unit) {
    if (this?.isAdded == true) {
        try {
            toExec(this)
        } catch (e: IllegalStateException) {
        }
    }
}