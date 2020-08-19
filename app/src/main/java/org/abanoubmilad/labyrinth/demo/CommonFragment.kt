/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/14/20 5:39 PM
 *  * Last modified 8/14/20 5:37 PM
 *
 */

package org.abanoubmilad.labyrinth.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.abanoubmilad.labyrinth.NavFragment


/**
 * Shows a profile screen for a user, taking the name from the arguments.
 */
abstract class BaseFragment : NavFragment() {
    abstract val layoutId: Int

    override fun buildRootView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View {
        return inflater.inflate(layoutId, container, false)
    }

}
