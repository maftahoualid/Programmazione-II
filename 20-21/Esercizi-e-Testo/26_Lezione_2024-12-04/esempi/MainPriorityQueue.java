package it.univr.collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class MainPriorityQueue {

	public static void main(String[] args) {
		Queue<String> q1 = new PriorityQueue<String>();
		q1.add("ciao");
		q1.add("amico");
		q1.add("come va?");
		q1.add("ancora qui?");
		String s;
		while ((s = q1.poll()) != null)
			System.out.println(s);
	}

}
