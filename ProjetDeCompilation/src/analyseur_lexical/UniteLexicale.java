package analyseur_lexical;

public class UniteLexicale {
	
	public Categorie categorie;
	public Object lexeme;
	public UniteLexicale(Categorie cat, Object obj) {
		this.categorie=cat;
		this.lexeme=obj;
	}
	
	public String toString() {
		return "[ "+this.categorie+","+this.lexeme+" ]\n";
	}

}
