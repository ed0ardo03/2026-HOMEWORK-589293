package comandi;

import attrezzi.Attrezzo;
import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoPosa implements Comando{
	
	private IO IO; 
	private String parametro;
	private static final String nome = "Posa";

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Attrezzo a = partita.getGiocatore().getBorsa().removeAttrezzo(parametro);
		if(partita.getStanzaCorrente().addAttrezzo(a)) {
			this.IO.mostraMessaggio("Hai posato "+parametro);
			return;
		}else {
			if(a == null) {
				this.IO.mostraMessaggio("dammi un un attrezzo che esiste"); 
				return;
			}
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			this.IO.mostraMessaggio(parametro+ "non è presente, non lo hai posato ");
		}
		
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
