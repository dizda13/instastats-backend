package ba.instastats.instastats.user_controller;
import ba.instastats.instastats.ExeptionHandler.BadRequestException;
import ba.instastats.instastats.instaController.Model.InstagramExpandedUser;
import ba.instastats.instastats.instaController.RequestUrlFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserConterller {

    RequestUrlFactory requestUrlFactory;
    RestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    UserConterller() throws IOException {
        requestUrlFactory=new RequestUrlFactory();
        restTemplate=new RestTemplate();
    }

    @PostMapping(value = "/auth")
    public @ResponseBody
    InstagramExpandedUser Auth(@RequestBody Map<String, String> code) throws HttpStatusCodeException {

        UserModel user;
        AuthUser authUser;
        try {

            String uri = requestUrlFactory.getAuthUrl();
            HttpEntity<MultiValueMap<String, String>> request = requestUrlFactory.getAuthForm(code.get("code"));

            authUser = restTemplate.postForEntity(uri, request, AuthUser.class).getBody();
            user=userRepository.findUserModelByUsername(authUser.getUser().getUsername());;
        } catch (Exception ex){
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Missing or incorrect code");
        }



        if(user == null)
            user=new UserModel(authUser.getUser().getUsername(),authUser.getAccess_token());
        else
            user.setAccess_token(authUser.getAccess_token());

        userRepository.save(user);

        return authUser.getUser();
    }

    @GetMapping(value = "/instagram/connect")
    public @ResponseBody
    Map<String, String> getConnectionUrl(){

        Map<String,String> map=new HashMap<String,String>();
        map.put("redirect_url", requestUrlFactory.getUrlToRedirect());

        return map;

    }

    static class AuthUser{
        String access_token;
        InstagramExpandedUser user;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public InstagramExpandedUser getUser() {
            return user;
        }

        public void setUser(InstagramExpandedUser user) {
            this.user = user;
        }
    }
}
