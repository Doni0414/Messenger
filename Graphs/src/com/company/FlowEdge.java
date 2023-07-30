package com.company;

public class FlowEdge {
    private int v;
    private int w;
    private final int capacity;
    private int flow;

    public FlowEdge(int v, int w, int capacity) {
        this.v = v;
        this.w = w;
        this.flow = flow;
        this.capacity = capacity;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }
    public int other(int v){
        if (v==this.v) return w;
        else if (v==this.w) return this.v;
        else throw new RuntimeException("Invalid endpoint");
    }

    public int flow() {
        return flow;
    }
    public int residualFlowTo(int v){
        if (v==this.v) return flow;
        else if(v==this.w) return capacity-flow;
        else throw new RuntimeException("Invalid endpoint");
    }
    public void addResidualFlowTo(int v, int delta){
        if (v==this.v) flow-=delta;
        else if(v==this.w) flow+=delta;
        else throw new RuntimeException("Invalid endpoint");
    }
}
