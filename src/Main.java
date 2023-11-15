import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[][] shipsLocations = new int[7][7];
        String[][] enteredLocations = new String[7][7];

        ArrayList<String> playersName = new ArrayList<>();
        ArrayList<Integer> playerStatsPercentage  = new ArrayList<>();
        int countAttempts = 0;

        while(true) {
            System.out.print("Enter your name: ");
            String getNameOfPlayer = scanner.next();
            playersName.add(getNameOfPlayer);
            System.out.println(getNameOfPlayer + " Welcome to Sea Battle Game \nFirst of all, before starting the game, we suggest you read the game instructions.");
            System.out.println("Battle Game Instructions:\n" + "\n" + "Coordinates Entry:\n" + "\n" + "Enter coordinates as a letter (capitalized) followed by a number (e.g., A3, D7).\n" + "Hitting Ships:\n" + "\n" + "If you hit a ship, it will be marked with \"H\".\n" + "Missing Shots:\n" + "\n" + "If you miss a ship, the field will display \"M\".\n" + "Sinking a Ship:\n" + "\n" + "If you successfully sink a ship, it will be marked with \"S\".\n" + "Valid Coordinates:\n" + "\n" + "Ensure coordinates are within the field boundaries.\n" + "Avoid repeating coordinates that were already guessed.\n" + "Enjoy the battle, and may your strategic skills prevail! \uD83D\uDEA2⚓\uFE0F" + "\n\n");

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ArrayList<Integer> shipsRowLocations = new ArrayList<>();
            ArrayList<Integer> shipsColumnLocations = new ArrayList<>();

            int secondTwoSquareShip = 0;
            int max = 6;
            int min = 0;
            int rowWay = 1;
            int defineWhichWay = random.nextInt(2 - 1 + 1) + 1;
            int selectRandomPlace = random.nextInt(max - min + 1) + min;
            int whichSquare = 3;
            if (defineWhichWay == rowWay) {
                int selectColumnPlace = random.nextInt(max - min + 1) + min;
                selectColumnPlace = prepareForRandomness(selectColumnPlace, selectRandomPlace, shipsRowLocations);
                putBigMidShipsRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, shipsLocations, defineWhichWay, whichSquare, secondTwoSquareShip);

            } else {
                int selectRowPlace = random.nextInt(max - min + 1) + min;
                selectRowPlace = prepareForRandomness(selectRowPlace, selectRandomPlace, shipsColumnLocations);
                putBigMidShipsRandomly(selectRowPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, shipsLocations, defineWhichWay, whichSquare, secondTwoSquareShip);
            }

            whichSquare--;
            int amountOFSquare = 0;
            int limitZone = 4;
            while(amountOFSquare < 2) {
                defineWhichWay = random.nextInt(2 - 1 + 1) + 1;
                selectRandomPlace = random.nextInt(max - min + 1) + min;
                if(defineWhichWay == rowWay) {
                    int selectColumnPlace = random.nextInt(max - min + 1) + min;
                    if(isThereShip(selectRandomPlace, selectColumnPlace, shipsRowLocations, shipsColumnLocations, limitZone)) {
                        if (selectColumnPlace == 6) {
                            selectColumnPlace--;
                            putBigMidShipsRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, shipsLocations, defineWhichWay, whichSquare, secondTwoSquareShip);
                            shipsRowLocations.add(selectRandomPlace);
                            amountOFSquare++;
                            secondTwoSquareShip += 2;
                        } else {
                            putBigMidShipsRandomly(selectColumnPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, shipsLocations, defineWhichWay, whichSquare,secondTwoSquareShip);
                            shipsRowLocations.add(selectRandomPlace);
                            amountOFSquare++;
                            secondTwoSquareShip += 2;
                        }
                    }
                } else {
                    int selectRowPlace = random.nextInt((max - min) + 1) + min;
                    if(isThereShip(selectRandomPlace, selectRowPlace, shipsColumnLocations, shipsRowLocations, limitZone)) {
                        if (selectRowPlace == 6) {
                            selectRowPlace--;
                            putBigMidShipsRandomly(selectRowPlace, selectRandomPlace, shipsRowLocations, shipsColumnLocations, shipsLocations, defineWhichWay, whichSquare,secondTwoSquareShip);
                            shipsColumnLocations.add(selectRandomPlace);
                            amountOFSquare++;
                            secondTwoSquareShip += 2;
                        } else {
                            putBigMidShipsRandomly(selectRowPlace, selectRandomPlace,shipsRowLocations, shipsColumnLocations, shipsLocations, defineWhichWay, whichSquare,secondTwoSquareShip);
                            shipsColumnLocations.add(selectRandomPlace);
                            amountOFSquare++;
                            secondTwoSquareShip += 2;
                        }
                    }
                }
            }

            int countOne = 0;
            while(countOne < 4) {
                int rowPLace = random.nextInt(max - min + 1) + min;
                int columnPlace = random.nextInt(max - min + 1) + min;
                if(isThisPLaceEmpty(rowPLace, columnPlace, shipsLocations)) {
                    shipsLocations[rowPLace][columnPlace] = 1;
                    countOne++;
                }
            }

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    System.out.print(shipsLocations[i][j] + "  ");
                }
                System.out.println();
            }

            for(int i = 0; i < 7; i++) {
                for(int j = 0; j < 7; j++) {
                    enteredLocations[i][j] = "■";
                }
            }

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if(i == 0 && j == 0)  {
                        System.out.print("   A  B  C  D  E  F  G");
                        System.out.println();
                        System.out.print(j + 1 + "  " + enteredLocations[i][j] + "  ");
                    } else if (j == 0) {
                        System.out.print(i + 1 + "  " + enteredLocations[i][j] + "  ");
                    } else {
                        System.out.print(enteredLocations[i][j] + "  ");
                    }
                }
                System.out.println();
            }

            ArrayList<String> playersColumnAnswer = new ArrayList<>();
            ArrayList<Integer> playersRowAnswer = new ArrayList<>();
            playersColumnAnswer.add("A");
            playersColumnAnswer.add("B");
            playersColumnAnswer.add("C");
            playersColumnAnswer.add("D");
            playersColumnAnswer.add("E");
            playersColumnAnswer.add("F");
            playersColumnAnswer.add("G");
            for(int i = 0; i < 7; i++) {
                playersRowAnswer.add(i + 1);
            }

            ArrayList<Integer> threeSquareShipsRow = new ArrayList<>();
            ArrayList<Integer> threeSquareShipsColumn = new ArrayList<>();
            ArrayList<Integer> twoSquareShipsRow = new ArrayList<>();
            ArrayList<Integer> twoSquareShipsColumn = new ArrayList<>();
            ArrayList<Integer> secondTwoSquareShipsRow = new ArrayList<>();
            ArrayList<Integer> secondTwoSquareShipsColumn = new ArrayList<>();
            int indexColumn;
            int indexRow;
            while(!haveAllShipsBeenHit(shipsLocations)) {
                while(true) {
                    countAttempts++;
                    System.out.print("Put letter: ");
                    String getColumnLocation = scanner.next();
                    System.out.print("Put number: ");
                    int getRowLocation = scanner.nextInt();
                    if(playersColumnAnswer.contains(getColumnLocation) && playersRowAnswer.contains(getRowLocation)) {
                        indexColumn = playersColumnAnswer.indexOf(getColumnLocation);
                        indexRow = playersRowAnswer.indexOf(getRowLocation);
                        break;
                    } else {
                        System.out.println("Something went wrong! \nDo everything as stated in the instructions");
                    }
                }

                if(shipsLocations[indexRow][indexColumn] == 3) {
                    shipsLocations[indexRow][indexColumn] = 0;
                    if(isThisPLaceEmpty(indexRow, indexColumn, shipsLocations)) {
                        for(int i = 0; i < 2; i++) {
                            enteredLocations[threeSquareShipsRow.get(i)][threeSquareShipsColumn.get(i)] = "S";
                        }
                        enteredLocations[indexRow][indexColumn] = "S";
                    } else {
                        enteredLocations[indexRow][indexColumn] = "H";
                        threeSquareShipsColumn.add(indexColumn);
                        threeSquareShipsRow.add(indexRow);
                    }
                } else if(shipsLocations[indexRow][indexColumn] == 2) {
                    shipsLocations[indexRow][indexColumn] = 0;
                    if(isThisPLaceEmpty(indexRow, indexColumn, shipsLocations)) {
                        for(int i = 0; i < 1; i++) {
                            enteredLocations[twoSquareShipsRow.get(i)][twoSquareShipsColumn.get(i)] = "S";
                        }
                        enteredLocations[indexRow][indexColumn] = "S";
                    } else {
                        enteredLocations[indexRow][indexColumn] = "H";
                        twoSquareShipsColumn.add(indexColumn);
                        twoSquareShipsRow.add(indexRow);
                    }
                }  else if(shipsLocations[indexRow][indexColumn] == 4) {
                    shipsLocations[indexRow][indexColumn] = 0;
                    if(isThisPLaceEmpty(indexRow, indexColumn, shipsLocations)) {
                        for(int i = 0; i < 1; i++) {
                            enteredLocations[secondTwoSquareShipsRow.get(i)][secondTwoSquareShipsColumn.get(i)] = "S";
                        }
                        enteredLocations[indexRow][indexColumn] = "S";
                    } else {
                        enteredLocations[indexRow][indexColumn] = "H";
                        secondTwoSquareShipsColumn.add(indexColumn);
                        secondTwoSquareShipsRow.add(indexRow);
                    }
                }else if(shipsLocations[indexRow][indexColumn] == 1) {
                    shipsLocations[indexRow][indexColumn] = 0;
                    enteredLocations[indexRow][indexColumn] = "S";
                } else {
                    enteredLocations[indexRow][indexColumn] = "M";
                }

                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 7; j++) {
                        if(i == 0 && j == 0)  {
                            System.out.print("   A  B  C  D  E  F  G");
                            System.out.println();
                            System.out.print(j + 1 + "  " + enteredLocations[i][j] + "  ");
                        } else if (j == 0) {
                            System.out.print(i + 1 + "  " + enteredLocations[i][j] + "  ");
                        } else {
                            System.out.print(enteredLocations[i][j] + "  ");
                        }
                    }
                    System.out.println();
                }
            }

            double percentage = (11 / countAttempts) * 100;
            playerStatsPercentage.add((int)percentage);
            String congratulationsText = "You've triumphed on the high seas, sinking every enemy ship with strategic mastery. " +
                    "Your precision and cunning secured a decisive victory, making the seas safe once again. " +
                    "Your leadership will be remembered in naval lore. Well done, and may your future voyages be just as triumphant!";
            System.out.println("\n\nCongratulations, Admiral " + getNameOfPlayer + "!" + congratulationsText + "\n\uD83D\uDEA2⚓\uFE0F Victory Achieved! ⚓\uFE0F\uD83D\uDEA2");
            System.out.println("\n  You've successfully destroyed all ships on your " + countAttempts + "th attempt!");
            System.out.println("\nRating of players:");
            for(int i = 0; i < playerStatsPercentage.size(); i++) {
                System.out.println(1 + i + ". " + playersName.get(i) + ": \nHit statistics:  " + playerStatsPercentage.get(i) + "%     Attempts Made:  " + countAttempts);
            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n\n Would you like to play again?" + "\n1. Yes    2. No");
            int willPlayerPlay = scanner.nextInt();

            if(willPlayerPlay == 2) {
                break;
            }
        }
    }

    public static boolean isThereShip (int selectRandomPlace, int selectRowColumnPlace, ArrayList<Integer> shipsColumnLocations, ArrayList<Integer> shipsRowLocations, int limitZone) {
        if(limitZone == 4 && selectRowColumnPlace == 6) {
            selectRowColumnPlace--;
        }
            for(int i = 0; i < 3; i++) {
                if(shipsColumnLocations.contains((selectRandomPlace - 1) + i)) {
                    for(int j = 0; j < limitZone; j++) {
                        if(shipsRowLocations.contains((selectRowColumnPlace - 1) + j)) {
                            return false;
                        }
                    }
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
    public static void putBigMidShipsRandomly(int selectRowColumnPlace, int selectRandomPlace, ArrayList<Integer> shipsRowLocations, ArrayList<Integer> shipsColumnLocations, int[][] shipsLocations, int defineWhichWay, int whichSquare, int secondTwoSquareShip) {
        for(int i = 0; i < whichSquare; i++) {
            if(defineWhichWay == 1) {
                shipsLocations[selectRandomPlace][selectRowColumnPlace + i] = whichSquare + secondTwoSquareShip;
                shipsColumnLocations.add(selectRowColumnPlace + i);
            }
            else {
                shipsLocations[selectRowColumnPlace + i][selectRandomPlace] = whichSquare + secondTwoSquareShip;
                shipsRowLocations.add(selectRowColumnPlace + i);
            }
        }
    }

    public static boolean isThisPLaceEmpty(int rowPlace, int columnPlace, int[][] shipsLocations) {
        if(rowPlace == 0 && columnPlace == 0) {
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    if(shipsLocations[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else if (rowPlace == 6 && columnPlace == 6){
            for(int i = -1; i < 1; i++) {
                for(int j = -1; j < 1; j++) {
                    if(shipsLocations[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else if(rowPlace == 0 && columnPlace == 6) {
            for(int i = 0; i < 2; i++) {
                for(int j = -1; j < 1; j++) {
                    if(shipsLocations[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else if (rowPlace == 6 && columnPlace == 0) {
            for(int i = -1; i < 1; i++) {
                for(int j = 0; j < 2; j++) {
                    if(shipsLocations[rowPlace + i][columnPlace + j] == 0) {
                    }
                    return false;
                }
            }
        } else if (rowPlace == 0) {
            for(int i = 0; i < 2; i++) {
                for(int j = -1; j < 2; j++) {
                    if(shipsLocations[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else if (columnPlace == 0) {
            for(int i = -1; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    if(shipsLocations[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else if (rowPlace == 6) {
            for(int i = -1; i < 1; i++) {
                for(int j = -1; j < 2; j++) {
                    if(shipsLocations[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else if (columnPlace == 6) {
            for(int i = -1; i < 2; i++) {
                for(int j = -1; j < 1; j++) {
                    if(shipsLocations[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else {
            for(int i = -1; i < 2; i++) {
                for(int j = -1; j < 2; j++) {
                    if(shipsLocations[rowPlace + i][columnPlace + j] == 0) {
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean haveAllShipsBeenHit(int[][] shipsLocations) {
        int countShipsLocations = 0;
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                if(shipsLocations[i][j] == 0) {
                } else {
                    countShipsLocations++;
                }
            }
        }

        if(countShipsLocations == 0) {
            return true;
        } else {
            return false;
        }
    }
}