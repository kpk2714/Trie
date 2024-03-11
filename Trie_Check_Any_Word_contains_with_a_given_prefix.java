import java.util.*;

 class Main
{
    static Node root = new Node();
    static class Node{
        Node[] children;
        boolean eow;

        public Node(){
            children = new Node[26];
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            eow = false;
        }


    }

    public static void Insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            int index = (word.charAt(i)-'a');
            if(node.children[index]==null){
                node.children[index] = new Node();
            }
            if(i==word.length()-1) {
                node.children[index].eow = true;
            }
            node = node.children[index];
        }
    }

    public static boolean Search(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            int index = (word.charAt(i)-'a');
            if(node.children[index]==null){
                return false;
            }
            if(i==word.length()-1 && node.children[index].eow==false){
                return false;
            }

            node = node.children[index];
        }
        return true;
    }
    
    
    public static void displayTrie(Node node,String str){
    
    	if(node==null)
        	return;
            
        if(node.eow==true)
        	System.out.println(str);
        
        for(char ch='a';ch<='z';ch++){
        	if(node.children[ch-'a']!=null){
                displayTrie(node.children[ch-'a'],str+ch);
			}
        }
        
    }
    
    public static void display(){
    	displayTrie(root,"");
    }
    
    public static boolean startsWith(String prefix){
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i)-'a';
            if(node.children[index]==null)
            {
                return false;
            }
            
            node = node.children[index];
        }
        return true;
    }


    public static void main(String[] args) {
        String[] words = {"apple","app","mango","man","woman"};

        for(int i=0;i<words.length;i++){
            Insert(words[i]);
        }
        
        String prefix = "man";

        System.out.println("Any word is present or not with that prefix = "+startsWith(prefix));
        
    }
}
