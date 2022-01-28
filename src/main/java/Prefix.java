
class Prefix {

  public static void main(String[] args) {
    Prefix prefix = new Prefix();
    prefix.insert("n");
    prefix.insert("n");
    prefix.insert("jvo");
    prefix.erase("n");
    prefix.countWordsStartingWith("n");
  }
  TrieNode root;

  public Prefix() {
    root = null;

  }

  public void insert(String word) {
    root = insert(root, word,0);

  }
  private TrieNode insert(TrieNode node, String word, int i){
    if(node == null){
      node = new TrieNode();
    }
    if(i == word.length()){
      node.countChar++;
      node.countEnd ++;
      return node;
    }
    char c = word.charAt(i);
    node.countChar++;
    node.children[c] = insert(node.children[c], word, i+1);
    return node;
  }

  public int countWordsEqualTo(String word) {
    TrieNode p = root;
    for(int i = 0; i < word.length(); i++){
      if(p == null) return 0;
      char c = word.charAt(i);
      p = p.children[c];
    }
    return p.countEnd;

  }

  public int countWordsStartingWith(String prefix) {
    TrieNode p = root;
    for(int i = 0; i < prefix.length(); i++){
      if(p == null) return 0;
      char c = prefix.charAt(i);
      p = p.children[c];
    }
    return p.countChar;

  }

  public void erase(String word) {
    root = remove(root,word,0);
  }

  private TrieNode remove(TrieNode node, String key, int i){
    if(node == null) return null;
    if(i == key.length()){
      node.countEnd--;
      node.countChar--;
    }else{
      char c = key.charAt(i);
      node.countChar--;
      node.children[c] = remove(node.children[c], key, i+1);
    }
    if(node.countEnd > 0){
      return node;
    }
    for(int j = 0; j < 256; j++){
      if(node.children[j] != null) return node;
    }
    return null;
  }

  class TrieNode{
    int countEnd = 0;
    int countChar = 0;
    TrieNode[] children = new TrieNode[256];
  }
}