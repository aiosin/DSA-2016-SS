package de.unistuttgart.dsass2016.ex01.p2;

public class SampleLinkedList {
	//This code is TEST ONLY
	//TODO: implement SpeedList in speedlist.java
	class Node <E> {
		
	    public int data1;
	    public double data2;
	    @SuppressWarnings("unused")
		private E e;
	    public Node<E> nextLink;

	    //Node constructor
	    public Node(int d1, double d2) {
		    data1 = d1;
		    data2 = d2;
	    }

	    //Print Link data
	    public void printLink() {
		    System.out.print("{" + data1 + ", " + data2 + "} ");
	    }
	}

	class LinkList {
		
		//setting up the head
	    @SuppressWarnings("rawtypes")
		private Node head;

	    //LinkList constructor
	    public LinkList() {
		    head = null;
	    }

	    //Returns true if list is empty
	    public boolean isEmpty() {
		    return head == null;
	    }

	    //Inserts a new Link at the first of the list
	    @SuppressWarnings("unchecked")
		public void insert(int d1, double d2) {
		    @SuppressWarnings("rawtypes")
			Node link = new Node(d1, d2);
		    link.nextLink = head;
		    head = link;
	    }

	    //Deletes the link at the first of the list
	    @SuppressWarnings("rawtypes")
		public Node delete() {
		    Node temp = head;
		    head = head.nextLink;
		    return temp;
	    }

	    //Prints list data
	    @SuppressWarnings("rawtypes")
		public void printList() {
		    Node currentLink = head;
		    System.out.print("List: ");
		    while(currentLink != null) {
			    currentLink.printLink();
			    currentLink = currentLink.nextLink;
		    }
		    System.out.println("");
	    }
	}  
	
}
