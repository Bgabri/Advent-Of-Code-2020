//2020 day 4 - Passport Processing

import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PassportProcessing {
	static List<String> inputList = new ArrayList<String>();
	public static void main(String[] args) {
		loadFile();

		int totalValid = 0;
		
		for (int j = 0; j< inputList.size(); j++){
			boolean valid0 = false;
			boolean valid1 = false;
			boolean valid2 = false;
			boolean valid3 = false;
			boolean valid4 = false;
			boolean valid5 = false;
			boolean valid6 = false;
			String[] string = inputList.get(j).split(" ");


			for (int i = 0; i < string.length; i++){
				String[] str = string[i].split(":");

				if(str[0].equals("byr") && Integer.parseInt(str[1]) <= 2002 && Integer.parseInt(str[1]) >= 1920){
						valid0 = true;
				} else if(str[0].equals("iyr") && Integer.parseInt(str[1]) <= 2020 && Integer.parseInt(str[1]) >= 2010){
						valid1 = true;	
				} else if(str[0].equals("eyr") && Integer.parseInt(str[1]) <= 2030 && Integer.parseInt(str[1]) >= 2020){
						valid2 = true;
				} else if(str[0].equals("hgt")){
					String type = str[1].substring(str[1].length()-2, str[1].length());
					if(type.equals("cm")){
						int height = Integer.parseInt(str[1].substring(0, str[1].length()-2));

						if(height <= 193 && height >= 150){
							valid3 = true;
						}
					} else if(type.equals("in")){
						int height = Integer.parseInt(str[1].substring(0, str[1].length()-2));

						if(height <= 76 && height >= 59 ){
							
							valid3 = true;
						}
					}
				} else if(str[0].equals("hcl") && str[1].matches("#[0-9a-f]{6}")){
						valid4 = true;
				} else if(str[0].equals("ecl") && str[1].equals("amb")|| str[1].equals("blu")|| str[1].equals("brn")|| str[1].equals("gry")|| str[1].equals("grn")|| str[1].equals("hzl")|| str[1].equals("oth")){
						valid5 = true;
				} else if(str[0].equals("pid") && str[1].matches("[0-9]{9}")){
						valid6 = true;	
				}
			}
			if (valid0&&valid1&&valid2&&valid3&&valid4&&valid5&&valid6){
				totalValid++;
			}
		}
		System.out.println(totalValid);
	}


	public static void loadFile() {
        File file = new File("PassportProcessing.txt");

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