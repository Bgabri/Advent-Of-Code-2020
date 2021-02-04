//2020 Day 23: Crab Cups
// "" -< sum weird charterer that got bugged into the file for some reason
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class CrabCups23 {
	static LinkedList<Integer> cupList = new LinkedList<Integer>();
	public static void main(String[] args) {
		loadFile();
		part1();//32897654
		// part2();//186715244496
	}
	
	public static void part1() {
		int crabIndex = 0;

		for(int i = 0; i < 1000; i++){
			//1) find
			LinkedList<Integer> newCupList = new LinkedList<Integer>();
			LinkedList<Integer> pickedCups = new LinkedList<Integer>();

			int currentCup = cupList.get(crabIndex);

			for(int j = 0; j < 3; j++){
				if (crabIndex+1 >= cupList.size()){
					pickedCups.add(cupList.pop());
				} else {
					pickedCups.add(cupList.get(crabIndex+1));
					cupList.remove(crabIndex+1);
				}
			} // picked up

			int destination = 0;

			int amount = 1;
			int largest = -1;
			for(int j = 0; j < cupList.size(); j++){
				if(largest < cupList.get(j)){
					largest = cupList.get(j);
				}
				if(cupList.contains(currentCup-amount)){
					destination = currentCup-amount;
					break;
				} else {
					amount++;
					destination = largest;
				}
			}

			LinkedList<Integer> newCupOrder = new LinkedList<Integer>();
			Iterator iterator = cupList.iterator();

		    while(iterator.hasNext()){
				int value = (int) iterator.next();
				newCupOrder.add(value);
				if(value == destination){
					for(int k = 0; k < pickedCups.size(); k++){
						newCupOrder.add(pickedCups.get(k));
					}
				}
			}

			cupList = new LinkedList<Integer>();
			Iterator iterator2 = newCupOrder.iterator();
		    while(iterator2.hasNext()){
				cupList.add((int) iterator2.next());
			}

			crabIndex = cupList.indexOf(currentCup);

			crabIndex++;
			if(crabIndex >= cupList.size()){
				crabIndex -= cupList.size();
			}
			System.out.println(cupList);
		}
		String finalCupList = "";
		int index = cupList.indexOf(1) + 1;
		for(int i = 1; i < cupList.size(); i++) {
			finalCupList += cupList.get(index);
			index++;
			if(index >= cupList.size()){
				index -= cupList.size();
			}
		}
		System.out.println("solution for part 1: " + finalCupList);
	}

	public static void part2() {

		for(int i = cupList.size(); i < 1000000; i++){
			cupList.add(i);
		}

		System.out.println("progress: " + "-1");

		int crabIndex = 0;
		
		for(int i = 0; i < 10000000; i++){
			//1) find
			LinkedList<Integer> newCupList = new LinkedList<Integer>();
			LinkedList<Integer> pickedCups = new LinkedList<Integer>();

			int currentCup = cupList.get(crabIndex);

			for(int j = 0; j < 3; j++){
				if (crabIndex+1 >= cupList.size()){
					pickedCups.add(cupList.pop());
				} else {
					pickedCups.add(cupList.get(crabIndex+1));
					cupList.remove(crabIndex+1);
				}
			} // picked up

			int destination = 0;

			int amount = 1;
			int largest = -1;
			for(int j = 0; j < cupList.size(); j++){
				if(largest < cupList.get(j)){
					largest = cupList.get(j);
				}
				if(cupList.contains(currentCup-amount)){
					destination = currentCup-amount;
					break;
				} else {
					amount++;
					destination = largest;
				}
			}

			LinkedList<Integer> newCupOrder = new LinkedList<Integer>();
			Iterator iterator = cupList.iterator();

		    while(iterator.hasNext()){
				int value = (int) iterator.next();
				newCupOrder.add(value);
				if(value == destination){
					for(int k = 0; k < pickedCups.size(); k++){
						newCupOrder.add(pickedCups.get(k));
					}
				}
			}

			cupList = new LinkedList<Integer>();
			Iterator iterator2 = newCupOrder.iterator();
		    while(iterator2.hasNext()){
				cupList.add((int) iterator2.next());
			}

			crabIndex = cupList.indexOf(currentCup);

			crabIndex++;
			if(crabIndex >= cupList.size()){
				crabIndex -= cupList.size();
			}

			// if(i%10 == 0){
				System.out.println("progress: " + i);
			// }
		}
		String finalCupList = "";
		int index = cupList.indexOf(1);
		index++;
			if(index >= cupList.size()){
				index -= cupList.size();
			}
		int value1 = cupList.get(index);
		index++;
			if(index >= cupList.size()){
				index -= cupList.size();
			}
		int value2 = cupList.get(index);
		for(int i = 1; i < cupList.size(); i++) {
			finalCupList += cupList.get(index);
			index++;
			if(index >= cupList.size()){
				index -= cupList.size();
			}
		}
		System.out.println("solution for part 2: " + finalCupList);
	}//186715244496

	public static void loadFile() {
        File file = new File("CrabCups23.txt");

        try {
            Scanner scan = new Scanner(file);
            String[] currentLine = scan.nextLine().split("");
            for(int i = 0; i < currentLine.length; i++){
            	cupList.add(Integer.parseInt(currentLine[i]));
			}
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}