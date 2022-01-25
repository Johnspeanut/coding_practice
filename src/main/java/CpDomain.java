import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class CpDomain {

  public static void main(String[] args) {
    CpDomain cpDomain = new CpDomain();
    String[] inputs = new String[2];
    inputs[0] = "9001 discuss.leetcode.com";
    inputs[1] = "9001 discuss.leetcode.com";
    cpDomain.subdomainVisits(inputs);
  }

  public List<String> subdomainVisits(String[] cpdomains) {
    List<String> result = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();
    for(int i = 0; i < cpdomains.length; i++){
      String[] parts = cpdomains[i].split(" ");
      int count = Integer.parseInt(parts[0]);
      String domains = parts[1];
      String[] domainList = domains.split("\\.");
      String comDomain = "";
      for(int j = domainList.length-1; j >= 0; j--){
        comDomain = domainList[j] + "." + comDomain;
        System.out.println(comDomain);
        if(comDomain.charAt(comDomain.length()-1) == '.'){
          comDomain.substring(0,comDomain.length()-1);
        }
        map.put(comDomain, map.getOrDefault(comDomain, 0) + count);
      }
    }

    for(Map.Entry<String,Integer> entry:map.entrySet()){
      result.add(entry.getValue() + " " + entry.getKey());
    }
    return result;
  }
}