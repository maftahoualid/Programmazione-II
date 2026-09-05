package it.univr.chat;

import java.util.Iterator;

public class Chat implements Iterable<String> {
	private final String[] messages = new String[100];
	private int pos; // indice del prossimo elemento libero di messages

	public void add(String author, String message) {
		if (pos < messages.length)
			messages[pos++] = author + ": " + message;
	}

	public Iterator<String> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<String> {
		private int cursor;

		public boolean hasNext() {
			return cursor < pos;
		}

		public String next() {
			return messages[cursor++];
		}
	}

	public static void main(String[] args) {
		Chat chat = new Chat();
		chat.add("Fausto", "Buongiorno");
		chat.add("Giorgio", "Fa freddo");
		chat.add("Fausto", "meno di ieri");
		chat.add("Giorgio", "addio");
		
		for (String m: chat)
			System.out.println(m);
	}
}
