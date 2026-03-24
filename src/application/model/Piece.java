package application.model;

public abstract class Piece {
    private boolean white;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    // Vérifie si un déplacement est valide
    // Pour l’instant on laisse true pour test
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        return true;
    }
}