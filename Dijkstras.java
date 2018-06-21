package utilities;

public class Dijkstras {

    public static void dij(int[][] graph ,int src , int l){

        int inf=999,v=0;
        int[] distance = new int[l];
        int[] visited = new int[l];
        distance=graph[src];
        visited[src]=1;
        distance[src]=0;
        for(int i=0; i<l;i++) {
            inf = 999;
            for (int j = 0; j < l; j++) {
                if (inf > distance[j] && visited[j] != 1) {
                    inf = distance[j];
                    v = j;
                }
            }
            visited[v] = 1;
            for (int j = 0; j < l; j++) {
                if ((inf + graph[j][v] < distance[j]) && visited[j] != 1) {
                    distance[j] = inf + graph[j][v];
                }
            }
        }
    }
}
