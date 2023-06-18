package Dem1Pack;


import edu.princeton.cs.algs4.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class AvgBellmanFordSP {
    public static void main(String[] args) throws IOException {
        BufferedReader read;
        BufferedReader read1;
        float till=0;
        read1 = new BufferedReader(new FileReader("GraphList.txt"));
        String line1 = read1.readLine();
        In in1 = new In(line1);
        EdgeWeightedDigraph G1 = new EdgeWeightedDigraph(in1);
        double[][] arrayarr = new double[G1.V()][G1.V()];


            read = new BufferedReader(new FileReader("GraphList.txt"));
            String line = read.readLine();

            while (line != null) {
                till++;
                In in = new In(line);
                EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);


                for (int s = 0; s < G.V(); s++)
                {
                    // compute shortest paths
                    BellmanFordSP sp = new BellmanFordSP(G, s);
                    for (int t = 0; t < G.V(); t++) {
                        if (sp.hasPathTo(t)) {
                            arrayarr[s][t] += sp.distTo(t);

                        } else {
                            arrayarr[s][t] += 0;
                        }
                    }
                }

                line = read.readLine();
            }

            read.close();


        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (arrayarr[i][j] / till == 0){
                    StdOut.printf("%d to %d   no path.", i, j);
                    System.out.println();
                }
                else {
                    StdOut.printf("%d to %d   %.2f", i, j, arrayarr[i][j] / till);
                    System.out.println();
                }
            }

        }
    }

}


