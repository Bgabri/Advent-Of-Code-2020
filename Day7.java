//2020 day 7: 

import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Day7 {
	static List<String[]> inputList = new ArrayList<String[]>();
	public static void main(String[] args) {
		loadFile();

		
		int total = 0;

		for (int j = 0; j< inputList.size(); j++){	
			for (int i = 1; i < inputList.get(j).length; i++){
				for (int k = 0; k < inputList.size(); k ++){
						
				}
			}
		
		}
		System.out.println();
	}

	public static void loadFile() {
        File file = new File("Day7.txt");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String currentLine = scan.nextLine().replaceAll("( bags contain [0-9] )|(( bag)s?((, [0-9] )|.))", "TEMP");
                inputList.add(currentLine.split("TEMP"));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}