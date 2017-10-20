package ba.instastats.instastats.ExeptionHandler;

import ba.instastats.instastats.instaController.RequestUrlFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
class RestExceptionHandler {

    RequestUrlFactory requestUrlFactory;

    RestExceptionHandler() throws IOException {
        super();
        requestUrlFactory=new RequestUrlFactory();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity handleConflict(RuntimeException ex, WebRequest request) {
        Map<String, String> map=new HashMap<String,String>();
        map.put("message", ex.getLocalizedMessage());
        return ResponseEntity.status(401).body(map);
               // .body(map);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ResponseEntity badRequest(RuntimeException ex, WebRequest request) {
        Map<String, String> map=new HashMap<String,String>();
        map.put("message", ex.getLocalizedMessage());
        return ResponseEntity.status(400).body(map);
        // .body(map);
    }

}
