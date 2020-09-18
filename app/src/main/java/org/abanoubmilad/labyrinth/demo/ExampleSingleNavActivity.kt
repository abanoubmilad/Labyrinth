/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 4:16 PM
 *  * Last modified 8/13/20 4:06 PM
 *
 */

package org.abanoubmilad.labyrinth.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.abanoubmilad.labyrinth.BuilderSingle
import org.abanoubmilad.labyrinth.INavHolder
import org.abanoubmilad.labyrinth.LabyrinthSingle
import org.abanoubmilad.labyrinth.R
import org.abanoubmilad.labyrinth.demo.tab0.About1

class ExampleSingleNavActivity : AppCompatActivity(), INavHolder {

    lateinit var labyrinth: LabyrinthSingle
    override fun getINav() = labyrinth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_single_nav_activity)

        labyrinth = BuilderSingle(
            viewModelStoreOwner = this,
            lifecycleOwner = this,
            fragmentManager = supportFragmentManager,

            fragmentContainerId = R.id.nav_host_container
        ).apply {

            saveStateEnabled = true
            retainNonActiveFragmentsEnabled = false

        }.build()

        labyrinth.navigate(About1())
    }


    override fun onBackPressed() {
        if (labyrinth.shouldCallSuperOnBackPressed())
            super.onBackPressed()
    }
}
