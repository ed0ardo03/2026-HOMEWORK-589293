package comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.IOConsole;
import diadia.Partita;

class ComandoVaiTest {
	
	private ComandoVai c;
	private Partita p;
	
	
	@BeforeEach
	public void setup() {
		this.p = new Partita();
		this.c = new ComandoVai();
		this.c.setIOConsole(new IOConsole());
	}

	@Test
	void testEseguiSuccesso() {
		
		assertEquals("vai", c.getNome());
		
		c.setParametro("nord");
		c.esegui(p);
		
		assertEquals("Biblioteca", p.getStanzaCorrente().getNome());             
	}
	
	@Test
	void testEseguiFallimento() {
		
		c.setParametro("sord");
		c.esegui(p);
		
		assertNotEquals("Biblioteca", p.getStanzaCorrente().getNome()); 
		assertEquals("Atrio", p.getStanzaCorrente().getNome());
	}
	
	@Test
	void testEseguiFallimentoNull() {
		
		c.setParametro(null);
		c.esegui(p);
		
		assertNotEquals("Biblioteca", p.getStanzaCorrente().getNome()); 
		assertEquals("Atrio", p.getStanzaCorrente().getNome()); 
	}
	
	

}
