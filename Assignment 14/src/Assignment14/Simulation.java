package Assignment14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author pieterkoopman
 */
public class Simulation {

  /**
   * Constants for the size of the simulation
   */
  public static final int TRAIN_TRIPS = 10;
  public static final int MIN_TRAVELLERS = 60;
  public static final int MAX_TRAVELLERS = 90;
  public static final int CAPACITY_SMALL = 4;
  public static final int CAPACITY_LARGE = 7;
  public static final int TIME_SMALL = 2;
  public static final int TIME_LARGE = 3;
  public static final int NR_OF_TAXIS = 4;
  public static final int NR_OF_SMALL_TAXIS = 2;

  /**
   * main elements of the simulation
   */
  private final Taxi[] taxis;
  private final Train train;
  private final Station station;

  /**
   * hasEnded: is the simulation finished? nextTaxi: number of the taxi to be use in next step
   */
  private boolean hasEnded = false;
  private int nextTaxi = 0;

  /**
   * Constructor: create station and small and large taxis
   */
  public Simulation() {
    station = new Station();
    taxis = new Taxi[NR_OF_TAXIS];
    train = new Train(station);
  }

  public void start() {
    ExecutorService executor = Executors.newCachedThreadPool();

    executor.execute(train);
    for (int i = 0; i < NR_OF_TAXIS; i++) {
      taxis[i] = i < NR_OF_SMALL_TAXIS
              ? new Taxi(i + 1, CAPACITY_SMALL, TIME_SMALL, station)
              : new Taxi(i + 1, CAPACITY_LARGE, TIME_LARGE, station);
      executor.execute(taxis[i]);
    }

    executor.shutdown();

    try {
      hasEnded = executor.awaitTermination(1, TimeUnit.MINUTES);
      if (hasEnded) {
        System.out.println("\nSIMULATION HAS TERMINATED!\n");
      } else {
        System.out.println("Timed out while waiting for tasks to finish.");
      }
    } catch (InterruptedException error) {
      throw new Error(error);
    }
  }

  public boolean ended() {
    return hasEnded;
  }

  public void showStatistics() {
    System.out.println("All persons have been transported");
    System.out.println("Total transport time in this simulation:" + calcTotalTime(taxis));
    System.out.println("Total number of train travelers: " + station.getTotalNrOfPassengers());
    System.out.println("Total number of persons transported in this simulation: " + calcTotalNrOfPassengers(taxis));
  }

  /**
   * Calculates the total time of the simulation by looping over all taxis
   *
   * @param taxis
   * @return total time
   */
  private static int calcTotalTime(Taxi[] taxis) {
    int time = 0;
    for (Taxi taxi : taxis) {
      time += taxi.calcTotalTime();
    }
    return time;
  }

  /**
   * Calculates the total number of passengers that has been transported by looping over all taxis
   *
   * @param taxis
   * @return total number of passengers
   */
  private static int calcTotalNrOfPassengers(Taxi[] taxis) {
    int total = 0;
    for (Taxi taxi : taxis) {
      total += taxi.getTotalNrOfPassengers();
    }
    return total;
  }
}
