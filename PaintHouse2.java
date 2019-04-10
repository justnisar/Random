class Solution {
        public int minCostII(int[][] costs) {

        if(costs == null || costs.length == 0){
            return 0;
        }
        int rows = costs.length;
        int cols = costs[0].length;

        for(int i = 1 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0 ; k < cols ; k++){
                    if(k == j){
                        continue;
                    }
                    min = Math.min(min,costs[i-1][k]);
                }
                costs[i][j] = min + costs[i][j];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < cols ; i++){
            min = Math.min(min,costs[rows - 1][i]);
        }

        return min;
    }
}
