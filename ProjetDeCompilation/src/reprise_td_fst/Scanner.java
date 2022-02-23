package reprise_td_fst;

import java.util.ArrayList;
import java.util.List;

public class Scanner {
	public List<Character> chaine;
	public char caratereCourant;
	int etat=0;
	int index=0;
	boolean eof=false;
	public Scanner() {
		LireContenu lc=new LireContenu("solo.txt");
		this.chaine=lc.lectureContenu();
		if(chaine.size()==0) {
			this.eof=true;
		}
		else {
			this.eof=false;
		}
		
		//afficher la chaine;
		/*while(!eof) {
			charactereSuivant();
			System.out.println(caratereCourant);
		}*/
	}
	
	void charactereSuivant() {
		
		if(index<this.chaine.size()) {
			caratereCourant=chaine.get(index);
			index++;
		}
		else {
			eof=true;
		}
		
	}
	void reculer() {
		if(chaine.size()>0) {
			index--;
		}
	}
	
	void getId() {
		
		StringBuffer sb=new StringBuffer();
		
		while(true) {
			switch(etat) {
			case 0:{
				etat=1;
				this.charactereSuivant();
				sb.append(chaine.get(caratereCourant).charValue());
				break;
				}
			case 1:{
				
				if(eof) {
					
				}
			
				}
			}
		}
	}
	
	
	
	

}
