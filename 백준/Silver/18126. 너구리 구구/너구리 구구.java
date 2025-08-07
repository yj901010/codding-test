import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long ans = 0;
    static List<Edge>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new List[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }

        dfs(1, 0, 0);
        System.out.println(ans);
    }

    static void dfs(int node, int parent, long dist) {
        ans = Math.max(ans, dist);
        for (Edge e : adj[node]) {
            if (e.to == parent) continue;
            dfs(e.to, node, dist + e.weight);
        }
    }

    static class Edge {
        int to;
        long weight;
        Edge(int t, long w) { to = t; weight = w; }
    }
}
