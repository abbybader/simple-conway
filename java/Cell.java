package problems.conways;

public class Cell {
	
	private boolean isLive;

	
	public Cell(boolean isLive) {
		this.isLive = isLive;
	}
	
	public boolean shouldDie(int numNeighbors) {	
		return isLive && ( numNeighbors < 2 || numNeighbors > 3);
	}
	
	public boolean shouldComeToLife(int numNeighbors) {
		return !isLive && numNeighbors == 3;
	}
	
	public void toggleLifeStatus() {
		if (isLive) {
			isLive = false;
		}
		else {
			isLive = true;
		}
	}
	
	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	
	@Override
	public String toString() {
		if (isLive()) {
			return "1";
		}
		return "0";
	}

}
