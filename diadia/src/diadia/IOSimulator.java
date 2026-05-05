package diadia;

public class IOSimulator implements IO{
	
	private String[] comandi;
	private int numComandi;
	private String messaggio;
	private String[] outputComandi;
	private int numOutputComandi;
	private int numOutputComandoni;
	
	
	public IOSimulator(String[] c) {
		this.messaggio = null;
		this.numComandi = 0;
		this.numOutputComandi = 0;
		this.outputComandi = new String[100];
		this.comandi = c;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		
		if(messaggio!=null) {
			outputComandi[numOutputComandi] = messaggio;
			numOutputComandi++;
		}
		
	}

	@Override
	public String leggiRiga() {
		
		
		this.messaggio = comandi[numComandi];
		numComandi++;
		
		return this.messaggio;
		
	}

	
	
	public String leggiOutput() {
		String messaggione = outputComandi[numOutputComandoni];
		numOutputComandoni++;
		
		return messaggione;
	}
}
