class TrieNode{
    char data;
    TrieNode[] next;
    boolean isTerminal;

    TrieNode(char data){
        this.data = data;
        this.next = new TrieNode[26];
        this.isTerminal = false;
    }

    TrieNode(char data, boolean isTerminal){
        this.data = data;
        this.next = new TrieNode[26];
        this.isTerminal = isTerminal;
    }
}
class PrefixTree {
    TrieNode root;

    public PrefixTree() {
         root = new TrieNode('a');
    }

    public void insertHelper(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminal = true;
            return;
        }

        int ch = word.charAt(0) - 'a';

        if(root.next[ch] == null){
            // Not Present
            TrieNode newNode = new TrieNode((char)ch);
            root.next[ch] = newNode;
        } 

        insertHelper(root.next[ch], word.substring(1));
    }

    public void insert(String word) {
        insertHelper(root, word);
    }

    public boolean searchHelper(TrieNode root, String word){
        if(word.length() == 0){
            return root.isTerminal;
        }

        int ch = word.charAt(0) - 'a';

        if(root.next[ch] == null){
            return false;
        } 

        return searchHelper(root.next[ch], word.substring(1));
    }

    public boolean search(String word) {
        return searchHelper(root, word);
    }

    public boolean startsWithHelper(TrieNode root, String word){
        if(word.length() == 0){
            return true;
        }

        int ch = word.charAt(0) - 'a';

        if(root.next[ch] == null){
            return false;
        } 

        return startsWithHelper(root.next[ch], word.substring(1));
    }

    public boolean startsWith(String prefix) {
        return startsWithHelper(root, prefix);
    }
}
