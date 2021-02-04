// 2020 Day 22: Crab Combat

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class CrabCombat22 {
	static List<Integer> player1Deck = new ArrayList<Integer>();
	static List<Integer> player2Deck = new ArrayList<Integer>();
	public static void main(String[] args) {
		loadFile();
		part1();
		player1Deck = new ArrayList<Integer>();
		player2Deck = new ArrayList<Integer>();
		loadFile();
		part2();
	}
	
	public static void part1() {
		while(player1Deck.size() > 0 && player2Deck.size() > 0){
			if(player1Deck.get(0) < player2Deck.get(0)){
				player2Deck.add(player2Deck.get(0));
				player2Deck.add(player1Deck.get(0));
				player1Deck.remove(0);
				player2Deck.remove(0);
			} else if(player1Deck.get(0) > player2Deck.get(0)){
				player1Deck.add(player1Deck.get(0));
				player1Deck.add(player2Deck.get(0));
				player1Deck.remove(0);
				player2Deck.remove(0);
			}
		}

		int total = 0;

		if(player1Deck.size() > 0){
			for(int i = 0; i < player1Deck.size(); i++){
				total += player1Deck.get(i) * i;
			}
		} else if(player2Deck.size() > 0){
			for(int i = 0; i < player2Deck.size(); i++){
				total += player2Deck.get(player2Deck.size() - i - 1) * (i+1);
			}
		}

		System.out.println("solution for part 1: " + total);
	}

	public static void part2() {
		int player1Draw = player1Deck.get(0);
		int player2Draw = player2Deck.get(0);
		int index = 0;
		while(player1Deck.size() <= player1Draw || player2Deck.size() <= player2Draw){ // round winner determiner
			if(player1Draw < player2Draw){
				player2Deck.add(player2Draw);
				player2Deck.add(player1Draw);
				player1Deck.remove(0);
				player2Deck.remove(0);
			} else if(player1Draw > player2Draw){
				player1Deck.add(player1Draw);
				player1Deck.add(player2Draw);
				player1Deck.remove(0);
				player2Deck.remove(0);
			}
			index ++;
			player1Draw = player1Deck.get(0);
			player2Draw = player2Deck.get(0);
		}
		
		System.out.println(index);
		System.out.println(player1Deck);
		System.out.println(player2Deck);

		int total = 0;

		if(player1Deck.size() > 0){
			for(int i = 0; i < player1Deck.size(); i++){
				total += player1Deck.get(i) * i;
			}
		} else if(player2Deck.size() > 0){
			for(int i = 0; i < player2Deck.size(); i++){
				total += player2Deck.get(player2Deck.size() - i - 1) * (i+1);
			}
		}

		System.out.println("solution for part 2: " + total);
	}

	public static void loadFile() {
        File file = new File("CrabCombat22.txt");

        try {
            Scanner scan = new Scanner(file);
            String currentLine = scan.nextLine();

            currentLine = scan.nextLine();
            while (!currentLine.equals("")) {
                player1Deck.add(Integer.parseInt(currentLine));
                currentLine = scan.nextLine();
            }

			currentLine = scan.nextLine();
			scan.close();

            while (scan.hasNext()) {
            	currentLine = scan.nextLine();
                player2Deck.add(Integer.parseInt(currentLine));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}