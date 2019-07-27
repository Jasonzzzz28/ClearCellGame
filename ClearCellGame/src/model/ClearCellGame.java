package model;

import java.util.Random;

/* This class must extend Game */
public class ClearCellGame extends Game {
    private Random rnd;
	private int Stgy;
	private int rows;
	private int cols;
	private int score;
	public ClearCellGame(int maxRows,int maxCols,Random random, int strategy) {
    	super(maxRows,maxCols);
    	super.setBoardWithColor(BoardCell.EMPTY);
    	this.rnd= random;
    	this.Stgy=strategy;
    	rows=maxRows;
    	cols=maxCols;
    	score =0; 		
    }
	public boolean isGameOver() {
		    int count=0;
		    for (int k=0;k<board[board.length-1].length;k++) {
		    	if(board[board.length-1][k]==BoardCell.EMPTY) {
		    		count++;
		    	}
		    }
		   
		    return !(count==board[board.length-1].length);
		    
		
	}
	public int getScore() {
		
		return score;
	}
	public void nextAnimationStep() {
		if (!this.isGameOver()) {
			
			BoardCell[][] newboard=new BoardCell[rows][cols];
			for (int n=0; n<board[0].length;n++) {
				newboard[0][n]=BoardCell.getNonEmptyRandomBoardCell(rnd);
			}
			for (int i=0;i<board.length-1;i++) {
			    for (int k=0;k<board[i].length;k++) {
			    	
			    	newboard[i+1][k]=super.board[i][k];
			    }
			}
			super.board=newboard;
			
		}
	}
	
	public void processCell(int rowIndex,int colIndex) {
	   if(!this.isGameOver()) {
		BoardCell x=board[rowIndex][colIndex];
		board[rowIndex][colIndex]=BoardCell.EMPTY;
		score++;
		int c=colIndex;
		while (c>0) {
			if (board[rowIndex][--c]==x) {
			   board[rowIndex][c]=BoardCell.EMPTY;
			   score++;
			}
			else {
				c=0;
			}
		}
		int c1=colIndex;
		while(c1<board[rowIndex].length-1) {
			if (board[rowIndex][++c1]==x) {
			   board[rowIndex][c1]=BoardCell.EMPTY;
			   score++;
			}
			else {
				c1=board[rowIndex].length;
			}
		}
		int r=rowIndex; 
		while (r>0) {
			if (board[--r][colIndex]==x) {
			   board[r][colIndex]=BoardCell.EMPTY;
			   score++;
			}
			else {
				r=0;
			}
		}
		int r1=rowIndex;
		while(r1<board.length-1) {
			if(board[++r1][colIndex]==x) {
			   board[r1][colIndex]=BoardCell.EMPTY;
			   score++;
			}
			else {
				r1=board.length;
			}
		}
		int r2=rowIndex; int c2=colIndex;
		while(r2>0 & c2>0) {
			if(board[--r2][--c2]==x) {
				board[r2][c2]=BoardCell.EMPTY;
				score++;
			}
			else {
				r2=0;
			}
		}
		int r3=rowIndex; int c3=colIndex;
		while(r3<board.length-1 & c3<board[rowIndex].length-1) {
			if (board[++r3][++c3]==x) {
				board[r3][c3]=BoardCell.EMPTY;
				score++;
			}
			else {
				r3=board.length;
			}
		}
		BoardCell[][] newboard=new BoardCell[rows][cols];
		int i=0;
		while (i<board.length-1) {
		    boolean mark=true; 
			for (int k=0;k<board[i].length;k++) {
		    	if(board[i][k]!=BoardCell.EMPTY) {
		    		mark=false;
		    	}
		    }
			if(mark) {
				
				for (int v=0; v<i;v++) {
					for(int y=0; y<board[i].length;y++) {
						newboard[v][y]=board[v][y];
					}
				}
				for(int v=i;v<board.length;v++) {
					for (int y=0; y<board[i].length;y++) {
						newboard[v][y]=BoardCell.EMPTY;
					}
				}
				for (int m=i;m<board.length-1;m++) {
				    for (int n=0;n<board[i].length;n++) {
				    	newboard[m][n]=board[m+1][n];
				    }
				}
				board=newboard;
			
			}
			i++;
		}
	   } 
		
	}
}