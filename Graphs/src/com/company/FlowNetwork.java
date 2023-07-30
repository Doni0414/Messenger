package com.company;

import java.util.ArrayList;
import java.util.concurrent.Flow;

public class FlowNetwork {
    private final int V;
    private ArrayList<ArrayList<FlowEdge>> adj;

    public FlowNetwork(int V){
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(FlowEdge e){
        int v = e.from();
        int w = e.to();
        adj.get(v).add(e);
        adj.get(w).add(e);
    }
    public ArrayList<FlowEdge> adj(int v){
        return adj.get(v);
    }
    public int V(){
        return V;
    }
}
