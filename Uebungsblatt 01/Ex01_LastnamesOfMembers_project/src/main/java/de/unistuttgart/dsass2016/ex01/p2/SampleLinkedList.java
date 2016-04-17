package de.unistuttgart.dsass2016.ex01.p2;

public class SampleLinkedList {
	//This code is TEST ONLY
	//TODO: implement SpeedList in speedlist.java
	class Link {
	    public int data1;
	    public double data2;
	    public Link nextLink;

	    //Link constructor
	    public Link(int d1, double d2) {
		    data1 = d1;
		    data2 = d2;
	    }

	    //Print Link data
	    public void printLink() {
		    System.out.print("{" + data1 + ", " + data2 + "} ");
	    }
	}

	class LinkList {
	    private Link first;

	    //LinkList constructor
	    public LinkList() {
		    first = null;
	    }

	    //Returns true if list is empty
	    public boolean isEmpty() {
		    return first == null;
	    }

	    //Inserts a new Link at the first of the list
	    public void insert(int d1, double d2) {
		    Link link = new Link(d1, d2);
		    link.nextLink = first;
		    first = link;
	    }

	    //Deletes the link at the first of the list
	    public Link delete() {
		    Link temp = first;
		    first = first.nextLink;
		    return temp;
	    }

	    //Prints list data
	    public void printList() {
		    Link currentLink = first;
		    System.out.print("List: ");
		    while(currentLink != null) {
			    currentLink.printLink();
			    currentLink = currentLink.nextLink;
		    }
		    System.out.println("");
	    }
	}  
	
}
