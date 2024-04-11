import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Main
{
    static UsersBase users = new UsersBase();
    static Workout workout = new Workout();

    public static void main(String[] args)
    {
        boolean exit = true;
        Scanner scanner = null;
        while (exit)
        {

            System.out.println("Выберите действие:\n" +
                    "1. Регистрация\n" +
                    "2. Вход\n" +
                    "3. Завершить программу");
            scanner = new Scanner(System.in);

            if (scanner.hasNextInt())
            {
                int num = scanner.nextInt();
                if (num == 3)
                {
                    System.out.println("До новых встреч");
                    break;
                }
//                Selection toDo = new Selection();
                caseSelection(num);
            } else
            {
                System.out.println("Выберите корректный вариант\n");
            }

        }
        scanner.close();
    }

    private static void caseSelection(int num)
    {
        String name;
        String pass;
        Scanner scanner;
        switch (num)
        {
            case 1:
                System.out.println("Registration\n" +
                        "Введите имя\n");
                scanner = new Scanner(System.in);
                name = scanner.nextLine();
                System.out.println("Registration\n" +
                        "Введите пароль\n");
                scanner = new Scanner(System.in);
                pass = scanner.nextLine();
                users.newUser(name, pass);
                break;
            case 2:
                System.out.println("Sign On\n" +
                        "Введите имя\n");
                scanner = new Scanner(System.in);
                name = scanner.nextLine();
                System.out.println("Sign On\n" +
                        "Введите пароль\n");
                scanner = new Scanner(System.in);
                pass = scanner.nextLine();
                String userNameLogIn = users.signOn(name, pass);
                if (!userNameLogIn.isEmpty())
                {
                    workout.setUserName(userNameLogIn);
                    userActionSelection(userNameLogIn);
                }
                break;
            default:
                System.out.println(" Don't understand");
        }
    }

    private static void userActionSelection(String userName)
    {
        String user = userName;
        boolean exit = true;
        Scanner scanner = null;
        while (exit)
        {

            System.out.println("Выберите действие:\n" +
                    "1. Добавить тренировку\n" +
                    "2. Вывести список тренировок\n" +
                    "3. Выйти");
            scanner = new Scanner(System.in);

            if (scanner.hasNextInt())
            {
                int num = scanner.nextInt();
                if (num == 3)
                {
                    System.out.println("До новых встреч");
                    break;
                }
//
                caseSelectionUserAction(num, user);
            } else
            {
                System.out.println("Выберите корректный вариант\n");
            }

        }
//        scanner.close();
    }

    private static void caseSelectionUserAction(int num, String user)
    {
        LocalDate date;
        String type;
        String duration;
        String calories;
        String info;
        Scanner scanner;
        WorkoutDetails workoutDetails;
        switch (num)
        {
            case 1:
                System.out.println("Введите данные тренировки:\n" +
                        "дата в формате гггг-мм-дд\n");
                scanner = new Scanner(System.in);
                date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
                System.out.println("тип тренировки\n");
                scanner = new Scanner(System.in);
                type = scanner.nextLine();
                System.out.println("продолжительность в минутах\n");
                scanner = new Scanner(System.in);
                duration = scanner.nextLine();
                System.out.println("количество сожженых ккал\n");
                scanner = new Scanner(System.in);
                calories = scanner.nextLine();
                System.out.println("дополнительная информация (по желанию)\n");
                scanner = new Scanner(System.in);
                info = scanner.nextLine();
                if (info.isEmpty())
                {
                    workoutDetails = new WorkoutDetails(date, type, duration, calories);
                } else
                {
                    workoutDetails = new WorkoutDetails(date, type, duration, calories, info);
                }
                workout.addWorkoutForUser(user, workoutDetails);
                break;
            case 2:
                workout.getWorkout(user);
                break;
            default:
                System.out.println(" Don't understand");
        }
    }
}


