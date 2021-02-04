//Day 20: Jurassic Jigsaw

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class JurassicJigsaw20 {
	static List<String[]> inputList = new ArrayList<String[]>();
	public static void main(String[] args) {
		loadFile();
		part1();
		part2();
	}
	
	public static void part1() {
		int total = 0;

		for (int i = 0; i < inputList.size(); i++){
			for (int j = 0; j < inputList.size(); j++){
				for (int k = 0; k < inputList.get(i).length; k++){
					for (int l = 0; l < inputList.get(j).length; l++){
					}
				}
			}
		}

		System.out.println("solution for part 1: ");
	}

	public static void part2() {
		int total = 0;

		for (int i = 0; i < inputList.size(); i++){
			
		}
		System.out.println("solution for part 2: ");
	}

	public static void loadFile() {
        File file = new File("JurassicJigsaw20.txt");

        try {
            Scanner scan = new Scanner(file);
            String edgeT = "";
            String edgeB = "";
            String edgeL = "";
            String edgeR = "";

            String id = "";
            int index = 0;
            while (scan.hasNext()) {
            	String currentLine = scan.nextLine();
            	if(currentLine.equals("")){
            		inputList.add(new String[]{edgeT, edgeR, edgeB, edgeL});

            		edgeT = "";
					edgeB = "";
					edgeL = "";
					edgeR = "";
            		index = 0;
            	} else if(!currentLine.startsWith("Tile")){
            		if(index == 0){
            			edgeT = currentLine;
            		} else if(index == 9){
            			edgeB = currentLine;
            		}
            		edgeL += currentLine.charAt(index);
            		edgeR += currentLine.charAt(index);
		        	index++;
            	} else id = currentLine.substring(5,9);
            }

            inputList.add(new String[]{edgeT, edgeR, edgeB, edgeL});
			edgeT = "";
			edgeB = "";
			edgeL = "";
			edgeR = "";
			index = 0;
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}