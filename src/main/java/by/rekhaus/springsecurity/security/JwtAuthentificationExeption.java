package by.rekhaus.springsecurity.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
public class JwtAuthentificationExeption extends AuthenticationException {
    private HttpStatus httpStatus;

    public JwtAuthentificationExeption(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    public JwtAuthentificationExeption(String msg) {
        super(msg);
    }
}
