# Laboratorio dell'8/11/2024, ore 12:30 - 14:30, aula Delta

## Informazioni sulla Lezione

- **Tipo**: Laboratorio
- **Data**: 8/11/2024
- **Orario**: 12:30 - 14:30
- **Aula**: Aula Delta

## Argomenti Trattati

Laboratorio dell’8/11/2024, ore 12:30 - 14:30, aula Delta


1. Si consideri la seguente interfaccia, che specifica un giocatore di calcio:

```java
public interface SoccerPlayer {
String toString(); // ritorna il nome del giocatore
boolean canUseHands(); // determina se il giocatore può usare le mani
}
```


Si completi la seguente implementazione di SoccerPlayer:

```java
public abstract class AbstractSoccerPlayer implements SoccerPlayer {
...
protected AbstractSoccerPlayer(String name) {
...
}
public final String toString() {
...
}
}
```


E’ possibile aggiungere campi o metodi, ma solo private. Si noti che il metodo canUseHands() non è ancora implementato in AbstractSoccerPlayer, per cui tale classe deve
essere abstract.

2. Si realizzino quattro sottoclassi concrete di AbstractSoccerPlayer, chiamate rispettivamente Forward, Midfield, Defence e GoalKeeper. Il costruttore di tali classi richiede il nome del
giocatore come parametro. Solo il GoalKeeper può usare le mani nel gioco del calcio.

3. Si completi la seguente classe, che implementa una formazione del gioco del calcio, cioè
l’insieme degli 11 giocatori che formano la squadra durante una partita.


```java
public class Formation {
...
public Formation(SoccerPlayer[] players) {
...
if (!isValid())
throw new IllegalArgumentException("invalid formation");
}
protected boolean isValid() {
// ritorna true se e solo se la formazione è fatta da 11 giocatori, di cui esattamente uno è un portiere
}
protected SoccerPlayer[] getPlayers() {
// ritorna i giocatori di questa formazione
}
public final String toString() {
// ritorna i nomi dei giocatori della formazione, separati da virgola
}
}
```



4. Si implementi una sottoclasse concreta di Formation, chiamata Formation433, che, per essere valida, deve essere composta da 4 difensori, 3 centrocampisti e 3 attaccanti, oltre ovviamente a un portiere. L’implementazione di isValid() dovrà quindi cambiare per questa
sottoclasse.

5. Si scriva una classe di prova Main con un metodo main() che crea 11 giocatori: 4 difensori
(Alex Sandro, Rugani, Chiellini e Dani Alves), 3 centrocampisti (Fabinho, Iniesta, Pjanic), 3 attaccanti (Dybala, Higuain, Bernardeschi) e un portiere (Szczesny). Poi crea una Formation433,
passando tali giocatori al costruttore, e la stampa.

## Materiali Didattici ed Esercizi

### Soluzione

- 💻 [**`AbstractSoccerPlayer.java`**](soluzione/AbstractSoccerPlayer.java)
- 💻 [**`Defence.java`**](soluzione/Defence.java)
- 💻 [**`Formation.java`**](soluzione/Formation.java)
- 💻 [**`Formation433.java`**](soluzione/Formation433.java)
- 💻 [**`Forward.java`**](soluzione/Forward.java)
- 💻 [**`GoalKeeper.java`**](soluzione/GoalKeeper.java)
- 💻 [**`Main.java`**](soluzione/Main.java)
- 💻 [**`Midfield.java`**](soluzione/Midfield.java)
- 💻 [**`SoccerPlayer.java`**](soluzione/SoccerPlayer.java)

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
    <a href="../18_Lezione_2024-11-06/README.md" style="color: #0969da; text-decoration: none;" title="Lezione del 6/11/2024, ore 13:30 - 14:30, aula Magna">← Prec</a>
    <span style="color: #d0d7de;">|</span>
    <a href="../20_Lezione_2024-11-13/README.md" style="color: #0969da; text-decoration: none;" title="Lezione del 13/11/2024, ore 13:30 - 14:30, aula Magna">Succ →</a>
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
    <li style="margin: 2px 0; font-weight: 600; color: #0969da; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio dell'8/11/2024, ore 12:30 - 14:30, aula Delta">19. Lab 08/11</li>
    <li style="margin: 2px 0;"><a href="../20_Lezione_2024-11-13/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 13/11/2024, ore 13:30 - 14:30, aula Magna">20. 13/11</a></li>
    <li style="margin: 2px 0;"><a href="../21_Lezione_2024-11-14/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Lezione del 14/11/2024, ore 13:30 - 15:30, aula Magna">21. 14/11</a></li>
    <li style="margin: 2px 0;"><a href="../22_Laboratorio_2024-11-15/README.md" style="color: #656d76; text-decoration: none; display: block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;" title="Laboratorio del 15/11/2024, ore 12:30 - 14:30, aula Delta">22. Lab 15/11</a></li>
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
