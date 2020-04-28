//Floyd Warshall Algorithm(All pair shortest path)
/*The input is given as a matrix where each column value is defined as the distance between column index and row index.
If two vertices aren't connected, the column value is given as infinity.*/
/*Output:
0  3  7  5  
2  0  6  4  
3  1  0  5  
5  3  2  0*/
public class FloydWarshall {
  final static int INF = 999, nV = 4;

  void floydWarshall(int graph[][]) {
    int A[][] = new int[nV][nV];
    int i, j, k;

    for (i = 0; i < nV; i++)
      for (j = 0; j < nV; j++)
        A[i][j] = graph[i][j];

    for (k = 0; k < nV; k++) {
      for (i = 0; i < nV; i++) {
        for (j = 0; j < nV; j++) {
          if (A[i][k] + A[k][j] < A[i][j])
            A[i][j] = A[i][k] + A[k][j];
        }
      }
    }
    printMatrix(A);
  }

  void printMatrix(int A[][]) {
    for (int i = 0; i < nV; ++i) {
      for (int j = 0; j < nV; ++j) {
        if (A[i][j] == INF)
          System.out.print("INF ");
        else
          System.out.print(A[i][j] + "  ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int graph[][] = { { 0, 3, INF, 5 }, 
            { 2, 0, INF, 4 },
            { INF, 1, 0, INF },
            { INF, INF, 2, 0 } };
    FloydWarshall a = new FloydWarshall();
    a.floydWarshall(graph);
  }
}