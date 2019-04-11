package net.hasanguner.search.algorithm.uninformed

import net.hasanguner.search.datastructure.Node
import java.util.*

class DepthFirstSearch : NoCostSearch() {
    override val fringe: Queue<Node> = Collections.asLifoQueue(ArrayDeque<Node>())
}
