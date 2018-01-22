import java.util.Comparator;
import java.util.Hashtable;
import java.util.concurrent.Executor;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new
//                AnnotationConfigApplicationContext(RootConfig.class);

//        ProductService productService = (ProductService)context.getBean("productService");
//        productService.add(new Product("phone", "fdfdf", "dfdfd", "dfdfd"));

//        UserServiceImpl userService = (UserServiceImpl)context.getBean("userServiceImpl");
//        userService.addUser(new User("karen", "jkhdfjdf"));


//        Person.Builder builder = new Person.Builder();
//        Person.Builder builder1 = new Person.Builder();

//        Person person = new Person();
//        Person.Inner inner = person.new Inner();




    }

    private static void f() {
        f();
    }

}


class Person {
    String name;
    int age;

    static int f = 5;

    static {
        f = 10;
    }

    Person() {
        System.out.println("Person is created");
    }

    static class Builder {
        Builder() {
            System.out.println("f: " + f);
        }

        void method() {
//            name = "d";
        }
    }

    class Inner {

        void method() {
            name = "";
        }

    }

    public static void main(String[] args) {

        Builder builder = new Builder();

    }
}


