# Laboratorio del 15/11/2024, ore 12:30 - 14:30, aula Delta

## Informazioni sulla Lezione

- **Tipo**: Laboratorio
- **Data**: 15/11/2024
- **Orario**: 12:30 - 14:30
- **Aula**: Aula Delta

## Argomenti Trattati

1. Si crei un progetto Eclipse e si copi al suo interno la seguente interfaccia, che rappresenta un
numero non negativo, in una qualsiasi base di numerazione:

```java
public interface Number extends Comparable<Number> {
int getValue(); // restituisce il valore di questo numero
}
```



2. Si completi la seguente implementazione astratta di un Number, che fornisce le funzionalità
comuni a tutti i numeri, cioè il controllo sulla non negatività del valore, l’accesso al valore, la
traduzione in stringa e il metodo per il test di uguaglianza:

```java
public abstract class AbstractNumber implements Number {
private final int value;
protected AbstractNumber(int value) {
// se value è negativo, esegue throw new IllegalArgumentException(); altrimenti inizializza il campo value
...
}
// restituisce il valore di questo numero
public final int getValue() { ... }
// restituice la base di numerazione di questo numero
protected abstract int getBase();
// restituisce il carattere che rappresenta la cifra "digit" nella base di numerazione
// di questo numero. Sarà sempre vero che 0 <= digit < getBase();
// per esempio, in base sedici si avrà getCharForDigit(10) == 'A' e
// in base otto si avrà getCharForDigit(7) == '7'
protected abstract char getCharForDigit(int digit);
// restituisce una stringa che rappresenta il numero nella sua base di numerazione
public String toString() { ... }

public final boolean equals(Object other) {
// due numeri sono uguali se e solo se hanno lo stesso valore
...
}
public final int compareTo(Number other) {
// l'ordinamento fra i Number è quello crescente per valore
...
}
}
```



3. Si scrivano le sottoclassi concrete DecimalNumber, BinaryNumber, OctalNumber ed HexNumber di AbstractNumber, che rappresentano, rispettivamente, un numero in base 10, 2, 8 e

16. Queste classi si instanziano con il loro costruttore, a cui viene passato il valore del numero. Non si ridefinisca, in queste quattro sottoclassi, il metodo toString(): quello ereditato
da AbstractNumber dovrà funzionare per tutte queste sottoclassi, traducendo il valore del
numero nella giusta base di numerazione.

4. Nella codifica binaria con parità, un numero binario viene esteso con un’ulteriore cifra binaria
di controllo, in modo da rendere pari il numero totale di cifre 1. Se quindi il numero binario
aveva una quantità pari di 1, si aggiungerà una cifra di controllo 0. Se invece il numero binario
aveva una quantità dispari di 1, si aggiungerà una cifra di controllo 1. Questa modifica riduce il
rischio di trasmissione di dati corrotti, permettendo di implementare un rudimentale sistema
di rilevazione dell’errore. Si implementi una sottoclasse concreta BinaryNumberWithParity
di BinaryNumber, ridefinendo solo il metodo toString() in modo da aggiungere in fondo la
cifra di controllo opportuna.

5. Nella codifica in base 58, si utilizzano 58 cifre diverse, scelte fra i numeri arabi e le lettere inglesi maiuscole e minuscole. Si evitano i caratteri 0OIl, che potrebbero essere confusi
a video, perché graficamente simili. Si implementi una sottoclasse concreta Base58Number
di AbstractNumber, in modo da implementare questa numerazione in base 58. Le 58 cifre sono quindi 123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz. Non si
ridefinisca il metodo toString() ereditato da AbstractNumber.

6. Si scriva una classe di prova MainNumbers con un metodo main() che chiede all’utente di
inserire un numero non negativo n, quindi crea il numero n in base 10, poi in base 2, poi in
base 2 con parità, poi in base 8, poi in base 16 e infine in base 58, stampando tutti tali numeri.
Se per esempio l’utente inserisse il numero 1234567, il main() dovrà stampare:
12D687
7Kze


7. Si scriva una classe di prova MainNumbersSort con un metodo main() che crea un array di
Number contenente esattamente sei elementi:
- `2024 in base 10`
- `113 in base 2`
- `158 in base 2 con parità`
- `827 in base 8`
- `2066 in base 16`
- `8092 in base 58 Quindi ordina l’array con java.util.Arrays.sort(...) e lo stampa sfruttando java.util.Arrays.toString(...).`

## Materiali Didattici ed Esercizi

### Soluzione

- 💻 [**`AbstractNumber.java`**](soluzione/AbstractNumber.java)
- 💻 [**`Base58Number.java`**](soluzione/Base58Number.java)
- 💻 [**`BinaryNumber.java`**](soluzione/BinaryNumber.java)
- 💻 [**`BinaryNumberWithParity.java`**](soluzione/BinaryNumberWithParity.java)
- 💻 [**`DecimalNumber.java`**](soluzione/DecimalNumber.java)
- 💻 [**`HexNumber.java`**](soluzione/HexNumber.java)
- 💻 [**`MainNumbers.java`**](soluzione/MainNumbers.java)
- 💻 [**`MainNumbersSort.java`**](soluzione/MainNumbersSort.java)
- 💻 [**`Number.java`**](soluzione/Number.java)
- 💻 [**`OctalNumber.java`**](soluzione/OctalNumber.java)

<style>
  body, .markdown-body, #_html {
    padding-right: 160px !important;
  }
  nav.lesson-nav ul::-webkit-scrollbar {
    width: 3px;
  }
  nav.lesson-nav ul::-webkit-scrollbar-thumb {
    background: #d0d7de;
    border-radius: 3px;
  }
  nav.lesson-nav ul::-webkit-scrollbar-track {
    background: transparent;
  }
</style>
<nav class="lesson-nav" style="position: fixed; top: 24px; right: 20px; width: 125px; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Noto Sans', Helvetica, Arial, sans-serif; font-size: 11px; line-height: 1.45; border-left: 1px solid #d0d7de; padding-left: 10px; z-index: 100;">
  <div style="margin-bottom: 6px; display: flex; justify-content: space-between; align-items: center;">
    <span style="text-transform: uppercase; font-size: 10px; font-weight: 600; letter-spacing: 0.5px; color: #656d76;">Lezioni</span>
    <a href="../README.md" style="color: #0969da; font-size: 10px; text-decoration: none;">Indice ↗</a>
  </div>
  <div style="display: flex; gap: 8px; margin-bottom: 8px; font-size: 10px; color: #656d76;">
    <a href="../21_Lezione_2024-11-14/README.md" style="color: #0969da; text-decoration: none;" title="Lezione del 14/11/2024, ore 13:30 - 15:30, aula Magna">← Prec</a>
    <span style="color: #d0d7de;">|</span>
    <a href="../23_Lezione_2024-11-20/README.md" style="color: #0969da; text-decoration: none;" title="Lezione del 20/11/2024, ore 13:30 - 14:30, aula Magna">Succ →</a>
  </div>
  <ul style="list-style: none; margin: 0; padding: 0; max-height: calc(100vh - 80px); overflow-y: auto; scrollbar-width: thin;">
    <li style="margin: 2px 0;"><a href="../01_Introduzione/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Programmazione II - Introduzione">01. Intro</a></li>
    <li style="margin: 2px 0;"><a href="../02_Lezione_2024-10-02/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 2/10/2024, 13:30 - 14:30, aula Magna">02. 02/10</a></li>
    <li style="margin: 2px 0;"><a href="../03_Lezione_2024-10-03/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 3/10/2024, ore 16:30 - 18:30, aula Magna">03. 03/10</a></li>
    <li style="margin: 2px 0;"><a href="../04_Laboratorio_2024-10-04/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 4/10/2024, 12:30 - 14:30, aula Delta">04. Lab 04/10</a></li>
    <li style="margin: 2px 0;"><a href="../05_Lezione_2024-10-04/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 4/10/2024, ore 17:30 - 18:30, aula Tessari">05. 04/10</a></li>
    <li style="margin: 2px 0;"><a href="../06_Lezione_2024-10-09/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 9/10/2024, ore 13:30 - 14:30, aula Magna">06. 09/10</a></li>
    <li style="margin: 2px 0;"><a href="../07_Lezione_2024-10-10/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 10/10/2024, ore 16:00 - 18:00, aula Magna">07. 10/10</a></li>
    <li style="margin: 2px 0;"><a href="../08_Laboratorio_2024-10-11/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 11/10/2024, ore 12:30 - 14:30, aula Delta">08. Lab 11/10</a></li>
    <li style="margin: 2px 0;"><a href="../09_Lezione_2024-10-11/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione dell'11/10/2024, ore 14:30 - 15:30, aula Delta">09. 11/10</a></li>
    <li style="margin: 2px 0;"><a href="../10_Lezione_2024-10-16/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 16/10/2024, ore 13:30 - 14:30, aula Magna">10. 16/10</a></li>
    <li style="margin: 2px 0;"><a href="../11_Lezione_2024-10-17/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 17/10/2024, ore 13:30 - 16:30, aula Magna">11. 17/10</a></li>
    <li style="margin: 2px 0;"><a href="../12_Laboratorio_2024-10-18/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 18/10/2024, ore 12:30 - 14:30, aula Delta">12. Lab 18/10</a></li>
    <li style="margin: 2px 0;"><a href="../13_Lezione_2024-10-23/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 23/10/2024, ore 13:30 - 14:30, aula Magna">13. 23/10</a></li>
    <li style="margin: 2px 0;"><a href="../14_Lezione_2024-10-24/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 24/10/2024, ore 16:30 - 18:30, aula Magna">14. 24/10</a></li>
    <li style="margin: 2px 0;"><a href="../15_Laboratorio_2024-10-25/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 25/10/2024, ore 12:30 - 14:30, aula Delta">15. Lab 25/10</a></li>
    <li style="margin: 2px 0;"><a href="../16_Lezione_2024-10-30/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 30/10/2024, ore 13:30 - 14:30, aula Magna">16. 30/10</a></li>
    <li style="margin: 2px 0;"><a href="../17_Lezione_2024-10-31/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 31/10/2024, ore 16:30 - 18:30, aula Magna">17. 31/10</a></li>
    <li style="margin: 2px 0;"><a href="../18_Lezione_2024-11-06/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 6/11/2024, ore 13:30 - 14:30, aula Magna">18. 06/11</a></li>
    <li style="margin: 2px 0;"><a href="../19_Laboratorio_2024-11-08/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio dell'8/11/2024, ore 12:30 - 14:30, aula Delta">19. Lab 08/11</a></li>
    <li style="margin: 2px 0;"><a href="../20_Lezione_2024-11-13/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 13/11/2024, ore 13:30 - 14:30, aula Magna">20. 13/11</a></li>
    <li style="margin: 2px 0;"><a href="../21_Lezione_2024-11-14/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 14/11/2024, ore 13:30 - 15:30, aula Magna">21. 14/11</a></li>
    <li style="margin: 2px 0; font-weight: 600; color: #0969da; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 15/11/2024, ore 12:30 - 14:30, aula Delta">22. Lab 15/11</li>
    <li style="margin: 2px 0;"><a href="../23_Lezione_2024-11-20/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 20/11/2024, ore 13:30 - 14:30, aula Magna">23. 20/11</a></li>
    <li style="margin: 2px 0;"><a href="../24_Lezione_2024-11-21/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 21/11/2024, ore 16:30 - 18:30, aula Magna">24. 21/11</a></li>
    <li style="margin: 2px 0;"><a href="../25_Laboratorio_2024-11-22/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 22/11/2024, ore 12:30 - 14:30, aula Delta">25. Lab 22/11</a></li>
    <li style="margin: 2px 0;"><a href="../26_Lezione_2024-12-04/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 4/12/2024, ore 13:30 - 14:30, aula Magna">26. 04/12</a></li>
    <li style="margin: 2px 0;"><a href="../27_Lezione_2024-12-05/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 5/12/2024, ore 16:30 - 18:30, aula Magna">27. 05/12</a></li>
    <li style="margin: 2px 0;"><a href="../28_Laboratorio_2024-12-06/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 6/12/2024, ore 12:30 - 14:30, aula Delta">28. Lab 06/12</a></li>
    <li style="margin: 2px 0;"><a href="../29_Lezione_2024-12-11/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione dell'11/12/2024, ore 13:30 - 14:30, aula Magna">29. 11/12</a></li>
    <li style="margin: 2px 0;"><a href="../30_Lezione_2024-12-12/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 12/12/2024, ore 16:30 - 18:30, aula Magna">30. 12/12</a></li>
    <li style="margin: 2px 0;"><a href="../31_Laboratorio_2024-12-13/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 13/12/2024, ore 12:30 - 14:30, aula Delta">31. Lab 13/12</a></li>
    <li style="margin: 2px 0;"><a href="../32_Lezione_2024-12-18/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 18/12/2024, ore 13:30 - 14:30, aula Magna">32. 18/12</a></li>
    <li style="margin: 2px 0;"><a href="../33_Laboratorio_2024-12-18/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 18/12/2024, ore 16:30 - 18:30, aula Delta">33. Lab 18/12</a></li>
    <li style="margin: 2px 0;"><a href="../34_Lezione_2024-12-19/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 19/12/2024, ore 16:30 - 18:30, aula Magna">34. 19/12</a></li>
    <li style="margin: 2px 0;"><a href="../35_Laboratorio_2024-12-20/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 20/12/2024, ore 12:30 - 14:30, aula Delta">35. Lab 20/12</a></li>
    <li style="margin: 2px 0;"><a href="../36_Laboratorio_2025-01-10/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 10/1/2025, ore 12:30 - 14:30, aula Delta">36. Lab 10/01</a></li>
    <li style="margin: 2px 0;"><a href="../37_Laboratorio_2025-01-17/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 17/1/2025, ore 12:30 - 14:30, aula Delta">37. Lab 17/01</a></li>
    <li style="margin: 2px 0;"><a href="../38_Laboratorio_2025-01-24/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 24/1/2025, ore 12:30 - 14:30, aula Delta">38. Lab 24/01</a></li>
    <li style="margin: 2px 0;"><a href="../39_Primo_Appello_2025-02-05/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Primo Appello di Programmazione 2 del 5/2/2025, aula Delta">39. 1° Appello</a></li>
    <li style="margin: 2px 0;"><a href="../40_Secondo_Appello_2025-02-20/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Secondo Appello di Programmazione 2 del 20/2/2025, aula Delta">40. 2° Appello</a></li>
  </ul>
</nav>
