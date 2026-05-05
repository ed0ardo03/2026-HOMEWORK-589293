package ambienti;

import attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	
	private String chiave;
	private String direzioneBloccata;

	public StanzaBloccata(String nome, String direzione, String chiave) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.chiave = chiave;
	}
	
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	
	@Override
	public String[] getDirezioni() {
		
		if(this.hasAttrezzo(chiave)) {
			return super.getDirezioni();
		}else {
			String[] direzioniAmmissibili = new String[this.getNumeroStanzeadiacenti()-1];
			String[] direzioniTot = super.getDirezioni();
			for(int i = 0; i < this.getNumeroStanzeadiacenti(); i++) {
				if(direzioniTot[i] != null && !direzioniTot[i].equals(direzioneBloccata)) {
					direzioniAmmissibili[i] = direzioniTot[i];
				}
			}
			return direzioniAmmissibili;
		}
    }
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(chiave)) {
			return super.toString();
		}else return this.toString();
    }
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
    	risultato.append(this.getNome());
    	risultato.append("\nUscite: ");
    	for (String direzione : super.getDirezioni())
    		if (direzione!=null) {
    			if(!direzione.equals(direzioneBloccata)) {
    				risultato.append(" " + direzione);
    			}else {
    				risultato.append("direzione "+ this.direzioneBloccata +  " pericolosa è vietata");
    			}
    			
    		}
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.getAttrezzi()) {
    		if(attrezzo != null)
    		risultato.append(attrezzo.toString()+" ");
    	}
    	return risultato.toString();
	}
	
	@Override
	public int getNumeroStanzeadiacenti() {
		if(this.hasAttrezzo(chiave)) {
			return super.getNumeroStanzeadiacenti();
		}else {
			return super.getNumeroStanzeadiacenti()-1;
		}
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.hasAttrezzo(chiave)) {
			return super.getStanzaAdiacente(direzione);
		}else {
			if(direzione.equals(direzioneBloccata)) {
				return this;
			}else return super.getStanzaAdiacente(direzione);
		}
	}
	
}
