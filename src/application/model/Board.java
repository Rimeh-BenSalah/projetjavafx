package application.model;

public class Board {
    private Piece[][] board = new Piece[8][8];

    public Board() {
        // pions blancs
        for (int i=0;i<8;i++) board[6][i] = new Pawn(true);
        // pions noirs
        for (int i=0;i<8;i++) board[1][i] = new Pawn(false);
        // Tours
        board[7][0] = new Rook(true); board[7][7] = new Rook(true);
        board[0][0] = new Rook(false); board[0][7] = new Rook(false);
        // Cavaliers
        board[7][1] = new Knight(true); board[7][6] = new Knight(true);
        board[0][1] = new Knight(false); board[0][6] = new Knight(false);
        // Fous
        board[7][2] = new Bishop(true); board[7][5] = new Bishop(true);
        board[0][2] = new Bishop(false); board[0][5] = new Bishop(false);
        // Reines
        board[7][3] = new Queen(true); board[0][3] = new Queen(false);
        // Rois
        board[7][4] = new King(true); board[0][4] = new King(false);
    }

    public Piece[][] getBoard() { return board; }

    public void movePiece(int startX, int startY, int endX, int endY) {
        board[endX][endY] = board[startX][startY];
        board[startX][startY] = null;
    }
}