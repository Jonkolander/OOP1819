package Assignment14;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author pieterkoopman
 */
public class Taxi implements Runnable {

  private final int taxiId;
  private final int maxNrOfPassengers;
  private final int transportationTime;
  private final Station station;

  private int totalNrOfPassengers = 0;
  private int nrOfRides = 0;

  public Taxi(int nr, int maxNumberOfPassengers, int transportationTime, Station station) {
    this.taxiId = nr;
    this.maxNrOfPassengers = maxNumberOfPassengers;
    this.transportationTime = transportationTime;
    this.station = station;
    System.out.println("Taxi " + nr + " created");
  }

  /**
   * Calculates the total time of this taxi by multiplying the number of rides by the transportation time
   *
   * @return total time
   */
  public int calcTotalTime() {
    return transportationTime * nrOfRides;
  }

  public int getTotalNrOfPassengers() {
    return totalNrOfPassengers;
  }

  @Override
  public void run() {
    try {
      while (!station.isClosed() || station.waitingPassengers() > 0) {
        System.out.println("Waiting passengers: " + station.waitingPassengers());
        int nrOfPassengers = Math.min(station.waitingPassengers(), maxNrOfPassengers);
        station.leaveStation(nrOfPassengers);
        totalNrOfPassengers += nrOfPassengers;
        nrOfRides++;

        System.out.println("Taxi " + taxiId + " takes " + nrOfPassengers + " passengers");
        Thread.sleep(transportationTime);
      }
    } catch (InterruptedException error) {
      throw new Error(error);
    }
  }
}
