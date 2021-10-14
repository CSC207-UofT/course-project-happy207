/* This is an entity class named Flight.
 * Belows are the information each class instance stores.
 * flight number
 * origin of the flight
 * destination of the flight
 * departure and arrival time of fight
 * distance traveled from departure to destination
 * seat capacity (total seat numbers) and number of available seat
 * boarding gate
 * the array of seat numbers

 */

import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



public class Flight {
    private final String flightNumber;
    private final String originCity;
    private final String destinationCity;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final int distanceTraveled;
    private final int totalSeats;
    private final String boardingGate;
    private ArrayList<String> seatNumberArray;
    private int availableSeats;


    /**
     * Construct a Flight giving it the given flight_number, origin, destination, departureTime, arrivalTime,
     * distance_traveled, totalSeats, availableSeats, and fuel_capacity.
     * @param flightNumber flight_number of this flight
     * @param originCity string of departure
     * @param destinationCity string of destination
     * @param departureTime departure time in the format of [year,month,day,hour,minute]
     * @param arrivalTime arrival time in the format of [year,month,day,hour,minute]
     * @param totalNumSeats the number of seats that this flight can have
     * @param numSeatAvailable number of seats booked
     * @param distance_traveled The flight's length
     * @param boardingGate the boarding gate of this flight
     * @param seatNumberArray    array of all seat numbers of this flight
     */
    public Flight(String flightNumber, String originCity, String destinationCity, ArrayList<String> departureTime,
                  ArrayList<String> arrivalTime, int totalNumSeats, int numSeatAvailable, int distance_traveled
            , String boardingGate, ArrayList<String> seatNumberArray){
        this.flightNumber = flightNumber;
        this.distanceTraveled = distance_traveled;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.totalSeats = totalNumSeats;
        this.availableSeats = numSeatAvailable;
        this.boardingGate = boardingGate;
        this.seatNumberArray = seatNumberArray;

        // set departure and arrival time
        int dYear = Integer.parseInt(departureTime.get(0));
        int dMonth = Integer.parseInt(departureTime.get(1));
        int dDay = Integer.parseInt(departureTime.get(2));
        int dHour = Integer.parseInt(departureTime.get(3));
        int dMinute = Integer.parseInt(departureTime.get(4));
        int aYear = Integer.parseInt(arrivalTime.get(0));
        int aMonth = Integer.parseInt(arrivalTime.get(1));
        int aDay = Integer.parseInt(arrivalTime.get(2));
        int aHour = Integer.parseInt(arrivalTime.get(3));
        int aMinute = Integer.parseInt(arrivalTime.get(4));
        this.arrivalTime =  LocalDateTime.of(aYear,aMonth,aDay,aHour,aMinute);
        this.departureTime = LocalDateTime.of(dYear,dMonth,dDay,dHour,dMinute);
    }

    public String getFlightNumber() {return flightNumber;}

    public String getOriginCity(){return originCity;}

    public String getDestinationCity(){return destinationCity;}

    public LocalDateTime getDepartureTime(){return departureTime;}

    public LocalDateTime getArrivalTime(){return arrivalTime;}

    public int getTotalSeats() {return totalSeats;}

    public int getAvailableSeats() {return availableSeats;}
    //public void ResetAvailableSeats(int availableSeats) {this.availableSeats = availableSeats;}

    public int getDistanceTraveled() {return distanceTraveled;}

    public String getBoardingGate() {return boardingGate;}

    public ArrayList<String> getSeatNumberArray() {return seatNumberArray;}
    //public void setSeatNumberArray(ArrayList<String> seatNumberArray) {this.seatNumberArray = seatNumberArray;}
    public boolean ReserveOneSeat(String seatNumber){
        if(seatNumberArray.contains(seatNumber)){
            int index = seatNumberArray.indexOf(seatNumber);
            seatNumberArray.set(index,"Booked");
            this.availableSeats --;
            return true;
        }
        return false;
    }



/*
    @Override
    public String toString(){
        return "Flight Number: " + this.getFlightNumber() + '}';
    }
    */
/**
 Print all info about the flight
 *//*

    public void printInfo() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Origin: " + originCity);
        System.out.println("Destination: " + destinationCity);
        System.out.println("Number of seats available: "+ availableSeats);
        System.out.println("Total number of seats of this flight: "+ totalSeats);

        System.out.println("Distance traveled: "+ distanceTraveled);


        DateTimeFormatter FormatObj = DateTimeFormatter.ofPattern("yyyy MMM dd  HH:mm:ss");
        String formattedArrivalTime = arrivalTime.format(FormatObj);
        String formattedDepartureTime = departureTime.format(FormatObj);
        System.out.println("Arrival Time is: "+formattedArrivalTime);
        System.out.println("Departure Time is: "+formattedDepartureTime);

    }
*/



}
