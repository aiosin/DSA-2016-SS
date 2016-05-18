package de.unistuttgart.dsass2016.ex05.p2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import de.unistuttgart.dsass2016.ex05.p2.Rect;

public class Main {


	@SuppressWarnings("unused")
	public static void main(String[] args) {

		ArrayList<Rect> rectList = new ArrayList<Rect>();
		
		rectList.add(new Rect(0,0,4,4));
		rectList.add(new Rect(3,4,3,2));
		rectList.add(new Rect(4,0,16,1));
		rectList.add(new Rect(19,0,1,20));
		rectList.add(new Rect(0,19,20,1));
		rectList.add(new Rect(0,4,1,16));
		rectList.add(new Rect(15,15,5,5));
		
		CollisionMap map = new CollisionMap(rectList);
		
		System.out.println("Done");
	
	}


}