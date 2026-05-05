package comandi;

import attrezzi.Attrezzo;
import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoPrendi implements Comando{
	private IO IO; 
	private String parametro;
	private static final String nome = "Prendi";

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(this.parametro);
		
		if(partita.getStanzaCorrente().removeAttrezzo(a)) {
			
			if(!partita.getGiocatore().getBorsa().addAttrezzo(a)) {
				partita.getStanzaCorrente().addAttrezzo(a);
				this.IO.mostraMessaggio("Non hai preso: " + parametro);
			}else {
				this.IO.mostraMessaggio("Hai preso: " + parametro);
			}
		}else this.IO.mostraMessaggio("Non hai preso: " + parametro);
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.parametro = parametro;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.parametro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public void setIOConsole(IO C) {
		// TODO Auto-generated method stub
		this.IO = C;
	}

}
