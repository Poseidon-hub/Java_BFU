package Lab3;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMainMenu(); // Вывод главного меню
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    handleLogin(authService, scanner); // Обработка входа
                    break;

                case 2:
                    handleRegistration(authService, scanner); // Обработка регистрации
                    break;

                case 3:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }

            // Пауза перед следующим шагом
            System.out.println("\nНажмите Enter, чтобы продолжить...");
            scanner.nextLine();
        }
    }

    // Метод для вывода главного меню
    private static void printMainMenu() {
        System.out.println("====================================");
        System.out.println("Система авторизации кинотеатра");
        System.out.println("1. Вход");
        System.out.println("2. Регистрация");
        System.out.println("3. Выход");
        System.out.println("====================================");
    }

    // Метод для обработки входа
    private static void handleLogin(AuthService authService, Scanner scanner) {
        System.out.print("Введите логин: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        User user = authService.login(username, password);
        if (user != null) {
            System.out.println("Успешный вход!");
            if (user.isAdmin()) {
                handleAdminMenu(authService, scanner); // Меню для администратора
            } else {
                handleUserMenu(authService, scanner); // Меню для пользователя
            }
        } else {
            System.out.println("Неверный логин или пароль.");
        }
    }

    // Метод для обработки регистрации
    private static void handleRegistration(AuthService authService, Scanner scanner) {
        System.out.print("Введите новый логин: ");
        String username = scanner.nextLine();
        System.out.print("Введите новый пароль: ");
        String password = scanner.nextLine();
        System.out.print("Вы администратор? (true/false): ");
        boolean isAdmin = scanner.nextBoolean();
        scanner.nextLine(); // consume newline

        if (authService.register(username, password, isAdmin)) {
            System.out.println("Регистрация прошла успешно!");
        } else {
            System.out.println("Пользователь с таким логином уже существует.");
        }
    }

    // Меню для администратора
    private static void handleAdminMenu(AuthService authService, Scanner scanner) {
        while (true) {
            System.out.println("\n====================================");
            System.out.println("Меню администратора");
            System.out.println("1. Добавить кинотеатр");
            System.out.println("2. Просмотреть список кинотеатров");
            System.out.println("3. Добавить зал в кинотеатр");
            System.out.println("4. Создать сеанс");
            System.out.println("5. Выйти в главное меню");
            System.out.println("====================================");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Введите название кинотеатра: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите адрес кинотеатра: ");
                    String address = scanner.nextLine();
                    authService.addCinema(name, address);
                    System.out.println("Кинотеатр успешно добавлен!");
                    break;

                case 2:
                    List<Cinema> cinemas = authService.getCinemas();
                    if (cinemas.isEmpty()) {
                        System.out.println("Список кинотеатров пуст.");
                    } else {
                        System.out.println("Список кинотеатров:");
                        for (Cinema cinema : cinemas) {
                            System.out.println(cinema);
                            List<Hall> halls = cinema.getHalls();
                            if (!halls.isEmpty()) {
                                System.out.println("Залы:");
                                for (Hall hall : halls) {
                                    System.out.println("  " + hall);
                                }
                            }
                            List<Session> sessions = cinema.getSessions();
                            if (!sessions.isEmpty()) {
                                System.out.println("Сеансы:");
                                for (Session session : sessions) {
                                    System.out.println("  " + session);
                                }
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.print("Введите название кинотеатра: ");
                    String cinemaName = scanner.nextLine();
                    Cinema cinema = authService.findCinemaByName(cinemaName);
                    if (cinema != null) {
                        System.out.print("Введите название зала: ");
                        String hallName = scanner.nextLine();
                        System.out.print("Введите количество рядов: ");
                        int rows = scanner.nextInt();
                        System.out.print("Введите количество мест в ряду: ");
                        int seatsPerRow = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        cinema.addHall(hallName, rows, seatsPerRow);
                        System.out.println("Зал успешно добавлен!");
                    } else {
                        System.out.println("Кинотеатр не найден.");
                    }
                    break;

                case 4:
                    System.out.print("Введите название кинотеатра: ");
                    String cinemaNameForSession = scanner.nextLine();
                    Cinema cinemaForSession = authService.findCinemaByName(cinemaNameForSession);
                    if (cinemaForSession != null) {
                        System.out.print("Введите название фильма: ");
                        String movieName = scanner.nextLine();
                        System.out.print("Введите время начала сеанса (HH:MM): ");
                        String startTime = scanner.nextLine();
                        System.out.print("Введите длительность фильма (в минутах): ");
                        int durationMinutes = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.print("Введите название зала: ");
                        String hallNameForSession = scanner.nextLine();
                        Hall hallForSession = null;
                        for (Hall hall : cinemaForSession.getHalls()) {
                            if (hall.getName().equalsIgnoreCase(hallNameForSession)) {
                                hallForSession = hall;
                                break;
                            }
                        }
                        if (hallForSession != null) {
                            cinemaForSession.addSession(movieName, startTime, durationMinutes, hallForSession);
                            System.out.println("Сеанс успешно создан!");
                        } else {
                            System.out.println("Зал не найден.");
                        }
                    } else {
                        System.out.println("Кинотеатр не найден.");
                    }
                    break;

                case 5:
                    return; // Выход в главное меню

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }

            // Пауза перед следующим шагом
            System.out.println("\nНажмите Enter, чтобы продолжить...");
            scanner.nextLine();
        }
    }

    // Меню для пользователя
    private static void handleUserMenu(AuthService authService, Scanner scanner) {
        while (true) {
            System.out.println("\n====================================");
            System.out.println("Меню пользователя");
            System.out.println("1. Просмотреть список кинотеатров");
            System.out.println("2. Купить билет");
            System.out.println("3. Найти ближайший сеанс с свободными местами");
            System.out.println("4. Выйти в главное меню");
            System.out.println("====================================");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    List<Cinema> cinemas = authService.getCinemas();
                    if (cinemas.isEmpty()) {
                        System.out.println("Список кинотеатров пуст.");
                    } else {
                        System.out.println("Список кинотеатров:");
                        for (Cinema cinema : cinemas) {
                            System.out.println(cinema);
                            List<Session> sessions = cinema.getSessions();
                            if (!sessions.isEmpty()) {
                                System.out.println("Сеансы:");
                                for (Session session : sessions) {
                                    System.out.println("  " + session);
                                    cinema.printHallPlan(session); // План зала
                                }
                            }
                        }
                    }
                    break;

                // В методе handleUserMenu (для пользователя)
                case 2:
                    System.out.print("Введите название кинотеатра: ");
                    String cinemaName = scanner.nextLine();
                    Cinema cinema = authService.findCinemaByName(cinemaName);
                    if (cinema != null) {
                        List<Session> sessions = cinema.getSessions();
                        if (sessions.isEmpty()) {
                            System.out.println("Нет доступных сеансов.");
                        } else {
                            System.out.println("Доступные сеансы:");
                            for (int i = 0; i < sessions.size(); i++) {
                                System.out.println((i + 1) + ". " + sessions.get(i)); // Информация о сеансе
                            }
                            System.out.print("Выберите сеанс: ");
                            int sessionIndex = scanner.nextInt() - 1;
                            scanner.nextLine(); // consume newline
                            if (sessionIndex >= 0 && sessionIndex < sessions.size()) {
                                Session session = sessions.get(sessionIndex);
                                System.out.println("Информация о зале:");
                                System.out.println("  " + session); // Параметры зала
                                cinema.printHallPlan(session); // План зала

                                System.out.print("Введите номер ряда: ");
                                int row = scanner.nextInt();
                                System.out.print("Введите номер места: ");
                                int seat = scanner.nextInt();
                                scanner.nextLine(); // consume newline
                                if (cinema.buyTicket(session, row, seat)) {
                                    System.out.println("Билет успешно куплен!");
                                } else {
                                    System.out.println("Не удалось купить билет. Возможно, место уже занято или не существует.");
                                }
                            } else {
                                System.out.println("Неверный выбор сеанса.");
                            }
                        }
                    } else {
                        System.out.println("Кинотеатр не найден.");
                    }
                    break;

                // В методе handleUserMenu (для пользователя)
                case 3:
                    System.out.print("Введите название фильма: ");
                    String movieName = scanner.nextLine();
                    Session nearestSession = authService.findNearestSessionWithAvailableSeats(movieName);
                    if (nearestSession != null) {
                        System.out.println("Ближайший сеанс с свободными местами:");
                        System.out.println("  Фильм: " + nearestSession.getMovieName());
                        System.out.println("  Начало: " + nearestSession.getStartTime());
                        System.out.println("  Длительность: " + nearestSession.getDurationMinutes() + " мин.");
                        System.out.println("  Кинотеатр: " + nearestSession.getHall().getCinema().getName()); // Используем getCinema()
                        System.out.println("  Зал: " + nearestSession.getHall().getName());
                        System.out.println("  План зала:");
                        nearestSession.getHall().getCinema().printHallPlan(nearestSession);
                    } else {
                        System.out.println("Нет доступных сеансов для выбранного фильма.");
                    }
                    break;

                // В методе handleUserMenu (для пользователя)
                case 4:
                    return; // Выход в главное меню

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }

            // Пауза перед следующим шагом
            System.out.println("\nНажмите Enter, чтобы продолжить...");
            scanner.nextLine();
        }
    }
}