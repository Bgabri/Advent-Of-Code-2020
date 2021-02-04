// 2020 Day 2: Password Philosophy


import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PasswordPhilosophy {
	public static void main(String[] args) {
		loadFile();
	}

	public static void loadFile() {
        File file = new File("PasswordPhilosophy.txt");
        int total1 = 0; //part 1
        int total2 = 0; //part 2
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {

            String currentLine[] = scan.nextLine().split(" ");
            String pass[] = currentLine[3].split("");
            int num = 0;

            //part 1
 			for (int j = 0; j < pass.length; j++){
				if (pass[j].equals(currentLine[2])){
					num++;
				}
			}
			
			if (num <= Integer.parseInt(currentLine[1]) && num >= Integer.parseInt(currentLine[0])){
				total1++;
			}

		//part 2
			if ((pass[Integer.parseInt(currentLine[1])-1].equals(currentLine[2]) || pass[Integer.parseInt(currentLine[0])-1].equals(currentLine[2]))){
					if (!(pass[Integer.parseInt(currentLine[1])-1].equals(pass[Integer.parseInt(currentLine[0])-1]))){
						total2++;
					}
				}
			}
			System.out.println("part 1 solution: " + total1);
			System.out.println("part 2 solution: " + total2);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }
}