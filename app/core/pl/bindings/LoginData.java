package core.pl.bindings;

import play.data.validation.Constraints;

/**
 * Created by nue on 2.9.2015.
 */
public class LoginData {

    // str. 246

    @Constraints.Email
    private String email;

    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
