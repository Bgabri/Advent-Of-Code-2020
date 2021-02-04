// 2020 day 3: TobogganTrajectory

import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TobogganTrajectory {
	static List<String[]> inputList = new ArrayList<String[]>();
	public static void main(String[] args) {
		loadFile();

		int[] input = {};
		
		int[] current = {0,0};
		
		int total = 0;
		int counter = 0;
		boolean end = false;
		while (!end){	
			if(current[1] >= inputList.size()){
				end = true;
				break;
			}

			if(current[0] >= inputList.get(current[1]).length){
				current[0] = current[0] - inputList.get(current[1]).length;
			}

			String terrain = inputList.get(current[1])[current[0]];

			if(terrain.equals("#")){
				total++;
			}
			current[0] += 1; //change for part 1/2
			current[1] += 3; //change for part 1/2
		}

		System.out.println(total);
	}

	public static void loadFile() {
        File file = new File("TobogganTrajectory.txt");

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