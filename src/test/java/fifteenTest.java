//import com.company.FindSolution;
//import com.company.Node;
//import com.company.Puzzle;
//import com.company.WriteToFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fifteenTest {
    @Test
    public void existsAndNotEmpty() {

        File file = new File("saved.txt");

        boolean exists = file.exists();
        long length = file.length();

        Assert.assertTrue(exists);
        Assert.assertNotEquals(0, length);

    }

    @Test
    public void ifContainInitialConfiguration() throws FileNotFoundException {

        File file = new File("saved.txt");
        Scanner scanner = new Scanner(file);
        Scanner sc = new Scanner(scanner.nextLine());
        int[] checkTable = new int[16];
        for (int i = 0; i < checkTable.length; i++) {
            checkTable[i] = 0;
        }

        while (sc.hasNext()) {
            String number = sc.next();
            try {
                int numberToInt = Integer.parseInt(number);
                if (numberToInt >= 0 && numberToInt <= 15) {
                    checkTable[numberToInt] = 1;
                }
            } catch (Exception ignored) {
            }

        }

        for (int i : checkTable){
            Assert.assertEquals(1, i);
        }


    }

    @Test
    public void isMovesOk() throws CloneNotSupportedException {

        Puzzle puzzle = new Puzzle();

        puzzle.getTab()[0][0] = 15;
        puzzle.getTab()[0][1] = 11;
        puzzle.getTab()[0][2] = 7;
        puzzle.getTab()[0][3] = 3;
        puzzle.getTab()[1][0] = 14;
        puzzle.getTab()[1][1] = 10;
        puzzle.getTab()[1][2] = 6;
        puzzle.getTab()[1][3] = 1;
        puzzle.getTab()[2][0] = 13;
        puzzle.getTab()[2][1] = 9;
        puzzle.getTab()[2][2] = 5;
        puzzle.getTab()[2][3] = 2;
        puzzle.getTab()[3][0] = 12;
        puzzle.getTab()[3][1] = 8;
        puzzle.getTab()[3][2] = 4;
        puzzle.getTab()[3][3] = 0;

        Puzzle puzzleLeft = puzzle.clone();
        puzzleLeft.moveLeft();

        int rowOfIndexZero = -1;
        int columnOfIndexZero = -1;

        for(int i=0;i<Puzzle.SIZE_OF_MATRIX;i++){
            for(int j=0;j<Puzzle.SIZE_OF_MATRIX;j++){
                if(puzzle.getTab()[i][j] == 0){
                    columnOfIndexZero = i;
                    rowOfIndexZero = j;
                }
            }
        }

        puzzle.swap(columnOfIndexZero,rowOfIndexZero,columnOfIndexZero-1,rowOfIndexZero);

        Assert.assertEquals(puzzleLeft,puzzle);

    }

    @Test public void numberOfTilesMovementsIsEqualsNumberOfMoveSequence() throws FileNotFoundException {

        File file = new File("saved.txt");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        String number = scanner.nextLine();
        int numberInt = Integer.parseInt(number);
        int wordCounter = 0;
        if (numberInt != -1){

            String line = scanner.nextLine();
            Scanner sc = new Scanner(line);

            while(sc.hasNext()){
                sc.next();
                wordCounter++;
            }
            Assert.assertEquals(numberInt,wordCounter);
        }
    }

    // Last test which changes the file
    @Test
    public void whatIfSolutionIsUnattainable() throws FileNotFoundException, CloneNotSupportedException {

        Puzzle puzzle = new Puzzle();

        puzzle.getTab()[0][0] = 1;
        puzzle.getTab()[0][1] = 5;
        puzzle.getTab()[0][2] = 9;
        puzzle.getTab()[0][3] = 13;
        puzzle.getTab()[1][0] = 2;
        puzzle.getTab()[1][1] = 6;
        puzzle.getTab()[1][2] = 10;
        puzzle.getTab()[1][3] = 15;
        puzzle.getTab()[2][0] = 3;
        puzzle.getTab()[2][1] = 7;
        puzzle.getTab()[2][2] = 11;
        puzzle.getTab()[2][3] = 14;
        puzzle.getTab()[3][0] = 4;
        puzzle.getTab()[3][1] = 8;
        puzzle.getTab()[3][2] = 12;
        puzzle.getTab()[3][3] = 0;

        Node node = new Node(puzzle);
        Node solutionWhichFind;
        Puzzle finishSolution = Node.shufflePuzzle(node.puz);

        solutionWhichFind = FindSolution.viewSolution(puzzle, finishSolution, node);
        WriteToFile.saveToFile(puzzle, solutionWhichFind);

        File file = new File("saved.txt");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        String number = scanner.nextLine();
        Assert.assertEquals(-1,Integer.parseInt(number));



    }


}