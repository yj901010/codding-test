import java.io.*;
import java.util.*;

class Point {
    private int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {return x;}
    public int getY() {return y;}
}

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        arr = new int[N][M];
        List<Point> points = new ArrayList<>();

        for(int i=0;i<N;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
                if (arr[i][j] == 1) {
                    points.add(new Point(i, j));
                }
            }
        }
        int max = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                int min = 1000000;
                if(arr[i][j]==0) {
                    for(Point p : points) {
                        int d = Math.max(Math.abs(p.getX() - i), Math.abs(p.getY() - j));
                        if(d<min) {
                            min = d;
                        }
                    }
                }
                if(max < min && min != 1000000) max = min;
            }
        }
        System.out.println(max);
    }
}
