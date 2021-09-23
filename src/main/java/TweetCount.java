import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

class TweetCount {

  public static void main(String[] args) {
     TweetCount obj = new TweetCount();
 obj.recordTweet("tweet3",0);
    obj.recordTweet("tweet3",60);
    obj.recordTweet("tweet3",10);
    obj.recordTweet("tweet3",10);
    obj.recordTweet("tweet3",120);
 List<Integer> param_2 = obj.getTweetCountsPerFrequency("hour","tweet3",0,210);
    System.out.println("The value is" + param_2.toString());
  }
  HashMap<String, TreeSet<Integer>> map;

  public TweetCount() {
    map = new HashMap<>();
  }

  public void recordTweet(String tweetName, int time) {
    TreeSet<Integer> set = map.getOrDefault(tweetName, new TreeSet<>());
    set.add(time);
    map.put(tweetName, set);

  }

  public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
    List<Integer> res = new LinkedList<>();
    TreeSet<Integer> set = map.getOrDefault(tweetName, new TreeSet<Integer>());
    int interval = getInterval(freq);
    for(int i = startTime; i <= endTime; i += interval){
      int endtime = Math.min(i + interval, endTime + 1);
      SortedSet<Integer> sub = set.subSet(i, endtime);
      res.add(sub.size());
    }
    return res;

  }

  private int getInterval(String freq){
    int res = 0;
    if(freq.equals("minute")){
      res = 60;
    }else if(freq.equals("hour")){
      res = 3600;
    }else if(freq.equals("day")){
      res = 86400;
    }
    return res;
  }
}