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

        if(defineWhichWay == rowWay) {
            int selectColumnPlace = random.nextInt(max - min + 1) + min;
            if(selectColumnPlace == 6) {
                shipsRowLocations.add(selectRandomPlace - 1);
                shipsRowLocations.add(selectRandomPlace);
                shipsRowLocations.add(selectRandomPlace + 1);
                selectColumnPlace -= 2;
                shipsColumnLocations.add(selectColumnPlace - 1);
                for(int i = 0; i < 3; i++) {
                    matrixElement[selectRandomPlace][selectColumnPlace] = 3;
                    shipsColumnLocations.add(selectColumnPlace);
                    selectColumnPlace++;
                }
            }
            else if(selectColumnPlace == 5) {
                shipsRowLocations.add(selectRandomPlace - 1);
                shipsRowLocations.add(selectRandomPlace);
                shipsRowLocations.add(selectRandomPlace + 1);
                selectColumnPlace--;
                shipsColumnLocations.add(selectColumnPlace - 1);
                for(int i = 0; i < 3; i++) {
                    matrixElement[selectRandomPlace][selectColumnPlace] = 3;
                    shipsColumnLocations.add(selectColumnPlace);
                    selectColumnPlace++;
                }
                shipsColumnLocations.add(selectColumnPlace + 1);
            }
            else {
                shipsRowLocations.add(selectRandomPlace - 1);
                shipsRowLocations.add(selectRandomPlace);
                shipsRowLocations.add(selectRandomPlace + 1);
                shipsColumnLocations.add(selectColumnPlace - 1);
                for(int i = 0; i < 3; i++) {
                    matrixElement[selectRandomPlace][selectColumnPlace] = 3;
                    shipsColumnLocations.add(selectColumnPlace);
                    selectColumnPlace++;
                }
                shipsColumnLocations.add(selectColumnPlace + 1);
            }
        }
        else {
            int selectRowPlace = random.nextInt(max - min + 1) + min;
            if(selectRowPlace == 6) {
                shipsColumnLocations.add(selectRandomPlace - 1);
                shipsColumnLocations.add(selectRandomPlace);
                shipsColumnLocations.add(selectRandomPlace + 1);
                selectRowPlace -= 2;
                shipsRowLocations.add(selectRowPlace - 1);
                for(int i = 0; i < 3; i++) {
                    matrixElement[selectRowPlace][selectRandomPlace] = 3;
                    shipsRowLocations.add(selectRowPlace);
                    selectRowPlace++;
                }
            }
            else if(selectRowPlace == 5) {
                shipsColumnLocations.add(selectRandomPlace - 1);
                shipsColumnLocations.add(selectRandomPlace);
                shipsColumnLocations.add(selectRandomPlace + 1);
                selectRowPlace--;
                shipsRowLocations.add(selectRowPlace - 1);
                for(int i = 0; i < 3; i++) {
                    matrixElement[selectRowPlace][selectRandomPlace] = 3;
                    shipsRowLocations.add(selectRowPlace);
                    selectRowPlace++;
                }
                shipsRowLocations.add(selectRowPlace + 1);
            }
            else {
                shipsColumnLocations.add(selectRandomPlace - 1);
                shipsColumnLocations.add(selectRandomPlace);
                shipsColumnLocations.add(selectRandomPlace + 1);
                shipsRowLocations.add(selectRowPlace - 1);
                for(int i = 0; i < 3; i++) {
                    matrixElement[selectRowPlace][selectRandomPlace] = 3;
                    shipsRowLocations.add(selectRowPlace);
                    selectRowPlace++;
                }
                shipsRowLocations.add(selectRowPlace + 1);
            }
        }

        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                System.out.print(matrixElement[i][j] + "  ");
            }
            System.out.println();
        }
    }

//    public static void putBigShipRandomly (int selectColumnPlace, int selectRandomPlace, ArrayList<Integer> shipsRowLocations, ArrayList<Integer> shipsColumnLocations, int[][] matrixElement) {
//        if(selectColumnPlace == 6) {
//            shipsRowLocations.add(selectRandomPlace - 1);
//            shipsRowLocations.add(selectRandomPlace);
//            shipsRowLocations.add(selectRandomPlace + 1);
//            selectColumnPlace -= 2;
//            shipsColumnLocations.add(selectColumnPlace - 1);
//            for(int i = 0; i < 3; i++) {
//                matrixElement[selectRandomPlace][selectColumnPlace] = 3;
//                shipsColumnLocations.add(selectColumnPlace);
//                selectColumnPlace++;
//            }
//        }
//        else if(selectColumnPlace == 5) {
//            shipsRowLocations.add(selectRandomPlace - 1);
//            shipsRowLocations.add(selectRandomPlace);
//            shipsRowLocations.add(selectRandomPlace + 1);
//            selectColumnPlace--;
//            shipsColumnLocations.add(selectColumnPlace - 1);
//            for(int i = 0; i < 3; i++) {
//                matrixElement[selectRandomPlace][selectColumnPlace] = 3;
//                shipsColumnLocations.add(selectColumnPlace);
//                selectColumnPlace++;
//            }
//            shipsColumnLocations.add(selectColumnPlace + 1);
//        }
//        else {
//            shipsRowLocations.add(selectRandomPlace - 1);
//            shipsRowLocations.add(selectRandomPlace);
//            shipsRowLocations.add(selectRandomPlace + 1);
//            shipsColumnLocations.add(selectColumnPlace - 1);
//            for(int i = 0; i < 3; i++) {
//                matrixElement[selectRandomPlace][selectColumnPlace] = 3;
//                shipsColumnLocations.add(selectColumnPlace);
//                selectColumnPlace++;
//            }
//            shipsColumnLocations.add(selectColumnPlace + 1);
//        }
//    }
}