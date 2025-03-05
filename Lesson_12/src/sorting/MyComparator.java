package sorting;

import java.util.Comparator;

public class MyComparator implements Comparator<User> {


    // -1 , 0 , 1
    @Override
    public int compare(User u1, User u2) {
        int result;

        if (u1.getAge() > u2.getAge()) {
            result = 1;
        } else if (u1.getAge() < u2.getAge()) {
            result = -1;
        } else {
            result = u1.getName().compareTo(u2.getName());
        }
        return result;
    }
}
