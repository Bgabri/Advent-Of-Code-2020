// 2020 day 8: Handheld Halting

import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class HandheldHalting {
	static List<String[]> inputList = new ArrayList<String[]>();
	public static void main(String[] args) {
		loadFile();
			int accumulator = 0;
			boolean looped = false;
			List<Integer> executed = new ArrayList<Integer>();
			for (int i = 0; i < inputList.size(); i++){
				if(executed.contains(i)){
					looped = true;
					System.out.println("solution to part 1: " + accumulator);
					break;
				}
				else if (inputList.get(i)[0].equals("acc")){
					executed.add(i);
					accumulator += Integer.parseInt(inputList.get(i)[1]);
				} else if (inputList.get(i)[0].equals("jmp")){
					executed.add(i);
					i += Integer.parseInt(inputList.get(i)[1]) - 1;
				} else if (inputList.get(i)[0].equals("nop")){
					executed.add(i);
				}
			}


		for (int k = 0; k < inputList.size(); k++){
			if(inputList.get(k)[0].equals("nop")){
				inputList.get(k)[0] = "jmp";
			} else if(inputList.get(k)[0].equals("jmp")){
				inputList.get(k)[0] = "nop";
			}
			accumulator = 0;
			looped = false;
			executed = new ArrayList<Integer>();
			for (int i = 0; i < inputList.size(); i++){
				if(executed.contains(i)){
					looped = true;
					break;
				}
				else if (inputList.get(i)[0].equals("acc")){
					executed.add(i);
					accumulator += Integer.parseInt(inputList.get(i)[1]);
				} else if (inputList.get(i)[0].equals("jmp")){
					executed.add(i);
					i += Integer.parseInt(inputList.get(i)[1]) - 1;
				} else if (inputList.get(i)[0].equals("nop")){
					executed.add(i);
				}
			}
			if(!looped){
				// System.out.println(executed);
				System.out.println("solution to part 2: " + accumulator);		
			}
			if(inputList.get(k)[0].equals("nop")){
				inputList.get(k)[0] = "jmp";
			} else if(inputList.get(k)[0].equals("jmp")){
				inputList.get(k)[0] = "nop";
			}
		}
		// System.out.println(accumulator);
	}

	public static void loadFile() {
        File file = new File("HandheldHalting.txt");

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