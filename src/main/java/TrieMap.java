import java.util.LinkedList;
import java.util.List;

public class TrieMap<V> {
  TrieNode root = null;
  int size = 0;
  public void put(String key, V value){
    if(!containsKey(key)){
      size ++;
    }
    root = put(root, key, value,0);
  }

  public TrieNode<V> put(TrieNode<V> node, String key, V value, int i){
    if(node == null){
      node = new TrieNode<>();
    }
    if(i == key.length()){
      node.value = value;
      return node;
    }
    char c = key.charAt(i);
    node.children[c] = put(node.children[c], key,value, i+1);
    return node;
  }

  public void remove(String key){
    if(!containsKey(key)) return;
    root = remove(root, key,0);
    size--;

  }

  public TrieNode<V> remove(TrieNode<V> node, String key, int i){
    if(node == null) return null;
    if(i == key.length()){
      node.value = null;
    }else{
      char c = key.charAt(i);
      node.children[c] = remove(node.children[c], key, i+1);
    }
    if(node.value != null){
      return node;
    }
    for(int j = 0; j < 256; j++){
      if(node.children[j] != null) return node;
    }
    return null;
  }

  public V get(String key){
    TrieNode<V> p = getNode(root, key);
    if(p == null || p.value == null){
      return null;
    }
    return p.value;
  }

  private TrieNode<V> getNode(TrieNode<V> node, String key){
    TrieNode<V> p = node;
    for(int i = 0; i < key.length(); i++){
      if(p == null) return null;
      char c = key.charAt(i);
      p = p.children[c];
    }
    return p;
  }

  public boolean containsKey(String key){
    V value = get(key);
    return value != null;
  }

  public boolean hasKeyWithPrefix(String prefix){
    return getNode(root, prefix) != null;
  }

  public String shortestPrefixOf(String query){
    TrieNode p = root;
    for(int i = 0; i < query.length(); i++){
      if(p == null) return "";
      if(p.value != null) return query.substring(0,i);
      char c = query.charAt(i);
      p = p.children[c];
    }
    if(p != null && p.value != null) return query;
    return "";
  }

  public String longestPrefixOf(String query){
    TrieNode<V> p = root;
    int maxLen = 0;
    for(int i = 0; i < query.length(); i++){
      if(p == null){
        break;
      }
      if(p.value != null){
        maxLen = i;
      }
      char c = query.charAt(i);
      p = p.children[c];
    }

    if(p != null && p.value != null) return query;
    return query.substring(0,maxLen);

  }

  public List<String> keysWithPrefix(String prefix){
    List<String> result = new LinkedList<>();
    TrieNode p = getNode(root,prefix);
    if(p == null) return result;
    traverse(p, new StringBuilder(prefix), result);
    return result;
  }

  private void traverse(TrieNode<V> node, StringBuilder path, List<String> res){
    if(node == null) return;
    if(node.value != null) res.add(path.toString());
    for(char c = 0; c < 256; c++){
      path.append(c);
      traverse(node.children[c], path, res);
      path.deleteCharAt(path.length()-1);
    }
  }

  public List<String> keysWithPattern(String pattern){
    List<String> res = new LinkedList<>();
    traversePattern(root, new StringBuilder(), pattern,0,res);
    return res;
  }

  private void traversePattern(TrieNode<V> node, StringBuilder path, String pattern, int i, List<String> res){
    if(node  ==  null) return;
    if(i == pattern.length()){
      if(node.value != null){
        res.add(path.toString());
      }
      return;
    }
    char c = pattern.charAt(i);
    if(c == '.'){
      for(char k = 0; k < 256;k++){
        path.append(k);
        traversePattern(node.children[k],path, pattern, i+1,res);
        path.deleteCharAt(path.length()-1);
      }

    }else{
      path.append(c);
      traversePattern(node.children[c],path, pattern, i+1,res);
      path.deleteCharAt(path.length()-1);
    }
  }

  public boolean hasKeyWithPattern(String pattern){
     return hasKeyWithPattern(root,pattern,0);
  }

  private boolean hasKeyWithPattern(TrieNode<V> node, String pattern, int i){
    if(node == null) return false;
    if(i == pattern.length()){
      return node.value != null;
    }
    char c = pattern.charAt(i);
    if(c != '.'){
      return hasKeyWithPattern(node.children[c], pattern, i+1);
    }
    for(int j = 0; j < 256; j++){
      if(hasKeyWithPattern(node.children[j], pattern,i+1)){
        return true;
      }
    }
    return false;
  }

  public int size(){
    return size;
  }
  class TrieNode<V>{
    V value = null;
    TrieNode<V>[] children = new TrieNode[256];
  }

}


