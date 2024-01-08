# Cinema Booking System

This is a simple cinema booking system implemented in Java. The system allows users to interactively book and cancel seats, check seat availability, and view the seating arrangement in different cinema halls.

## Classes

### 1. Main Class (Main.java)

#### Overview
The `Main` class is the entry point of the application. It handles user input and provides a menu-driven interface for interacting with the cinema booking system.

#### Methods
- **main**: The main method initializes the cinema halls, prompts the user to select a hall, and continuously displays a menu for booking, canceling, checking availability, printing the seating arrangement, and exiting the program.

- **selectHall**: Prompts the user to select a cinema hall.

- **bookSeats**: Allows the user to book seats by specifying the row, number of seats, and seat numbers.

- **cancelBooking**: Allows the user to cancel a booking by specifying the row, number of seats, and seat numbers.

- **checkAvailability**: Checks the availability of seats in a specific row.

- **printSeatingArrangement**: Displays the current seating arrangement for a selected cinema hall.

- **getSeatStatus**: Returns the status of a seat as either booked ('O') or available ('X').

### 2. Initialization Class (Initialization.java)

#### Overview
The `Initialization` class is responsible for initializing the cinema halls with available seats.

#### Methods
- **initializeHall**: Initializes a cinema hall with rows and seats, marking all seats as available ('O').

### 3. Booking Class (Booking.java)

#### Overview
The `Booking` class contains methods for booking seats, canceling bookings, and checking seat availability.

#### Methods
- **bookSeats**: Marks selected seats as booked ('1') in a specific cinema hall.

- **cancelBooking**: Cancels the booking of selected seats in a specific cinema hall.

- **checkAvailability**: Checks if a specified number of seats is available in a particular row of a cinema hall.
