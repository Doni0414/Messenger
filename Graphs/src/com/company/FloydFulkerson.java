package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class FloydFulkerson {
    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private int maxFlow;

    public FloydFulkerson(FlowNetwork G, int s, int t){
        floydFulkerson(G,s,t);
    }
    public void floydFulkerson(FlowNetwork G, int s, int t){
        while (hasAugmentingPath(G,s,t)) {
            int bottle = Integer.MAX_VALUE;
            int p = t;
            for (int v = t; v != s; v = edgeTo[v].other(v))
                bottle = Math.min(bottle, edgeTo[v].residualFlowTo(v));
            for (int v = t; v != s; v = edgeTo[v].other(v))
                edgeTo[v].addResidualFlowTo(v, bottle);
            maxFlow+=bottle;
        }
    }
    public boolean hasAugmentingPath(FlowNetwork G, int s, int t){
        marked = new boolean[G.V()];
        edgeTo = new FlowEdge[G.V()];

        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);

        while (!queue.isEmpty()){
            int v = queue.poll();
            for (FlowEdge e: G.adj(v)){
                int w = e.to();
                if (e.residualFlowTo(w) > 0 && !marked[w]){
                    queue.add(w);
                    marked[w] = true;
                    edgeTo[w] = e;
                }
            }
        }
        return marked[t];
    }
    public int maxFlow(){
        return maxFlow;
    }
}
