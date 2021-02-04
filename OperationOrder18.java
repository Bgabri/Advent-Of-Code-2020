//Day 18: Operation Order
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class OperationOrder18 {
	static List<String> inputList = new ArrayList<String>();
	public static void main(String[] args) {
		loadFile();
		part1();
		part2();
	}
	
	public static void part1() {
		long total = 0;

		for (int i = 0; i < inputList.size(); i++){
			total += calculator(inputList.get(i));
		}

		System.out.println("solution for part 1: " + total);
	}

	public static long calculator(String calculation) {
		boolean valueFound = false;
		long accumulator = 0;
		for (int i = 0; i < calculation.length()-1; i+=2){
			int opperationIndex = i;
			String lowerValue = Character.toString(calculation.charAt(i+1));

			if(lowerValue.equals("(")){
				int numOfOpenBrackets = 0;
				int numOfCloseBrackets = 0;
				for (int j = i+1; j < calculation.length(); j++){
					if(calculation.charAt(j) == '(') {
					    numOfOpenBrackets++;
					} else if(calculation.charAt(j) == ')') {
						numOfCloseBrackets++;
					}
					if(numOfOpenBrackets == numOfCloseBrackets){
						lowerValue = Long.toString(calculator("+" + calculation.substring(i+2, j)));
						i = j-1;
						break;
					}
				}
			}
			if(calculation.charAt(opperationIndex) == '*'){
				accumulator *= Long.parseLong(lowerValue);
			} else if(calculation.charAt(opperationIndex) == '+'){
				accumulator += Long.parseLong(lowerValue);
			}
		}
		return accumulator;
	}

	public static void part2() {
		long total = 0;

		for (int i = 0; i < inputList.size(); i++){
			total += calculator(reformator(inputList.get(i)));
		}

		System.out.println("solution for part 2: " + total);
	}
	
	public static String reformator(String calculation) {
		boolean valueFound = false;
		for (int i = 1; i < calculation.length(); i++){
			if(calculation.charAt(i) == '+'){
				int numOfOpenBrackets = 0;
				int numOfCloseBrackets = 0;
				int upperIndex = i;
				int lowerIndex = i;
				for (int j = i-1; j > 0; j--){
					if(calculation.charAt(j) == '(') {
					    numOfOpenBrackets++;
					} else if(calculation.charAt(j) == ')') {
						numOfCloseBrackets++;
					}
					if(numOfCloseBrackets == numOfOpenBrackets){
						lowerIndex = j;
						break;
					}
				}
				for (int j = i+1; j < calculation.length(); j++){
					if(calculation.charAt(j) == '(') {
					    numOfOpenBrackets++;
					} else if(calculation.charAt(j) == ')') {
						numOfCloseBrackets++;
					}
					if(numOfCloseBrackets == numOfOpenBrackets){
						upperIndex = j;
						break;
					}
				}
				calculation = calculation.substring(0, upperIndex+1) + ")"+ calculation.substring(upperIndex+1, calculation.length());
				calculation = calculation.substring(0, lowerIndex) + "("+ calculation.substring(lowerIndex, calculation.length());
				i+=2;
			}
		}
		return calculation;
	}

	public static void loadFile() {
        File file = new File("OperationOrder18.txt");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String currentLine = scan.nextLine().replace(" ", "");
                inputList.add("+" + currentLine);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}








