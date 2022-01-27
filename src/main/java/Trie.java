class Trie {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    trie.search("apple");
  }
  TrieNode root = null;
  int size = 0;

  public Trie() {

  }

  public void insert(String word) {
    if(!search(word)){
      size++;
    }
    root = put(root, word,0);

  }
  private TrieNode put(TrieNode node, String key, int i){
    if(node == null){
      node = new TrieNode();
    }
    if(i == key.length()){
      node.isEnd = true;
      return node;
    }
    char c = key.charAt(i);
    node.children[c] = put(node.children[c], key, i+1);
    return node;
  }

  public boolean search(String word) {
    TrieNode p = getNode(root, word);
    if(p == null || !p.isEnd){
      return false;
    }
    return true;

  }

  public TrieNode getNode(TrieNode node, String key){
    TrieNode p = node;
    for(int i = 0; i < key.length(); i++){
      if(p == null) return null;
      char c = key.charAt(i);
      p = p.children[c];
    }
    return p;
  }

  public boolean startsWith(String prefix) {
    TrieNode p = root;
    for(int i = 0; i < prefix.length(); i++){
      if(p == null) return false;
      char c = prefix.charAt(i);
      p = p.children[c];
    }
    return p != null;

  }
}

class TrieNode{
  boolean isEnd;
  TrieNode[] children = new TrieNode[256];
}