import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[][] matrixElement = new int[7][7];

        System.out.print("Enter your name: ");
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
        int whichSquare = 3;
        if (defineWhichWay == rowWay) {
            int selectColumnPlace = random.nextInt(max - min + 1) + min;
//            int selectColumnPlace = scanner.nextInt();
            selectColumnPlace = prepareForRandomness(selectColumnPlace, selectRandomPlace, shipsRowLocations);
            putBigShipRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);

        } else {
            int selectRowPlace = random.nextInt(max - min + 1) + min;
//            int selectRowPlace = scanner.nextInt();
            selectRowPlace = prepareForRandomness(selectRowPlace, selectRandomPlace, shipsColumnLocations);
            putBigShipRandomly(selectRowPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);

        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrixElement[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println(shipsColumnLocations);
        System.out.println(shipsRowLocations);

        whichSquare--;
        int amountOFSquare = 0;
        int limitZone = 4;
        while(amountOFSquare < 2) {

            System.out.println(shipsColumnLocations);
            System.out.println(shipsRowLocations);

            defineWhichWay = random.nextInt(2 - 1 + 1) + 1;
//            System.out.println("put way");
//            defineWhichWay = scanner.nextInt();
            selectRandomPlace = random.nextInt(max - min + 1) + min;
//            System.out.println("Put random place");
//            selectRandomPlace = scanner.nextInt();
            if(defineWhichWay == rowWay) {
//                System.out.println("Put for column");
                int selectColumnPlace = random.nextInt(max - min + 1) + min;
//                int selectColumnPlace = scanner.nextInt();
                if(isThereShip(selectRandomPlace, selectColumnPlace, shipsRowLocations, shipsColumnLocations, limitZone)) {
                    if (selectColumnPlace == 6) {
                        selectColumnPlace--;
                        putBigShipRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
                        shipsRowLocations.add(selectRandomPlace);
                        amountOFSquare++;
                    } else {
                        putBigShipRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
                        shipsRowLocations.add(selectRandomPlace);
                        amountOFSquare++;
                    }
                }
            } else {
                int selectRowPlace = random.nextInt((max - min) + 1) + min;
//                int selectRowPlace = scanner.nextInt();
                if(isThereShip(selectRandomPlace, selectRowPlace, shipsColumnLocations, shipsRowLocations, limitZone)) {
                    if (selectRowPlace == 6) {
                        selectRowPlace--;
                        putBigShipRandomly(selectRowPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
                        shipsColumnLocations.add(selectRandomPlace);
                        amountOFSquare++;
                    } else {
                        putBigShipRandomly(selectRowPlace, selectRandomPlace,shipsRowLocations, shipsColumnLocations, matrixElement, defineWhichWay, whichSquare);
                        shipsColumnLocations.add(selectRandomPlace);
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
        System.out.println();
        System.out.println(shipsColumnLocations);
        System.out.println(shipsRowLocations);
        System.out.println();


        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrixElement[i][j] + "  ");
            }
            System.out.println();
        }
        int countOne = 0;
        while(countOne < 4) {
            int rowPLace = random.nextInt(max - min + 1) + min;
            int columnPlace = random.nextInt(max - min + 1) + min;
            System.out.println(rowPLace + " " + columnPlace);
//            System.out.println("Put for row place");
//            int rowPLace = scanner.nextInt();
//            System.out.println("Put for column");
//            int columnPlace = scanner.nextInt();
            if(isThisPLaceEmpty(rowPLace, columnPlace, matrixElement)) {
                matrixElement[rowPLace][columnPlace] = 1;
                countOne++;
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrixElement[i][j] + "  ");
            }
            System.out.println();
        }
    }


    public static boolean isThereShip (int selectRandomPlace, int selectRowColumnPlace, ArrayList<Integer> shipsColumnLocations, ArrayList<Integer> shipsRowLocations, int limitZone) {
        if(limitZone == 4 && selectRowColumnPlace == 6) {
            selectRowColumnPlace--;
        }
            for(int i = 0; i < 3; i++) {
                if(shipsColumnLocations.contains((selectRandomPlace - 1) + i)) {
                    System.out.println("its contains" +(selectRandomPlace - 1 + i));
                    for(int j = 0; j < limitZone; j++) {
                        System.out.println("the i: " + j);

                        if(shipsRowLocations.contains((selectRowColumnPlace - 1) + j)) {
                            System.out.println(selectRowColumnPlace - 1 + j + " its contains");
                            return false;
                        }
                        else {
                            System.out.println(selectRowColumnPlace - 1 + j + " not its contains");

                        }
                    }
                }
                else {
                    System.out.println("its not contains");
                }
            }
            return true;
        }

    public static int prepareForRandomness(int selectRowColumnPlace, int selectRandomPlace, ArrayList<Integer> shipsRowColumnLocations) {
        if (selectRowColumnPlace == 6) {
            selectRowColumnPlace -= 2;
            shipsRowColumnLocations.add(selectRandomPlace);
        } else if (selectRowColumnPlace == 5) {
            selectRowColumnPlace--;
            shipsRowColumnLocations.add(selectRandomPlace);
        } else {
            shipsRowColumnLocations.add(selectRandomPlace);
        }
        return selectRowColumnPlace;
    }
    public static void putBigShipRandomly(int selectRowColumnPlace, int selectRandomPlace, ArrayList<Integer> shipsRowLocations, ArrayList<Integer> shipsColumnLocations, int[][] matrixElement, int defineWhichWay, int whichSquare) {
        for(int i = 0; i < whichSquare; i++) {
            if(defineWhichWay == 1) {
                matrixElement[selectRandomPlace][selectRowColumnPlace + i] = whichSquare;
                shipsColumnLocations.add(selectRowColumnPlace + i);
            }
            else {
                matrixElement[selectRowColumnPlace + i][selectRandomPlace] = whichSquare;
                shipsRowLocations.add(selectRowColumnPlace + i);
            }
        }
    }

    public static boolean isThisPLaceEmpty(int rowPlace, int columnPlace, int[][] matrixElement) {
        if(rowPlace == 0 && columnPlace == 0) {
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    if(matrixElement[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else if (rowPlace == 6 && columnPlace == 6){
            for(int i = -1; i < 1; i++) {
                for(int j = -1; j < 1; j++) {
                    if(matrixElement[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else if(rowPlace == 0 && columnPlace == 6) {
            for(int i = 0; i < 2; i++) {
                for(int j = -1; j < 1; j++) {
                    if(matrixElement[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else if (rowPlace == 6 && columnPlace == 0) {
            for(int i = -1; i < 1; i++) {
                for(int j = 0; j < 2; j++) {
                    if(matrixElement[rowPlace + i][columnPlace + j] == 0) {
                    }
                    return false;
                }
            }
        } else if (rowPlace == 0) {
            for(int i = 0; i < 2; i++) {
                for(int j = -1; j < 2; j++) {
                    if(matrixElement[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else if (columnPlace == 0) {
            for(int i = -1; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    System.out.println(matrixElement[rowPlace + i][columnPlace + j] + " This number neighbor");
                    if(matrixElement[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else if (rowPlace == 6) {
            for(int i = -1; i < 1; i++) {
                System.out.println("Result: " + rowPlace + " " + i);
                for(int j = -1; j < 2; j++) {
                    if(matrixElement[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else if (columnPlace == 6) {
            for(int i = -1; i < 2; i++) {
                for(int j = -1; j < 1; j++) {
                    System.out.println("Result: " + columnPlace + " " + j);
                    if(matrixElement[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else {
            for(int i = -1; i < 2; i++) {
                for(int j = -1; j < 2; j++) {
                    if(matrixElement[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        }
        System.out.println("Well done!!! ");
        return true;
    }
}