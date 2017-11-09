import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class Solution {
	
	public TreeMap<String,List<String>> getFriends(String[] employeesInput,String[] friendshipsInput){
		
		TreeMap<String,List<String>> graph = new TreeMap<String,List<String>>();
		for(int i = 0 ; i < employeesInput.length ; i++){
			String[] str_arr = employeesInput[i].split(",");
			String node = str_arr[0];
			List<String> temp = new ArrayList<String>();
			graph.put(node,temp);
		}
		
		for(int i = 0 ; i < friendshipsInput.length ; i++){
			String[] str_arr = friendshipsInput[i].split(",");
			String left = str_arr[0];
			String right = str_arr[1];
			List<String> leftNode = graph.get(left);
			List<String> rightNode = graph.get(right);
			leftNode.add(right);
			rightNode.add(left);
		}
		
		return graph;
		
	}
	
	public static void main(String[] args){
		String[] employeesInput = {
			      "1,Richard,Engineering",
			      "2,Erlich,HR",
			      "3,Monica,Business",
			      "4,Dinesh,Engineering",
			      "6,Carla,Engineering",
			      "9,Laurie,Directors"
			    };

			    String[] friendshipsInput = {
			      "1,2",
			      "1,3",
			      "1,6",
			      "2,4"
			    };  
		Solution obj = new Solution();
		TreeMap<String,List<String>> result = obj.getFriends(employeesInput, friendshipsInput);
		for(Map.Entry<String,List<String>> entry : result.entrySet()){
			System.out.print(entry.getKey() + " : ");
			System.out.println(entry.getValue());
		}
	}
}

