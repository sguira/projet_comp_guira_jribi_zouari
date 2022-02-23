package analyseur_lexical;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LireContenu {
	
	private String file_name;
	public List<Character> contenu;
	private BufferedReader f;
	
	public LireContenu(String name) {
		this.file_name=name;
		contenu=new ArrayList<>();
		f=null;
	}
	
	void ouvrirFichier(){
		try {
			this.f=new BufferedReader(new FileReader("C:\\Users\\sguira\\Desktop\\IF3 DATA SCIENCE\\COURS FAC\\COMPILATION\\TP\\ESSAI MAISON\\"+this.file_name));
		}
		catch(Exception e) {
			System.out.println("Error Ouverture Fichier");
			e.printStackTrace();
		}
	}
	
	void fermerFichier() {
		if(f!=null) {
			try {
				f.close();
			}
			catch(IOException e) {
				e.printStackTrace();
				
			}
		}
	}
	
	public List<Character> lectureContenu(){
		this.ouvrirFichier();
		int caractereCourant;
		char c;
		try {
			while((caractereCourant=f.read())!=-1) {
				c=(char)caractereCourant;
				this.contenu.add(c);
			}
			this.fermerFichier();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			this.fermerFichier();
		}
		return this.contenu;
	}
	
	public String toString() {
		return "le contenu de notre fichier est \n"+this.contenu;
	}

}
