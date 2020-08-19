/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 4:06 PM
 *  * Last modified 8/13/20 4:06 PM
 *
 */

package org.abanoubmilad.labyrinth.demo.tab1

import org.abanoubmilad.labyrinth.demo.BaseFragment
import org.abanoubmilad.labyrinth.R
import org.abanoubmilad.labyrinth.demo.tab1.MyAdapter.Companion.USERNAME_KEY
import org.abanoubmilad.labyrinth.demo.showSnackbar
import kotlinx.android.synthetic.main.fragment_user_profile.*


/**
 * Shows a profile screen for a user, taking the name from the arguments.
 */
class UserProfile : BaseFragment() {
    override val layoutId = R.layout.fragment_user_profile

    override fun onCreated() {

        val name = arguments?.getString(USERNAME_KEY) ?: "Ali Connors"
        profile_user_name.text = name
    }


    override fun onVisible() {

        showSnackbar("profile")
    }
}
