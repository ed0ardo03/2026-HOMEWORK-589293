package comandi;

import ambienti.Stanza;
import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoVai implements Comando {
	private String direzione;
	private static final String nome = "vai";
	private IO io;
	
	

	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

/**
* esecuzione del comando
*/
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.direzione == null) {
			io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			io.mostraMessaggio("direzione inesistente");
			return;
		}
		
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		
	}

	@Override
	public String getParametro() {
	// TODO Auto-generated method stub
		
		return this.direzione;
	}

	@Override
	public String getNome() {
	// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public void setIOConsole(IO C) {
	// TODO Auto-generated method stub
		this.io = C;
	}
}
