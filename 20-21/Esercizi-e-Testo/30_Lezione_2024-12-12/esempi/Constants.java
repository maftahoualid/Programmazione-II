package it.univr.autosentences;

public abstract class Constants {

	public final static String[] REPLACEMENTS = {
		"zero", "uno", "due", "tre",
		"quattro", "cinque", "sei", "sette",
		"otto", "nove", "dieci", "undici", "dodici",
		"tredici", "quattordici", "quindici", "sedici",
		"diciassette", "diciotto", "diciannove", "venti",
		"ventuno", "ventidue", "ventitre", "ventiquattro",
	};

	public final static String FORMAT =
		"Ecco una frase che si autodescrive, infatti contiene %s 'a', %s 'e', %s 'i', %s 'o' e %s 'u': verificatelo!";
}