package net.hasanguner.search.algorithm

class SearchAlgorithmNotFoundException(algorithm: SearchAlgorithm) :
    RuntimeException("Concrete implementation of Algorithm[$algorithm] not found.")
