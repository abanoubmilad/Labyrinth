package org.abanoubmilad.labyrinth

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.google.android.material.bottomnavigation.BottomNavigationView

class Builder(
    viewModelStoreOwner: ViewModelStoreOwner,
    val lifecycleOwner: LifecycleOwner,
    val fragmentManager: FragmentManager,
    @IdRes val fragmentContainerId: Int,
    var bottomNavigationView: BottomNavigationView?,
    override val rootTabFragmentsInitializer: List<() -> Fragment>,
    override val menuItemIdToRootTabFragmentIndexMap: HashMap<Int, Int>
) : ILabyrinthConfig {

    override var defaultSelectedTabIndex: Int = 0

    override var resetOnSameTabClickEnabled: Boolean = true
    override var saveStateEnabled: Boolean = false
    override var tabHistoryEnabled: Boolean = true

    var onNavTabSelected: ((menItemId: Int) -> Unit)? = null
    var onNonNavTabSelected: ((menItemId: Int) -> Unit)? = null

    val viewModel: LabyrinthViewModel =
        ViewModelProvider(viewModelStoreOwner).get(LabyrinthViewModel::class.java)

    fun build() = Labyrinth(this)
}