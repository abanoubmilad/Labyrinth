/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 6:58 PM
 *  * Last modified 1/22/20 12:20 AM
 *
 */

package org.abanoubmilad.labyrinth

data class UniqueStack(private val elements: MutableList<Int> = mutableListOf()) {

    fun push(entry: Int) {
        elements.remove(entry)
        elements.add(entry)
    }

    fun pop() = if (elements.isNotEmpty()) elements.removeAt(elements.size - 1) else null

    fun peek() = if (elements.isNotEmpty()) elements[elements.size - 1] else null

    fun isEmpty() = elements.isEmpty()

    fun getSize() = elements.size

    fun clear() {
        elements.clear()
    }
}