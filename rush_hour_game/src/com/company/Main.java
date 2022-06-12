package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Board> boards  = new ArrayList<>();

    public static void main(String[] args) {
        readBoardFromFile(".\\test.txt");
    }

    public static ArrayList<Board> readBoardFromFile(String path){
        Scanner sc = null;
        int lineNum = 0;
        String[] vars;

        int numOfParking; // T
        int rowOfParking, colOfParking, numOfCars;
        int x, y, size;
        String orient;

        try {
            File file = new File(path); // java.io.File
            sc = new Scanner(file);     // java.util.Scanner
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                vars = line.split("\\s+");


                if (lineNum == 0) {   // reading numOfParking
                    numOfParking = Integer.parseInt(line);
                    System.out.println(numOfParking);

                }else if (lineNum == 1) { // reading info of board
                    rowOfParking= Integer.parseInt(vars[0]);
                    colOfParking= Integer.parseInt(vars[1]);
                    numOfCars= Integer.parseInt(vars[2]);

                    System.out.println(rowOfParking+" "+colOfParking+" "+numOfCars);
                    boards.add(new Board(rowOfParking, colOfParking, numOfCars));

                }else {
                        x= Integer.parseInt(vars[0]);
                        y= Integer.parseInt(vars[1]);
                        orient= (vars[2]);
                        size= Integer.parseInt(vars[3]);
                    System.out.println(x+" "+ y+" "+orient+" "+ size);
                        boards.get(0).getCars().add(new Car(x, y,orient, size));

                }
                lineNum++;
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            if (sc != null) sc.close();
        }

        return boards;
     }
}
