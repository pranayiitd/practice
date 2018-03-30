import java.util.*;
/*
class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean isWord;
    boolean isPrefix;
    Character nodeChar;
    
    public TrieNode(Character c){
        nodeChar = c;
        children = new HashMap<>();
    }
    
     // Ideally I would implement even this inside the Trie class,
    // But just for example
    void insert(String word){
        if(word == null){
            return;
        }
        if(word.isEmpty()){
            isWord = true;
            return;
        }
        isPrefix = true;
        char c = word.charAt(0);
        TrieNode child = children.get(c);
        if(child == null){
            child = new TrieNode(c);
            children.put(c, child);
        }
        child.insert(word.substring(1));
    }
}

public class Trie {
    
    TrieNode root;
    
    public Trie() {
        Character c = new Character(' ');
        root = new TrieNode(c);
    }
    
    public void insert(String word) {
        root.insert(word);
    }
    
    // NOTE: we can also follow the style of BTreeNode.java
    public boolean search(String word) {
        return search(root, word, false);  
    }
    
    private boolean search(TrieNode root, String word, boolean isPrefixSearch){
        if(root == null || word == null){
            return false;
        }
        if(word.isEmpty()){
            return root.isWord || isPrefixSearch;
        }
        char c = word.charAt(0);
        TrieNode child = root.children.get(c);
        if(child == null){
            return false;
        }
        return search(child, word.substring(1), isPrefixSearch);
    }
    
    public boolean startsWith(String prefix) {
        return search(root, prefix, true);
    }
}

*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */