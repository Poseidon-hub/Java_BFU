package Lab3;

import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<User> users;
    private List<Cinema> cinemas;

    public AuthService() {
        users = new ArrayList<>();
        cinemas = new ArrayList<>();

        // Добавляем тестовых пользователей
        users.add(new User("admin", "admin123", true));
        users.add(new User("user", "user123", false));

        // Добавляем тестовые кинотеатры и залы
        Cinema cinema1 = new Cinema("Киномакс", "ул. Ленина, 10");
        cinema1.addHall("Зал 1", 10, 20); // 10 рядов, 20 мест в ряду
        cinema1.addHall("Зал 2", 8, 15);  // 8 рядов, 15 мест в ряду
        cinemas.add(cinema1);

        Cinema cinema2 = new Cinema("Синема Парк", "пр. Мира, 25");
        cinema2.addHall("Зал A", 12, 25); // 12 рядов, 25 мест в ряду
        cinema2.addHall("Зал B", 6, 10);  // 6 рядов, 10 мест в ряду
        cinemas.add(cinema2);

        // Добавляем тестовые сеансы
        cinema1.addSession("Матрица", "13:00", 120, cinema1.getHalls().get(0)); // Зал 1
        cinema1.addSession("Интерстеллар", "16:00", 150, cinema1.getHalls().get(1)); // Зал 2
        cinema2.addSession("Форсаж", "14:00", 140, cinema2.getHalls().get(0)); // Зал A
    }

    // Метод для поиска ближайшего сеанса с свободными местами
    public Session findNearestSessionWithAvailableSeats(String movieName) {
        Session nearestSession = null;
        for (Cinema cinema : cinemas) {
            for (Session session : cinema.getSessions()) {
                if (session.getMovieName().equalsIgnoreCase(movieName)) {
                    // Проверяем, есть ли свободные места
                    if (cinema.getTickets().stream().filter(t -> t.getSession().equals(session)).count() <
                            session.getHall().getRows() * session.getHall().getSeatsPerRow()) {
                        if (nearestSession == null || session.getStartTime().compareTo(nearestSession.getStartTime()) < 0) {
                            nearestSession = session;
                        }
                    }
                }
            }
        }
        return nearestSession;
    }

    // Остальные методы остаются без изменений
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean register(String username, String password, boolean isAdmin) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Пользователь уже существует
            }
        }
        users.add(new User(username, password, isAdmin));
        return true;
    }

    public void addCinema(String name, String address) {
        cinemas.add(new Cinema(name, address));
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public Cinema findCinemaByName(String name) {
        for (Cinema cinema : cinemas) {
            if (cinema.getName().equalsIgnoreCase(name)) {
                return cinema;
            }
        }
        return null;
    }
}