class Solution {
    public int minCost(int[][] costs) {
        
        if(costs == null || costs.length == 0){
            return 0;
        }
        
        for(int i = 1 ; i < costs.length ; i++){
            for(int j = 0; j < costs[0].length ; j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0 ; k < 3 ; k++){
                    if(k == j){
                        continue;
                    }
                    min = Math.min(min,costs[i-1][k]);
                }
                costs[i][j] = costs[i][j] + min;
            }
        }
        
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}
