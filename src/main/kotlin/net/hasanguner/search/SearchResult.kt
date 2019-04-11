package net.hasanguner.search

import net.hasanguner.search.datastructure.Node

data class SearchResult(
    val path: List<Node>,
    val explored: Set<Node>
)
