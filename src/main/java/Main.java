import config.RootConfig;
import model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.impl.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(RootConfig.class);

//        ProductService productService = (ProductService)context.getBean("productService");
//        productService.add(new Product("phone", "fdfdf", "dfdfd", "dfdfd"));

//        UserServiceImpl userService = (UserServiceImpl)context.getBean("userServiceImpl");
//        userService.addUser(new User("karen", "jkhdfjdf"));

    }



}
