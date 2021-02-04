// 2020 day 13: Shuttle Search
import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ShuttleSearch13 {
	static List<String[]> inputList = new ArrayList<String[]>();
	public static void main(String[] args) {
		loadFile();
		part1();
		part2();
	}

	public static void part1() {
		long startTime = Long.parseLong(inputList.get(0)[0]);
		long currentTime = startTime;
		String[] busTimes = inputList.get(1);
		boolean run = true;
		while (run){
			for (int i = 0; i < busTimes.length; i++){
				if(!busTimes[i].equals("x")){
					if(currentTime%Long.parseLong(busTimes[i]) == 0){
						System.out.println("solution for part 1: " + ((currentTime-startTime) * Long.parseLong(busTimes[i])));
						run = false;
						break;
					}
				}
			}
			currentTime++;
		}
	}

	public static void part2() {
		//CRT
		String[] busTimes = inputList.get(1);
		
		boolean run = true;
		List<Integer> noXInput = new ArrayList<Integer>();
		List<Integer> pos = new ArrayList<Integer>();
		for (int i = 0; i < busTimes.length; i++){
			if(!busTimes[i].equals("x")){
				noXInput.add(Integer.parseInt(busTimes[i]));
				pos.add(i);
			}
		}

		long currentTime = 0;
		int nextBusI = 1;
		long increment = noXInput.get(0);

		while (nextBusI < noXInput.size()){
			currentTime += increment;
			if((currentTime + pos.get(nextBusI))%noXInput.get(nextBusI) == 0){
				nextBusI++;
				increment *= noXInput.get(nextBusI-1);
			}
		}
				

		System.out.println("solution for part 2: " + (currentTime));
	}

	public static void loadFile() {
        File file = new File("2020\ShuttleSearch13.txt");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()){
                String[] currentLine = scan.nextLine().split(",");
                inputList.add(currentLine);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}