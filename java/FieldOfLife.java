package problems.conways;

import java.util.ArrayList;
import java.util.Collection;

public class FieldOfLife {
	
	private static int[][] spinnerBoard = {
		{ 0, 0, 0, 0, 0 },
		{ 0, 0, 1, 0, 0 },
		{ 0, 0, 1, 0, 0 },
		{ 0, 0, 1, 0, 0 },
		{ 0, 0, 0, 0, 0 }
	};
	
	private static int[][] rallyBoard = {
		{ 0, 1, 0, 0, 0 },
		{ 1, 0, 0, 1, 1 },
		{ 1, 1, 0, 0, 1 },
		{ 0, 1, 0, 0, 0 },
		{ 1, 0, 0, 0, 1 }
	};
	
	private static int[][] bigBoard = {
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
		{ 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1 },
		{ 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
		{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
		{ 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1 },
		{ 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
		{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
		{ 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1 },
		{ 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
		{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
		{ 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1 },
		{ 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
		{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
		{ 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1 },
		{ 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1 },
		{ 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 },
		{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1 }
	};
	
	public static void main(String[] args) {
		
//		FieldOfLife game = new FieldOfLife(bigBoard);
		FieldOfLife game = new FieldOfLife(rallyBoard);
//		FieldOfLife game = new FieldOfLife(spinnerBoard);
			
		for (int i=0; i<7; i++) {
			System.out.println("Generation " + i + ":");
			System.out.println(game + "\n");
			game.incrementGeneration();
		}		
	}

	private Cell[][] board;
	private int rows = -1;
	private int cols = -1;
	
	public FieldOfLife(int[][] input) {
		createBoard(input);
		populateBoard(input);
	}

	public void incrementGeneration() {
		
		Collection<Cell> toUpdate = getCellsToUpdate();
		
		for (Cell cell : toUpdate) {
			cell.toggleLifeStatus();
		}
	}

	private Collection<Cell> getCellsToUpdate() {
		Collection<Cell> toUpdate = new ArrayList<Cell>();
		
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				Cell cell = board[i][j];
				if (shouldUpdate(cell, i, j) ) {
					toUpdate.add(cell);
				}
			}
		}
		return toUpdate;
	}

	private boolean shouldUpdate(Cell cell, int row, int col) {
		int liveNeighbors = getLiveNeighbors(row,col);
		if ( cell.shouldDie(liveNeighbors)) {
			return true;
		}
		if ( cell.shouldComeToLife(liveNeighbors)) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		
		for (int i=0; i<rows; i++) {
			if (i>0) {
				b.append("\n");
			}
			for (int j=0; j<cols; j++) {
				if (j>0) {
					b.append(" ");
				}
				b.append(board[i][j]);
			}
		}
		return b.toString();
		
	}
	
	private int getLiveNeighbors(int x, int y) {

		int count = 0;
		
		int north = x-1;
		int south = x+1;
		int east = y+1;
		int west = y-1;
		
		if (hasLiveNeighbor( north, west)) 	{ count++; }
		if (hasLiveNeighbor( north, y)) 	{ count++; }
		if (hasLiveNeighbor( north, east)) 	{ count++; }
		if (hasLiveNeighbor( x, west)) 		{ count++; }
		if (hasLiveNeighbor( x, east)) 		{ count++; }
		if (hasLiveNeighbor( south, west)) 	{ count++; }
		if (hasLiveNeighbor( south, y)) 	{ count++; }
		if (hasLiveNeighbor( south, east)) 	{ count++; }
		
		return count;
	}

	private boolean hasLiveNeighbor(int i, int j) {
		
		if ( 0 <= i  && i < rows) {
			if ( 0 <= j && j < cols) {
				Cell cell = board[i][j];
				return cell.isLive();
			}
		}
		return false;
	}

	private void createBoard(int[][] input) {
		rows = input.length;
		if ( rows > 0 ) {
			cols = input[0].length;
		}
		
		if ( rows <=0 || cols <= 0) {
			throw new IllegalArgumentException("Game board has illegal dimensions.");
		}
		board = new Cell[rows][cols];

	}

	private void populateBoard(int[][] input) {
		for (int i=0; i < rows; i++) {
			
			for (int j=0; j < cols; j++) {
				
				int val=input[i][j];
				boolean isLive = false;
				if (val == 1) {
					isLive = true;
				}
				board[i][j] = new Cell(isLive);
			}
		}	
	}
}
