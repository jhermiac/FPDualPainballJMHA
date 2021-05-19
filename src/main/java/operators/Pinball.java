package operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pinball {

	/** LOGGER */
	final static Logger LOGGER = LoggerFactory.getLogger(Pinball.class);

	/**
	 * MÉTODO PARA LANZAR LA BOLA
	 * 
	 * @param repeats
	 * @return
	 */

	public static int launchBall(int repeats) {

		int points = 0;

		// Bucle que se repetirá tantas veces como la variable repeats marque, que viene del main según el dinero que meta el cliente por la máquina
		for (int i = 0; i < repeats; i++) {

			LOGGER.trace("Interación del bucle: {}", i);

			int random = (int) (Math.random() * 10 + 1);

			LOGGER.trace("Número random: {}", random);

			if (random == 1) {
				points += 10;
			} else if (random == 2) {
				points += 20;
			} else if (random == 3) {
				points += 30;

			} else if (random == 4) {
				points += 40;
			} else if (random == 5) {
				points += 50;

			} else if (random == 6) {
				points += 60;
			} else if (random == 7) {
				points += 70;
			} else if (random == 8) {
				points -= 20;
			} else {
				points += 0;
			}

			generateInfo(points, i);

		}

		return points;

	}

	/**
	 * @param points
	 * @param i
	 */
	private static void generateInfo(int points, int i) {

		System.out.println("----------------------------");
		System.out.println("* Tirada: " + (i + 1));
		System.out.println("* Puntos acumulados: " + points);
		System.out.println("----------------------------");
	}

}
