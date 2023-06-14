package Dem1Pack;

import edu.princeton.cs.algs4.*;

public class AvgPrimsMST {

    public static void main(String args[]){
        In in = new In("G3.txt");            //Original : args[0]
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        PrimMST mst = new PrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }

}
