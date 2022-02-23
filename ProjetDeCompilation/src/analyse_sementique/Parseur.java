package analyse_sementique;

public class Parseur {

	public String[] GRMM = {
			"P->LI",
			"LI->I;LI",
			"LI->''",
			"I->ID := E",
			"I->IF E THEN LI ELSE LI",
			"I->WHILE E DO LI DONE",
			"I->PRINT E",
			"E->ID[E]=E",
			"E->(E)",
			"E->NOT E",
			"E->NB",
			"E->FALSE",
			"E->TRUE",
			"E->{E}",
			"E->F OPARTH E",
			"E->F OPREL E",
			"E-> F LOGIQUE E",
			"F->ID",
			"F->NB",
			"LOGIQUE->OR",
			"LOGIQUE->AND",
			"LOGIQUE->XOR",
			"OPARTH->+",
			"OPARTH->-",
			"OPARTH->*",
			"OPARTH->/",
			"OPREL-><",
			"OPREL-><=",
			"OPREL->>",
			"OPREL->>=",
			"OPREL-><>",
			"OPREL->=",
			"E->ID"
	};

	public String[][] DDS = {
			{ "PRODUCTION", "SEMENTIQUE", "PILE" },
			{ "CHIFFRE->0", "0", "empiler(0)" },
			{ "CHIFFRE->1", "1", "empiler(1)" },
			{ "CHIFFRE->2", "2", "empiler(2)" },
			{ "CHIFFRE->3", "3", "empiler(3)" },
			{ "CHIFFRE->4", "4", "empiler(4)" },
			{ "CHIFFRE->5", "5", "empiler(5)" },
			{ "CHIFFRE->6", "6", "empiler(6)" },
			{ "CHIFFRE->7", "7", "empiler(7)" },
			{ "CHIFFRE->8", "8", "empiler(8)" },
			{ "CHIFFRE->8", "9", "empiler(9)" },
			{ "E->CHIFFRE", "E.val:=CHIFFRE.vallex", "empiler(chiffre)" },
			{ "E->ID", "9", "empiler(9)" },

	};

	String[] solo = { "id", ":=", "5" };

}
