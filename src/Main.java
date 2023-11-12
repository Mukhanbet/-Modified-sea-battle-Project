import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[][] matrixElement = new int[7][7];

        System.out.println("Enter your name: ");
        String getNameOfPlayer = scanner.next();

        ArrayList<Integer> shipsRowLocations = new ArrayList<>();
        ArrayList<Integer> shipsColumnLocations = new ArrayList<>();

        int max = 6;
        int min = 0;
        int rowWay = 1;
        int defineWhichWay = random.nextInt(2 - 1 + 1) + 1;
//        int defineWhichWay = scanner.nextInt();
        int selectRandomPlace = random.nextInt(max - min + 1) + min;
//        int selectRandomPlace = scanner.nextInt();
        System.out.println(defineWhichWay);
        int whichSquare = 3;
        if (defineWhichWay == rowWay) {
            int selectColumnPlace = random.nextInt(max - min + 1) + min;
//            int selectColumnPlace = scanner.nextInt();
            if (selectColumnPlace == 6) {
                selectColumnPlace -= 2;
                shipsColumnLocations.add(selectColumnPlace - 1);
                putBigShipRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
            } else if (selectColumnPlace == 5) {
                selectColumnPlace--;
                shipsColumnLocations.add(selectColumnPlace - 1);
                putBigShipRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
            } else {
                shipsColumnLocations.add(selectColumnPlace - 1);
                putBigShipRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
                shipsColumnLocations.add(selectColumnPlace + 3);
            }
        } else {
            int selectRowPlace = random.nextInt(max - min + 1) + min;
//            int selectRowPlace = scanner.nextInt();
            if (selectRowPlace == 6) {
                selectRowPlace -= 2;
                shipsRowLocations.add(selectRowPlace - 1);
                putBigShipRandomly(selectRowPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
            } else if (selectRowPlace == 5) {
                selectRowPlace--;
                shipsRowLocations.add(selectRowPlace - 1);
                putBigShipRandomly(selectRowPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
            } else {
                shipsRowLocations.add(selectRowPlace - 1);
                putBigShipRandomly(selectRowPlace, selectRandomPlace,shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
                shipsRowLocations.add(selectRowPlace + 3);
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrixElement[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        whichSquare--;
        int amountOFSquare = 0;
        while(amountOFSquare < 2) {
            defineWhichWay = random.nextInt(max - min + 1) + min;
//            defineWhichWay = scanner.nextInt();
            selectRandomPlace = random.nextInt(max - min + 1) + min;
//            selectRandomPlace = scanner.nextInt();
            if(defineWhichWay == rowWay) {
                int selectColumnPlace = random.nextInt(max - min + 1) + min;
                if(!(shipsColumnLocations.contains(selectColumnPlace) && shipsRowLocations.contains(selectRandomPlace))) {
                    if (selectColumnPlace == 6) {
                        selectColumnPlace--;
                        shipsColumnLocations.add(selectColumnPlace - 1);
                        putBigShipRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
                        amountOFSquare++;
                    } else {
                        shipsColumnLocations.add(selectColumnPlace - 1);
                        putBigShipRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
                        shipsColumnLocations.add(selectColumnPlace + 2);
                        shipsRowLocations.add(selectRandomPlace + 1);
                        amountOFSquare++;
                    }
                }
            } else {
                int selectRowPlace = random.nextInt((max - min) + 1) + min;
//                int selectRowPlace = scanner.nextInt();
                if(!(shipsColumnLocations.contains(selectRandomPlace) && shipsRowLocations.contains(selectRowPlace))) {
                    if (selectRowPlace == 6) {
                        selectRowPlace--;
                        shipsRowLocations.add(selectRowPlace - 1);
                        putBigShipRandomly(selectRowPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
                        amountOFSquare++;
                    } else {
                        shipsRowLocations.add(selectRowPlace - 1);
                        putBigShipRandomly(selectRowPlace, selectRandomPlace,shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
                        shipsRowLocations.add(selectRowPlace + 2);
                        shipsColumnLocations.add(selectRandomPlace + 1);
                        amountOFSquare++;
                    }
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrixElement[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void putBigShipRandomly(int selectRowColumnPlace, int selectRandomPlace, ArrayList<Integer> shipsRowLocations, ArrayList<Integer> shipsColumnLocations, int[][] matrixElement, int defineWhichWay, int whichSquare) {
        for(int i = 0; i < whichSquare; i++) {
            if(defineWhichWay == 1) {
                shipsRowLocations.add(selectRandomPlace - 1 + i);
                matrixElement[selectRandomPlace][selectRowColumnPlace + i] = whichSquare;
                shipsColumnLocations.add(selectRowColumnPlace + i);
            }
            else {
                shipsColumnLocations.add(selectRandomPlace - 1 + i);
                matrixElement[selectRowColumnPlace + i][selectRandomPlace] = whichSquare;
                shipsRowLocations.add(selectRowColumnPlace + i);
            }
        }
    }
}