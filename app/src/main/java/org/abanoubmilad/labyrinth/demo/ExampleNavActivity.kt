/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 4:16 PM
 *  * Last modified 8/13/20 4:06 PM
 *
 */

package org.abanoubmilad.labyrinth.demo

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.labyrinth.demo.tab0.About1
import org.abanoubmilad.labyrinth.INavHolder
import org.abanoubmilad.labyrinth.LabyrinthSingle
import org.abanoubmilad.labyrinth.R

class ExampleNavActivity : FragmentActivity(), INavHolder {

    lateinit var labyrinth: LabyrinthSingle
    override fun getINav() = labyrinth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_single_nav_activity)

        labyrinth = LabyrinthSingle.Builder(
            fragmentManager = supportFragmentManager,

            fragmentContainerId = R.id.nav_host_container
        ).build()

        labyrinth.navigate(About1())
    }


    override fun onBackPressed() {
        if (labyrinth.shouldCallSuperOnBackPressed())
            super.onBackPressed()
    }
}
