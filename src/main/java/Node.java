import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Node {
    public Puzzle puz;

    Node previous;
    Move lastMove;

    Node left;
    Node right;
    Node up;
    Node down;

    public Node(Puzzle puz) {
        nodeList.add(this);
        this.puz = puz;

        previous = null;
        lastMove = Move.EMPTY;
        left = null;
        right = null;
        up = null;
        down = null;
    }


    /**
     * The function accepts the argument as a puzzle and returns Puzzles, which are puzzles after 15 moves. Each of the 15 moves
     * has to bring some change, but they can mutually neutralize. Upward movement is permitted and later downward
     * @param puzzle
     * @return
     * @throws CloneNotSupportedException
     */
    public static Puzzle shufflePuzzle(Puzzle puzzle) throws CloneNotSupportedException {

        Puzzle puzzleClone = puzzle.clone();

        Random randomDirection = new Random();
        int moveDirection;
        for (int i = 0; i < 15; i++) {
            moveDirection = randomDirection.nextInt(4);
            Puzzle puzzleCloneTemporary;
            switch (moveDirection) {
                case 0:
                    puzzleCloneTemporary = puzzleClone.clone();
                    puzzleCloneTemporary.moveUp();
                    if (!puzzleCloneTemporary.equals(puzzleClone)) {
                        puzzleClone = puzzleCloneTemporary;
                    } else {
                        i = i - 1;
                    }
                    break;
                case 1:
                    puzzleCloneTemporary = puzzleClone.clone();
                    puzzleCloneTemporary.moveDown();
                    if (!puzzleCloneTemporary.equals(puzzleClone)) {
                        puzzleClone = puzzleCloneTemporary;
                    } else {
                        i = i - 1;
                    }
                    break;
                case 2:
                    puzzleCloneTemporary = puzzleClone.clone();
                    puzzleCloneTemporary.moveLeft();
                    if (!puzzleCloneTemporary.equals(puzzleClone)) {
                        puzzleClone = puzzleCloneTemporary;
                    } else {
                        i = i - 1;
                    }
                    break;
                case 3:
                    puzzleCloneTemporary = puzzleClone.clone();
                    puzzleCloneTemporary.moveRight();
                    if (!puzzleCloneTemporary.equals(puzzleClone)) {
                        puzzleClone = puzzleCloneTemporary;
                    } else {
                        i = i - 1;
                    }
                    break;
                default:
                    break;


            }
        }
        return puzzleClone;
    }

    public static ArrayList<Move> listOfMoves = new ArrayList<Move>();


    /**
     * @param node
     * the function saves moves to listOfMoves from initial configuration to the configuration in the current node
     */
    public static void writeTolistOfMoves(Node node) {
        if (node.lastMove != Move.EMPTY) {
            listOfMoves.add(node.lastMove);
        }
        if (node.previous != null) {
            writeTolistOfMoves(node.previous);
        }
    }

    public static HashSet<Node> temporaryNode = new HashSet<Node>();
    public static HashSet<Node> nodeList = new HashSet<Node>();


    public Puzzle puzzleAfterMove(Node root, Move move) throws CloneNotSupportedException {
        Puzzle puzzleClone = root.puz.clone();
        if (move == Move.LEFT)
            puzzleClone.moveLeft();
        if (move == Move.RIGHT)
            puzzleClone.moveRight();
        if (move == Move.UP)
            puzzleClone.moveUp();
        if (move == Move.DOWN)
            puzzleClone.moveDown();

        return puzzleClone;
    }

    public void add(Node root) throws CloneNotSupportedException {
        if (root != null) {
            nodeList.add(root);
            add(root.up);
            add(root.down);
            add(root.left);
            add(root.right);

            Puzzle puzzleLeft = puzzleAfterMove(root,Move.LEFT);
            Puzzle puzzleRight = puzzleAfterMove(root,Move.RIGHT);
            Puzzle puzzleUp = puzzleAfterMove(root,Move.UP);
            Puzzle puzzleDown = puzzleAfterMove(root,Move.DOWN);

            if (root.left == null && !puzzleLeft.equals(root.puz)) {
                boolean save = true;
                for (Node n : nodeList) {
                    if (n.puz.equals(puzzleLeft)) {
                        save = false;
                        break;
                    }
                }
                if (save) {
                    root.left = new Node(puzzleLeft);
                    root.left.previous = root;
                    root.left.lastMove = Move.LEFT;
                }
            }
            if (root.right == null && !puzzleRight.equals(root.puz)) {
                boolean save = true;
                for (Node n : nodeList) {
                    if (n.puz.equals(puzzleRight)) {
                        save = false;
                        break;
                    }
                }
                if (save) {
                    root.right = new Node(puzzleRight);
                    root.right.previous = root;
                    root.right.lastMove = Move.RIGHT;
                }
            }
            if (root.up == null && !puzzleUp.equals(root.puz)) {
                boolean save = true;
                for (Node n : nodeList) {
                    if (n.puz.equals(puzzleUp)) {
                        save = false;
                        break;
                    }
                }
                if (save) {
                    root.up = new Node(puzzleUp);
                    root.up.previous = root;
                    root.up.lastMove = Move.UP;
                }
            }
            if (root.down == null && !puzzleDown.equals(root.puz)) {
                boolean save = true;
                for (Node n : nodeList) {
                    if (n.puz.equals(puzzleDown)) {
                        save = false;
                        break;
                    }
                }
                if (save) {
                    root.down = new Node(puzzleDown);
                    root.down.previous = root;
                    root.down.lastMove = Move.DOWN;
                }
            }

        }

    }
}
