package Assignment14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class that holds the number of persons arriving by train at the station and waiting for a taxi
 */
public class Station {

  private int nrOfPassengersAtStation = 0;
  private int totalNrOfPassengers = 0;
  private boolean isClosed = false;

  private final Lock LOCK = new ReentrantLock();
  private final Condition THERE_ARE_PASSENGERS = LOCK.newCondition();
  // private final Condition THERE_ARE_NO_PASSENGERS = LOCK.newCondition();

  public void enterStation(int nrOfPassengers) {
    LOCK.lock();

    try {
      while (nrOfPassengersAtStation != 0) {
        THERE_ARE_PASSENGERS.await();
      }

      nrOfPassengersAtStation += nrOfPassengers;
      totalNrOfPassengers += nrOfPassengers;
      System.out.println(nrOfPassengers + " passengers arrived at station");
    } catch (InterruptedException error) {
      throw new Error(error);
    } finally {
      LOCK.unlock();
    }
  }

  /**
   * Ask for nrOfPassengers Passengers to leave the station
   *
   * @param requestedNrOfPassengers
   * @return number of passengers actually leaving
   */
  public void leaveStation(int requestedNrOfPassengers) {
    LOCK.lock();
    try {
      if (nrOfPassengersAtStation <= nrOfPassengersAtStation) {
        nrOfPassengersAtStation -= nrOfPassengersAtStation;
      } else {
        System.out.println("trying to take " + nrOfPassengersAtStation + " but station only has " + nrOfPassengersAtStation);
      }
      if (nrOfPassengersAtStation == 0) {
        THERE_ARE_PASSENGERS.signalAll();
      }
    } finally {
      LOCK.unlock();
    }

//    int actuallyLeaving = Math.min(requestedNrOfPassengers, nrOfPassengersAtStation);
//    nrOfPassengersAtStation -= actuallyLeaving;
//    return actuallyLeaving;
  }

  public int waitingPassengers() {
    LOCK.lock();
    int passengers;
    try {
      System.out.println("REEEEE: " + nrOfPassengersAtStation);
      passengers = nrOfPassengersAtStation;
    } finally {
      LOCK.unlock();
    }
    return passengers;
  }

  public void close() {
    LOCK.lock();
    try {
      isClosed = true;
    } finally {
      LOCK.unlock();
    }
  }

  public boolean isClosed() {
    LOCK.lock();
    boolean value;
    try {
      value = isClosed;
    } finally {
      LOCK.unlock();
    }
    return value;
  }

  public int getTotalNrOfPassengers() {
    LOCK.lock();
    int passengers;
    try {
      passengers = totalNrOfPassengers;
    } finally {
      LOCK.unlock();
    }
    return passengers;
  }
}
