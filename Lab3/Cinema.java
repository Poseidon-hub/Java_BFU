package Lab3;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String name;
    private String address;
    private List<Hall> halls;
    private List<Session> sessions;
    private List<Ticket> tickets;

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.halls = new ArrayList<>();
        this.sessions = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // Метод для добавления зала
    public void addHall(String name, int rows, int seatsPerRow) {
        halls.add(new Hall(name, rows, seatsPerRow, this)); // Передаем текущий кинотеатр
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void addSession(String movieName, String startTime, int durationMinutes, Hall hall) {
        sessions.add(new Session(movieName, startTime, durationMinutes, hall));
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public boolean buyTicket(Session session, int row, int seat) {
        if (row < 1 || row > session.getHall().getRows() || seat < 1 || seat > session.getHall().getSeatsPerRow()) {
            return false; // Место не существует
        }
        for (Ticket ticket : tickets) {
            if (ticket.getSession().equals(session) && ticket.getRow() == row && ticket.getSeat() == seat) {
                return false; // Место уже занято
            }
        }
        tickets.add(new Ticket(session, row, seat));
        return true;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void printHallPlan(Session session) {
        Hall hall = session.getHall();
        int rows = hall.getRows();
        int seatsPerRow = hall.getSeatsPerRow();

        System.out.println("План зала '" + hall.getName() + "':");
        System.out.print("   ");
        for (int seat = 1; seat <= seatsPerRow; seat++) {
            System.out.printf("%2d ", seat); // Номера мест
        }
        System.out.println();

        for (int row = 1; row <= rows; row++) {
            System.out.printf("%2d ", row); // Номер ряда
            for (int seat = 1; seat <= seatsPerRow; seat++) {
                boolean isOccupied = false;
                for (Ticket ticket : tickets) {
                    if (ticket.getSession().equals(session) && ticket.getRow() == row && ticket.getSeat() == seat) {
                        isOccupied = true;
                        break;
                    }
                }
                System.out.print(isOccupied ? " X " : " O "); // X - занято, O - свободно
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Кинотеатр: " + name + ", Адрес: " + address;
    }
}