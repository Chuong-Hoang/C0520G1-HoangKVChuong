package main_user.bo;

import main_user.model.User;

import java.util.Comparator;

public class SortingUserName implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return u1.getName().compareTo(u2.getName());
    }
}
