package fr.eni.cheques;

import java.util.Scanner;

public class Chèques {

	static int numChèque = 0;
	static double montantChèque = 0;
	static int nbrTotalChèque = 0;
	static double montantTotalChèques = 0;
	static double moyenneMontantChèques = 0;
	static int nbrChèqueInf200 = 0;
	static double montantChèqueInf200 = 0;
	static int nbrChèqueSup200 = 0;
	static double montantChèqueSup200 = 0;
	static int numChèqueMin = 0;
	static double montantChèqueMin = 0;
	static int numChèqueMax = 0;
	static double montantChèqueMax = 0;

	public static void main(String[] args) {
		System.out.println("Bienvenu dans la statistique de vos chèques.");
		saisieChèques();
		affichage();
	}

	public static void saisieChèques() {
		System.out.println("Quel est le numéro du chèque? Entrez 0 pour finir");
		numChèque = scanner();
		while (numChèque != 0) {
			System.out.println("Quel est le montant du chèque?");
			montantChèque = scanner();
			montantTotalChèques = montantTotalChèques + montantChèque;
			nbrTotalChèque++;
			if (montantChèque < 200) {
				nbrChèqueInf200++;
				montantChèqueInf200 += montantChèque;
			}
			if (montantChèque >= 200) {
				nbrChèqueSup200++;
				montantChèqueSup200 += montantChèque;
			}
			if (montantChèqueMin == 0 || montantChèque < montantChèqueMin) {
				numChèqueMin = numChèque;
				montantChèqueMin = montantChèque;
			}
			if (montantChèqueMax == 0 || montantChèque > montantChèqueMax) {
				numChèqueMax = numChèque;
				montantChèqueMax = montantChèque;
			}
			System.out.println("Quel est le numéro du chèque? Entrez 0 pour finir");
			numChèque = scanner();
		}
	}

	public static double moyenne() {
		moyenneMontantChèques = montantTotalChèques / nbrTotalChèque;
		return moyenneMontantChèques;
	}

	public static void affichage() {
		if (nbrTotalChèque > 0) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("					Vos statistiques");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Vous avez entré " + nbrTotalChèque + " chèques");
			System.out.println("Le montant total de vos chèques est de " + montantChèque + "€");
			System.out.println("La moyenne de vos montants est de " + moyenne() + "€");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("	Il y a " + nbrChèqueInf200 + " chèques dont le montant est inférieur à 200€");
			System.out.println("	Leurs sommes est de " + montantChèqueInf200 + "€");
			System.out.println("--------------------------------------------------------------------------");
			System.out
					.println("	Il y a " + nbrChèqueSup200 + " chèques dont le montant est supérieur ou égal à 200€");
			System.out.println("	Leurs sommes est de " + montantChèqueSup200 + "€");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println(
					"Le chèque n°" + numChèqueMin + " d'une vlaur de " + montantChèqueMin + "€ est le plus petit ");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println(
					"Le chèque n°" + numChèqueMax + " d'une vlaur de " + montantChèqueMax + "€ est le plus grand ");
		} else {
			System.out.println("Vous n'avez pas entré de chèque!");
		}
	}

	public static int scanner() {
		Scanner scan = new Scanner(System.in);
		int saisie = scan.nextInt();
		return saisie;
	}
}
