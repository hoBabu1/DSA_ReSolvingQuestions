import java.util.*;
public class DijkstrasAlgorithm
{
    public static void main(String args[])
    {
        ArrayList<Edge> graph[] = new ArrayList[6];
        CreateGraph(graph);
        Dijkstras(graph , 0);
        
    }
    public static void Dijkstras(ArrayList<Edge> graph[] , int src)
    {
        int dist[] = new int[graph.length];
        for(int i = 0 ; i<dist.length ; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        boolean visit[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src , 0));
        dist[src]=0;
        while(!pq.isEmpty())
        {
            Pair curr = pq.remove();
            if(!visit[curr.vertex])
            {
                visit[curr.vertex] = true ;
                for(int i = 0 ; i<graph[curr.vertex].size();i++)
                {
                    Edge e = graph[curr.vertex].get(i);
                    int u = e.src ;
                    int v = e.dest ; 
                    int path = e.wt ;
                    if(dist[u]+path < dist[v])
                    {
                        dist[v] = dist[u]+path;
                    }
                    pq.add(new Pair(v , dist[v]));
                }
            }
        }
        for(int i = 0 ; i<dist.length ; i++)
        {
            System.out.println(dist[i]+" ");
        }
    }
    public static class Pair implements Comparable<Pair>
    {
        int vertex ;
        int w ;
        public Pair(int vertex , int w)
        {
            this.vertex=vertex;
            this.w=w;
        }
        public int compareTo(Pair p2)
        {
            return this.w - p2.w;
        }
    }
    public static void CreateGraph(ArrayList<Edge> graph[])
    {
        for(int i = 0 ; i<graph.length ; i++)
        {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));
        graph[2].add(new Edge(2,4,3));
        graph[2].add(new Edge(2,4,3));
        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,5,5));
        graph[4].add(new Edge(4,3,2));

    }
    public static class Edge{
        int src ;
        int dest ;
        int wt ;
        public Edge(int src , int dest , int wt )
        {
            this.wt = wt ;
            this.dest = dest ;
            this.src = src;
        }
    }
}