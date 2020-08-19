/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 2:46 PM
 *  * Last modified 8/13/20 2:46 PM
 *
 */
package org.abanoubmilad.labyrinth

import android.os.Bundle
import androidx.fragment.app.Fragment


interface INav {

    fun navigate(
        tabIndex: Int,
        clearAllTop: Boolean = false,
        fragmentToPush: Fragment? = null,
        bundle: Bundle? = null
    )

    fun dismiss(clearAllTop: Boolean = false)

    fun dismissThenNavigate(fragment: Fragment, bundle: Bundle? = null)

    fun navigate(fragment: Fragment, bundle: Bundle? = null)

    fun getCurrentFragment(): Fragment?
}