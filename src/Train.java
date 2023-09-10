import java.util.ArrayList;

class Train {
    private String name;
    private String time;
    private int passengerStrength;
    private int trainNumber;
    private ArrayList<Passenger> passengers;

    public Train(String name, String time, int passengerStrength, int trainNumber) {
        this.name = name;
        this.time = time;
        this.passengerStrength = passengerStrength;
        this.trainNumber = trainNumber;
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public int getPassengerStrength() {
        return passengerStrength;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public boolean isSeatAvailable(int seatNumber) {
        return passengers.size() < passengerStrength && !isSeatBooked(seatNumber);
    }

    public boolean isSeatBooked(int seatNumber) {
        for (Passenger passenger : passengers) {
            if (passenger.getSeatNumber() == seatNumber) {
                return true;
            }
        }
        return false;
    }

    public void bookSeat(String passengerName, int seatNumber) {
        if (isSeatAvailable(seatNumber)) {
            passengers.add(new Passenger(passengerName, seatNumber));
            System.out.println("Seat booked successfully!");
        } else {
            System.out.println("Seat is already booked or not available.");
        }
    }

    public void cancelSeat(int seatNumber) {
        for (Passenger passenger : passengers) {
            if (passenger.getSeatNumber() == seatNumber) {
                passengers.remove(passenger);
                System.out.println("Seat canceled successfully!");
                return;
            }
        }
        System.out.println("Seat not found or cannot be canceled.");
    }
    public void displayTicket() {
        System.out.println("Train Name: " + name);
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Passengers:");
        if (passengers != null) {
            for (Passenger passenger : passengers) {
                System.out.println("Seat Number: " + passenger.getSeatNumber() + "\tPassenger Name: " + passenger.getName());
            }
        } else {
            System.out.println("No Passengers");
        }
    }
}