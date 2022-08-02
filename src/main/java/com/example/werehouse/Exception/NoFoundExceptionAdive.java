package com.example.werehouse.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// Porada przekazana w momecie pojawienia sie bledu
@ControllerAdvice // Dzieki adnotacji przechwytujemy wywolywanie kodu wyjatku
public class NoFoundExceptionAdive {

    @ResponseBody // Czyli request przemapowany na czytelna odpwoedz dla uzytkownika (czyli zwort stringa)
    @ExceptionHandler(NoFoundException.class) // To dziala tak ze jak tylko zostanie wywolana podana klasa to odrazu ten element zostanie przechwycony
    @ResponseStatus(HttpStatus.NOT_FOUND) // to jest status czyli (NOT_FOUND) czyli nie znaleziono danego elementu (kod 404)
    public String noFoundHandler(NoFoundException ex) {
        return ex.getMessage();
    }

}
