// classe libreria
// modifica online
// importata in loocale

import java.util.Arrays;

public class Libreria {
	private String nome;
	// private int maxLibri;
	private Libro[] libri;
	// private Libro libri[];
	private int numLibri;

	public Libreria(String nome, int maxLibri) {

		libri = new Libro[maxLibri];
		numLibri = 0;
		this.nome = nome;
	}

	/*
	 * public boolean addLibro(Libro lib) { libri[numLibri] = lib; numLibri++;
	 * return false; }
	 */

	public boolean addLibro(Libro lib) {
		if (numLibri < libri.length) {
			libri[numLibri] = lib;
			numLibri++;
			return true;
		}
		return false;
	}

	/*
	 * @Override public String toString() { return "Libreria [nome=" + nome +
	 * ", libri=" + Arrays.toString(libri) + "]"; }
	 */

	// elimina libro per posizione senza controllo
	public void delLibroPos(int pos) {
		libri[pos] = null;
	}

	// elimina libro per codice con controllo

	public boolean delLibroCodice(String cod) {
		for (int i = 0; i < libri.length; i++) {
			if (libri[i] != null && libri[i].getCodice().equalsIgnoreCase(cod)) {
				libri[i] = null;
				return true;
			}
		}

		return false;
	}

	// elimina libro per codice con controllo e compattazione

	public boolean delLibroCodiceComp(String cod) {
		int j;
		for (int i = 0; i < libri.length; i++) {
			if (libri[i] != null && libri[i].getCodice().equalsIgnoreCase(cod)) {

				// libri [i] = null;

				for (j = i + 1; j < libri.length; j++) {
					libri[j - 1] = libri[j];
				}
				numLibri--;
				libri[j-1] = null;

				return true;
			}
		}

		return false;
	}

	// libri presenti in biblioteca

	int libriPresenti() {
		return numLibri;
	}
	
	// libro con più pagine
	
	Libro libroPiuPagine (){
		Libro libMax = libri [0];
		int pagMax = libri [0].getPagine();
		// for
		for (int i = 0; i < libri.length; i++) {
			if (libri [i]!=null && libri [i].getPagine() > pagMax) {
				pagMax = libri[i].getPagine();
				libMax = libri [i];
			}
		}
		
		return libMax;
		
	}

	// ricerca di tutti i libri scritti da un autore
	
	String libriPerAutore(String autore) {
		String a = "";
		for (int i = 0; i < libri.length; i++) {
			if (libri[i] != null && libri[i].getAutore().equalsIgnoreCase(autore)) {
				a = a + libri[i] + "\n";
			}	
		}
		return a;
	}
	
	int libriPerAutoreNum(String autore) {
		int numLib=0;
		for (int i = 0; i < libri.length; i++) {
			if (libri[i] != null && libri[i].getAutore().equalsIgnoreCase(autore)) {
				numLib++;
			}	
		}
		return numLib;
	}
	// ricerca di tutti i libri scritti da un autore - ritorno Array di oggetti
	
	Libro[] libriPerAutoreArray2(String autore) {
		
		int numLib = libriPerAutoreNum(autore);
		System.out.println("lung ....." + numLib);
		
		// dichiaro un array di tipo libro temporaneo
		
		Libro libriPerAutore[] = new Libro [numLib];
		
		//System.out.println("lung 2....." + libriPerAutore.length);
		int n=0; // variabile per i libri trovati
		
		for (int i = 0; i< libri.length; i++) {
			System.out.println("cicl");
			if (libri[i] != null && libri[i].getAutore().equalsIgnoreCase(autore)) {
				System.out.println("trov");
				libriPerAutore[n] = libri [i];
				n++;
			}
		}
		return libriPerAutore; //ritorno array
	}
	
	Libro[] libriPerAutoreArray(String autore) {
		
		// dichiaro un array di tipo libro temporaneo
		Libro libriPerAutore[] = new Libro [numLibri];
		
		int n=0; // variabile per i libri trovati
		for (int i = 0; i< libri.length; i++) {
			//System.out.println(autore);
			if (libri[i] != null && libri[i].getAutore().equalsIgnoreCase(autore)) {
				//System.out.println("ttt");
				libriPerAutore[n] = libri [i];
				n++;
			}
		}
		return libriPerAutore; //ritorno array
	}
	
	
	
	
	
	public String toString() {
		String s = "Nome libreria: " + nome + "\n";
		for (int i = 0; i < libri.length; i++) {
			if (libri[i] != null)
				s = s + libri[i] + "\n";
		}

		return s;
	}

	// test di classe
	public static void main(String[] args) {
		Libreria libCentrale = new Libreria("libreria viale ferrari", 5);
		Libro lib1 = new Libro("libro 1", "autore 1");
		Libro lib2 = new Libro("libro 2", "autore 2");
		Libro lib3 = new Libro("libro 3", "autore 2");
		Libro lib4 = new Libro("libro 4", "autore 4");

		System.out.println(libCentrale.addLibro(lib1));
		System.out.println(libCentrale.addLibro(lib2));
		System.out.println(libCentrale.addLibro(lib3));
		System.out.println(libCentrale.addLibro(lib4));
		
		libCentrale.libri[0].setCodice("cod 1");
		libCentrale.libri[1].setCodice("cod 2");
		libCentrale.libri[2].setCodice("cod 3");
		libCentrale.libri[3].setCodice("cod 4");
		
		libCentrale.libri[0].setPagine(10);
		libCentrale.libri[1].setPagine(100);
		libCentrale.libri[2].setPagine(200);
		libCentrale.libri[3].setPagine(125);
		
		// libCentrale.delLibroPos(1);
		System.out.println("--- canc ---");
	//	System.out.println(libCentrale.delLibroCodice("cod 3"));

		
		//System.out.println(libCentrale.delLibroCodiceComp("cod 3"));
		System.out.println(libCentrale);
		System.out.println("libri presenti " + libCentrale.libriPresenti());
		System.out.println("libro con più pagine " + libCentrale.libroPiuPagine());
		
		// libri per autore
		System.out.println("--- libri per autore --- \n" + libCentrale.libriPerAutore("autore 2"));
		
		// libri per autore array
		
		Libro libAut[] = libCentrale.libriPerAutoreArray("autore 2");
		
		System.out.println("---- libri per autore array " + libAut.length);
		
		for (int i=0; i < libAut.length; i++) {
			if (libAut [i] != null)
				System.out.println(libAut[i]);
		}
		
		// libri per autore array 2
		
				Libro libAut2[] = libCentrale.libriPerAutoreArray2("autore 2");
				
				System.out.println("---- libri per autore array 2 - " + libAut2.length);
				
				for (int i=0; i < libAut2.length; i++) {
				//	if (libAut2 [i] != null)
						System.out.println(libAut2[i]);
				}
	}

}

