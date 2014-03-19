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

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Queue;

public class BreadthFirstPath {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on s-v path
    private int[] distTo;      // distTo[v] = number of edges s-v path
    private Queue<Integer> queue;

    /**
     * Computes the shortest path between the source vertex s
     * and every other vertex in the graph G.
     * @param G the graph
     * @param s the source vertex
     */
    public BreadthFirstPath(Graph G, int s) throws IOException {

    }

    /**
     * Computes the shortest path between any one of the source vertices in <tt>sources
     * and every other vertex in graph <tt>G</tt>.
     * @param G the graph
     * @param sources the source vertices
     */
    public BreadthFirstPath(Graph G, Iterable<Integer> sources) {

    }


    // breadth-first search from a single source
    private void bfs(Graph G, int s) {
        for (int u = 0; u < G.v; u++) {
            marked[u] = false;
            distTo[u] = INFINITY;
        }
        distTo[s] = 0;
    }

    // breadth-first search from multiple sources
    private void bfs(Graph G, Iterable<Integer> sources) {
        // Same algo as BFS from a single source but for numerous source vertices
    }

    /**
     * Is there a path between the source vertex s (or sources) and vertex v?
     * @param v the vertex
     * @return true if there is a path, and false otherwise
     */
    public boolean hasPathTo(int v) {
        return false;
    }

    /**
     * Returns the number of edges in a path between the source vertex s
     * (or sources) and vertex v?
     * @param v the vertex
     * @return the number of edges in a path
     */
    public int distTo(int v) {
        return 0;
    }

    /**
     * Returns a path between the source vertex s (or sources)
     * and v, or null if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a shortest path, as an Iterable
     */
    public Iterable<Integer> pathTo(int v) {
        return null;
    }

}