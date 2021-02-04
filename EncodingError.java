//2020 Day 9: Encoding Error

import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class EncodingError {
	static List<String> inputList = new ArrayList<String>();
	public static void main(String[] args) {
		loadFile();

		long total = 0;
		List<String> otherList = new ArrayList<String>();
		int length  = 25;
		long solution1 = -1;
		for (int i = 0; i < length; i++){
			otherList.add(inputList.get(i));
		}

		for (int j = length; j< inputList.size(); j++){
			boolean test = false;
			for (int k = 0; k < otherList.size(); k++){
				for (int l = k + 1; l < otherList.size(); l++){
					if (Long.parseLong(otherList.get(k)) + Long.parseLong(otherList.get(l)) == Long.parseLong(inputList.get(j))){
						test = true;
						break;
					}
				}
			}

			otherList.add(inputList.get(j));
			otherList.remove(0);
			if(!test){	
				solution1 = Long.parseLong(inputList.get(j));
				System.out.println("solution for part 1: " + inputList.get(j));
				break;
			}
		}

		for (int i = 0; i < inputList.size(); i++){
			long sum = 0;
			long biggestOfSum = 0;
			long smallestOfSum = Long.MAX_VALUE;

			for (int j = i; j < inputList.size(); j++){
				sum += Long.parseLong(inputList.get(j));
				if(sum == solution1){
					System.out.println("solution for part 2: " + (biggestOfSum + smallestOfSum));
					break;
				} else if(sum > solution1){
					break;
				}
				if(Long.parseLong(inputList.get(j)) > biggestOfSum){
					biggestOfSum = Long.parseLong(inputList.get(j));
				}
				if (Long.parseLong(inputList.get(j)) < smallestOfSum){
					smallestOfSum = Long.parseLong(inputList.get(j));
				}
			}
			if(sum == solution1){
					break;
			}
		}
	}

	public static void loadFile() {
        File file = new File("EncodingError.txt");

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
} // 3145218865846 to big