public class User
{
    private String name;
    private String pass;

    public String getName()
    {
        return name;
    }

    public String getPass()
    {
        return pass;
    }

    public User(String name, String pass)
    {
        this.name = name;
        this.pass = pass;
        User user = new User(name, pass);

    }
}
