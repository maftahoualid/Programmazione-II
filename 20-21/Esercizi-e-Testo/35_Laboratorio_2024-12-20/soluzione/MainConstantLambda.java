package it.univr.life;

public class MainConstantLambda {

	public static void main(String[] args) throws InterruptedException {
		Board board = new Board(40, 20, 100);
		NextAliveProcessor processor = board::isAliveAt; //(x, y) -> board.isAliveAt(x, y); 
		board.play(processor);
	}
}
