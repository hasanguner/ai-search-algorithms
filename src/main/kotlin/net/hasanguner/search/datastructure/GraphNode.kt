package net.hasanguner.search.datastructure

class GraphNode @JvmOverloads constructor(
    id: String,
    override val heuristic: Int = 0
) : Node(id) {

    override val adjacencies: Set<Edge>
        get() = edges.toSet()

    private val edges: MutableSet<Edge> = mutableSetOf()

    @JvmOverloads
    fun addEdge(cost: Int = 0, target: GraphNode): Boolean =
        edges.add(Edge(cost, target))
            .also { if (it) target.addEdge(cost, this) }
}
