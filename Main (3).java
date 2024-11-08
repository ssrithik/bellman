import java.util.Arrays;
public class Main
{
    public static void bellman(int v,int e,int graph[][],int src){
        int dist[]=new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<v-1;i++){
            for(int j=0;j<e;j++){
                int s=graph[j][0];
                int d=graph[j][1];
                int w=graph[j][2];
                if(dist[s]+w<dist[d]){
                    dist[d]=dist[s]+w;
                }
            }
        }
        for(int j=0;j<e;j++){
            int s=graph[j][0];
            int d=graph[j][1];
            int w=graph[j][2];
            if(dist[s]+w<dist[d]){
                System.out.println("Negative cycle found");
            }
        }
        System.out.println("Vertex\tDistance");
        for (int i=0;i<v;i++){
            System.out.println(i+"\t"+dist[i]);
        }
    }
public static void main(String[] args) {
int v=5;
int e=6;
int graph[][]={{0,1,2},{0,2,4},{0,3,3},{2,4,-1},{2,3,0},{1,4,3}};
bellman(v,e,graph,0);
}
}
