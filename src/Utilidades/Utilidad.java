package Utilidades;

import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Utilidad {

	public static void sleep() {

		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		final Runnable runnable = new Runnable() {
			int countdownStarter = 5;

			public void run() {

				System.out.println(countdownStarter);
				countdownStarter--;

				if (countdownStarter < 0) {
					System.out.println("Timer Over!");
					scheduler.shutdown();
				}
			}
		};

		scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);

	}

	public static void limpiaPantalla() {
		for (int i = 0; i < 8; i++) {
			System.out.print("\n");
		}

	}

	public static void sleep2() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
