package Lab3;

public class Session {
    private String movieName;
    private String startTime; // Время начала сеанса в формате "HH:MM"
    private int durationMinutes; // Длительность фильма в минутах
    private Hall hall;

    public Session(String movieName, String startTime, int durationMinutes, Hall hall) {
        this.movieName = movieName;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.hall = hall;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public Hall getHall() {
        return hall;
    }

    @Override
    public String toString() {
        return "Фильм: " + movieName + ", Начало: " + startTime + ", Длительность: " + durationMinutes + " мин., " +
                "Зал: " + hall.getName() + " (Рядов: " + hall.getRows() + ", Мест в ряду: " + hall.getSeatsPerRow() + ")";
    }
}