import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.geom.AffineTransform;
import javax.swing.Box;
import java.awt.image.*;




public class Chess {

   //pixel dimensions of a square 
   public static final int SQUARESIZE = 80;
   //always true for a normal game of chess
   public static final int NUMSQUARES = 8;
   
   public static final String PICSLOCATION = "S:\\embergquist\\Writeable\\ProjectsInCS\\AttemptAtChess\\PieceImages\\";
      
   public static void drawBoard (Graphics g) {
      Color c = Color.BLACK;
      for (int i = 0; i < NUMSQUARES; i++) {
         for (int j = 0; j < NUMSQUARES; j++) {
            if (i % 2 == j % 2) 
               g.setColor(Color.WHITE);
            else
               g.setColor(Color.BLACK);   
            g.fillRect (i * SQUARESIZE, j * SQUARESIZE, SQUARESIZE, SQUARESIZE);
         }
      }
      
      
   }   
      
      
   public static void main (String [] args) throws Exception {
      DrawingPanel bd = new DrawingPanel (SQUARESIZE * 8, SQUARESIZE * 8); 
      Graphics g = bd.getGraphics();

      drawBoard(g);
      //Image blackRook = getImageFromFile ("S:\\embergquist\\Writeable\\ProjectsInCS\\AttemptAtChess\\PieceImages\\blackRook.png");
      Image [] blackPieces = getBlackPieces();
      Image [] whitePieces = getWhitePieces();
      drawStartingPosition(blackPieces, whitePieces, g);
      
   }
    
   public static void drawStartingPosition (Image [] blackPieces, Image[] whitePieces, Graphics g) {
      //black first row
      for (int i = 0; i < 8; i++) {
         drawImage(g, i * SQUARESIZE, 0, blackPieces[i]);      
      }
      //black pawns 
      for (int i = 0; i < 8; i++) {
         drawImage(g, i * SQUARESIZE, SQUARESIZE, blackPieces[8]);
      }
      
      //white first row
      for (int i = 0; i < 8; i++) {
         drawImage(g, i * SQUARESIZE, SQUARESIZE * 7, whitePieces[i]);      
      }
      
      //white pawns 
      for (int i = 0; i < 8; i++) {
         drawImage(g, i * SQUARESIZE, SQUARESIZE * 6, whitePieces[8]);
      }
   
   }
   
   public static void drawImage (Graphics g, int x, int y, Image img) {
      ImageObserver b = new Box (1);
      g.drawImage (img, x, y, SQUARESIZE, SQUARESIZE, b);
   
   }
   
   public static Image [] getWhitePieces () throws Exception{
      Image [] whitePieces = new Image[9];
      whitePieces [0] = getImageFromFile (PICSLOCATION + "whiteRook.png");
      whitePieces [1] = getImageFromFile (PICSLOCATION + "whiteKnight.png");
      whitePieces [2] = getImageFromFile (PICSLOCATION + "whiteBishop.png");
      whitePieces [3] = getImageFromFile (PICSLOCATION + "whiteQueen.png");
      whitePieces [4] = getImageFromFile (PICSLOCATION + "whiteKing.png");
      whitePieces [5] = whitePieces[2]; //another bishop
      whitePieces [6] = whitePieces[1]; //another knight
      whitePieces [7] = whitePieces[0]; //another rook
      whitePieces [8] = getImageFromFile (PICSLOCATION + "whitePawn.png");

      return whitePieces; 
   }
   
   
   public static Image [] getBlackPieces () throws Exception{
      Image [] blackPieces = new Image[9];
      blackPieces [0] = getImageFromFile (PICSLOCATION + "blackRook.png");
      blackPieces [1] = getImageFromFile (PICSLOCATION + "blackKnight.png");
      blackPieces [2] = getImageFromFile (PICSLOCATION + "blackBishop.png");
      blackPieces [3] = getImageFromFile (PICSLOCATION + "blackQueen.png");
      blackPieces [4] = getImageFromFile (PICSLOCATION + "blackKing.png");
      blackPieces [5] = blackPieces[2]; //another bishop
      blackPieces [6] = blackPieces[1]; //another knight
      blackPieces [7] = blackPieces[0]; //another rook
      blackPieces [8] = getImageFromFile (PICSLOCATION + "blackPawn.png");

      return blackPieces; 
   }
   
   public static Image getImageFromFile (String filePath) throws Exception {
      File f = new File (filePath);
      Image img = ImageIO.read(f);
      return img;
   }
   
   
}

class Position {
   //lower case chars represent black pieces
   //upper case chars represent white pieces
   //ex: R is a white rook, n is a black knight 
   private char[][] boardState;
   private boolean whiteToMove;
   
   public Position() {
      boardState = new char[8][8];
      whiteToMove = true;
      
      boardState[0][0] = 'r';
      boardState[0][1] = 'n';
      boardState[0][2] = 'b';
      boardState[0][3] = 'q';
      boardState[0][4] = 'k';
      boardState[0][5] = 'b';
      boardState[0][6] = 'n';
      boardState[0][7] = 'r';
      
      boardState[1][0] = 'p';
      boardState[1][1] = 'p';
      boardState[1][2] = 'p';
      boardState[1][3] = 'p';
      boardState[1][4] = 'p';
      boardState[1][5] = 'p';
      boardState[1][6] = 'p';
      boardState[1][7] = 'p';
      
      boardState[7][0] = 'R';
      boardState[7][1] = 'N';
      boardState[7][2] = 'B';
      boardState[7][3] = 'Q';
      boardState[7][4] = 'K';
      boardState[7][5] = 'B';
      boardState[7][6] = 'N';
      boardState[7][7] = 'R';
      
      boardState[6][0] = 'P';
      boardState[6][1] = 'P';
      boardState[6][2] = 'P';
      boardState[6][3] = 'P';
      boardState[6][4] = 'P';
      boardState[6][5] = 'P';
      boardState[6][6] = 'P';
      boardState[6][7] = 'P';
 
   
   }
   
   




}

