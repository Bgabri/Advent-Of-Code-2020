// 2020 day 16: Ticket Translation

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TicketTranslation16 {
	static List<String[]> conditions = new ArrayList<String[]>();
	static String[] ownTicket;
	static List<String[]> tickets = new ArrayList<String[]>();
	public static void main(String[] args) {
		loadFile();
		part1();
		part2();

		// for (int i = 0; i < input.length; i++){

		// }
	}
	
	public static void part1() {
        int totalErrors = 0;
		for (int i = 0; i < tickets.size(); i++){
            boolean ticketValid = true;
            for (int j = 0; j < tickets.get(i).length; j++){
                boolean numValid = false;
                for (int k = 0; k < conditions.size(); k++){
                    String condition0 = conditions.get(k)[1].split(" or ")[0];
                    String condition1 = conditions.get(k)[1].split(" or ")[1];
                    boolean test = ((Integer.parseInt(tickets.get(i)[j]) >= Integer.parseInt(condition0.split("-")[0])
                        && (Integer.parseInt(tickets.get(i)[j]) <= Integer.parseInt(condition0.split("-")[1])))
                        || (Integer.parseInt(tickets.get(i)[j]) >= Integer.parseInt(condition1.split("-")[0]) 
                        &&  Integer.parseInt(tickets.get(i)[j]) <= Integer.parseInt(condition1.split("-")[1])));
                    if(test){
                        numValid = true;
                    }
                }
                if(!numValid){
                    totalErrors += Integer.parseInt(tickets.get(i)[j]);
                    ticketValid = false;
                    break;
                }
            }
            if(!ticketValid){
                tickets.remove(i);
                --i;
            }
		}

		System.out.println("solution for part 1: " + totalErrors);
	}

	public static void part2() {
        List<String[]> possiblePositions = new ArrayList<String[]>();
        for (int k = 0; k < conditions.size(); k++){
            for (int j = 0; j < tickets.get(k).length; j++){
                Boolean conditionValid = true;
                for (int i = 0; i < tickets.size(); i++){
                    String condition0 = conditions.get(k)[1].split(" or ")[0];
                    String condition1 = conditions.get(k)[1].split(" or ")[1];
                    boolean test = ((Integer.parseInt(tickets.get(i)[j]) >= Integer.parseInt(condition0.split("-")[0])
                        && (Integer.parseInt(tickets.get(i)[j]) <= Integer.parseInt(condition0.split("-")[1])))
                        || (Integer.parseInt(tickets.get(i)[j]) >= Integer.parseInt(condition1.split("-")[0]) 
                        &&  Integer.parseInt(tickets.get(i)[j]) <= Integer.parseInt(condition1.split("-")[1])));
                    if (!test){
                        conditionValid = false;
                        break;
                    }
                }
                if(conditionValid){
                    // System.out.println(conditions.get(k)[0] + " j: " + j);
                    possiblePositions.add(new String[]{conditions.get(k)[0], Integer.toString(j)});
                }
            }
        }

        // Boolean propertiesFound = false;
        // while(!propertiesFound){
        //     for (int i = 0; i < 20; i++){
        //         int numSatisfied = 0;
        //         for (int k = 0; k < possiblePositions.size(); k++){
        //             if(Integer.parseInt(possiblePositions.get(k)[1]) == i){
        //                 numSatisfied++;
        //                System.out.println(Arrays.toString(possiblePositions.get(k)));
        //             }
        //         }
        //         if (numSatisfied == 1){
        //             // System.out.println(i);
        //         }
        //     }
        //     break;
        // } idk just did the rest manually
	}

	public static void loadFile() {
        File file = new File("TicketTranslation16.txt");

        try {
            Scanner scan = new Scanner(file);
            int newLine = 0;
            while (scan.hasNext()) {
                String currentLine = scan.nextLine();
                if (currentLine.equals("")){
                    newLine++;
                    currentLine = scan.nextLine();
                } else if(newLine == 2){
                	tickets.add(currentLine.split(","));
                } else if(newLine == 0){
                	conditions.add(currentLine.split(": "));
                } else if(newLine == 1){
                	ownTicket = currentLine.split(",");
                }
                // inputList.add(currentLine);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}