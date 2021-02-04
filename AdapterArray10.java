// 2020 day 14: Adapter Array

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.AbstractCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class AdapterArray10 {
	static List<Integer> inputList = new ArrayList<Integer>();
	static Integer maxJolt = 0;
	public static void main(String[] args) {
		loadFile();
		part1();
		part2();
	}
	
	public static void part1() {
		maxJolt +=3;
		int[] tempArray = new int[inputList.size()];
		for (int i = 0; i < inputList.size(); i++){
			tempArray[i] = inputList.get(i);
		}
		tempArray = bubbleSort(tempArray);

		int total = 0;
		int jolt1 = 0;
		int jolt3 = 0;
		int prevValue = 0;

		for (int i = 0; i < tempArray.length; i++){
			int difference = tempArray[i] - prevValue;
			total += difference;
			prevValue = tempArray[i];
			if(difference == 3){
				jolt3++;
			} else if(difference == 1){
				jolt1++;
			}
		}

		jolt3 +=1;

		System.out.println("solution for part 1: " + (jolt1 * jolt3));
	}

	public static void part2() {
		int[] adapters = new int[inputList.size()];
		for (int i = 0; i < inputList.size(); i++){
			adapters[i] = inputList.get(i);
		}
		adapters = bubbleSort(adapters);
		System.out.println(Arrays.toString(adapters));
		int[] seqs = new int[6];
		int seq = 1;
		int j = 0;
		while (j <= adapters.length - 2) {
			int a = (int) adapters[j];
			int b = (int) adapters[j + 1];
			if (b - a == 1) {
				seq++;
			} else {
				seqs[seq]++;
				seq = 1;
			}
			j++;
		}
		seqs[seq]++;

		long ans = 1;
		ans *= Math.pow(2, seqs[3]);
		ans *= Math.pow(4, seqs[4]);
		ans *= Math.pow(7, seqs[5]);

		System.out.println("adapter combinations: " + ans);
	} //1511207993344 not mine

	public static int[] bubbleSort(int[] array) {
		boolean stable = false;

		while(!stable){
			stable = true;
			for (int i = 0; i < array.length-1; i++){
				if(array[i] > array[i+1]){
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					stable = false;
				}
			}
		}
		return array;
	} 

	public static void loadFile() {
        File file = new File("AdapterArray10.txt");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                Integer currentLine = Integer.parseInt(scan.nextLine());
                inputList.add(currentLine);
                if(maxJolt < currentLine){
                	maxJolt = currentLine;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}