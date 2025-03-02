package Lab3;

public class Ticket {
    private Session session;
    private int row;
    private int seat;

    public Ticket(Session session, int row, int seat) {
        this.session = session;
        this.row = row;
        this.seat = seat;
    }

    public Session getSession() {
        return session;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Билет на фильм: " + session.getMovieName() + ", Зал: " + session.getHall().getName() +
                ", Ряд: " + row + ", Место: " + seat + ", Время: " + session.getStartTime();
    }
}