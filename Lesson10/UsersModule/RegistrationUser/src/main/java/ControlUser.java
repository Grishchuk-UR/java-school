public interface ControlUser {

   public boolean addNewUser(String firstName,
                             String lastName,
                             String pass);

   public boolean removeUser(String firstName,
                             String lastName,
                             String pass);

   public boolean updateUser(User user);

   public boolean addMail(Integer id, String eMail);

   public boolean addAge(Integer id, Integer age);

   public User getUser(Integer id);

}
