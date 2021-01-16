package isel.poo;

public enum Dir {
    LEFT(0,-1), RIGHT(0,+1), UP(-1,0), DOWN(+1,0), LEFT_UP(-1,-1), LEFT_DOWN(+1,-1), RIGHT_UP(-1,+1), RIGHT_DOWN(+1,+1);

    public final int dLin;
    public final int dCol;

    Dir(int dLin, int dCol) {
        this.dLin = dLin;
        this.dCol = dCol;
    }
}
