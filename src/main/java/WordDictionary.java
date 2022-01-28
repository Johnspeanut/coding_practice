class WordDictionary {

  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    wordDictionary.search("bad");
  }
  Trie trie;

  public WordDictionary() {
    trie = new Trie();

  }

  public void addWord(String word) {
    trie.put(word);

  }

  public boolean search(String word) {
    return trie.searchPattern(word);

  }

  class Trie{
    TrieNode root = null;
    public void Trie(){

    }

    public void put(String word){
      root = put(root, word, 0);
    }

    public TrieNode put(TrieNode node, String word, int i){
      if(node == null){
        return new TrieNode();
      }
      if(i == word.length()){
        node.isEnd = true;
        return node;
      }
      char c = word.charAt(i);
      node.children[c] = put(node.children[c], word, i+1);
      return node;
    }

    public boolean searchPattern(String word){
      return hasKeyWithPattern(root, word,0);

    }

    private boolean hasKeyWithPattern(TrieNode node, String pattern, int i){
      if(node == null) return false;
      if(i == pattern.length()){
        return node.isEnd;
      }
      char c = pattern.charAt(i);
      if(c != '.'){
        return hasKeyWithPattern(node.children[c], pattern, i+1);
      }else{
        for(int j = 0; j < 256; j++){
          if(hasKeyWithPattern(node.children[j], pattern,i+1)){
            return true;
          }
        }
      }
      return false;
    }

  }

  class TrieNode{
    boolean isEnd;
    TrieNode[] children = new TrieNode[256];
  }
}
