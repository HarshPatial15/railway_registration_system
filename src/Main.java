import java.util.Scanner;

class RailwayReservationSystem {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Railway Reservation System");
            System.out.println("1. Display Available Trains");
            System.out.println("2. Check Seat Availability");
            System.out.println("3. Book a Seat");
            System.out.println("4. Cancel a Seat");
            System.out.println("5. Display Ticket");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reservationSystem.displayAvailableTrains();
                    break;
                case 2:
                    // Implement seat availability chec
                    System.out.print("Enter Train Number: ");
                    int trainNumberToCheck = scanner.nextInt();
                    System.out.print("Enter Seat Number: ");
                    int seatNumberToCheck = scanner.nextInt();

                    Train trainToCheck = reservationSystem.getTrainByNumber(trainNumberToCheck);
                    if (trainToCheck != null) {
                        if (trainToCheck.isSeatAvailable(seatNumberToCheck)) {
                            System.out.println("Seat is available.");
                        } else {
                            System.out.println("Seat is not available.");
                        }
                    } else {
                        System.out.println("Train not found.");
                    }
                    break;
                case 3:
                    // Implement seat booking
                    System.out.print("Enter Train Number: ");
                    int trainNumberToBook = scanner.nextInt();
                    System.out.print("Enter Passenger Name: ");
                    String passengerName = scanner.next();
                    System.out.print("Enter Seat Number: ");
                    int seatNumberToBook = scanner.nextInt();

                    Train trainToBook = reservationSystem.getTrainByNumber(trainNumberToBook);
                    if (trainToBook != null) {
                        trainToBook.bookSeat(passengerName, seatNumberToBook);
                    } else {
                        System.out.println("Train not found.");
                    }
                    break;
                case 4:
                    // Implement seat cancellation
                    System.out.print("Enter Train Number: ");
                    int trainNumberToCancel = scanner.nextInt();
                    System.out.print("Enter Seat Number to Cancel: ");
                    int seatNumberToCancel = scanner.nextInt();

                    Train trainToCancel = reservationSystem.getTrainByNumber(trainNumberToCancel);
                    if (trainToCancel != null) {
                        trainToCancel.cancelSeat(seatNumberToCancel);
                    } else {
                        System.out.println("Train not found.");
                    }

                    break;
                case 5:
                    // Implement ticket display
                    System.out.print("Enter Train Number for Ticket Display: ");
                    int trainNumberToDisplay = scanner.nextInt();

                    Train trainToDisplay = reservationSystem.getTrainByNumber(trainNumberToDisplay);
                    if (trainToDisplay != null) {
                        trainToDisplay.displayTicket();
                    } else {
                        System.out.println("Train not found.");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using the Railway Reservation System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}