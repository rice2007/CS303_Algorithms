package labten.dfs;

import labnine.graph.Graph;

import java.util.LinkedList;

public class DepthFirstPaths {

    private final boolean[] grayed;    // marked[v] = is there an s-v path?
    private final boolean[] marked;
    private final int NIL = Integer.MIN_VALUE;
    private final int source;         // source vertex
    private final int[] distTo;
    private final int[] edgeTo;        // edgeTo[v] = last edge on s-v path

    private int time;
    private LinkedList<Integer> topList;

    /**
     * Computes a path between <tt>s</tt> and every other vertex in graph <tt>G</tt>.
     * @param G the graph you built in the previous assignment, make sure it has the adjacency list adj for each vertex
     * @param s the source vertex
     */
    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.getV()];
        grayed = new boolean[G.getV()];
        distTo = new int[G.getV()];
        edgeTo = new int[G.getV()];
        topList = new LinkedList<>();
        source = s;
        dfs(G);
    }

    // depth first search from v
    private void dfs(Graph G) {
        for (int i = 0; i < edgeTo.length; i++) {
            edgeTo[i] = NIL;
        }
        time = 0;
        for (int u = 0; u < G.getV(); u++) {
            if (!marked[u]) {
                DFSVisit(G, u);
            }
        }
    }

    private void DFSVisit(Graph G, int u) {
        time++;
        grayed[u] = true;
        for (int v : G.adj(u)) {
            if (!marked[v] && !grayed[v]) {
                edgeTo[v] = u;
                DFSVisit(G, v);
            }
        }
        marked[u] = true;
        time++;
        distTo[u] = time;
        topSortHelper(u);
    }

    private void topSortHelper(int u) {
        topList.push(u);
    }

    /**
     * Is there a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>?
     * @param v the vertex
     * @return <tt>true</tt> if there is a path, <tt>false</tt> otherwise
     */
    public boolean hasPathTo(int v) {
        if (v == NIL) {
            return false;
        }
        if (v != source) {
            return hasPathTo(edgeTo[v]);
        } else {
            return true;
        }
    }

    /**
     * Returns a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>, or
     * <tt>null</tt> if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a path between the source vertex
     *   <tt>s</tt> and vertex <tt>v</tt>, as an Iterable
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        LinkedList<Integer> path = new LinkedList<>();
        for (int i = v; i != source ; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(source);
        return path;
    }

    public int getSource() {
        return source;
    }

    public LinkedList<Integer> topologicalSort() {
        return topList;
    }
}