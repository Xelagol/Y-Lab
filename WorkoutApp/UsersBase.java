import java.util.HashMap;
import java.util.Map;

public class UsersBase
{


    Map<String, String> users = new HashMap<>();
    String name;
    String pass;

    public Map<String, String> getUsers()
    {
        return users;
    }

    public void newUser(String name, String pass)
    {
        if (users.containsKey(name))
        {
            System.out.println("Пользователь с таким именем существует, введите другое имя\n**************");
        } else
        {
            users.put(name, pass);
            System.out.println("Пользователь с именем " + name + " и паролем " + pass + " создан");
        }

        System.out.println(users);

    }

    public String signOn(String name, String pass)
    {
        try
        {
            String pswr = users.get(name);

            if (pswr.equals(pass))
            {
                System.out.println(name + ", Вы успешно вошли в систему");
                return name;
            } else
            {
                System.out.println("Введены не корретные имя пользователя и/или пароль");
                return "";
            }
        } catch (NullPointerException e)
        {
            System.out.println("Ошибка ввода данных");
        }
        return "";
    }

}
