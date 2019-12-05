public interface loginUser {

    public User login(Integer id, String pass);

    public User login(String name, String eMail, String pass);

}
