package model;


public abstract class Game {
	protected BoardCell[][] board;

	/**
	 * Defines a board with BoardCell.EMPTY cells.
	 * 
	 * @param maxRows
	 * @param maxCols
	 */
	private int rows;
	private int cols; 
	
	public Game(int maxRows, int maxCols) {
		this.rows=maxRows;
		this.cols=maxCols;
		this.board=new BoardCell[maxRows][maxCols];
	}

	public int getMaxRows() {
		return rows;
	}

	public int getMaxCols() {
		return cols;
	}

	public void setBoardCell(int rowIndex, int colIndex, BoardCell boardCell) {
		this.board[rowIndex][colIndex]=boardCell;
	}

	public BoardCell getBoardCell(int rowIndex, int colIndex) {
		return this.board[rowIndex][colIndex];
	}

	/**
	 * Initializes row with the specified color.
	 * @param rowIndex
	 * @param cell
	 */
	public void setRowWithColor(int rowIndex, BoardCell cell) {
	    for (int i=0;i<this.board[rowIndex].length;i++) {
	    	this.board[rowIndex][i]=cell;
	    }
	}
	
	/**
	 * Initializes column with the specified color.
	 * @param colIndex
	 * @param cell
	 */
	public void setColWithColor(int colIndex, BoardCell cell) {
		for (int i=0;i<this.board.length;i++) {
			this.board[i][colIndex]=cell;
		}
	}
	
	/**
	 * Initializes the board with the specified color.
	 * @param cell
	 */
	public void setBoardWithColor(BoardCell cell) {
		for (int i=0;i<this.board.length;i++) {
		    for (int k=0;k<this.board[i].length;k++) {
		    	this.board[i][k]=cell;
		    }
		}
	}
	
	public abstract boolean isGameOver();

	public abstract int getScore();

	/**
	 * Advances the animation one step.
	 */
	public abstract void nextAnimationStep();

	/**
	 * Adjust the board state according to the current board state and the
	 * selected cell.
	 * 
	 * @param rowIndex
	 * @param colIndex
	 */
	public abstract void processCell(int rowIndex, int colIndex);
}
