package com.company.servlets;

import java.util.ArrayDeque;
import java.util.Queue;

public class Util
{

    protected static final int M = 7;
    protected static final int N = 7;

    // Below arrays details all 4 possible movements from a cell
    protected static final int row[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
    protected static final int col[] = { -1, -2, -2, -1, 1, 2, 2, 1 };


    public static boolean isValid(int mat[][], boolean visited[][], int row, int col)
    {
        return ((row >= 0) && (row < M) && (col >= 0) && (col < N)
                && mat[row][col] == 0 && !visited[row][col]);
    }


    public static int LeeAlgorithm(int mat[][], int startCol, int startRow, int endCol, int endRow) {
        boolean[][] visited = new boolean[M][N];

        Queue<Node> queue = new ArrayDeque<Node>();

        visited[startRow][startCol] = true;
        queue.add(new Node(startRow, startCol, 0));

        int min_dist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            startRow = node.x;
            startCol = node.y;
            int dist = node.dist;

            if (startRow == endRow && startCol == endCol) {
                min_dist = dist;
                break;
            }

            for (int k = 0; k < 8; k++) {
                if (isValid(mat, visited, startRow + row[k], startCol + col[k])) {
                    visited[startRow + row[k]][startCol + col[k]] = true;
                    queue.add(new Node(startRow + row[k], startCol + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            return(min_dist);
        } else {
            System.out.println(-1);
            System.exit(-1);
            return -1;
        }
    }
}
