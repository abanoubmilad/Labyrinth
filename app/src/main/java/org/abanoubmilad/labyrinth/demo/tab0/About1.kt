/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 4:06 PM
 *  * Last modified 8/13/20 4:06 PM
 *
 */

package org.abanoubmilad.labyrinth.demo.tab0

import org.abanoubmilad.labyrinth.demo.BaseFragment
import org.abanoubmilad.labyrinth.demo.showSnackbar
import kotlinx.android.synthetic.main.fragment_about1.*
import org.abanoubmilad.labyrinth.R

/**
 * Shows "About"
 */
class About1 : BaseFragment() {
    override val layoutId = R.layout.fragment_about1

    override fun onCreated() {

        btnNext.setOnClickListener {
            iNav?.navigate(About2())
        }
        tab_1_clear_top.setOnClickListener {
            iNav?.navigate(1, clearAllTop = true)

        }
        tab_1_and_navigate.setOnClickListener {
            iNav?.navigate(1, fragmentToPush = About1())

        }
        tab_1_and_navigate_clear.setOnClickListener {
            iNav?.navigate(1, clearAllTop = true, fragmentToPush = About1())

        }
        tab_1.setOnClickListener {
            iNav?.navigate(1)
        }
        tab_2_clear_top.setOnClickListener {
            iNav?.navigate(2, clearAllTop = true)

        }
        tab_2.setOnClickListener {
            iNav?.navigate(2)
        }

        dismiss.setOnClickListener {
            iNav?.dismiss()
        }

        dismiss_clear_top.setOnClickListener {
            iNav?.dismiss(clearAllTop = true)
        }
    }


    override fun onVisible() {

        showSnackbar("about 1")
    }


}
