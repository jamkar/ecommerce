package model;

public class Test {

    public static void main(String[] args) {

        User user = new User(1, "karen", "jamalyan", "abc");
        User user1 = new User(1, "karen", "jamalyan", "abc");
        User user2 = new User(2, "karen", "jamalyan", "abc");

        System.out.println(user.equals(user1));
        System.out.println(user.equals(user2));
        System.out.println(user.equals(null));

        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());

    }

}
