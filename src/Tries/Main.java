package Tries;

public class Main {
    public static void main(String[] args) {
        TrieNode root=new TrieNode('i');
        root.insertWord(root,"coding");
        System.out.println("Search coding --" +root.searchWord(root,"coding"));
        System.out.println("Search code --" +root.searchWord(root,"code"));
    }
}
