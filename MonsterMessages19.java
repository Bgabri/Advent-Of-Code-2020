// 2020: day 19 Monster Messages,


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MonsterMessages19 {
	static List<String[]> rules = new ArrayList<String[]>();
	static List<String> messages = new ArrayList<String>();
	static int rule0Index = -1;
	public static void main(String[] args) {
		loadFile();
		part1();
		part2();

		// for (int i = 0; i < input.length; i++){

		// }
	}
	
	public static void part1() {
		int total = 0;

		// boolean rulesSet = false;
		// while (!rulesSet){
			System.out.println(Arrays.toString(rules.get(rule0Index)));
			String rule0[] = rules.get(rule0Index);
				String[] nestedRules = rule0[1].split(" ");
				for (int k = 0; k < nestedRules.length; k++){
					String[] temp = rule0;
					for (int l = 0; l < rules.size(); l++){
						if(nestedRules[k].equals(rules.get(l)[0])){
							String[] nestedRules2 = rules.get(l)[1].split(",");
							String newRule0 = (new String(new char[nestedRules2.length])).replace("\0", rule0[1]);
							// rule0[1] = newRule0.replace(nestedRules[k], );
							System.out.println(Arrays.toString(rule0));
						}
					}
			}
			// break;
		// }

		System.out.println("solution for part 1: " + Arrays.toString(rule0));
	}

	public static void part2() {
		int total = 0;

		// for (int i = 0; i < inputList.size(); i++){
			
		// }
		System.out.println("solution for part 2: ");
	}

	public static void loadFile() {
        File file = new File("MonsterMessages19.txt");

        try {
            Scanner scan = new Scanner(file);
            String currentLine = scan.nextLine();
            int index = 0;
            while (!currentLine.equals("")) {
            	String[] line = currentLine.replace("\"", "").replace(" | ", ",").split(": ");
                rules.add(line);
                currentLine = scan.nextLine();
                if(line[0].equals("0")){
                	rule0Index = index;
                }
                index++;
            }
            while (scan.hasNext()) {
            	currentLine = scan.nextLine();
                messages.add(currentLine);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}