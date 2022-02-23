package analyseur_syntaxique;

import java.util.Stack;

public class LexeurSyntaxique {
	
	public String type;
	
	public String[][] TSLR= {
			{"etat/VT",		";",		"id",	":=",	"if",	"then",		"else",		"while",	"do",	"done",		"print",	"["		,"]"	,"="	,"("	,")"	,"not",		"nb",	"false",	"true",		"{",	"}",	"or",	"and",		"xor",		"+",	"-",	"*",	"/",	"<",	">",	"$",	"P",	"LI",	"I",	"E",	"F",	"LOGIQUE",	"OPARTH",	"OPREL"},
			{"0",	  		"r3", 		"s4",	"err",	"s5",	"err",		"r3",		"s6",		"err",	"r3",		"s7",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"r3",	"1",	"2",	"3",	"err",	"err",		"err",	"err",		"err"},
			{"1",	  		"err", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"acc",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"2",	  		"err", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"r1",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"3",	  		"s8", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"acc",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"4",	  		"err", 		"err",	"s9",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"acc",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"5",	  		"err", 		"s11",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"s12",	"err",	"s13",		"s14",	"s15",		"s16",		"s17",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"acc",	"err",	"err",	"err",	"10",	"18",		"err",	"err",		"err"},
			{"6",	  		"err", 		"s11",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"s12",	"err",	"s13",		"s14",	"s15",		"s16",		"s17",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"acc",	"err",	"err",	"err",	"19",	"18",		"err",	"err",		"err"},
			{"7",	  		"err", 		"s11",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"s12",	"err",	"s13",		"s14",	"s15",		"s16",		"s17",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"acc",	"err",	"err",	"err",	"20",	"18",		"err",	"err",		"err"},
			{"8",	  		"r3", 		"s4",	"err",	"s5",	"err",		"r3",		"s6",		"err",	"r3",		"s7",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"r3",	"err",	"21",	"3",	"err",	"err",		"err",	"err",		"err"},
			{"9",	  		"err", 		"s11",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"s12",	"err",	"s13",		"s14",	"s15",		"s16",		"s17",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"22",	"18",		"err",	"err",		"err"},
			{"10",	  		"err", 		"err",	"err",	"err",	"s23",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"11",	  		"r33", 		"err",	"err",	"err",	"r33",		"err",		"err",		"r33",	"err",		"err",		"s24",	"r33",	"r18",	"err",	"r33",	"err",		"err",	"err",		"err",		"err",	"r33",	"r18",	"r18",		"r18",		"r18",	"r18",	"r18",	"r18",	"r18",	"r18",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"12",	  		"err", 		"s11",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"s12",	"err",	"err",		"s14",	"s15",		"s16",		"s17",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"25",	"18",		"err",	"err",		"err"},
			{"13",	  		"err", 		"s11",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"s12",	"err",	"s13",		"s14",	"s15",		"s16",		"s17",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"26",	"18",		"err",	"err",		"err"},
			{"14",	  		"r11", 		"s11",	"err",	"err",	"r11",		"err",		"err",		"r11",	"err",		"err",		"err",	"r11",	"r19",	"err",	"r11",	"err",		"err",	"err",		"err",		"err",	"r11",	"r19",	"r19",		"r19",		"r19",	"r19",	"r19",	"r19",	"r19",	"r19",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"15",	  		"r12", 		"s11",	"err",	"err",	"r12",		"err",		"err",		"r12",	"err",		"err",		"err",	"r12",	"err",	"err",	"r12",	"err",		"err",	"err",		"err",		"err",	"r12",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"16",	  		"r13", 		"s11",	"err",	"err",	"r13",		"err",		"err",		"r13",	"err",		"err",		"err",	"r13",	"err",	"err",	"r13",	"err",		"err",	"err",		"err",		"err",	"r13",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"17",	  		"err", 		"s11",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"s12",	"err",	"s13",		"s14",	"s15",		"s16",		"s17",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"27",	"18",		"err",	"err",		"err"},
			{"18",	  		"err", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"s37",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"s38",	"s39",		"s40",		"s31",	"s32",	"s33",	"s34",	"s35",	"s36",	"err",	"err",	"err",	"err",	"err",	"err",		"30",	"28",		"29"},
			{"19",	  		"err", 		"err",	"err",	"err",	"err",		"err",		"err",		"s41",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"20",	  		"r7", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"21",	  		"r2", 		"err",	"err",	"err",	"err",		"r2",		"err",		"err",	"r2",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"r2",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"22",	  		"r4", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"acc",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"23",	  		"r3", 		"s4",	"err",	"s5",	"err",		"r3",		"s6",		"err",	"r3",		"r7",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"r3",	"err",	"42",	"3",	"err",	"err",		"err",	"err",		"err"},
			{"24",	  		"err", 		"s11",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"s12",	"err",	"s13",		"s14",	"s15",		"s16",		"s17",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"43",	"18",		"err",	"err",		"err"},
			{"25",	  		"err", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",	"s44",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"26",	  		"r10", 		"err",	"err",	"err",	"r10",		"err",		"err",		"r10",	"err",		"err",		"err",	"r10",	"err",	"err",	"r10",	"err",		"err",	"err",		"err",		"err",	"r10",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"27",	  		"err", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"s45",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"28",	  		"err", 		"s11",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"s12",	"err",	"s13",		"s14",	"s15",		"s16",		"s17",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"46",	"18",		"err",	"err",		"err"},
			{"29",	  		"err", 		"s11",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"s12",	"err",	"s13",		"s14",	"s15",		"s16",		"s17",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"47",	"18",		"err",	"err",		"err"},
			{"30",	  		"err", 		"s11",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"s12",	"err",	"s13",		"s14",	"s15",		"s16",		"s17",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"48",	"18",		"err",	"err",		"err"},
			{"31",	  		"err", 		"r23",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"r23",	"err",	"r23",		"r23",	"r23",		"r23",		"r23",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"27",	"18",		"err",	"err",		"err"},
			{"32",	  		"err", 		"r24",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"r24",	"err",	"r24",		"r24",	"r24",		"r24",		"r24",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"27",	"18",		"err",	"err",		"err"},
			{"33",	  		"err", 		"r25",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"r25",	"err",	"r25",		"r25",	"r25",		"r25",		"r25",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"34",	  		"err", 		"r26",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"r26",	"err",	"r26",		"r26",	"r26",		"r26",		"r26",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"35",	  		"err", 		"r27",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"s49",	"r27",	"err",	"r27",		"r27",	"r27",		"r27",		"r27",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"s50",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"36",	  		"err", 		"r29",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"s51",	"r29",	"err",	"r29",		"r29",	"r29",		"r29",		"r29",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"37",	  		"err", 		"r32",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"r32",	"err",	"r32",		"r32",	"r32",		"r32",		"r32",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"38",	  		"err", 		"r20",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"r20",	"err",	"r20",		"r20",	"r20",		"r20",		"r20",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"39",	  		"err", 		"r21",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"r21",	"err",	"r21",		"r21",	"r21",		"r21",		"r21",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"40",	  		"err", 		"r22",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"r22",	"err",	"r22",		"r22",	"r22",		"r22",		"r22",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"41",	  		"r3", 		"s4",	"err",	"s5",	"err",		"r3",		"s6",		"err",	"r3",		"s7",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"r3",	"err",	"err",	"52",	"3",	"err",		"err",	"err",		"err"},
			{"42",	  		"err", 		"err",	"err",	"err",	"err",		"s53",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"43",	  		"err", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"s54",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"44",	  		"r9", 		"err",	"err",	"err",	"r9",		"err",		"err",		"r9",	"err",		"err",		"err",	"r9",	"err",	"err",	"r9",	"err",		"err",	"err",		"err",		"err",	"r9",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"45",	  		"r14", 		"err",	"err",	"err",	"r14",		"err",		"err",		"r14",	"err",		"err",		"err",	"r14",	"err",	"err",	"r14",	"err",		"err",	"err",		"err",		"err",	"r14",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"46",	  		"r15", 		"err",	"err",	"err",	"r15",		"err",		"err",		"r15",	"err",		"err",		"err",	"r15",	"err",	"err",	"r15",	"err",		"err",	"err",		"err",		"err",	"r15",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"47",	  		"r16", 		"err",	"err",	"err",	"r16",		"err",		"err",		"r16",	"err",		"err",		"err",	"r16",	"err",	"err",	"r16",	"err",		"err",	"err",		"err",		"err",	"r16",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"48",	  		"r17", 		"err",	"err",	"err",	"r17",		"err",		"err",		"r17",	"err",		"err",		"err",	"r17",	"err",	"err",	"r17",	"err",		"err",	"err",		"err",		"err",	"r17",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"49",	  		"err", 		"r28",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"r28",	"err",	"r28",		"r28",	"r28",		"r28",		"r28",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"50",	  		"err", 		"r31",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"r31",	"err",	"r31",		"r31",	"r31",		"r31",		"r31",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"51",	  		"err", 		"30",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"r30",	"err",	"r30",		"r30",	"r30",		"r30",		"r30",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"52",	  		"err", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"s55",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"53",	  		"r3", 		"s4",	"err",	"s5",	"err",		"r3",		"s6",		"err",	"r3",		"s7",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"r3",	"err",	"err",	"56",	"3",	"err",		"err",	"err",		"err"},
			{"54",	  		"err", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"s57",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"55",	  		"r5", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"56",	  		"r6", 		"err",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err",		"err",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},
			{"57",	  		"err", 		"s11",	"err",	"err",	"err",		"err",		"err",		"err",	"err",		"err",		"err",	"err",	"err",	"s12",	"err",	"s13",		"s14",	"s15",		"s16",		"s17",	"err",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"58",	"18",		"err",	"err",		"err"},
			{"58",	  		"r8", 		"err",	"err",	"err",	"r8",		"err",		"err",		"r8",	"err",		"err",		"err",	"r8",	"err",	"err",	"r8",	"err",		"err",	"err",		"err",		"err",	"r8",	"err",	"err",		"err",		"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",	"err",		"err",	"err",		"err"},

	};
	
	
	
	
	public String[] GRMM= {
					"P->LI",
					"LI->I ; LI",
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
	public Stack<String> pile=new Stack<String>();
	public String[] chaine;
	public int index;
	public String action;
	public Stack<Integer> pileDDS=new Stack<Integer>();
	public Stack<String> pileType=new Stack<String>();
	
	public String action(String s,String a) {
		
		for(int i=1;i<TSLR.length;i++) {
			if(TSLR[i][0].equals(s)) {
				for(int j=1;j<TSLR[0].length;j++) {
					if(TSLR[0][j].equals(a)) {
						return TSLR[i][j];
					}
				}
			}
		}
		
		return "err";
	}
	
	
	
	public void analyseSementique(int j) {
		int tete=pileDDS.get(j);
		switch(tete) {
		case 0:{
			int code = 0;
			for(int i=0;i<pileType.size();i++) {
				if(!pileType.get(i).equals(pileType.peek()) || pileType.peek().equals("ERROR_TYPE")) {
					pileType.push("ERROR_TYPE");
					code=1;
					break;
				}
			}
			if(code!=1 && pileType.size()>0) {
				type=pileType.peek();
				pileType.push(pileType.peek());
				
			}
			System.out.println("Type du programme"+type);
			break;
		}
		case 1,2:{
			int code = 0;
			for(int i=0;i<pileType.size();i++) {
				if(!pileType.get(i).equals(pileType.peek()) || pileType.peek().equals("ERROR_TYPE")) {
					pileType.push("ERROR_TYPE");
					code=1;
					break;
				}
			}
			if(code!=1 && pileType.size()>0) {
				type=pileType.peek();
				pileType.push(pileType.peek());
				
			}
			
			break;
		}
		case 3:{
			int code =0;
			for(int i=0;i<pileType.size();i++) {
				if(!pileType.peek().equals(pileType.get(i)) || pile.peek().equals("ERROR_TYPE")) {
					type="ERROR_TYPE";
					pileType.push("ERROR_TYPE");
					code =1;
					break;
				}
				
			}
			if(code!=1 && pileType.size()>0) {
				type=pileType.peek();
			}
			
			break;
		}
			case 4,5,6:{
				int code =0;
				for(int i=0;i<pileType.size();i++) {
					if(!pileType.peek().equals(pileType.get(i)) || pile.peek().equals("ERROR_TYPE")) {
						type="ERROR_TYPE";
						pileType.push("ERROR_TYPE");
						code =1;
						break;
					}
					
				}
				if(code!=1 && pileType.size()>0) {
					type="TYPE_VIDE";
				}
				
				break;
			}
			case 10,18:{
				pileType.push("INT");
				break;
			}
			
			case 11,12:{
				pileType.push("BOOLEAN");
				System.out.println(pileType);
				break;
			}
			case 14,15,16:{
				int code=0;
				for(int i=0;i<pileType.size();i++) {
					if(!pileType.peek().equals(pileType.get(i))) {
						type="ERROR_TYPE";
						pileType.push("ERROR_TYPE");
						code = 1;
						break;
					}
				}
				if(code!=1 && pileType.size()>0) {
					type=pileType.peek();
				}
				System.out.println(pileType);
				break;
			}
			case 17,32:{
				pileType.push("CHAR");
				//type="INT";
				System.out.println(pileType);
				break;
			}
			case 19,20,21,22:{
				int code=0;
				for(int i=0;i<pileType.size();i++) {
					if(!pileType.peek().equals("BOOLEAN")) {
						type="ERROR_TYPE";
						code = 1;
						break;
					}
				}
				if(code!=1) {
					type=pileType.peek();
				}
				System.out.println(type);
				break;
			}
			
			
		}
	}
	
	public void analyseurSLR() {
		
		index=0;
		pile.push("0");
		action="";
		System.out.println("debut analyse");
		System.out.println("[Action]__________________________[ENTREZ]________________________[ACTION]");
		display();
		while(index<chaine.length) {
			String s;
			
			s=pile.peek();
			
			if(action(s, chaine[index]).charAt(0)=='s') {
				if(chaine[index]!="$") {
					pile.push(chaine[index]);
				}
				pile.push((action(s,chaine[index]).substring(1)));
				index++;
				action="s";
				display();
			}
			else if(action(s,chaine[index]).charAt(0)=='r') {
				String regleProduction=GRMM[Integer.parseInt(action(s,chaine[index]).substring(1))-1];
				pileDDS.push(Integer.parseInt(action(s,chaine[index]).substring(1))-1);
				int pos=Integer.parseInt(action(s,chaine[index]).substring(1));
				String partie[]=regleProduction.split("->");
				String gauche=partie[0];
				String droite=partie[1];
				int taille=droite.split(" ").length*2;
				int taille2 =(droite.equals("''"))?0:taille;
				
				for(int i=1;i<=taille2;i++) {	
					pile.pop();
				}
				
				String etat=pile.peek();
				pile.push(gauche);
				pile.push(action(etat,gauche));
				action="r"+pos;
				display();
			}
			
			else if(action(s,chaine[index])=="acc") {
				action="acception";
				display();
				break;
			}
			else {
				action="error";
				display();
				break;
			}
			
		}
		
        
    }
  
	
	
	public void display() {
		System.out.print(pile +"\t\t\t");
		for(int i=index;i<chaine.length;i++) {
			if(i==0) {
				System.out.print("_________");
			}
			System.out.print(chaine[i]+" ");
		}
		System.out.print("\t\t\t"+action +"\t\t\t\n");
		
	}
	
	
}
