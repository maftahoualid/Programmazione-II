package it.univr.life;

public class MainConstant {

	public static void main(String[] args) throws InterruptedException {
		Board board = new Board(40, 20, 100);
		NextAliveProcessor processor = new Constant(board); 
		board.play(processor);
	}

	private static class Constant implements NextAliveProcessor {
		private final Board board;

		private Constant(Board board) {
			this.board = board;
		}

		public boolean isAliveNextAt(int x, int y) {
			return board.isAliveAt(x, y);
		}
	}
}
