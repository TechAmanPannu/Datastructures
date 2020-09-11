package com.company.algorithm.binaryTree;

import java.util.GregorianCalendar;

public class BinarySearchTree {
    private Node root;


    public void insert(int value){
       this.root =  addNode(this.root, value);
    }

    public Node addNode(Node root, int value){

        if(root == null)
            root = new Node(value);
        else if( value <= root.getValue())
            root.setLeft(addNode(root.getLeft(), value));
        else root.setRight(addNode(root.getRight(), value));

    return root;
    }

    public int getNodesCount(){
        int count = 0;
        count = count(this.root, count);
        return count;
    }

    public int count(Node root, int count){

        if(root == null)
            return count;

        count = count(root.getLeft(), count);
        count = count(root.getRight(), count);
        count++;
         return count;
    }

    public boolean search(int value){

        boolean isFound = false;
        isFound = search(this.root, value, isFound);
        return isFound;
    }

    public boolean search(Node root, int value, boolean isFound){

        if(root == null)
            return isFound;

        if(root.getValue() == value)
            return true;

        if(value <= root.getValue()){
            isFound = search(root.getLeft(), value, isFound);
        }else isFound = search(root.getRight(), value, isFound);

        return isFound;
    }


    public Node delete(int value){

        boolean isFound = search(value);
        if(!isFound){
            System.out.println("Node "+value+" is not available to delete");
            return null;
        }


        root =  delete(root, value);

        return root;
    }

    //todo deletion binary node as to be done
    public Node delete(Node root, int value){


        if(root == null)
            return null;

        // Three cases to delete a tree
        // 1. Deleted node is leaf(no children) : 0 child
        // 2. Deleted node has only 1 child : 1 child
        // 3. Deleted node has 2 children : 2 child

        if(root.getValue() == value){

            ///if there is only one or no child
            if(root.getLeft() == null) {
                return root.getRight();
            }else if(root.getRight() == null)
                return root.getLeft();
            else {

                // in case of two children
                root.setValue(minValue(root.getRight()));
                root.setRight(delete(root.getRight(), root.getValue()));
            }

        }else if(value < root.getValue()){
            root.setLeft(delete(root.getLeft(), value));
        }else if( value > root.getValue()){
            root.setRight(delete(root.getRight(), value));
        }
        return root;
    }

    private int minValue(Node root) {

        int minValue = root.getValue();

        while(root.getLeft() != null) {
            minValue = root.getLeft().getValue();
            root = root.getLeft();
        }
        return minValue;
    }

    // todo has to check
    public int countLeftMostNodes(){

        int count = 0;
                count = countLeftMostNodes(this.root, count);
                return count;
    }

    public int countLeftMostNodes(Node node, int count){

        if(node == null)
            return count;

        count = countLeftMostNodes(node.getLeft(), count);
        count ++;
        return count;
    }


    public void inOrderTraversal(){
        inOrder(this.root);

    }

    private void inOrder(Node root) {

        if(root == null)
            return;

        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());

    }

    public void preOrderTraversal(){

        preOrder(this.root);

    }

    private void preOrder(Node root) {

        if(root == null)
            return;

        System.out.print(root.getValue()  + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());

    }

    public void postOrderTraversal(){

        postOrder(this.root);

    }

    private void postOrder(Node root) {

        if(root == null)
            return;

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue()  + " ");

    }

    public int height(){
        int height = 0;
        height = height(this.root, height);
        return height;
    }

    public int height(Node root, int height){

        if(root == null)
            return height;

        int lheight = height(root.getLeft(), height);
        int rheight = height(root.getRight(), height);

        if (lheight > rheight)
            return(lheight+1);
        else return(rheight+1);

    }

    public void leverOrderTraversal(){
        int height = 0;
        height = height(this.root, height );

        for(int i = 1 ; i <= height ; i++) {
            leverOrder(this.root, i);
        }


    }

    private void leverOrder(Node root, int level) {

        if(root == null)
            return;

        if(level == 1){
            System.out.print(root.getValue()  + " ");
        }


        if(level > 1){
            leverOrder(root.getLeft(), level - 1);
            leverOrder(root.getRight(), level - 1);
        }



    }


    public boolean isBst() {

        boolean isBst = false;

        return  isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBst(Node root, int min, int max) {

        if(root == null )
            return true;

        if(root.getValue() < min || root.getValue() > max)
            return false;

        return isBst(root.getLeft(), min, root.getValue()) &&
                isBst(root.getRight(), root.getValue(), max);

    }

    public void leftView(){
        showLeftView(root);
    }

    private void showLeftView(Node root) {

        if(root == null)
            return;

        showLeftView(root.getLeft());
        System.out.print(root.getValue() + " ");
    }
}

class Node{
    private Node left;
    private int value;
    private Node right;

    public Node(int value){
        this.value = value;
    }

    public Node getLeft(){
        return this.left;
    }
    public Node getRight(){
        return this.right;
    }
    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }
    public void setLeft(Node left){
        this.left = left;
    }
    public void setRight(Node right){
        this.right = right;
    }
}

class Driver{

    public static void main(String[] arg){


        BinarySearchTree bst =  new BinarySearchTree();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);
        bst.insert(20);

        System.out.println("in order traversal");
        bst.inOrderTraversal();
        System.out.println("===========");

        System.out.println("preorder traversal");
        bst.preOrderTraversal();
        System.out.println("==============");

        System.out.println("postorder traversal");
        bst.postOrderTraversal();
        System.out.println("==============");

        System.out.println("level order traversal");
        bst.leverOrderTraversal();
        System.out.println("==============");

        System.out.println("count : "+bst.getNodesCount());

        System.out.println("node isFound : "+bst.search(8));

        System.out.println("count left most nodes : "+bst.countLeftMostNodes()); // todo to find properly

        System.out.println("height : "+bst.height());

        System.out.println("delete node "+bst.delete(1));

        System.out.println("traversing to check whether node got deleted : ");

        bst.inOrderTraversal();
        System.out.println("========================================");

        System.out.println("isBst : "+bst.isBst());
        bst.leftView();

    }
}
