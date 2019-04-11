package net.hasanguner.search.datastructure

abstract class Node(val id: String) : Comparable<Node> {

    abstract val heuristic: Int
    abstract val adjacencies: Set<Edge>

    var cost = 0
    var parent: Node? = null

    fun getShortestPath(): List<Node> {
        val path = mutableListOf<Node>()
        var node: Node? = this
        while (node != null) {
            path.add(node)
            node = node.parent
        }
        return path.reversed()
    }

    override fun compareTo(other: Node): Int = cost.compareTo(other.cost)

    override fun equals(other: Any?): Boolean =
        other != null && other is Node && other.id == id

    override fun hashCode(): Int =
        id.hashCode()
}
