class Solution {
    
    public boolean isSelfDividing(int number){
        if(number == 0)
            return false;
        int n = number;
        while(number != 0){
            int rem = number % 10;
            number /= 10;
            if(rem == 0)
                return false;
            if(n % rem != 0)
                return false;
        }
        return true;
    }
    
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = left ; i <= right ; i++){
            if(isSelfDividing(i))
                result.add(i);
        }
        return result;
    }
}
