package ba.instastats.instastats.instaController;

import ba.instastats.instastats.ExeptionHandler.ResourceNotFoundException;
import ba.instastats.instastats.user_controller.UserModel;
import ba.instastats.instastats.user_controller.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.persistence.Entity;

public abstract class BaseInstaController {

    @Autowired
    UserRepository userRepository;



    @ModelAttribute("entity")
    public UserModel populate(
            @RequestHeader("Authorization") String username) throws RuntimeException  {

        UserModel userModel=this.userRepository.findUserModelByUsername(username);

        if (userModel == null) {
            throw new ResourceNotFoundException(HttpStatus.UNAUTHORIZED, "User not connected with instagram");
        }
        return userModel;
    }
}