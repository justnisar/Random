import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length];

        int[] table = new int[1001];

        for(int number : arr1){
            table[number]++;
        }

        int counter = 0;

        for(int number : arr2){
            int numberCount = table[number];
            while(numberCount-- > 0){
                result[counter++] = number;
            }
            table[number] = 0;
        }

        for(int i = 0 ; i < table.length ; i++){

            if(table[i] != 0){
                int numberCount = table[i];
                while(numberCount-- > 0){
                    result[counter++] = i;
                }
                table[i] = 0;
            }

        }

        return result;
    }

}
