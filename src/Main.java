import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int targetNumber1 = 17;
    public static ArrayList<ArrayList<Integer>> foeBoat1 = new ArrayList<>();
    public static String[][] board1 = {{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"A", "~","~","~","~","~","~","~","~","~","~",},
            {"B", "~","~","~","~","~","~","~","~","~","~",},
            {"C", "~","~","~","~","~","~","~","~","~","~",},
            {"D", "~","~","~","~","~","~","~","~","~","~",},
            {"E", "~","~","~","~","~","~","~","~","~","~",},
            {"F", "~","~","~","~","~","~","~","~","~","~",},
            {"G", "~","~","~","~","~","~","~","~","~","~",},
            {"H", "~","~","~","~","~","~","~","~","~","~",},
            {"I", "~","~","~","~","~","~","~","~","~","~",},
            {"J", "~","~","~","~","~","~","~","~","~","~",}};
    public static String[][] fogBoard1 = {{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"A", "~","~","~","~","~","~","~","~","~","~",},
            {"B", "~","~","~","~","~","~","~","~","~","~",},
            {"C", "~","~","~","~","~","~","~","~","~","~",},
            {"D", "~","~","~","~","~","~","~","~","~","~",},
            {"E", "~","~","~","~","~","~","~","~","~","~",},
            {"F", "~","~","~","~","~","~","~","~","~","~",},
            {"G", "~","~","~","~","~","~","~","~","~","~",},
            {"H", "~","~","~","~","~","~","~","~","~","~",},
            {"I", "~","~","~","~","~","~","~","~","~","~",},
            {"J", "~","~","~","~","~","~","~","~","~","~",}};

    public static int targetNumber2 = 17;
    public static ArrayList<ArrayList<Integer>> foeBoat2 = new ArrayList<>();
    public static String[][] board2 = {{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"A", "~","~","~","~","~","~","~","~","~","~",},
            {"B", "~","~","~","~","~","~","~","~","~","~",},
            {"C", "~","~","~","~","~","~","~","~","~","~",},
            {"D", "~","~","~","~","~","~","~","~","~","~",},
            {"E", "~","~","~","~","~","~","~","~","~","~",},
            {"F", "~","~","~","~","~","~","~","~","~","~",},
            {"G", "~","~","~","~","~","~","~","~","~","~",},
            {"H", "~","~","~","~","~","~","~","~","~","~",},
            {"I", "~","~","~","~","~","~","~","~","~","~",},
            {"J", "~","~","~","~","~","~","~","~","~","~",}};
    public static String[][] fogBoard2 = {{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"A", "~","~","~","~","~","~","~","~","~","~",},
            {"B", "~","~","~","~","~","~","~","~","~","~",},
            {"C", "~","~","~","~","~","~","~","~","~","~",},
            {"D", "~","~","~","~","~","~","~","~","~","~",},
            {"E", "~","~","~","~","~","~","~","~","~","~",},
            {"F", "~","~","~","~","~","~","~","~","~","~",},
            {"G", "~","~","~","~","~","~","~","~","~","~",},
            {"H", "~","~","~","~","~","~","~","~","~","~",},
            {"I", "~","~","~","~","~","~","~","~","~","~",},
            {"J", "~","~","~","~","~","~","~","~","~","~",}};

    public static int[] getColRowInt(String startRow, String startCol, String endRow, String endCol) {
        int startColInt = Integer.parseInt(startCol);
        int endColInt = Integer.parseInt(endCol);

        if (startColInt > endColInt) { // startColInt is smaller
            int tmp = startColInt;
            startColInt = endColInt;
            endColInt = tmp;
        }

        int startRowInt = startRow.charAt(0) - 'A' + 1;
        int endRowInt = endRow.charAt(0) - 'A' + 1;

        if (startRowInt > endRowInt) { // startRowInt is smaller
            int tmp = startRowInt;
            startRowInt = endRowInt;
            endRowInt = tmp;
        }

        return new int[] {startColInt, endColInt, startRowInt, endRowInt};
    }

    public static boolean locationCheck(String startRow, String startCol, String endRow, String endCol, String ship, int length) {
        try {

            // not in grid
            if (!"ABCDEFGHIJ".contains(startRow)) {
                throw new Exception();
            }
            if (!"ABCDEFGHIJ".contains(endRow)) {
                throw new Exception();
            }

            Integer startColInt = Integer.parseInt(startCol);
            Integer endColInt = Integer.parseInt(endCol);

            // not in grid
            if (startColInt < 1 || startColInt > 10) {
                throw new Exception();
            }

            // placing diagonally
            if (!startRow.equals(endRow) && startColInt != endColInt) {
                throw new Exception();
            }

            return true;

        } catch (Exception e) {
            System.out.println("Error! Wrong ship location! Try again:");
            System.out.println();
            return false;
        }

    }

    public static boolean lengthCheck(String startRow, String startCol, String endRow, String endCol, String ship, int length) {
        // not diagonal

        try {
            Integer startColInt = Integer.parseInt(startCol);
            Integer endColInt = Integer.parseInt(endCol);

            char startRowChar = startRow.charAt(0);
            char endRowChar = endRow.charAt(0);

            // coord don't match with ship length
            if (Math.abs(endRowChar - startRowChar) + 1 != length &&
                    Math.abs(startColInt - endColInt) + 1 != length) {
                throw new Exception();
            }

            return true;

        } catch (Exception e) {
            System.out.println("Error! Wrong length of the Submarine! Try again:");
            System.out.println();
            return false;
        }
    }

    public static boolean nearbyCheck(String startRow, String startCol, String endRow, String endCol, String ship, int length, String[][] board) {
        try {

            int[] colRowInt = getColRowInt(startRow, startCol, endRow, endCol);
            int startColInt = colRowInt[0];
            int endColInt = colRowInt[1];
            int startRowInt = colRowInt[2];
            int endRowInt = colRowInt[3];

            for (int i = startRowInt; i <= endRowInt; i++) {
                for (int j = startColInt; j <= endColInt; j++) {
                    for (int k = 0; k < 4; k++) {
                        int ii = i + dir[k][0];
                        int jj = j + dir[k][1];

                        if (ii <= 10 && jj <= 10 && board[ii][jj].equals("O")) { // occupied
                            throw new Exception();
                        }
                    }
                }
            }
            return true;

        } catch (Exception e) {
            System.out.println("Error! You placed it too close to another one. Try again:");
            System.out.println();
            return false;
        }
    }

    public static void placeShip(String startRow, String startCol, String endRow, String endCol, String ship, int length, String[][] board) {
        int[] colRowInt = getColRowInt(startRow, startCol, endRow, endCol);
        int startColInt = colRowInt[0];
        int endColInt = colRowInt[1];
        int startRowInt = colRowInt[2];
        int endRowInt = colRowInt[3];

        for (int i = startRowInt; i <= endRowInt; i++) {
            for (int j = startColInt; j <= endColInt; j++) {
                board[i][j] = "O";
            }
        }
    }

    public static boolean validInput(String ship, int length, String[][] board, ArrayList<ArrayList<Integer>> foeBoat) {
        String startCoord = scanner.next();
        String endCoord = scanner.next();

        if (startCoord.length() > 3 || endCoord.length() > 3) {
            return false;
        }

        String startRow = startCoord.substring(0,1);
        String startCol = startCoord.substring(1);
        String endRow = endCoord.substring(0,1);
        String endCol = endCoord.substring(1);

        boolean a = locationCheck(startRow, startCol, endRow, endCol, ship, length);
        boolean b = lengthCheck(startRow, startCol, endRow, endCol, ship, length);
        boolean c = nearbyCheck(startRow, startCol, endRow, endCol, ship, length, board);

        if (!(a && b && c)) return false;

        placeShip(startRow, startCol, endRow, endCol, ship, length, board);

//        ArrayList<Integer> boat = new ArrayList<>();
        int[] boat = singleStepCheck(startCoord);
        ArrayList<Integer> boatCoord = new ArrayList<>();
        boatCoord.add(boat[0]);
        boatCoord.add(boat[1]);
        foeBoat.add(boatCoord);

        return true;

    }

    public static void getInput(String ship, int length, String[][] board, ArrayList<ArrayList<Integer>> foeBoat) {
        System.out.printf("Enter the coordinates of the %s Carrier (%d cells):%n%n", ship, length);
        boolean res = validInput(ship, length, board, foeBoat);
        while (! res) {
            res = validInput(ship, length, board, foeBoat);
        }

    }

    public static void printBoard(String[][] board){
        for (int i = 0; i <= 10; i++) {
            System.out.println(String.join(" ", board[i]));
        }
        System.out.println();
    }

    public static void printFogBoard(String[][] fogBoard) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(String.join(" ", fogBoard[i]));
        }
        System.out.println();
    }

    public static int[] singleStepCheck(String nextStep) {
        try {

            String row = nextStep.substring(0,1);
            int rowInt = row.charAt(0) - 'A' + 1;

            String col = nextStep.substring(1);
            int colInt = Integer.parseInt(col);

            // not in grid
            if (colInt < 1 || colInt > 10 || rowInt < 1 || rowInt > 10) {
                throw new Exception();
            }

            return new int[] {rowInt, colInt};

        } catch (Exception e) {
            System.out.println("Error! Wrong ship location! Try again:");
            System.out.println();
            return new int[] {};
        }

    }

    public static boolean boatSinkCheck(int[] hitCoord, String[][] board) {
        HashSet visited = new HashSet();
        Deque<List<Integer>> queue = new ArrayDeque<>();

        List<Integer> hitCoordArr = Arrays.asList(hitCoord[0], hitCoord[1]);

        queue.add(hitCoordArr);
        visited.add(hitCoordArr);

        while (queue.size() > 0) {
            List<Integer> cur = queue.pop();

            for (int i = 0; i < 4; i++) {
                int ii = cur.get(0) + dir[i][0];
                int jj = cur.get(1) + dir[i][1];

                List<Integer> nxt = Arrays.asList(ii, jj);

                if (ii <= 10 && jj <= 10 && board[ii][jj].equals("O")) { // not sink
                    return false;
                }

                if (ii <= 10 && jj <= 10 && !visited.contains(nxt) && board[ii][jj].equals("X")) {
                    queue.add(nxt);
                    visited.add(nxt);
                }
            }
        }
        return true;

    }

    public static int fire(int targetNumber, ArrayList<ArrayList<Integer>> foeBoat, String[][] board, String[][] fogBoard) {
        //        int targetNumber, ArrayList<ArrayList<Integer>> foeBoat, String[][] board, String[][] fogBoard
        int[] coordArr = singleStepCheck(scanner.next());

        while (coordArr.length == 0) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            System.out.println();
            coordArr = singleStepCheck(scanner.next());
        }

        String msg;

        // ~ = sea, O = target, X = destroyed target,  M = missed
        if (board[coordArr[0]][coordArr[1]] == "~" || board[coordArr[0]][coordArr[1]] == "M") { // ~, M
            fogBoard[coordArr[0]][coordArr[1]] = "M";
            board[coordArr[0]][coordArr[1]] = "M";
            msg = "You missed.";
        } else { // O, X
            if (board[coordArr[0]][coordArr[1]] == "O") {
                targetNumber--;
                fogBoard[coordArr[0]][coordArr[1]] = "X";
                board[coordArr[0]][coordArr[1]] = "X";
            }
            msg = "You hit a ship!";
            if (boatSinkCheck(coordArr, board)) {
                msg = "You sank a ship!";
            }
        }

        System.out.println(targetNumber);
        if (targetNumber == 0) {
            msg = "You sank the last ship. You won. Congratulations!";
        }

//        printFogBoard(fogBoard);
        System.out.println(msg);
        return targetNumber;
    }

    public static void changePlayer() {
        System.out.print("""
                Press Enter and pass the move to another player
                ...""");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(input);
    }

    public static void printCompleteBoard(boolean player) {
        // true = player1, false = player2
        if (player == true) {
            printFogBoard(fogBoard2);
            System.out.println("---------------------");
            printBoard(board1);
            System.out.println("Player 1, it's your turn:");
            System.out.println();
        } else {
            printFogBoard(fogBoard1);
            System.out.println("---------------------");
            printBoard(board2);
            System.out.println("Player 2, it's your turn:");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Player 1, place your ships on the game field");
        printBoard(board1);
        getInput("Aircraft Carrier", 5, board1, foeBoat1);
        printBoard(board1);
        getInput("Battleship", 4, board1, foeBoat1);
        printBoard(board1);
        getInput("Submarine", 3, board1, foeBoat1);
        printBoard(board1);
        getInput("Cruiser", 3, board1, foeBoat1);
        printBoard(board1);
        getInput("Destroyer", 2, board1, foeBoat1);
        printBoard(board1);

        changePlayer();

        System.out.println("Player 2, place your ships on the game field");
        printBoard(board2);
        getInput("Aircraft Carrier", 5, board2, foeBoat2);
        printBoard(board2);
        getInput("Battleship", 4, board2, foeBoat2);
        printBoard(board2);
        getInput("Submarine", 3, board2, foeBoat2);
        printBoard(board2);
        getInput("Cruiser", 3, board2, foeBoat2);
        printBoard(board2);
        getInput("Destroyer", 2, board2, foeBoat2);
        printBoard(board2);


        changePlayer();
        boolean player = true;

        while (targetNumber1 != 0 && targetNumber2 != 0) {

            printCompleteBoard(player);
            if (player == true) { // player 1
                targetNumber2 = fire(targetNumber2, foeBoat2, board2, fogBoard2);
            } else {
                targetNumber1 = fire(targetNumber1, foeBoat1, board1, fogBoard1);
            }

            if (targetNumber1 == 0 || targetNumber2 == 0) break;

            changePlayer();
            player = !player;

        }

    }
}

