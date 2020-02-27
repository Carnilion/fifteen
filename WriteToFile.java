package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;

public class WriteToFile {

    public static void saveToFile(Puzzle puzzle, Node solution) throws FileNotFoundException {


        if (puzzle.isSolvable()) {
            Node.writeTolistOfMoves(solution);
            Collections.reverse(Node.listOfMoves);
        }

        /**
         * saving the initial configuration to a file
         */
        File file = new File("saved.txt");
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < Puzzle.SIZE_OF_MATRIX; i++) {
            for (int j = 0; j < Puzzle.SIZE_OF_MATRIX; j++) {
                writer.print(puzzle.getTab()[j][i] + " ");
            }
        }

        /**
         * if solution is available then we save into the file list of moves from initial configuration
         * and we write the solution
         */
        writer.println();
        if (puzzle.isSolvable()) {
            writer.println(Node.listOfMoves.size());
            for (Move move : Node.listOfMoves) {
                writer.print(move + " ");
            }

            writer.println();
            for (int i = 0; i < Puzzle.SIZE_OF_MATRIX; i++) {
                for (int j = 0; j < Puzzle.SIZE_OF_MATRIX; j++) {
                    writer.print(solution.puz.getTab()[j][i] + " ");
                }
            }

        } else {
            writer.println(-1);
        }

        writer.close();

    }

}
