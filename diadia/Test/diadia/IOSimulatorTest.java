package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ambienti.Labirinto;
import ambienti.Stanza;
import ambienti.StanzaBloccata;
import ambienti.StanzaBuia;
import ambienti.StanzaMagica;
import attrezzi.Attrezzo;

class IOSimulatorTest {
	
	private IOSimulator ios;
	private DiaDia d;
	private Attrezzo lanterna;
	private Attrezzo osso;
	private Stanza atrio;
	private Stanza aulaN11;
	private Stanza aulaN10;
	
	
	public void setup() {
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
	
	}

	@Test
	void testVittoria() {
		String[] elencoComandi = {"vai sud", "vai nord", "vai nord"};
		this.ios = new IOSimulator(elencoComandi);
		this.d = new DiaDia(ios);
		d.gioca();
		Stanza atrio = d.getPartita().getLabirinto().getStanzaIniziale();
		
		
		assertTrue(d.getPartita().isFinita());
		assertTrue(d.getPartita().vinta());
		
		assertEquals( ""+
				"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
				"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
				"I locali sono popolati da strani personaggi, " +
				"alcuni amici, altri... chissa!\n"+
				"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
				"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
				"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
				"Per conoscere le istruzioni usa il comando 'aiuto'." , ios.leggiOutput());
		assertEquals(atrio.getDescrizione() , ios.leggiOutput());
		assertEquals(atrio.getStanzaAdiacente("sud").getDescrizione() , ios.leggiOutput());
		assertEquals(atrio.getDescrizione() , ios.leggiOutput());
		assertEquals(atrio.getStanzaAdiacente("nord").getDescrizione() , ios.leggiOutput());
	}
	
	@Test
	void testLabirintoVuoto() {
		String[] elencoComandi = {"vai sud", "vai nord", "vai nord"};
		this.ios = new IOSimulator(elencoComandi);
		Stanza atrio = new Stanza("atrio");
		Labirinto l = new Labirinto(atrio, atrio);
		
		this.d = new DiaDia(ios);
		d.getPartita().setLabirinto(l);
		d.getPartita().setStanzaCorrente(atrio);
		
		
		d.gioca();
		
		
		assertTrue(d.getPartita().isFinita());
		assertTrue(d.getPartita().vinta());
		
		assertEquals( ""+
				"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
				"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
				"I locali sono popolati da strani personaggi, " +
				"alcuni amici, altri... chissa!\n"+
				"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
				"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
				"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
				"Per conoscere le istruzioni usa il comando 'aiuto'." , ios.leggiOutput());
		assertEquals(atrio.getDescrizione() , ios.leggiOutput());
		assertEquals( "direzione inesistente" , ios.leggiOutput());
		assertEquals( "Hai Vinto" , ios.leggiOutput());
	}
	
	@Test
	void testLabirintoStanzeParticolari() {
		String[] elencoComandi = {"posa lanterna", "vai sud", "posa chiave", "vai sud", "posa pistola", "posa pistola",
				"guarda", "vai sud"};
		this.ios = new IOSimulator(elencoComandi);
		Stanza atrio = new Stanza("atrio");
		Stanza cameraDeiSegreti = new StanzaMagica("cameraDeiSegreti",1); 
		Stanza cantina = new StanzaBuia("cantina", "lanterna");
		Stanza cavo = new StanzaBloccata("cavo", "sud", "chiave");
		Attrezzo chiave = new Attrezzo("chiave", 1);
		Attrezzo lanterna = new Attrezzo("lanterna", 1);
		Attrezzo pistola = new Attrezzo("pistola", 1);	
		
		
		cantina.impostaStanzaAdiacente("sud", cavo);
		cavo.impostaStanzaAdiacente("nord", cantina);
		cavo.impostaStanzaAdiacente("sud", cameraDeiSegreti);
		cameraDeiSegreti.impostaStanzaAdiacente("nord", cavo);
		cameraDeiSegreti.impostaStanzaAdiacente("sud", atrio);
		atrio.impostaStanzaAdiacente("nord", cameraDeiSegreti);
		
		
		Labirinto l = new Labirinto(cantina, atrio);
		
		String descrizione = cavo.getDescrizione();
		String descrizioneMagica = cameraDeiSegreti.getDescrizione();
		
		
		this.d = new DiaDia(ios);
		
		d.getPartita().getGiocatore().getBorsa().addAttrezzo(pistola);
		d.getPartita().getGiocatore().getBorsa().addAttrezzo(pistola);
		d.getPartita().getGiocatore().getBorsa().addAttrezzo(lanterna);
		d.getPartita().getGiocatore().getBorsa().addAttrezzo(chiave);
		
		d.getPartita().setLabirinto(l);
		d.getPartita().setStanzaCorrente(cantina);
		
		
		d.gioca();
		
		
		assertTrue(d.getPartita().isFinita());
		assertTrue(d.getPartita().vinta());
		
		assertEquals( ""+
				"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
				"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
				"I locali sono popolati da strani personaggi, " +
				"alcuni amici, altri... chissa!\n"+
				"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
				"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
				"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
				"Per conoscere le istruzioni usa il comando 'aiuto'." , ios.leggiOutput());
		assertEquals("Qui c'è buio pesto" , ios.leggiOutput());
		assertEquals("Hai posato lanterna" , ios.leggiOutput());
		assertEquals(descrizione , ios.leggiOutput());
		assertEquals("Hai posato chiave" , ios.leggiOutput());
		assertEquals(descrizioneMagica , ios.leggiOutput());
		assertEquals("Hai posato pistola" , ios.leggiOutput());
		assertEquals("Hai posato pistola" , ios.leggiOutput());
		d.getPartita().getGiocatore().setCfu(d.getPartita().getGiocatore().getCfu()+1);
		assertEquals(cameraDeiSegreti.getDescrizione() + d.getPartita().getDescrizione() , ios.leggiOutput());		
		assertEquals(atrio.getDescrizione() , ios.leggiOutput());
		
		assertEquals( "Hai Vinto" , ios.leggiOutput());
	}	
	
	

}
