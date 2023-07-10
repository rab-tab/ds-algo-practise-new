package Tries;

public class TrieNode {
    char data;
    TrieNode[] children = new TrieNode[26];
    boolean isTerminal;

    public TrieNode(char data) {
        this.data = data;
        isTerminal = false;
    }

    void insertWord(TrieNode root, String word) {
        System.out.println("Inserting "+word);
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }
        char ch = word.charAt(0);
        int index = ch - 'a';
        TrieNode child;
        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            child = new TrieNode(ch);
            root.children[index] = child;
        }
        insertWord(child, word.substring(1));
    }

}
