//2020 day 15: Rambunctious Recitation

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class RambunctiousRecitation15 {
	static List<Integer> spokenNumbers = new ArrayList<Integer>();

	public static void main(String[] args) {
		loadFile();
		System.out.println("solution for part 1: " + part1(2020));
		System.out.println("solution for part 2: " + part1(3000000));

	}

	public static int part1(int lastNumberIndex) {
		int total = 0;

		int[] spokenList = new int[lastNumberIndex];
		int startSize = spokenNumbers.size();

		for(int i = 0; i < startSize - 1; i++){
			spokenList[i] = spokenNumbers.get(i);
		}

		int currentSpoken = 0;
		int lastSpoken = spokenNumbers.get(startSize - 1);

		for(int i = startSize - 1; i < lastNumberIndex; i++){

			currentSpoken = -1;
			long startTimestamp = System.currentTimeMillis();
			int lastIndexOfLast = lastIndexOf(spokenList, lastSpoken, i-1);
			long endTimestamp = System.currentTimeMillis();
			if(lastIndexOfLast == -1){
				currentSpoken = 0;
				// System.out.println(endTimestamp - startTimestamp + " ms");
			} else {
				currentSpoken = i - lastIndexOfLast;
			}

			if(i%300000 == 0){
				System.out.println(i);
			}

			spokenList[i] = lastSpoken;
			lastSpoken = currentSpoken;

		}
		
		return spokenList[lastNumberIndex - 1];
	}

	public static int indexOf(int list[], int value) {
		int index = -1;
		for(int i = 0; i < list.length; i++){
			if(list[i] == value){
				index = i;
				break;
			}
		}
		return index;
	}

	public static int lastIndexOf(int list[], int value, int upperbound) {
		int index = -1;
		for(int i = upperbound; i >= 0; i--){
			if(list[i] == value){
				index = i;
				break;
			}
		}
		return index;		
	}

	public static void loadFile() {
        File file = new File("RambunctiousRecitation15.txt");

        try {
            Scanner scan = new Scanner(file);
                String[] currentLine = scan.nextLine().split(",");
                for(int i  = 0; i < currentLine.length; i++){
                	spokenNumbers.add(Integer.parseInt(currentLine[i]));
                }

        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}