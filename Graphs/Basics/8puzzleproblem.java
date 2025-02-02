import java.util.*;

class Node {
    Node parent;
    int[][] mat;
    int x, y;
    int cost;
    int level;

    public Node(int[][] mat, int x, int y, int newX, int newY, int level, Node parent) {
        this.parent = parent;
        this.mat = new int[3][3];
        for (int i = 0; i < 3; i++)
            System.arraycopy(mat[i], 0, this.mat[i], 0, 3);
        int temp = this.mat[x][y];
        this.mat[x][y] = this.mat[newX][newY];
        this.mat[newX][newY] = temp;

        this.cost = Integer.MAX_VALUE;
        this.level = level;
        this.x = newX;
        this.y = newY;
    }
}

class PuzzleSolver {
    static final int N = 3;

    // Print the matrix
    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

  
    static int calculateCost(int[][] initial, int[][] goal) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (initial[i][j] != 0 && initial[i][j] != goal[i][j])
                    count++;
            }
        }
        return count;
    }

    // Check if a position is valid
    static boolean isSafe(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    // Print the path from the root to the solution
    static void printPath(Node root) {
        if (root == null)
            return;
        printPath(root.parent);
        printMatrix(root.mat);
        System.out.println();
    }

    // A comparator class to compare the cost of nodes
    static class NodeComparator implements Comparator<Node> {
        public int compare(Node lhs, Node rhs) {
            return (lhs.cost + lhs.level) - (rhs.cost + rhs.level);
        }
    }

    // Solve the puzzle using A* algorithm
    static void solve(int[][] initial, int x, int y, int[][] goal) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());

        // Create root node
        Node root = new Node(initial, x, y, x, y, 0, null);
        root.cost = calculateCost(initial, goal);
        pq.add(root);

        // Directions for movement (down, left, up, right)
        int[] row = {1, 0, -1, 0};
        int[] col = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            Node min = pq.poll();

            // If goal state is reached, print the path
            if (min.cost == 0) {
                printPath(min);
                return;
            }

            // Explore all possible movements
            for (int i = 0; i < 4; i++) {
                int newX = min.x + row[i];
                int newY = min.y + col[i];

                if (isSafe(newX, newY)) {
                    Node child = new Node(min.mat, min.x, min.y, newX, newY, min.level + 1, min);
                    child.cost = calculateCost(child.mat, goal);
                    pq.add(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] initial = {
                {1, 2, 3},
                {5, 6, 0},
                {7, 8, 4}
        };

        int[][] goal = {
                {1, 2, 3},
                {5, 8, 6},
                {0, 7, 4}
        };

        // Blank tile coordinates
        int x = 1, y = 2;

        solve(initial, x, y, goal);
    }
}
