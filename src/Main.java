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
        int selectRandomPlace = random.nextInt(max - min + 1) + min;
        System.out.println(defineWhichWay);

        if (defineWhichWay == rowWay) {
            int selectColumnPlace = random.nextInt(max - min + 1) + min;
            if (selectColumnPlace == 6) {
                selectColumnPlace -= 2;
                shipsColumnLocations.add(selectColumnPlace - 1);
                putBigShipRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay);
            } else if (selectColumnPlace == 5) {
                selectColumnPlace--;
                shipsColumnLocations.add(selectColumnPlace - 1);
                putBigShipRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay);
                shipsColumnLocations.add(selectColumnPlace + 1);
            } else {
                shipsColumnLocations.add(selectColumnPlace - 1);
                putBigShipRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay);
                shipsColumnLocations.add(selectColumnPlace + 1);
            }
        } else {
            int selectRowPlace = random.nextInt(max - min + 1) + min;
            if (selectRowPlace == 6) {
                selectRowPlace -= 2;
                shipsRowLocations.add(selectRowPlace - 1);
                putBigShipRandomly(selectRowPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay);
            } else if (selectRowPlace == 5) {
                selectRowPlace--;
                shipsRowLocations.add(selectRowPlace - 1);
                putBigShipRandomly(selectRowPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay);
                shipsRowLocations.add(selectRowPlace + 1);
            } else {
                shipsRowLocations.add(selectRowPlace - 1);
                putBigShipRandomly(selectRowPlace, selectRandomPlace,shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay);
                shipsRowLocations.add(selectRowPlace + 1);
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrixElement[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void putBigShipRandomly(int selectRowColumnPlace, int selectRandomPlace, ArrayList<Integer> shipsRowLocations, ArrayList<Integer> shipsColumnLocations, int[][] matrixElement, int defineWhichWay) {
        for(int i = 0; i < 3; i++) {
            if(defineWhichWay == 1) {
                shipsRowLocations.add(selectRandomPlace - 1 + i);
                matrixElement[selectRandomPlace][selectRowColumnPlace + i] = 3;
                shipsColumnLocations.add(selectRowColumnPlace + i);
            }
            else {
                shipsColumnLocations.add(selectRandomPlace - 1 + i);
                matrixElement[selectRowColumnPlace + i][selectRandomPlace] = 3;
                shipsRowLocations.add(selectRowColumnPlace + i);
            }
        }
    }
}