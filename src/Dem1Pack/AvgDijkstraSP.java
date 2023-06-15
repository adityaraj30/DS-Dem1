package Dem1Pack;

import edu.princeton.cs.algs4.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AvgDijkstraSP {
    public static void main(String[] args) {
        BufferedReader read;
        float count=0;
        double[][] pArray = new double[6][6];

        try {
            read = new BufferedReader(new FileReader("GraphList.txt"));
            String line = read.readLine();

            while (line != null) {
                count++;
                In in = new In(line);
                EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

                for (int s = 0; s < G.V(); s++)
                {
                    // compute shortest paths
                    DijkstraSP sp = new DijkstraSP(G, s);
                    for (int t = 0; t < G.V(); t++) {
                        if (sp.hasPathTo(t)) {
                            pArray[s][t] += sp.distTo(t);

                        } else {
                            pArray[s][t] += 0;
                        }
                    }
                }

                line = read.readLine();
            }

            read.close();
        }
        catch (IOException a) {
            a.printStackTrace();
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (pArray[i][j] / count == 0){
                    StdOut.printf("%d to %d   (no path)", i, j);
                    System.out.println();
                }
                else {
                    StdOut.printf("%d to %d   (%.2f)", i, j, pArray[i][j] / count);
                    System.out.println();
                }
            }

        }
    }

}


