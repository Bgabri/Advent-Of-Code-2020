//2020 day 11: Seating System

import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;

class SeatingSystem {
	static List<String[]> inputList = new ArrayList<String[]>();
	public static void main(String[] args) {
		loadFile();

		int[] input = {};
		int total = 0;

		boolean unstable = true;
		int temp = 0;
		while (unstable){
			unstable = false;
			List<String[]> tempSeating = new ArrayList<String[]>();
			for (int i = 0; i < inputList.size(); i++){
				tempSeating.add(inputList.get(i).clone());
			}

			for (int i = 0; i < inputList.size(); i++){
				for (int j = 0; j < inputList.get(i).length; j++){
					if(!inputList.get(i)[j].equals(".")){
						int numOfAdjacent = 0;
						for (int y = -1; y <= 1; y++){
							for (int x = -1; x <= 1; x++){
								int xLook = 0;
								int yLook = 0;
								while(true && y!=0 || x!=0){
									xLook += x;
									yLook += y;
									if(i+yLook < 0 || i+yLook >= inputList.size() ||
								       j+xLook < 0 || j+xLook >= inputList.get(i).length
								       ||inputList.get(i+yLook)[j+xLook].equals("L")){
										break;
									}
									if(inputList.get(i+yLook)[j+xLook].equals("#")){
										numOfAdjacent++;
										break;
									}
								}
							}
						}
						if(numOfAdjacent == 0){
							if(tempSeating.get(i)[j].equals("L")){
								unstable = true;
							}
							tempSeating.get(i)[j] = "#";
						}

						if(numOfAdjacent >= 5){
							if(tempSeating.get(i)[j].equals("#")){
								unstable = true;
							}
							tempSeating.get(i)[j] = "L";
						}
					}
				}
			}
			inputList = tempSeating;
		}

		for (int i = 0; i < inputList.size(); i++){
			for (int j = 0; j < inputList.get(i).length; j++){
				if(inputList.get(i)[j].equals("#")){
					total++;
				}
			}
		}
		System.out.println();
		System.out.println(total);
	}

	public static void loadFile() {
        File file = new File("SeatingSystem.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String[] currentLine = scan.nextLine().split("");
                inputList.add(currentLine);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}








/*
//2020 day 11: Seating System part 1

import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;

class SeatingSystem {
	static List<String[]> inputList = new ArrayList<String[]>();
	public static void main(String[] args) {
		loadFile();

		int[] input = {};
		int total = 0;

		boolean unstable = true;

		while (unstable){
			unstable = false;
			List<String[]> tempSeating = new ArrayList<String[]>();
			for (int i = 0; i < inputList.size(); i++){
				tempSeating.add(inputList.get(i).clone());
			}

			for (int i = 0; i < inputList.size(); i++){
				for (int j = 0; j < inputList.get(i).length; j++){
					if(!inputList.get(i)[j].equals(".")){
						int numOfAdjacent = 0;
						for (int y = -1; y <= 1; y++){
							for (int x = -1; x <= 1; x++){
								if(i+y >= 0 && i+y < inputList.size() && 
									j+x >= 0 && j+x < inputList.get(i).length &&
									(y!=0 || x!=0) && inputList.get(i+y)[j+x].equals("#")){
									numOfAdjacent++;
								}
							}
						}
						if(numOfAdjacent == 0){
							if(tempSeating.get(i)[j].equals("L")){
								unstable = true;
							}
							tempSeating.get(i)[j] = "#";
						}

						if(numOfAdjacent >= 4){
							if(tempSeating.get(i)[j].equals("#")){
								unstable = true;
							}
							tempSeating.get(i)[j] = "L";
						}
					}
				}
			}
			inputList = tempSeating;
		}

		for (int i = 0; i < inputList.size(); i++){
			for (int j = 0; j < inputList.get(i).length; j++){
				if(inputList.get(i)[j].equals("#")){
					total++;
				}
			}
		}
		System.out.println(total);
	}

	public static void loadFile() {
        File file = new File("SeatingSystem.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String[] currentLine = scan.nextLine().split("");
                inputList.add(currentLine);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}*/