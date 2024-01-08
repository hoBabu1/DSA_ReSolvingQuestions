import java.util.*;
/**
 * calculate indegree 
 * add whose degree is 0 in queue<add vertex >
 * then go the neightbour and check if its dest is 0 or not if 0 thten add in queue
 */
public class TopoloGicalSortBFS {
    public static void main(String args[])
    {
        ArrayList<Edge> graph[] = new ArrayList[6];
        graphCreation(graph);
        topoSort(graph);
    }
    public static void topoSort(ArrayList<Edge> graph[])
    {
        int inDegree[] = new int[graph.length];
        inDegree(graph , inDegree);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < inDegree.length; i++)
        {
            if(inDegree[i] == 0)
            q.add(i);
        }
        while(!q.isEmpty())
        {
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i = 0 ; i<graph[curr].size();i++)
            {
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                if(inDegree[e.dest] == 0)
                {
                    q.add(e.dest);
                }
            }   
        }
    }
    public static void inDegree(ArrayList<Edge> graph[],int arr[])
    {
        for(int i = 0 ; i<graph.length;i++)
        {
            for(int j = 0 ; j<graph[i].size();j++)
            {
                Edge e = graph[i].get(j);
                arr[e.dest]++;
            }
        }

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
