//Prim's algorithm for Minimum Spanning Tree
/*Input is given as a table. Where each column value is defined as the weight value for edge connecting column index and row index.*/
/*Output:
0  1    5 
0  2    0 
0  3    8 
1  4    6*/
public class PrimMST 
{
	public final static int VERTICES = 5;
	public static int minimumKey(int[] k, int[] mst) 
        {
		int minimum = Integer.MAX_VALUE, min = 0;
		for(int i = 0; i < VERTICES; i++) 
                {
			if(mst[i] == 0 && k[i] < minimum) 
                        {
				minimum = k[i];
				min = i;
			}
		}
		return min;
	}
	public static void prim(int[][] g) {
		int[] parent = new int[VERTICES];
		int[] k = new int[VERTICES];
		int[] mst = new int[VERTICES];
		int u;
		for(int i = 0; i < VERTICES; i++) {
			k[i] = Integer.MAX_VALUE;
			mst[i] = 0;
		}
		k[0] = 0;
		parent[0] = -1;
		for(int count = 0; count < VERTICES - 1; count++) {
			u = minimumKey(k, mst);
			mst[u] = 1;
			for(int v = 0; v < VERTICES; v++) 
                        {
				if(g[u][v] != 0 && mst[v] == 0 && g[u][v] < k[v]) 
                                {
					parent[v] = u;
					k[v] = g[u][v];
				}
			}
		}
		for(int i = 1; i < VERTICES; i++) {
			System.out.println(parent[i] + "  " + i + "    " + g[i][parent[i]] + " ");
		}
	}

	public static void main(String[] args) {
		int[][] g = {{3, 2, 1, 9, 0}, 
                            {5, 1, 2, 10, 4}, 
                            {0, 4, 1, 0, 9}, 
                            {8, 10, 0, 2, 10}, 
                            {1, 6, 8, 11, 0}};
		prim(g);
	}
}