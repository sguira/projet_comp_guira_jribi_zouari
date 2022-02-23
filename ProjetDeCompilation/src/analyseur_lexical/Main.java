package analyseur_lexical;

import java.util.Scanner;
import java.util.Stack;

import analyseur_syntaxique.LexeurSyntaxique;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("____________Analyseur Lexicale _______");
		Parseur2 parseur=new Parseur2();
		String contenu= parseur.chaine.toString();
		System.out.println(contenu);
		String[] entree=contenu.split(" ");
		LexeurSyntaxique lexeur=new LexeurSyntaxique();
		lexeur.chaine=entree;
		lexeur.analyseurSLR();
		System.out.println("\n_______ Analyse Sementique (contrôle de type) ______");
		/*while(lexeur.pileDDS!=null){
			lexeur.analyseSementique();
			lexeur.pileDDS.pop();
		}*/
		System.out.println(lexeur.pileDDS+","+lexeur.pileDDS.size()+","+lexeur.pileDDS.get(0));
		for(int i=0;i<lexeur.pileDDS.size();i++) {
			//System.out.println(lexeur.pileDDS.peek());
			lexeur.analyseSementique(i);
			
		}
		
		
		
		
	}

}
