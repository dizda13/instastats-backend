package ba.instastats.instastats.ExeptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

import java.nio.charset.Charset;

public class ResourceNotFoundException extends HttpStatusCodeException {

    public ResourceNotFoundException(HttpStatus statusCode) {
        super(statusCode);
    }

    public ResourceNotFoundException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }

    public ResourceNotFoundException(HttpStatus statusCode, String statusText, byte[] responseBody, Charset responseCharset) {
        super(statusCode, statusText, responseBody, responseCharset);
    }

    public ResourceNotFoundException(HttpStatus statusCode, String statusText, HttpHeaders responseHeaders, byte[] responseBody, Charset responseCharset) {
        super(statusCode, statusText, responseHeaders, responseBody, responseCharset);
    }
}

