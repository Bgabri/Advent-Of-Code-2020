// 2020 Day 1: Report Repair
import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ReportRepair {
    static int[] inputArray = new int[200];
    public static void main(String[] args) {
        loadFile();

    	//part 1

        for (int i = 0; i < inputArray.length; i++){
        	for (int j = i + 1; j < inputArray.length; j++){
        		if(inputArray[i]+inputArray[j] == 2020){
        			System.out.println("part 1 solution: " + inputArray[i] * inputArray[j]);
        		}
        	}
        }

        //part 2
        for (int i = 0+1; i < inputArray.length; i++){
        	for (int j = i+1; j < inputArray.length; j++){
        		for (int k = j+1; k < inputArray.length; k++){
        			if(inputArray[i] + inputArray[j] + inputArray[k] == 2020){
        				System.out.println("part 2 solution: " + inputArray[i] * inputArray[j] * inputArray[k]);
        			}
        		}
        	}
        }
    }

    public static void loadFile() {
        File file = new File("ReportRepair.txt");

        try {
            Scanner scan = new Scanner(file);
            int counter = 0;
            while (scan.hasNext()) {
                int currentLine = Integer.parseInt(scan.nextLine());
                inputArray[counter] = currentLine;
                counter++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}