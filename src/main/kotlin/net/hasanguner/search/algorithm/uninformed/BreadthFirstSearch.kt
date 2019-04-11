package net.hasanguner.search.algorithm.uninformed

import net.hasanguner.search.datastructure.Node
import java.util.*

class BreadthFirstSearch : NoCostSearch() {
    override val fringe: Queue<Node> = ArrayDeque<Node>()
}
