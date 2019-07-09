class Solution {
  public List<List<String>> findDuplicate(String[] paths) {

    List<List<String>> result = new ArrayList<>();
    Map<String,List<String>> contentPathMap = new HashMap<>();

    for(String path : paths){

      String[] path_str = path.split(" ");
      String rootPath = path_str[0];
      for(int i = 1 ; i < path_str.length ; i++){
        String tempPath = path_str[i];
        int openParanIndex = tempPath.indexOf('(');
        int closeParanIndex = tempPath.indexOf(')');
        String filePath = tempPath.substring(0,openParanIndex);
        String content = tempPath.substring(openParanIndex + 1, closeParanIndex);
        List<String> pathList;
        String finalPath = rootPath + "/" + filePath;
        if(!contentPathMap.containsKey(content)){
          pathList = new ArrayList<>();
          pathList.add(finalPath);
        }
        else{
          pathList = contentPathMap.get(content);
          pathList.add(finalPath);
        }
        contentPathMap.put(content, pathList);
      }
    }

    for(Map.Entry<String,List<String>> entry : contentPathMap.entrySet()){
      if(entry.getValue().size() > 1){
        result.add(entry.getValue());
      }
    }

    return result;
  }
}
