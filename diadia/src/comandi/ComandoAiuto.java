package comandi;

import diadia.IOConsole;
import diadia.IO;
import diadia.Partita;

public class ComandoAiuto implements Comando{
	
	private IO IO; 
	private String parametro;
	private static final String nome = "Aiuto";
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		for(int i=0; i< elencoComandi.length; i++) 
			this.IO.mostraMessaggio(elencoComandi[i]+" ");
		this.IO.mostraMessaggio(" ");
		
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
