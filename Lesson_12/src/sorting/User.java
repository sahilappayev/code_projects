package sorting;

public class User implements Comparable<User> {


    @Override
    public int compareTo(User user) {
        int result;

        if (this.getAge() > user.getAge()) {
            result = 1;
        } else if (this.getAge() < user.getAge()) {
            result = -1;
        } else {
            result = this.getName().compareTo(user.getName());
        }
        return result;
    }

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
