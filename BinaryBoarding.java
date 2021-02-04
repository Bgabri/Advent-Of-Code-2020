//2020 Day 5: Binary Boarding


import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class BinaryBoarding {
	static List<String[]> inputList = new ArrayList<String[]>();
	public static void main(String[] args) {
		loadFile();
		
		int seatIdBig = 0;
		boolean[][] planeSeating = new boolean[128][8];

		for (int j = 0; j< inputList.size(); j++){
			int seatId = 0;
			int upRow = 127;
			int lowRow = 0;
			int upColumn = 0;
			int lowColumn = 7;
			String[] input = inputList.get(j);
			for (int i = 0; i < input.length; i++){
				if(input[i].equals("F")){
					lowRow = lowRow;
					upRow = lowRow + (upRow-lowRow)/2;
				} else if(input[i].equals("B")){
					lowRow = upRow - (upRow-lowRow)/2;
					upRow = upRow;
				} if(input[i].equals("R")){
					lowColumn = lowColumn;
					upColumn = lowColumn + (upColumn-lowColumn)/2;
				} else if(input[i].equals("L")){
					lowColumn = upColumn - (upColumn-lowColumn)/2;
					upColumn = upColumn;
				}
			}

			seatId = lowRow * 8 + upColumn;
			planeSeating[lowRow][upColumn] = true;
			if(seatId > seatIdBig){
				seatIdBig = seatId;
			}
		}

		System.out.println("solution for part 1: " + seatIdBig); //part 1

		int prev = 0;

		for (int i = 0; i < planeSeating.length; i++){
			for (int j = 0; j < planeSeating[i].length; j++){	
				if(planeSeating[i][j]){
					if(prev - (i * 8 + j) == -2 ){
						System.out.println("solution for part 2: " + prev); //part 2
					}
					prev = i * 8 + j;
				}
			}
		}
	}

	public static void loadFile() {
        File file = new File("BinaryBoarding.txt");

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
