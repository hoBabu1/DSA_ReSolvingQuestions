import java.util.*;
public class TopoloGicalSortDFS{
    public static void main(String args[])
    {
        ArrayList<Edge> graph[] = new ArrayList[6];
        graphCreation(graph);
        topoSort(graph);
    }
    public static void topoSort(ArrayList<Edge> graph[])
    {
        Stack<Integer> s = new Stack<>();
        boolean visit[] = new boolean[graph.length];
        for(int i = 0 ; i<graph.length;i++)
        {
            if(!visit[i])
            {
                topoSortutil(graph , s , visit , i);
            }
        }
        while(!s.isEmpty())
        {
            System.out.print(s.pop()+" ");
        }
    }
    public static void topoSortutil(ArrayList<Edge> graph[] , Stack<Integer> s  , boolean visit[] , int curr)
    {
        visit[curr] = true;
        for(int i = 0 ; i<graph[curr].size();i++)
        {
            Edge e = graph[curr].get(i);
            if(!visit[e.dest])
            {
                topoSortutil(graph , s , visit , e.dest);
            }
        }
        s.push(curr);
    }
   
    public static class Edge{
        int src ;
        int dest;
        public Edge(int src , int dest)
        {
            this.src = src ;
            this.dest=dest;
        }
    }
    public static void graphCreation(ArrayList<Edge> graph[])
    {
        for(int i = 0 ; i<graph.length ; i++)
        {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }
}
