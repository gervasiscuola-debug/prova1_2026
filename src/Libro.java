// versione 5 online


public class Libro {
	private String titolo;
	private String autore;
	private String codice;
	private int pagine;
	
	public Libro(String titolo, String autore) {
		this.titolo = titolo;
		this.autore = autore;
	}

	

	public String getAutore() {
		return autore;
	}



	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	public String getCodice() {
		return codice;
	}
	
	

	public int getPagine() {
		return pagine;
	}



	public void setPagine(int pagine) {
		this.pagine = pagine;
	}



	@Override
	public String toString() {
		return "titolo = " + titolo + ", autore =" + autore + ", codice=" + codice + ", pagine=" + pagine;
	}


	public static void main(String[] args) {
		Libro l1 = new Libro("i promessi sposi", "manzoni");
		l1.setCodice("codice555");
		l1.setPagine(125);
		System.out.println(l1);

	}

}
