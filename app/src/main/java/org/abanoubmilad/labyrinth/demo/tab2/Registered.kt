/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 4:06 PM
 *  * Last modified 8/13/20 4:06 PM
 *
 */

package org.abanoubmilad.labyrinth.demo.tab2

import org.abanoubmilad.labyrinth.demo.BaseFragment
import org.abanoubmilad.labyrinth.R
import org.abanoubmilad.labyrinth.demo.showSnackbar


/**
 * Shows "Done".
 */
class Registered : BaseFragment() {
    override val layoutId = R.layout.fragment_registered


    override fun onCreated() {


    }

    override fun onVisible() {

        showSnackbar("Registered")
    }
}
