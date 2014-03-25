/**
 *  The BreadthFirstPath class represents a data type for finding
 *  shortest paths (number of edges) from a source vertex s
 *  (or a set of source vertices)
 *  to every other vertex in an undirected graph.
 *  This implementation uses breadth-first search.
 *  The constructor takes time proportional to V + E
 *  where "V" is the number of vertices and E is the number of edges.
 */

package labnine.graph;

import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstPath {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int tEdges;
    private int source;
    private int[] edgeTo;      // edgeTo[v] = previous edge on s-v path
    private int[] distTo;      // distTo[v] = number of edges s-v path
    private Iterable<Integer> sources;
    private LinkedBlockingQueue<Integer> queue;

    /**
     * Computes the shortest path between the source vertex s
     * and every other vertex in the graph G.
     * @param G the graph
     * @param s the source vertex
     */
    public BreadthFirstPath(Graph G, int s) {
        source = s;
        marked = new boolean[G.v];
        edgeTo = new int[G.v];
        distTo = new int[G.v];
        queue = new LinkedBlockingQueue<>();
        tEdges = G.e;
        this.bfs(G, s);
    }

    /**
     * Computes the shortest path between any one of the source vertices in <tt>sources
     * and every other vertex in graph <tt>G</tt>.
     * @param G the graph
     * @param iSources the source vertices
     */
    public BreadthFirstPath(Graph G, Iterable<Integer> iSources) {
        sources = iSources;
        for (int i : sources) {
            BreadthFirstPath bfp = new BreadthFirstPath(G, i);
        }
    }


    // breadth-first search from a single source
    private void bfs(Graph G, int s) {
        for (int u = 0; u < G.v; u++) {
            marked[u] = false;
            edgeTo[u] = 0;
            distTo[u] = 0;
        }
        queue.add(s);
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i : G.adj(u)) {
                 if (!marked[i]) {
                    if (edgeTo[i] == 0) {
                        edgeTo[i] = u;
                    }
                    distTo[i] = distTo[u]++;
                    queue.add(i);
                 }
            }
            marked[u] = true;
        }
    }

    // breadth-first search from multiple sources
    private void bfs(Graph G, Iterable<Integer> sources) {
        for (int u : sources) {
            marked[u] = false;
            edgeTo[u] = INFINITY;
            distTo[u] = INFINITY;
            queue.add(u);
        }
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i : G.adj(u)) {
                if (!marked[u]) {
                    if (edgeTo[i] == INFINITY) {
                        edgeTo[i] = u;
                    }
                    distTo[i] = distTo[u]++;
                    queue.add(i);
                }
            }
            marked[u] = true;
        }
    }

    /**
     * Is there a path between the source vertex s (or sources) and vertex v?
     * @param v the vertex
     * @return true if there is a path, and false otherwise
     */
    public boolean hasPathTo(int v) {
        int distance = distTo(v);
        return (distance != INFINITY && distance != 0);
    }

    /**
     * Returns the number of edges in a path between the source vertex s
     * (or sources) and vertex v?
     * @param v the vertex
     * @return the number of edges in a path
     */
    public int distTo(int v) {
        int counter = 0;
        while (v != source) {
            counter++;
            v = edgeTo[v];
            distTo[v] = counter;
            if (counter > tEdges) {
                return INFINITY;
            }
        }
        return counter;
    }

    /**
     * Returns a path between the source vertex s (or sources)
     * and v, or null if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a shortest path, as an Iterable
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

}