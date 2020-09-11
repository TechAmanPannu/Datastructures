package com.company.algorithm.linkedList;

import java.util.HashMap;
import java.util.Map;

class Node{
    int data;
    Node next;
    Node random;

    Node(int data){
        this.data = data;
    }

}
class SinglyLinkedList {
    Node head;//Linked list head reference

    // Linked list constructor
    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    // push method to put data always at the head
    // in the linked list.
    public void push(int data) {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }

    public SinglyLinkedList cloneList(){

        Map<Node, Node> map = new HashMap<>();

        Node tail = this.head;

        while(tail != null){

            map.put(tail, new Node(tail.data)); // actual with cloned node
            tail = tail.next;
        }

        tail = this.head;
        while (tail != null){

            Node clonedNode = map.get(tail);
            clonedNode.next = map.get(tail.next);
            clonedNode.random = tail.random;

            tail = tail.next;
        }

        return new SinglyLinkedList(map.get(this.head));

    }
}


    public class CloneSinglyLinkedWithRandomPointers {

    public static void main(String arg[]){
        // Pushing data in the linked list.
        SinglyLinkedList list = new SinglyLinkedList(new Node(5)); /// pushing reverse
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random =
                list.head.next.next.next;
        list.head.next.next.random =
                list.head.next.next.next.next;
        list.head.next.next.next.random =
                list.head.next.next.next.next.next;
        list.head.next.next.next.next.random =
                list.head.next;

        list.cloneList();

    }


}
;

