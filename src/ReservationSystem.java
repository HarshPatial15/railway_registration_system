import java.util.ArrayList;

class ReservationSystem {
    private ArrayList<Train> trains;

    public ReservationSystem() {
        trains = new ArrayList<>();
        // Adding sample trains
        trains.add(new Train("Mumbai - Delhi", "13:05", 50, 1010));
        trains.add(new Train("Delhi - Jaipur", "7:00", 50, 2013));
        trains.add(new Train("Prayagraj - Delhi", "10:00", 50, 3045));
    }

    public Train getTrainByNumber(int trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }
        return null;
    }

    public void displayAvailableTrains() {
        System.out.println("Available Trains:");
        System.out.println("Train Name\tTime\tPassenger Strength\tTrain Number");
        for (Train train : trains) {
            System.out.println(train.getName() + "\t" + train.getTime() + "\t" +
                    train.getPassengerStrength() + "\t" + train.getTrainNumber());
        }
    }
}