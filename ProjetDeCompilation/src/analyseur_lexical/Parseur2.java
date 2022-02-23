package analyseur_lexical;

import java.util.List;
import java.util.regex.Pattern;

public class Parseur2 {
	
	public List<Character> contenu=new LireContenu("solo.txt").lectureContenu();
	public StringBuffer chaine=new StringBuffer();
	public int curseur=0;
	public Character caractereCourant=contenu.get(curseur);
	public boolean eof=false;
	
	//caractère suivant
	public void caractereSuivant() {
		if(curseur<contenu.size()) {
			caractereCourant=contenu.get(curseur++);
		}
		else {
			eof=true;
		}
	}
	
	public Parseur2() {
		while(!eof) {
			System.out.println(token().toString());
			curseur++;
		}
	}
	
	public UniteLexicale token() {
		while(!eof) {
			caractereSuivant();
			/*if(caractereCourant.equals('i')) {
				return cond();
			}*/
			if(caractereCourant==':') {
				return affectation();
			}
			/*if(Character.toLowerCase(caractereCourant)=='i') {
				return condition();
			}
			if(Character.toLowerCase(caractereCourant)=='w') {
				return while_();
			}
			if(Character.toLowerCase(caractereCourant)=='f') {
				return for_();
			}
			*/
			if(Character.isDigit(caractereCourant)) {
				return nombre();
			}
			if(Character.isAlphabetic(caractereCourant)) {
				return identifiant();
			}
			if(caractereCourant==',' || caractereCourant=='.' ) {
				reculer();
				return separateur();
			}
			if(caractereCourant==';' && !eof) {
				chaine.append("; ");
				return new UniteLexicale(Categorie.PV, ";");
				
			}
			if(caractereCourant=='+'||caractereCourant=='-'||caractereCourant=='*'||caractereCourant=='/') {
				chaine.append(caractereCourant+" ");
				reculer();
				return new UniteLexicale(Categorie.OPRARTH, caractereCourant);
			}
			if(eof) {
				chaine.append("$");
				return new UniteLexicale(Categorie.EOF, "FIN");
			}
			
		}
		return null;
	}
		
	void reculer() {
		if(curseur>0) {
			curseur--;
		}
	}
	
	
	public UniteLexicale affectation() {
		StringBuffer sb=new StringBuffer();
		int etat=0;
		while(true) {
			switch(etat) {
				case 0:{
					sb.append(caractereCourant);
					etat=1;
					break;
				}
				case 1:{
					caractereSuivant();
					if(eof) {
						etat=3;
					}
					else {
						if(caractereCourant=='=') {
							etat=2;
							sb.append(caractereCourant);
						}
						else {
							etat=3;
							sb.append(caractereCourant);
						}
					}
				}
				break;
				case 2:{
					caractereSuivant();
					if(eof || caractereCourant==' ') {
						reculer();
						chaine.append(sb);
						chaine.append(" ");
						return new UniteLexicale(Categorie.AFF, sb);
					}
					else {
						etat=3;
						break;
					}
				}
				case 3:{
					sb.append(caractereCourant);
					reculer();
					chaine.append(sb);
					return new UniteLexicale(Categorie.ERROR, sb);
				}
			}
		}
	}
		
	
	public UniteLexicale condition() {
		StringBuffer sb=new StringBuffer();
		int etat=0;
		while(true) {
			switch(etat) {
			case 0:{
				sb.append(caractereCourant);
				etat=1;
				break;
			}
			case 1:{
				caractereSuivant();
				if(eof) {
					etat=4;
				}
				else {
					if(Character.toLowerCase(caractereCourant)=='f') {
						sb.append(caractereCourant);
						etat=2;
					}
					else {
						etat=3;
					}
				}
			}break;
			case 2:{
				caractereSuivant();
				if(eof || caractereCourant==' ' || Character.isLetter(caractereCourant)==false) {
					reculer();
					chaine.append(sb);
					chaine.append(" ");
					
					return new UniteLexicale(Categorie.IF, sb);
				}
				else {
					etat=3;
					break;
				}
			}
			case 3:{
				while(!eof && Character.isLetterOrDigit(caractereCourant)) {
					sb.append(caractereCourant);
					caractereSuivant();
				}
				chaine.append(sb);
				chaine.append(" ");
				reculer();
				return new UniteLexicale(Categorie.ID, sb);
			}
			case 4:reculer();
			chaine.append(sb);
			chaine.append(" ");
				return new UniteLexicale(Categorie.ID, sb);
			}
		}
	}
	
	
	public UniteLexicale for_() {
		StringBuffer sb=new StringBuffer();
		int etat=0;
		while(true) {
			switch(etat) {
				case 0:{
					sb.append(caractereCourant);
					etat=1;
					System.out.print(etat);
					break;
				}
				case 1:{
					caractereSuivant();
					if(eof) {
						etat=5;
						System.out.print(etat);
					}
					else {
						if(Character.toLowerCase(caractereCourant)=='o') {
							etat=2;
							sb.append(caractereCourant);
							System.out.print(etat);
						}
						else {
							sb.append(caractereCourant);
							etat=4;
							System.out.print(etat);
						}
					}
					
					
				}break;
				case 2:{
					caractereSuivant();
					if(eof) {
						etat=5;
					}
					else {
						if(Character.toLowerCase(caractereCourant)=='r') {
							sb.append(caractereCourant);
							etat=3;
						}
						else {
							sb.append(caractereCourant);
							etat=4;
						}
					}
				}break;
				case 3:{
					caractereSuivant();
					if(eof || !Character.isLetterOrDigit(caractereCourant)) {
						reculer();
						return new UniteLexicale(Categorie.FOR, sb);
					}
					else {
						sb.append(caractereCourant);
						etat=4;
						break;
					}
				}
				case 4:{
					while(!eof && Character.isLetterOrDigit(caractereCourant)) {
						
						caractereSuivant();
						sb.append(caractereCourant);
						
					}
					reculer();
					chaine.append(sb);
					chaine.append(" ");
					return new UniteLexicale(Categorie.ID, sb);
				}
				case 5:{
					chaine.append(sb);
					chaine.append(" ");
					reculer();
					return new UniteLexicale(Categorie.ID, sb);
				}
			}
		}
	}
	
	public UniteLexicale while_() {
		StringBuffer sb=new StringBuffer();
		int etat=0;
		while(true) {
			switch(etat) {
				case 0:{
					sb.append(caractereCourant);
					etat=1;
					break;
				}
				case 1:{
					caractereSuivant();
					if(eof) {
						etat=7;
					}
					else {
						if(caractereCourant=='h') {
							sb.append(caractereCourant);
							etat=2;
						}
						else {
							etat=6;
							sb.append(caractereCourant);
						}
						
					}
				}
				break;
				case 2:{
					caractereSuivant();
					if(eof) {
						etat=7;
					}
					else {
						if(caractereCourant=='i') {
							sb.append(caractereCourant);
							etat=3;
						}
						else {
							etat=6;
							sb.append(caractereCourant);
						}
					}
				}break;
				case 3:{
					caractereSuivant();
					if(eof) {
						etat=7;
					}
					else {
						if(caractereCourant=='l') {
							sb.append(caractereCourant);
							etat=4;
						}
						else {
							reculer();
							etat=6;
							//sb.append(caractereCourant);
						}
					}
				}
				break;
				case 4:{
					caractereSuivant();
					if(eof) {
						etat=7;
					}
					else {
						if(caractereCourant=='e') {
							etat=5;
							sb.append(caractereCourant);
						}
						else {
							reculer();
							etat=6;
							sb.append(caractereCourant);
						}
					}
				}break;
				case 5:{
					caractereSuivant();
					if(eof || (!Character.isAlphabetic(caractereCourant))) {
						reculer();
						chaine.append(sb);
						chaine.append(" ");
						return new UniteLexicale(Categorie.WHILE, sb);
					}
					else {
						reculer();
						etat=6;
						//sb.append(caractereCourant);
					}
				}
				break;
				case 6:{
					while(!eof && Character.isLetterOrDigit(caractereCourant)) {
						caractereSuivant();
						sb.append(caractereCourant);
					}
					chaine.append(sb);
					chaine.append(" ");
					reculer();
					return new UniteLexicale(Categorie.ID, sb);
				}
				
				case 7:{
					chaine.append(sb);
					chaine.append(" ");
					return new UniteLexicale(Categorie.ID, sb);
				}
				
			}
		}
	}
	
	public UniteLexicale nombre() {
		int etat=0;
		StringBuffer sb=new StringBuffer();
		while(true) {
			switch(etat) {
				case 0:{
					sb.append(caractereCourant);
					etat=1;
					break; 
				}
				case 1:{
					caractereSuivant();
					if(eof) {
						etat=3;
					}
					else {
						if(Character.isDigit(caractereCourant)) {
							sb.append(caractereCourant);
						}
						else {
							reculer();
							etat=2;
						}
					}
					break;
				}
				case 2:{
					reculer();
					chaine.append(sb);
					chaine.append(" ");
					return new UniteLexicale(Categorie.NOMNRE, sb);
				}
					
				case 3:
					chaine.append(sb);
					chaine.append(" ");
					return new UniteLexicale(Categorie.NOMNRE, sb);
			}
		}
		
	}
	
	public UniteLexicale identifiant() {
		
		StringBuffer sb=new StringBuffer();
		int etat=0;
		while(true) {
			switch(etat) {
				case 0:{
					sb.append(caractereCourant);
					etat=1;
					
					break;
					
				}
				case 1:{
					caractereSuivant();
					if(eof) {
						etat=3;
					}
					else {
						if(Character.isDigit(caractereCourant) || Character.isAlphabetic(caractereCourant) ) {
							sb.append(caractereCourant);
							
						}
						else {
							etat=2;
						}
					}
					break;
				}
				case 2:{
					chaine.append(sb);
					chaine.append(" ");
					reculer();
					if(sb.toString().toLowerCase().equals("and")) {
						return new UniteLexicale(Categorie.AND, sb);
					}
					if(sb.toString().toLowerCase().equals("or")) {
						return new UniteLexicale(Categorie.OR, sb);
					}
					if(sb.toString().toLowerCase().equals("xor")) {
						return new UniteLexicale(Categorie.XOR, sb); 
					}
					if(sb.toString().toLowerCase().equals("for")) {
						return new UniteLexicale(Categorie.FOR, sb); 
					}
					if(sb.toString().toLowerCase().equals("while")) {
						return new UniteLexicale(Categorie.WHILE, sb); 
					}
					if(sb.toString().toLowerCase().equals("if")) {
						return new UniteLexicale(Categorie.IF, sb); 
					}
					if(sb.toString().toLowerCase().equals("true")) {
						return new UniteLexicale(Categorie.TRUE, sb); 
					}
					if(sb.toString().toLowerCase().equals("false")) {
						return new UniteLexicale(Categorie.FALSE, sb); 
					}
					if(sb.toString().toLowerCase().equals("else")) {
						return new UniteLexicale(Categorie.ELSE, sb); 
					}
					
					return new UniteLexicale(Categorie.ID, sb);
				}
				case 3:{
					chaine.append(sb);
					chaine.append(" ");
					return new UniteLexicale(Categorie.ID, sb);
				}
			}
		}
		
	}
	
	
	/*public UniteLexicale operateur() {
		StringBuffer sb=new StringBuffer();
		int etat=0;
		//Pattern p=Pattern.compile("[-+]");
		while(true) {
			switch(etat) {
				case 0:{
					etat=1;
				}
			}
		}
		
		
		
	}*/
	
	public UniteLexicale separateur() {
		StringBuffer sb=new StringBuffer();
		int etat=0;
		while(true) {
			switch(etat) {
				case 0:{
					sb.append(caractereCourant);
					etat=1;
					break;
				}
				case 1:{
					caractereSuivant();
					if(eof) {
						etat=3;
					}
					else {
						if(Character.isSpace(caractereCourant)) {
							sb.append(caractereCourant);
						}
						else {
							etat=2;
						}
						break;
					}
				}
				case 2:{
					chaine.append(sb);
					chaine.append(" ");
					reculer();
					return new UniteLexicale(Categorie.SEP, sb);
				}
				case 3:chaine.append(sb);
				chaine.append(" ");
					return new UniteLexicale(Categorie.SEP, sb);
			}
		}
	}
	
	
	
}
