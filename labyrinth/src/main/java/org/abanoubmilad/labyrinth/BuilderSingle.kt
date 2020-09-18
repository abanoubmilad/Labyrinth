package org.abanoubmilad.labyrinth

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

class BuilderSingle(
    viewModelStoreOwner: ViewModelStoreOwner,
    val lifecycleOwner: LifecycleOwner,
    val fragmentManager: FragmentManager,
    @IdRes val fragmentContainerId: Int
) : ILabyrinthConfigSingle {
    override var saveStateEnabled = true
    override var retainNonActiveFragmentsEnabled = false

    fun build() = LabyrinthSingle(this)

    val viewModel: LabyrinthViewModelSingle =
        ViewModelProvider(viewModelStoreOwner).get(LabyrinthViewModelSingle::class.java)
}