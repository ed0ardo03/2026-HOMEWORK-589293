package diadia;
import ambienti.Labirinto;
import ambienti.Stanza;
import giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  Edoardo Marinucci
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private boolean finita;
	private Giocatore giocatore;
	
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.finita = false;
		this.giocatore = new Giocatore();
		this.stanzaCorrente = this.labirinto.getStanzaIniziale();
	}
	
	public String getDescrizione() {
		StringBuilder risultato = new StringBuilder();
		
		risultato.append("\nLa partita è ancora in corso, ecco lo stato:\n");
		risultato.append(this.getGiocatore().getBorsa().toString());
		risultato.append("\nCFU rimanenti: " + getGiocatore().getCfu());
		return risultato.toString();
	}
	

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== labirinto.getStanzaFinale();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}	
	
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public boolean giocatoreIsVivo() {
		
		return this.giocatore.getCfu() > 0;
	}
}
