package com.company.algorithm.trie;

import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Trie {
    public TrieNode root;
    public Trie(){
      root =  new TrieNode();
    }

     void insert(String key)
    {
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (int i = 0; i < length; i++)
        {
            index = key.charAt(i) - 'a' ;
            if (pCrawl.children.get(index) == null)
                pCrawl.children.set(index, new TrieNode());

            pCrawl = pCrawl.children.get(index);
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
        System.out.println(pCrawl.children);
    }

    public boolean isAvailable(String query) {

        if(query == null || query.equals("")){
            return false;
        }

        TrieNode current = this.root;

        for(int i = 0 ; i < query.length(); i++){

           int index =  query.charAt(i) - 'a';
           if(current.children.get(index) ==  null)
               return false;

           current = current.children.get(index);
        }

        System.out.println(current.isEndOfWord);
        return current != null && current.isEndOfWord;
    }

    public Set<String> search (String query){

        if(query == null || query.equals("")){
            return new HashSet<>();
        }

        TrieNode current = this.root;

        boolean isFound = false;
        for(int i = 0 ; i < query.length(); i++){

            int index =  query.charAt(i) - 'a';
            if(current.children.get(index) ==  null){
                break;
            }

            current = current.children.get(index);
        }



return null;
    }
}

class TrieNode {
    public final static int ALPHABET_SIZE = 26;
    List<TrieNode> children = Arrays.asList(new TrieNode[ALPHABET_SIZE]);
    boolean isEndOfWord = true;

}

class Driver{
    public static void main(String arg[]){

        Trie trie = new Trie();
        trie.insert("aman");
//        trie.insert("amandeep");
//        trie.insert("the");
//        trie.insert("print");
       // System.out.println(trie.root.children);

        System.out.println(trie.isAvailable("ama"));

    }
}