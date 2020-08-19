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
import kotlinx.android.synthetic.main.fragment_register.*


/**
 * Shows a register form to showcase UI state persistence. It has a button that goes to [Registered]
 */
class Register : BaseFragment() {
    override val layoutId = R.layout.fragment_register

    override fun onCreated() {

        btnNext.setOnClickListener {
            iNav?.navigate(Registered())
        }
        tab_0_clear_top.setOnClickListener {
            iNav?.navigate(0, clearAllTop = true)

        }
        tab_0.setOnClickListener {
            iNav?.navigate(0)
        }
        tab_1_clear_top.setOnClickListener {
            iNav?.navigate(1, clearAllTop = true)

        }
        tab_1.setOnClickListener {
            iNav?.navigate(1)
        }

    }


    override fun onVisible() {

        showSnackbar("Register")
    }

}
