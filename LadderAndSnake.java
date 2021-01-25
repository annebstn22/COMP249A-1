

public class LadderAndSnake{

    private int nbPlayers;
    private final static int NB_DICE_FACES = 6;
    private final static int BOARD_SIZE = 10;
    private final static int NB_SNAKES = 8;
    private final static int NB_LADDERS = 9;
    private final static int SNAKE_HEADS_AND_TAILS[][] = new int[NB_SNAKES][2];
    private final static int LADDER_TOP_AND_BOTTOM[][] = new int[NB_LADDERS][2];

    public LadderAndSnake(int nbPlayers) {
        this.nbPlayers = nbPlayers;

    }

    //random integer between 1 and 6
    static public int flipDice() {
        return (int) ((Math.random() * NB_DICE_FACES + 1));
    }

}