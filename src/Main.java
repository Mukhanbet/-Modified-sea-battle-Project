import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[][] matrixElement = new int[6][6];

        System.out.println("Enter your name: ");
        String getNameOfPlayer = scanner.next();

        ArrayList<Integer> shipsRowLocations = new ArrayList<>();
        ArrayList<Integer> shipsColumnLocations = new ArrayList<>();
        int rowLocation = 1;
        int defineWhichWay = random.nextInt(2 - 1 +1) + 1;
        int max = 5;
        int min = 0;
        int getNumberForBigShip = random.nextInt(max - min + 1) + min;
        int amountOfSquare = 3;
        if(defineWhichWay == rowLocation) {
            while(true) {
                int getRandomNumber = random.nextInt((max - min) + 1) + min;
                if(getRandomNumber == 5 && !shipsRowLocations.contains(getRandomNumber)) {
                    getRandomNumber -= 2;
                    putBigShipRandomly(getNumberForBigShip, getRandomNumber, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                    break;
                }
                else if(getRandomNumber == 4 && !shipsRowLocations.contains(getRandomNumber)) {
                    getRandomNumber--;
                    putBigShipRandomly(getNumberForBigShip, getRandomNumber, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                    break;
                }
                else if(!shipsRowLocations.contains(getRandomNumber)) {
                    putBigShipRandomly(getNumberForBigShip, getRandomNumber, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                    break;
                }
            }
        }
        else {
            while(true) {
                int getRandomNumber = random.nextInt((max - min) + 1) + min;
                if(getRandomNumber == 5 && !shipsRowLocations.contains(getRandomNumber)) {
                    getRandomNumber -= 2;
                    putBigShipRandomly(getRandomNumber, getNumberForBigShip, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                    break;
                }
                else if(getRandomNumber == 4 && !shipsRowLocations.contains(getRandomNumber)) {
                    getRandomNumber--;
                    putBigShipRandomly(getRandomNumber, getNumberForBigShip, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                    break;
                }
                else if(!shipsRowLocations.contains(getRandomNumber)) {
                    putBigShipRandomly(getRandomNumber, getNumberForBigShip, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                    break;
                }
            }
        }

        amountOfSquare--;
        defineWhichWay = random.nextInt(2 - 1 +1) + 1;
        int getNumberForMidShip = random.nextInt(max - min + 1) + min;
        for(int i = 0; i < 2; i++) {
            if(defineWhichWay == rowLocation) {
                while(true) {
                    int getRandomNumber = random.nextInt((max - min) + 1) + min;
                    if(getRandomNumber == 5 && !shipsRowLocations.contains(getRandomNumber)) {
                        getRandomNumber -= 2;
                        putBigShipRandomly(getNumberForMidShip, getRandomNumber, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                        break;
                    }
                    else if(getRandomNumber == 4 && !shipsRowLocations.contains(getRandomNumber)) {
                        getRandomNumber--;
                        putBigShipRandomly(getNumberForMidShip, getRandomNumber, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                        break;
                    }
                    else if(!shipsRowLocations.contains(getRandomNumber)) {
                        putBigShipRandomly(getNumberForMidShip, getRandomNumber, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                        break;
                    }
                }
            }
            else {
                while(true) {
                    int getRandomNumber = random.nextInt((max - min) + 1) + min;
                    if(getRandomNumber == 5 && !shipsRowLocations.contains(getRandomNumber)) {
                        getRandomNumber -= 2;
                        putBigShipRandomly(getRandomNumber, getNumberForMidShip, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                        break;
                    }
                    else if(getRandomNumber == 4 && !shipsRowLocations.contains(getRandomNumber)) {
                        getRandomNumber--;
                        putBigShipRandomly(getRandomNumber, getNumberForMidShip, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                        break;
                    }
                    else if(!shipsRowLocations.contains(getRandomNumber)) {
                        putBigShipRandomly(getRandomNumber, getNumberForMidShip, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                        break;
                    }
                }
            }
        }

        amountOfSquare--;
        defineWhichWay = random.nextInt(2 - 1 +1) + 1;
        int getNumberForSmallShip = random.nextInt(max - min + 1) + min;
        for(int i = 0; i < 4; i++) {
            if(defineWhichWay == rowLocation) {
                while(true) {
                    int getRandomNumber = random.nextInt((max - min) + 1) + min;
                    if(getRandomNumber == 5 && !shipsRowLocations.contains(getRandomNumber)) {
                        getRandomNumber -= 2;
                        putBigShipRandomly(getNumberForSmallShip, getRandomNumber, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                        break;
                    }
                    else if(getRandomNumber == 4 && !shipsRowLocations.contains(getRandomNumber)) {
                        getRandomNumber--;
                        putBigShipRandomly(getNumberForSmallShip, getRandomNumber, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                        break;
                    }
                    else if(!shipsRowLocations.contains(getRandomNumber)) {
                        putBigShipRandomly(getNumberForSmallShip, getRandomNumber, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                        break;
                    }
                }
            }
            else {
                while(true) {
                    int getRandomNumber = random.nextInt((max - min) + 1) + min;
                    if(getRandomNumber == 5 && !shipsRowLocations.contains(getRandomNumber)) {
                        getRandomNumber -= 2;
                        putBigShipRandomly(getRandomNumber, getNumberForSmallShip, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                        break;
                    }
                    else if(getRandomNumber == 4 && !shipsRowLocations.contains(getRandomNumber)) {
                        getRandomNumber--;
                        putBigShipRandomly(getRandomNumber, getNumberForSmallShip, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                        break;
                    }
                    else if(!shipsRowLocations.contains(getRandomNumber)) {
                        putBigShipRandomly(getRandomNumber, getNumberForSmallShip, matrixElement, shipsRowLocations, shipsColumnLocations, amountOfSquare);
                        break;
                    }
                }
            }
        }

        for(int t = 0; t < 6; t++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(matrixElement[t][j] + " ");
            }
            System.out.println();
        }
    }

    public static void putBigShipRandomly(int getNumberForBigShip, int getRandomNumber, int[][] matrixElement, ArrayList<Integer> shipsRowLocations, ArrayList<Integer> shipsColumnLocations, int amountOfSquare) {
        for(int i = 0; i < amountOfSquare; i++) {
            matrixElement[getNumberForBigShip][getRandomNumber] = amountOfSquare;
            shipsRowLocations.add(getNumberForBigShip);
            shipsColumnLocations.add(getRandomNumber);
            getRandomNumber++;
        }
    }
}