package net.hasanguner.search.graph

import net.hasanguner.search.datastructure.GraphNode

class GermanySearchGraph {

    def frankfurt = new GraphNode("Frankfurt")
    def mannheim = new GraphNode("Mannheim")
    def wurzburg = new GraphNode("Würzburg")
    def stuttgart = new GraphNode("Stuttgart")
    def kassel = new GraphNode("Kassel")
    def karisruhe = new GraphNode("Karisruhe")
    def erfurt = new GraphNode("Erfurt")
    def numberg = new GraphNode("Nümberg")
    def augsburg = new GraphNode("Augsburg")
    def munchen = new GraphNode("München")

    GermanySearchGraph() {
        frankfurt.addEdge(85, mannheim)
        mannheim.addEdge(80, karisruhe)
        karisruhe.addEdge(250, augsburg)
        augsburg.addEdge(84, munchen)
        frankfurt.addEdge(217, wurzburg)
        wurzburg.addEdge(103, numberg)
        wurzburg.addEdge(186, erfurt)
        numberg.addEdge(183, stuttgart)
        numberg.addEdge(167, munchen)
        frankfurt.addEdge(173, kassel)
        kassel.addEdge(502, munchen)
    }

}

