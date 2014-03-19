package labten.dfs;

import labnine.graph.Graph;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] distTo;
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int source;         // source vertex
    private int time;

    /**
     * Computes a path between <tt>s</tt> and every other vertex in graph <tt>G</tt>.
     * @param G the graph you built in the previous assignment, make sure it has the adjacency list adj for each vertex
     * @param s the source vertex
     */
    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.getV()];
        distTo = new int[G.getV()];
        edgeTo = new int[G.getV()];
        source = s;
        dfs(G, s);
    }

    // depth first search from v
    private void dfs(Graph G, int v) {
        for (int u = 0; u < G.getV(); u++) {
            marked[u] = false;
            edgeTo[u] = 0;
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
        distTo[u] = time;
        for (int v : G.adj(u)) {
            if (!marked[v]) {
                edgeTo[v] = u;
                marked[v] = true;
                DFSVisit(G, v);
            }
        }
        marked[u] = true;
        time++;
    }

    /**
     * Is there a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>?
     * @param v the vertex
     * @return <tt>true</tt> if there is a path, <tt>false</tt> otherwise
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * Returns a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>, or
     * <tt>null</tt> if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a path between the source vertex
     *   <tt>s</tt> and vertex <tt>v</tt>, as an Iterable
     */
    public Iterable<Integer> pathTo(int v) {
        if (!this.hasPathTo(v)) {
            return null;
        }
        Stack path = new Stack();
        for (int i = v; i != source ; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(source);
        return path;
    }

    public int getSource() {
        return source;
    }

    /**
     * Unit tests the <tt>labten.dfs.DepthFirstPaths</tt> data type.
     */
    

}