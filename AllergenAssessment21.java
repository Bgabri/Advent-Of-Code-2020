//2020 Day 21: Allergen Assessment


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
	static List<String[]> inputList = new ArrayList<String[]>();
	public static void main(String[] args) {
		loadFile();
		part1();
		part2();
	}
	
	public static void part1() {
		int total = 0;

		for (int i = 0; i < inputList.size(); i++){
			
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
        File file = new File("Input.txt");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String[] currentLine = scan.nextLine().split(" ");
                inputList.add(currentLine);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}