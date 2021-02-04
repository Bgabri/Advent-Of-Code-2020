//2020 Day 6:

import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Day6 {
	static List<String> inputList = new ArrayList<String>();
	public static void main(String[] args) {
		loadFile();

		int[] input1 = {};
		int total1 = 0;
		List<String> ansList1 = new ArrayList<String>();
		for (int j = 0; j< inputList.size(); j++){
			if(!inputList.get(j).equals("")){
				String[] s1 = inputList.get(j).split("");
				for (int i = 0; i < s1.length; i++){
					if (!ansList1.contains(s1[i])){
						ansList1.add(s1[i]);
					}
				}
			} else if(inputList.get(j).equals("")){
				total1 += ansList1.size();
				ansList1 = new ArrayList<String>();
			}
		}
		total1 += ansList1.size();
		System.out.println("solution for part 1: " + total1);



		int[] input = {};
		int total = 0;
		List<String> ansList = new ArrayList<String>();
		int borders = 0;

		for (int j = 0; j< inputList.size(); j++){
			if(!inputList.get(j).equals("")){
				String[] s = inputList.get(j).split("");
				for (int i = 0; i < s.length; i++){
					ansList.add(s[i]);
				}
				borders++;
			} else if(inputList.get(j).equals("")){
				List<String> newList = new ArrayList<String>();
				for (int k = 0; k < ansList.size(); k++){
					int numAA = 0;
					if(!newList.contains(ansList.get(k))){
						for (int l = 0; l < ansList.size(); l++){
							if (ansList.get(k).equals(ansList.get(l))){
								numAA++;
							}
						}
						if (borders == numAA){
							total++;
						}
					}
						newList.add(ansList.get(k));
				}
				borders = 0;
				ansList = new ArrayList<String>();
			}
		}
		List<String> newList = new ArrayList<String>();
		for (int k = 0; k < ansList.size(); k++){
			int numAA = 0;
			if(!newList.contains(ansList.get(k))){
				for (int l = 0; l < ansList.size(); l++){
					if (ansList.get(k).equals(ansList.get(l))){
						numAA++;
					}
				}
				if (borders == numAA){
					total++;
				}
			}
			newList.add(ansList.get(k));
		}
		System.out.println("solution for part 2: " + total);
	}

	public static void loadFile() {
        File file = new File("Day6.txt");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String currentLine = scan.nextLine();
                inputList.add(currentLine);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}