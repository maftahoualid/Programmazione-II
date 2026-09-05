package it.univr.life;

public class MainGameOfLifeLambda {

	public static void main(String[] args) throws InterruptedException {
		Board board = new Board(40, 20, 100);
		NextAliveProcessor processor = (x, y) -> {
			int neighbors = countNeighbors(board, x, y);
			boolean isAlive = board.isAliveAt(x, y);
			if (isAlive && neighbors < 2)
				return false;
			if (isAlive && neighbors >= 2 && neighbors <= 3)
				return true;
			if (isAlive && neighbors > 3)
				return false;
			if (!isAlive && neighbors == 3)
				return true;
			
			return false;
		};
		
		board.play(processor);
	}

	private static int countNeighbors(Board board, int x, int y) {
		int counter = 0;
		for (int xx = x - 1; xx <= x + 1; xx++) {
			for (int yy = y - 1; yy <= y + 1; yy++) {
				if (xx >= 0 && xx < board.getWidth() && yy >= 0 && yy < board.getHeight() &&
						(xx != x || yy != y) && board.isAliveAt(xx, yy))
					counter++;
			}
		}
		
		return counter;
	}
}
