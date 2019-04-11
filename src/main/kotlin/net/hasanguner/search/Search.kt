package net.hasanguner.search

import net.hasanguner.search.datastructure.Node

interface Search {
    fun search(root: Node, goal: Node): SearchResult
}