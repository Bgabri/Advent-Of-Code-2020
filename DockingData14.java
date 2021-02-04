//2020 day 14: Docking Data - lost the og file and had to recover from an old class file I found

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DockingData14 {
    static List<String[]> inputList = new ArrayList();
    static int memSize = 0;

    DockingData14() {
    }

    public static void main(String[] var0) {
        loadFile();
        part1();
        part2();
    }

    public static void part1() {
        String var0 = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        long[] var1 = new long[memSize + 1];

        for(int var2 = 0; var2 < inputList.size(); ++var2) {
            if (((String[])inputList.get(var2))[0].equals("mask")) {
                var0 = ((String[])inputList.get(var2))[1];
            } else {
                String var3 = decToBit(Long.parseLong(((String[])inputList.get(var2))[1]));
                var3 = (new String(new char[var0.length() - var3.length()])).replace("\u0000", "0") + var3;
                String var4 = "";

                for(int var5 = 0; var5 < var0.length(); ++var5) {
                    if (var0.charAt(var5) != 'X') {
                        var4 = var4 + var0.charAt(var5);
                    } else {
                        var4 = var4 + var3.charAt(var5);
                    }
                }

                var1[Integer.parseInt(((String[])inputList.get(var2))[0].substring(4, ((String[])inputList.get(var2))[0].length() - 1))] = bitToDec(var4);
            }
        }

        long var6 = 0L;

        for(int var7 = 0; var7 < var1.length; ++var7) {
            var6 += var1[var7];
        }

        System.out.println("solution for part 1: " + var6);
    }

    public static void part2() {
        String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        List<Long> memoryAdress = new ArrayList();
        List<Long> memoryValues = new ArrayList();

        for(int i = 0; i < inputList.size(); i++) {
            if (((String[])inputList.get(i))[0].equals("mask")) {
                mask = ((String[])inputList.get(i))[1];
            } else {
                String value = decToBit((long)Integer.parseInt(((String[])inputList.get(i))[0].substring(4, ((String[])inputList.get(i))[0].length() - 1)));
                value = (new String(new char[mask.length() - value.length()])).replace("\0", "0") + value;
                String newValue = "";
                int numOfFloating = 0;

                for(int j = 0; j < mask.length(); j++) {
                    if (mask.charAt(j) == 'X') {
                        newValue = newValue + 'X';
                        numOfFloating++;
                    } else if (mask.charAt(j) == '1') {
                        newValue = newValue + '1';
                    } else {
                        newValue = newValue + value.charAt(j);
                    }
                }

                String current = (new String(new char[numOfFloating])).replace("\0", "0");
                while(true){
					String newMemoryAdress = "";
					int indexOfCurrent = 0;
					for(int k = 0; k < newValue.length(); k++) {
						if(newValue.charAt(k) != 'X'){
							newMemoryAdress += newValue.charAt(k);
						} else {
							newMemoryAdress += current.charAt(indexOfCurrent);
							indexOfCurrent++;
						}
                	}

                	// System.out.println(bitToDec(newMemoryAdress)+ "} {" +  Long.parseLong(inputList.get(i)[1]));
            		if(memoryAdress.contains((Long)(bitToDec(newMemoryAdress)))){
            			memoryValues.set(memoryAdress.indexOf((Long)(bitToDec(newMemoryAdress))), Long.parseLong(inputList.get(i)[1]));
            		} else {
            			memoryAdress.add((Long)(bitToDec(newMemoryAdress)));
            			memoryValues.add(Long.parseLong(inputList.get(i)[1]));	
            		}
	            	current = decToBit(bitToDec(current)+1);
	            	if(current.length()<=numOfFloating){
	            		current = (new String(new char[numOfFloating - current.length()])).replace("\0", "0") + current;
            		} else{
            			break;
            		}
                }
            }
        }

        long total = 0L;

        for(int i = 0; i < memoryValues.size(); i++) {
            total += memoryValues.get(i);
        
        }
        System.out.println(memoryAdress);
        System.out.println("solution for part 2: " + total);
    }

    public static long bitToDec(String var0) {
        long var1 = 0L;

        for(int var3 = 0; var3 < var0.length(); ++var3) {
            if (var0.charAt(var3) == '1') {
                var1 = (long)((double)var1 + Math.pow(2.0D, (double)(var0.length() - var3 - 1)));
            }
        }

        return var1;
    }

    public static String decToBit(long var0) {
        String var2;
        for(var2 = ""; var0 > 0L; var0 /= 2L) {
            var2 = var2 + var0 % 2L;
        }

        String var3 = "";

        for(int var4 = 0; var4 < var2.length(); ++var4) {
            var3 = var3 + var2.charAt(var2.length() - var4 - 1);
        }

        return var3;
    }

    public static void loadFile() {
        File file = new File("DockingData14.txt");

        String[] var2;
        try {
            for(Scanner var1 = new Scanner(file); var1.hasNext(); inputList.add(var2)) {
                var2 = var1.nextLine().split(" = ");
                if (!var2[0].equals("mask") && memSize < Integer.parseInt(var2[0].substring(4, var2[0].length() - 1))) {
                    memSize = Integer.parseInt(var2[0].substring(4, var2[0].length() - 1));
                }
            }
        } catch (FileNotFoundException var3) {
            System.out.println("file not found");
        }

    }
}
