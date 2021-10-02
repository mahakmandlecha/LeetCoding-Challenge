class Solution {
    public int minFlips(int[][] mat) {
        if(mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        int n = mat.length;
        int m = mat[0].length;
        
        if(isallzero(boardToString(mat))) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        queue.offer(boardToString(mat));
        visited.add(boardToString(mat));
        boolean find = false;
        
        int step = 0;
        while(!queue.isEmpty() && !find) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String head = queue.poll();
                if(isallzero(head)) {
                    return step;
                }
                List<String> neighbors = getAllNeighbor(head, n, m);
                for(String neighbor: neighbors) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            step++;
        }
        return find == false ? -1 : step;
    }
    
    private List<String> getAllNeighbor(String matstr, int n, int m) {
        List<String> list = new ArrayList<String>();
        int[][] mat = stringToBoard(matstr, n, m);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                list.add(changeboard(mat, i, j));
                changeboard(mat, i, j);
            }
        }
        return list;
    }
    
    private String changeboard(int[][] mat, int x, int y) {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int n = mat.length;
        int m = mat[0].length;
        
        mat[x][y] = (mat[x][y] == 0) ? 1 : 0;
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(0 <=nx && nx < n && 0 <= ny && ny < m) {
                mat[nx][ny] = (mat[nx][ny] == 0) ? 1 : 0;
            }
        }
        return boardToString(mat);
    }
    
    private String boardToString(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(mat[i][j]);
            }
        }
        return sb.toString();
    }
    
    private int[][] stringToBoard(String matstr, int n, int m) {
        int[][] mat = new int[n][m];
        for(int i = 0; i < matstr.length(); i++) {
            mat[i / m][ i % m] = matstr.charAt(i) - '0';
        }
        return mat;
    }
    
    private boolean isallzero(String matstr) {
        for(int i = 0; i < matstr.length(); i++) {
            if(matstr.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}
 
