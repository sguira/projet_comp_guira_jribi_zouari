package reprise_td_fst;

public class UniteLexicale {
	
	public Categorie categorie;
	public StringBuffer lexeme;
	public UniteLexicale(Categorie cate,StringBuffer lex) {
		this.categorie=cate;
		this.lexeme=lex;
	}
	
	public String toString() {
		return "<"+this.categorie+";"+this.lexeme+">";
	}

}
