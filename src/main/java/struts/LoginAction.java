package struts;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        if(name.equals("karen") && password.equals("123"))
            return "success";
        else
            return "error";
    }
}
