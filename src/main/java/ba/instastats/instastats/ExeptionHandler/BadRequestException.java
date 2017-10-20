package ba.instastats.instastats.ExeptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

import java.nio.charset.Charset;

public class BadRequestException extends HttpStatusCodeException {
    protected BadRequestException(HttpStatus statusCode) {
        super(statusCode);
    }

    public BadRequestException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }

    protected BadRequestException(HttpStatus statusCode, String statusText, byte[] responseBody, Charset responseCharset) {
        super(statusCode, statusText, responseBody, responseCharset);
    }

    protected BadRequestException(HttpStatus statusCode, String statusText, HttpHeaders responseHeaders, byte[] responseBody, Charset responseCharset) {
        super(statusCode, statusText, responseHeaders, responseBody, responseCharset);
    }
}
