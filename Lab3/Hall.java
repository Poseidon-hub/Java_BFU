package Lab3;

public class Hall {
    private String name;
    private int rows;
    private int seatsPerRow;
    private Cinema cinema; // Ссылка на кинотеатр

    public Hall(String name, int rows, int seatsPerRow, Cinema cinema) {
        this.name = name;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.cinema = cinema;
    }

    public String getName() {
        return name;
    }

    public int getRows() {
        return rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public int getCapacity() {
        return rows * seatsPerRow;
    }

    public Cinema getCinema() {
        return cinema;
    }

    @Override
    public String toString() {
        return "Зал: " + name + ", Ряды: " + rows + ", Мест в ряду: " + seatsPerRow + ", Вместимость: " + getCapacity() + " мест";
    }
}
