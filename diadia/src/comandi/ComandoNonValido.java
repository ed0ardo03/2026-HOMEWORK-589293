package comandi;

import diadia.IOConsole;
import diadia.IO;
import diadia.Partita;

public class ComandoNonValido implements Comando{
	private IO IO; 
	private String parametro;
	private static final String nome = "ComandoNonValido";

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		
			IO.mostraMessaggio("Comando non valido!");
		
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
