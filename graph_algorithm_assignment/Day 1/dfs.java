//Depth First Search
/*Output: 
Following is Depth First Traversal
0 1 2 4 3*/
import java.util.*;
public class dfs
{
    int numVertices;
    LinkedList<Integer> adjLists[];
    boolean visited[];
    dfs(int vertices)
    {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];
        
        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<>();
    }

    void addEdge(int src, int dest)
    {
        adjLists[src].add(dest);
    }

    void DFS(int vertex)
    {
        visited[vertex] = true;
        System.out.print(vertex + " ");
 
        Iterator ite = adjLists[vertex].listIterator();
        while (ite.hasNext())
        {
            int adj = (Integer)ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }

    public static void main(String args[])
    {
        dfs g = new dfs(5);
 
         g.addEdge(0, 1);
         g.addEdge(0, 2);
         g.addEdge(1, 2);
         g.addEdge(2, 4);
         g.addEdge(2, 3);
         g.addEdge(0, 3);
        System.out.println("Following is Depth First Traversal");
        g.DFS(0);
    }
}