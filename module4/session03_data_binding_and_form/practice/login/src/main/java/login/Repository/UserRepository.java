package login.Repository;

import login.model.Login;
import login.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> eList;

    static {
        eList = new ArrayList<>();
        eList.add(new User("john", "12345", "John", "john@gmail.com", 20));
        eList.add(new User("peter", "12345", "Peter", "peter@gmail.com", 30));
        eList.add(new User("david", "12345", "David", "david@gmail.com", 40));
    }

    public static User checkLogin(Login login){
        for(User el : eList){
            if(el.getAccount().equals(login.getAccount())
                    && el.getPassword().equals(login.getPassword())){
                return el;
            }
        }
        return null;
    }
}
