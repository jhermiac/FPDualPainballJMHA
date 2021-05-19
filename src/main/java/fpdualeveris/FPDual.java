package fpdualeveris;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import operators.Pinball;

/**
 * 
 * -- DESAFÍO JAVA PINBALL - FP DUAL EVERIS
 * 
 * @author Juan Manuel Hermida Acuña
 *
 */
public class FPDual {

	/** LOGGER */
	final static Logger LOGGER = LoggerFactory.getLogger(Pinball.class);

	/**
	 * -- MÉTODO PRINCIPAL
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean carryOn = false;
		int points;

		// Instrucciones
		System.out.println("-- BIENVENIDO A TU JUEGO FAVORITO --");
		System.out.println("-- PINBALL --");
		System.out.println("Instrucciones: \r\n" + "** 1€ -> 2 tiradas\r\n" + "** 2€ -> 5 tiradas\r\n" + "** 3€ -> 10 tiradas\r\n" + "** 5€ -> 15 tiradas\r\n"
		        + "-------------------\r\n" + "** PARA GANAR NECESITAS ACUMULAR 100 PUNTOS ");

		// Se quiere pregunar al jugador, si en el caso de no conseeguir los puntos suficientes quiera volver a jugar
		do {

			// Variables
			int repeats = 0;
			int money = 0;
			boolean stop1 = false;

			// Se quiere conseguir que el numero a introducir como numero sea válido y no se permita otra cosa
			while (stop1 == false) {

				System.out.println("-- Introduca el dinero por la ranura introduciendo la cantidad justa: ");

				// Se escanea y se guarda el número que se ha introducido por pantalla en la variable @money.
				Scanner escaner = new Scanner(System.in);
				try {
					money = escaner.nextInt();
					if (money == 1 || money == 2 || money == 3 || money == 5) {
						stop1 = true;
					} else {
						System.out.println("Has introducido una cantidad invalida, vuelve a intertalo");
					}

				} catch (InputMismatchException e) {
					System.out.println("Valor introducido no válido: " + e);
				}
			}

			// Dependiendo del money que entre por la máquina, el jugador tendrá más o menos tiradas
			repeats = checkMoney(money);

			/*
			 * Las repeteciones, que la hemos sacado del if anterior, la introducimos en el método launchBall de la clase Pinball, método que devuelve los
			 * puntos conseguidos. Guardamos los puntos en una variable
			 */
			points = Pinball.launchBall(repeats);

			/*
			 * Con el método comprobación, comoprobamos si el jugador ha conseguido suficientes puntos para ganar o tiene que seguir tirando money.
			 */
			check(points);

			System.out.println("========================");
			System.out.println("¿QUIERES VOLVER A JUGAR?");
			String answer = sc.nextLine();

			if (answer.equalsIgnoreCase("Si")) {
				carryOn = true;
			} else if (answer.equalsIgnoreCase("No")) {
				carryOn = false;
				System.out.println("-------------");
				System.out.println("FIN DEL JUEGO");
			}

		} while (points <= 100 && carryOn == true);

	}

	/**
	 * Con este método, compruebo el money que entra por la máquina y el jugador adquiere más o menos tiradas.
	 * 
	 * @param money
	 * @return repeat
	 */
	private static int checkMoney(int money) {
		int repeats = 0;

		if (money == 1) {
			repeats = 2;
		} else if (money == 2) {
			repeats = 5;

		} else if (money == 3) {
			repeats = 10;
		} else if (money == 5) {
			repeats = 15;
		}

		return repeats;
	}

	/**
	 * Con este método comprobamos si ha conseguido los puntos suficientes para ganar.
	 * 
	 * @param points
	 */
	private static void check(int points) {

		// Condiciones para ganar
		if (points >= 100) {

			LOGGER.info("PUNTOS: {}", points);

			System.out.println("ENHORABUENA!! PASE A RECOGER SU PREMIO");

		} else {

			LOGGER.info("PUNTOS: {}", points);
			System.out.println("-- GAME OVER --");
		}
	}

}
