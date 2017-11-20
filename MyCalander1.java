
class Pair{
    int left;
    int right;
    public Pair(int left,int right){
        this.left = left;
        this.right = right;
    }
}


public class MyCalendar {

    private List<Pair> bookingList;
    public MyCalendar() {
        bookingList = new ArrayList<Pair>();
    }
    
    public boolean doesCoincide(Pair pair1,Pair pair2){
        if(pair2.left >= pair1.left && pair2.right <= pair1.right)
            return true;
        return false;
    }
    
    public boolean book(int start, int end) {
        if(bookingList.size() == 0){
            bookingList.add(new Pair(0,start - 1));
            bookingList.add(new Pair(end,1000000000 - 1));
            return true;
        }
        int flag = 0;
        Pair inputPair = new Pair(start,end - 1);
        Pair matchPair = null;
        for(Pair pair : bookingList){
            if(doesCoincide(pair,inputPair)){
                matchPair = pair;
                flag = 1;
                break;
            }
        }
        if(flag == 1){
            int left = matchPair.left;
            int right = matchPair.right;
            bookingList.remove(matchPair);
            bookingList.add(new Pair(left,start - 1));
            bookingList.add(new Pair(end,right));
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
