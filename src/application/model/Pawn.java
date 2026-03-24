package application.model;

public class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white);
    }

    // Exemple minimal pour test : mouvement avant 1 case
    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        int dir = isWhite() ? -1 : 1; // Blanc avance vers le haut, noir vers le bas
        if(startX + dir == endX && startY == endY && board[endX][endY] == null) {
            return true;
        }
        return false; // pour l’instant on gère juste le déplacement simple
    }
}