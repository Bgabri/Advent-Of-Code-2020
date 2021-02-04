// 2020 Day 17: Conway Cubes

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ConwayCubes17 {
	static List<String> inputList = new ArrayList<String>();
	public static void main(String[] args) {
		loadFile();
		part1();
		part2();
	}
	
	public static void part1() {
		int worldSize = 50;

		String[][] world = new String[worldSize][worldSize];
		for (int i = 0; i < world.length; i++){
			for (int j = 0; j < world[i].length; j++){
				world[i][j] = (new String(new char[worldSize])).replace("\0", ".");
			}
		}

		for (int i = 0; i < inputList.size(); i++){
			String filler = (new String(new char[(worldSize-inputList.get(i).length())/2])).replace("\0", ".");
			world[worldSize/2][worldSize/2-inputList.get(i).length() + i] = filler + inputList.get(i) + filler;
		}
		String[][] tempWorld = deepCopy2(world);

		for (int time = 0; time < 6; time++){
			tempWorld = deepCopy2(world);
			for (int i = 1; i < world.length-1; i++){
				for (int j = 1; j < world[i].length-1; j++){
					for (int k = 1; k < world[i][j].length()-2; k++){
						int numOfNeighbours = 0;
						for (int l = -1; l <= 1; l++){
							for (int m = -1; m <= 1; m++){
								for (int n = -1; n <= 1; n++){
									if(!(l == 0 && m == 0 && n == 0)){
										if(world[i+l][j+n].charAt(k+m) == '#'){
											numOfNeighbours ++;
										}
									}		
								}
							}
						}
						if((numOfNeighbours == 3 || numOfNeighbours == 2) && world[i][j].charAt(k) == '#'){
							tempWorld[i][j] = tempWorld[i][j].substring(0, k) + "#" + tempWorld[i][j].substring(k+1, tempWorld[i][j].length());
						} else if((numOfNeighbours == 3) && world[i][j].charAt(k) == '.'){
							tempWorld[i][j] = tempWorld[i][j].substring(0, k) + "#" + tempWorld[i][j].substring(k+1, tempWorld[i][j].length());
						} else{
							tempWorld[i][j] = tempWorld[i][j].substring(0, k) + "." + tempWorld[i][j].substring(k+1, tempWorld[i][j].length());
						}
					}
				}
			}
			world = deepCopy2(tempWorld);
		}
		int total = 0;

		for (int i = 0; i < world.length; i++){
			for (int j = 0; j < world[i].length; j++){
				total += world[i][j].replace(".","").length();
			}
		}

		System.out.println("solution for part 1: " + total);
	}

	public static void part2() {
		int worldSize = 50;

		String[][][] world = new String[worldSize][worldSize][worldSize];

		for (int i = 0; i < world.length; i++){
			for (int j = 0; j < world[i].length; j++){
				for (int w = 0; w < world[i][j].length; w++){
					world[i][j][w] = (new String(new char[worldSize])).replace("\0", ".");
				}
			}
		}

		for (int i = 0; i < inputList.size(); i++){
			String filler = (new String(new char[(worldSize-inputList.get(i).length())/2])).replace("\0", ".");
			world[worldSize/2][worldSize/2][worldSize/2-inputList.get(i).length() + i] = filler + inputList.get(i) + filler;
		}

		String[][][] tempWorld = deepCopy3(world);

		for (int time = 0; time < 6; time++){
			tempWorld = deepCopy3(world);
			System.out.println(time);
			for (int i = 1; i < world.length-1; i++){
				for (int j = 1; j < world[i].length-1; j++){
					for (int w = 1; w < world[i][j].length-1; w++){
						for (int k = 1; k < world[i][j][w].length()-2; k++){
							int numOfNeighbours = 0;
							for (int l = -1; l <= 1; l++){
								for (int m = -1; m <= 1; m++){
									for (int n = -1; n <= 1; n++){
										for (int w2 = -1; w2 <= 1; w2++){
											if(!(l == 0 && m == 0 && n == 0 && w2 == 0)){
												if(world[i+l][j+n][w+w2].charAt(k+m) == '#'){
													numOfNeighbours++;
												}
											}
										}
									}
								}
							}
							if((numOfNeighbours == 3 || numOfNeighbours == 2) && world[i][j][w].charAt(k) == '#'){
								tempWorld[i][j][w] = tempWorld[i][j][w].substring(0, k) + "#" + tempWorld[i][j][w].substring(k+1, tempWorld[i][j][w].length());
							} else if((numOfNeighbours == 3) && world[i][j][w].charAt(k) == '.'){
								tempWorld[i][j][w] = tempWorld[i][j][w].substring(0, k) + "#" + tempWorld[i][j][w].substring(k+1, tempWorld[i][j][w].length());
							} else{
								tempWorld[i][j][w] = tempWorld[i][j][w].substring(0, k) + "." + tempWorld[i][j][w].substring(k+1, tempWorld[i][j][w].length());
							}
						}
					}
				}
			}
			world = deepCopy3(tempWorld);
		}
		int total = 0;

		for (int i = 0; i < world.length; i++){
			for (int j = 0; j < world[i].length; j++){
				for (int w = 0; w < world[i][j].length; w++){
					total += world[i][j][w].replace(".","").length();
				}
			}
		}

		System.out.println("solution for part 1: " + total);
	}

	public static String[][] deepCopy2(String[][] array) {
		String[][] newArray = new String[array.length][array[0].length];
		for (int i = 0; i < array.length; i++){
			newArray[i] = new String[array[i].length];
			for (int j = 0; j < array[i].length; j++){
				newArray[i][j] = array[i][j];
			}
		}
		return newArray;
	}
	public static String[][][] deepCopy3(String[][][] array) {
		String[][][] newArray = new String[array.length][array[0].length][array[0][0].length];
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[i].length; j++){
				newArray[i][j] = new String[array[i][j].length];
				for (int w = 0; w < array[i][j].length; w++){
					newArray[i][j][w] = array[i][j][w];
				}
			}
		}
		return newArray;
	}

	public static void loadFile() {
        File file = new File("ConwayCubes17.txt");

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