import com.sbt.javaschool.rnd.Validator;
import com.sbt.javaschool.rnd.ValidatorImpl;

import java.util.HashMap;
import java.util.Map;

public class ControlUserImpl implements ControlUser {

    private final Map<Integer, User> map = new HashMap();
    private Validator val = new ValidatorImpl();
    private User user = new UserImpl();

    public boolean addNewUser(String firstName, String lastName, String pass) {
        if(val.validName(firstName))
            user.setfName(firstName);
        if(val.validName(lastName))
            user.setlName(lastName);
        return false;
    }

    public boolean removeUser(String firstName, String lastName, String pass) {
        return false;
    }

    public boolean updateUser(User user) {
        return false;
    }

    public boolean addMail(Integer id, String eMail) {
        return false;
    }

    public boolean addAge(Integer id, Integer age) {
        return false;
    }

    public User getUser(Integer id) {
        return null;
    }
}
