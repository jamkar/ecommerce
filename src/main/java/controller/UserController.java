package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

import static security.SecurityUtils.checkPassword;
import static security.SecurityUtils.hashPassword;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<User> getUserByUsername(@RequestParam String username) {
        User user = userService.getByUsername(username);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestParam String username,
                                          @RequestParam String password) {

        String hashPassword = hashPassword(password);
        User user = new User(username, hashPassword);

        userService.add(user);

        return new ResponseEntity<String>(HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        userService.delete(id);

        return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestParam String username,
                                      @RequestParam String password,
                                      HttpServletRequest httpRequest) {

        User user = userService.getByUsername(username);

        if(user != null && checkPassword(password, user.getPasswordHash())) {
            httpRequest.getSession().setAttribute("user", user);

            return new ResponseEntity<User>(user, HttpStatus.OK);
        }

        else
            throw new ResponseException(404, "User not found", HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");

        return new ResponseEntity<String>("Successful Logout", HttpStatus.OK);
    }

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<String> error(ResponseException ex) {
        return new ResponseEntity<String>(ex.getMessage(), ex.getHttpStatus());
    }


}
