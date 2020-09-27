import java.util.PriorityQueue;

class MinCosttoConnectAllPoints {
    PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
    int [] parents;

    public int minCostConnectPoints(int[][] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = i; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                queue.add(new Edge(new Vertex(i, points[i][0], points[i][1]), new Vertex(j, points[j][0], points[j][1]), Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        parents = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            parents[i] = i;
        }
        int res = 0;
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int p = findParent(edge.start.id);
            int q  = findParent(edge.end.id);
            if (p != q) {
                parents[p] = q;
                res += edge.weight;
            }
        }
        return res;
    }

    int findParent(int u) {
        if (parents[u] == u) {
            return u;
        }
        return parents[u] = findParent(parents[u]);
    }
}

class Edge {
    Vertex start;
    Vertex end;
    int weight;

    Edge( Vertex s, Vertex e, int w) {
        start = s;
        end = e;
        weight = w;
    }
}

class Vertex {
    int x;
    int y;
    int id;

    Vertex(int i, int x, int y) {
        this.x = x;
        this.y = y;
        id = i;
    }
}