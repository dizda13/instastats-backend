package ba.instastats.instastats.instaController;

import ba.instastats.instastats.instaController.Model.*;
import ba.instastats.instastats.user_controller.UserModel;
import ba.instastats.instastats.user_controller.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

@RestController
public class InstaController extends  BaseInstaController {

    RestTemplate restTemplate;
    ObjectMapper mapper;
    RequestUrlFactory requestUrlFactory;
    @Autowired
    UserRepository userRepository;



    InstaController() throws IOException {
        restTemplate = new RestTemplate();
        mapper = new ObjectMapper();
        requestUrlFactory=new RequestUrlFactory();
    }

    @GetMapping(value = "/user")
    public 
    ResponseEntity<InstagramExpandedUser> GetInstaAcces(@ModelAttribute("entity") UserModel userModel) throws IOException {


        String uri = requestUrlFactory.getUrlInstaAcces(userModel.getAccess_token());

        String json = restTemplate.getForEntity(uri, String.class).getBody();
        ResponseInstagramBody<InstagramExpandedUser> instagramUserResponseInstagramBody =
                mapper.readValue(json, new TypeReference<ResponseInstagramBody<InstagramExpandedUser>>() {});

        return ResponseEntity.ok().body(instagramUserResponseInstagramBody.getData());
    }

    @GetMapping(value = "/media")
    public @ResponseBody InstagramMedia[] GetMedia(@ModelAttribute("entity") UserModel userModel) throws IOException {

        String uri = requestUrlFactory.getMediaUrl(userModel.getAccess_token());
        System.out.println(uri);
        String json = restTemplate.getForEntity(uri, String.class).getBody();
        ResponseInstagramBody<InstagramMedia[]>  instagramUserResponseInstagramBody =
                mapper.readValue(json, new TypeReference<ResponseInstagramBody<InstagramMedia[]>>() {});

        return instagramUserResponseInstagramBody.getData();
    }

    @GetMapping(value="/media/{mediaId}")
    public @ResponseBody InstagramMedia GetMediaById(@PathVariable String mediaId,@ModelAttribute("entity") UserModel userModel) throws IOException {

        String uri = requestUrlFactory.getMediaUrl(mediaId,userModel.getAccess_token());

        String json = restTemplate.getForEntity(uri, String.class).getBody();
        ResponseInstagramBody<InstagramMedia>  instagramUserResponseInstagramBody =
                mapper.readValue(json, new TypeReference<ResponseInstagramBody<InstagramMedia>>() {});

        return instagramUserResponseInstagramBody.getData();

        //return Arrays.copyOfRange(instagramUserResponseInstagramBody,0,count);
    }

    @GetMapping(value = "/top/comments/{count}")
    public @ResponseBody InstagramMedia[] GetTopCommnetsMedia(@PathVariable int count,@ModelAttribute("entity") UserModel userModel) throws IOException {

        InstagramMedia[]  instagramUserResponseInstagramBody = GetMedia(userModel);

        Arrays.sort(instagramUserResponseInstagramBody, new Comparator<InstagramMedia>() {
            @Override
            public int compare(InstagramMedia o1, InstagramMedia o2) {
                return o2.getComments()-o1.getComments();
            }
        });

        return Arrays.copyOfRange(instagramUserResponseInstagramBody,0,count);
    }

    @GetMapping(value = "/top/likes/{count}")
    public @ResponseBody InstagramMedia[] GetTopLikesMedia(@PathVariable int count,@ModelAttribute("entity") UserModel userModel) throws IOException {

        InstagramMedia[]  instagramUserResponseInstagramBody = GetMedia(userModel);

        Arrays.sort(instagramUserResponseInstagramBody, new Comparator<InstagramMedia>() {
            @Override
            public int compare(InstagramMedia o1, InstagramMedia o2) {
                return o2.getLikes()-o1.getLikes();
            }
        });

        return Arrays.copyOfRange(instagramUserResponseInstagramBody,0,count);
    }

    @GetMapping(value = "/likes/{mediaId}")
    public @ResponseBody
    InstagramBaseUser[] LikesMedia(@PathVariable String mediaId,@ModelAttribute("entity") UserModel userModel) throws IOException {

        String uri = requestUrlFactory.getMediaLikesUrl(userModel.getAccess_token(),mediaId);

        String json = restTemplate.getForEntity(uri, String.class).getBody();
        ResponseInstagramBody<InstagramBaseUser[]> instagramUserResponseInstagramBody =
                mapper.readValue(json, new TypeReference<ResponseInstagramBody<InstagramBaseUser[]>>() {});

        return instagramUserResponseInstagramBody.getData();
    }

    @GetMapping(value = "/comments/{mediaId}")
    public @ResponseBody
    Comment[] CommentsMedia(@PathVariable String mediaId,@ModelAttribute("entity") UserModel userModel) throws IOException {

        String uri = requestUrlFactory.getMediaCommentsUrl(userModel.getAccess_token(), mediaId);

        String json = restTemplate.getForEntity(uri, String.class).getBody();
        ResponseInstagramBody<Comment[]> instagramUserResponseInstagramBody =
                mapper.readValue(json, new TypeReference<ResponseInstagramBody<Comment[]>>() {});

        return instagramUserResponseInstagramBody.getData();
    }

    @DeleteMapping(value = "/comments/{mediaId}/{commentId}")
    public @ResponseBody
    ResponseInstagramBody.Meta deleteComment(@PathVariable String mediaId, @PathVariable String commentId, @ModelAttribute("entity") UserModel userModel) throws IOException {

        String uri = requestUrlFactory.getDeleteCommentUrl(mediaId, commentId, userModel.getAccess_token());
        HttpEntity<String> entity = new HttpEntity<String>("",null);

        String json = restTemplate.exchange(uri, HttpMethod.DELETE, (HttpEntity<?>) entity,String.class).getBody();
        ResponseInstagramBody<String> response=mapper.readValue(json, new TypeReference<ResponseInstagramBody<String>>() {});
        return response.getMeta();
    }

    @PutMapping(value = "/comments/{mediaId}")
    public @ResponseBody
    ResponseInstagramBody.Meta putComment(@PathVariable String mediaId, @ModelAttribute("entity") UserModel userModel) throws IOException {

        String uri = requestUrlFactory.getMediaCommentsUrl(userModel.getAccess_token(),mediaId);
        HttpEntity<String> entity = new HttpEntity<String>("",null);

        String json = restTemplate.exchange(uri, HttpMethod.DELETE, (HttpEntity<?>) entity,String.class).getBody();
        ResponseInstagramBody<String> response=mapper.readValue(json, new TypeReference<ResponseInstagramBody<String>>() {});
        return response.getMeta();
    }

}
