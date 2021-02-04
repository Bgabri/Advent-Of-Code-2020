//2020 day 12: Rain Risk

import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class RainRisk {
	static List<String> inputList = new ArrayList<String>();
	public static void main(String[] args) {
		loadFile();

		int total = 0;
		
		int ferryXPos = 0;
		int ferryYPos = 0;
		int wayPointXPos = 1;
		int wayPointYPos = 10;
		// String[] directions = {"N", "E", "S", "W"};

		int directionPointer = 1;

		for (int j = 0; j < inputList.size(); j++){

			if (inputList.get(j).substring(0,1).equals("F")){
				ferryXPos += wayPointXPos * Integer.parseInt(inputList.get(j).substring(1));
				ferryYPos += wayPointYPos * Integer.parseInt(inputList.get(j).substring(1));
			} else if(inputList.get(j).substring(0,1).equals("N")){
				wayPointXPos += Integer.parseInt(inputList.get(j).substring(1));
			} else if(inputList.get(j).substring(0,1).equals("E")){
				wayPointYPos += Integer.parseInt(inputList.get(j).substring(1));
			} else if(inputList.get(j).substring(0,1).equals("S")){
				wayPointXPos -= Integer.parseInt(inputList.get(j).substring(1));
			} else if(inputList.get(j).substring(0,1).equals("W")){
				wayPointYPos -= Integer.parseInt(inputList.get(j).substring(1));
			} else if(inputList.get(j).substring(0,1).equals("R")){
				int degrees = Integer.parseInt(inputList.get(j).substring(1))/90;
					if(degrees == 1){
						int distanceX = - (ferryYPos - wayPointYPos);
						int distanceY = (ferryXPos - wayPointXPos);
						wayPointXPos = ferryXPos + distanceX;
						wayPointYPos = ferryYPos + distanceY;
					} else if(degrees == 2){
						int distanceX = - (ferryXPos - wayPointXPos);
						int distanceY = - (ferryYPos - wayPointYPos);
						wayPointXPos = ferryXPos + distanceX;
						wayPointYPos = ferryYPos + distanceY;
					} else if(degrees == 3){
						int distanceX = (ferryYPos - wayPointYPos);
						int distanceY = - (ferryXPos - wayPointXPos);
						wayPointXPos = ferryXPos + distanceX;
						wayPointYPos = ferryYPos + distanceY;
					}





					int distanceX = - (ferryYPos - wayPointYPos);
					int distanceY = (ferryXPos - wayPointXPos);
					wayPointXPos = ferryXPos + distanceX;
					wayPointYPos = ferryYPos + distanceY;
			} else if(inputList.get(j).substring(0,1).equals("L")){
				int degrees = Integer.parseInt(inputList.get(j).substring(1))/90;
					// System.out.println("L: " + inputList.get(j));
					// System.out.println("fXY: (" + ferryXPos + ", " + ferryYPos + ") wXY: (" + wayPointXPos + ", " + wayPointYPos + ")");
					if(degrees == 1){
						int distanceX = (ferryYPos - wayPointYPos);
						int distanceY = - (ferryXPos - wayPointXPos);
						wayPointXPos = ferryXPos + distanceX;
						wayPointYPos = ferryYPos + distanceY;
					} else if(degrees == 2){
						int distanceX = - (ferryXPos - wayPointXPos);
						int distanceY = - (ferryYPos - wayPointYPos);
						wayPointXPos = ferryXPos + distanceX;
						wayPointYPos = ferryYPos + distanceY;
					} else if(degrees == 3){
						int distanceX = - (ferryYPos - wayPointYPos);
						int distanceY = (ferryXPos - wayPointXPos);
						wayPointXPos = ferryXPos + distanceX;
						wayPointYPos = ferryYPos + distanceY;
					}
					// System.out.println("fXY: (" + ferryXPos + ", " + ferryYPos + ") wXY: (" + wayPointXPos + ", " + wayPointYPos + ")");
				// directionPointer -= degrees;
				// directionPointer = directionPointer%4;
				// if (directionPointer < 0){
				// 	directionPointer += 4;
				// }
			}
			// System.out.println("j: " + inputList.get(j) + " xy: " + ferryXPos + " " + ferryYPos);
		}
		System.out.println("solution for part 1: " + (Math.abs(ferryXPos) + Math.abs(ferryYPos)));
	}

	public static void loadFile() {
        File file = new File("RainRisk.txt");

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

/*
//2020 day 12: Rain Risk

import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class RainRisk {
	static List<String> inputList = new ArrayList<String>();
	public static void main(String[] args) {
		loadFile();

		int total = 0;
		
		int ferryXPos = 0;
		int ferryYPos = 0;
		String[] directions = {"N", "E", "S", "W"};
		int directionPointer = 1;

		for (int j = 0; j < inputList.size(); j++){

			if (inputList.get(j).substring(0,1).equals("F")){
				inputList.set(j, directions[directionPointer] + inputList.get(j).substring(1));
			} 
			if(inputList.get(j).substring(0,1).equals("N")){
				ferryXPos += Integer.parseInt(inputList.get(j).substring(1));
			} else if(inputList.get(j).substring(0,1).equals("E")){
				ferryYPos += Integer.parseInt(inputList.get(j).substring(1));
			} else if(inputList.get(j).substring(0,1).equals("S")){
				ferryXPos -= Integer.parseInt(inputList.get(j).substring(1));
			} else if(inputList.get(j).substring(0,1).equals("W")){
				ferryYPos -= Integer.parseInt(inputList.get(j).substring(1));
			} else if(inputList.get(j).substring(0,1).equals("R")){
				int degrees = Integer.parseInt(inputList.get(j).substring(1))/90;
				directionPointer += degrees;
				directionPointer = directionPointer%4;
			} else if(inputList.get(j).substring(0,1).equals("L")){
				int degrees = Integer.parseInt(inputList.get(j).substring(1))/90;
				directionPointer -= degrees;
				directionPointer = directionPointer%4;
				if (directionPointer < 0){
					directionPointer += 4;
				}
			}
			// System.out.println("j: " + inputList.get(j) + " xy: " + ferryXPos + " " + ferryYPos);
		}
		System.out.println("solution for part 1: " + (Math.abs(ferryXPos) + Math.abs(ferryYPos)));
	}

	public static void loadFile() {
        File file = new File("RainRisk.txt");

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

*/




//52866
//56135