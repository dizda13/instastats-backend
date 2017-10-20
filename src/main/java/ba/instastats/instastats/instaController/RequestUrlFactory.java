package ba.instastats.instastats.instaController;

import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RequestUrlFactory {

    Properties prop = new Properties();
    static final String instagram_apis = "instagram_apis.properties";

    public RequestUrlFactory() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(instagram_apis);
        prop.load(inputStream);
    }

    public String getAuthUrl(){
        return prop.getProperty("get_auth_token_route");
    }

    public String getUrlInstaAcces(String access_token){
         String url=prop.getProperty("instagram_route") +
                prop.getProperty("user_details") +
                prop.getProperty("access_token_api") +
                access_token;

         return url;
    }

    public String getMediaUrl(String access_token){
        String uri = prop.getProperty("instagram_route") +
                prop.getProperty("user_details") +
                prop.getProperty("recinet_media") +
                prop.getProperty("access_token_api") +
                access_token;

        return uri;
    }

    public String getMediaUrl(String mediaId,String access_token){
        String uri=prop.getProperty("instagram_route") +
                prop.getProperty("media") +
                prop.getProperty("access_token_api")+
                access_token;
        uri=uri.replace("{media-id}", mediaId);

        return uri;
    }

    public String getMediaLikesUrl(String access_token, String mediaId){
        String uri = prop.getProperty("instagram_route") +
                prop.getProperty("likes") +
                prop.getProperty("access_token_api") +
                access_token;

        uri=uri.replace("{media-id}", mediaId);

        return uri;
    }

    public String getMediaCommentsUrl(String access_token, String mediaId){
        String uri = prop.getProperty("instagram_route") +
                prop.getProperty("comments") +
                prop.getProperty("access_token_api") +
                access_token;

        uri=uri.replace("{media-id}", mediaId);

        return uri;
    }

    public HttpEntity<MultiValueMap<String, String>> getAuthForm(String code){
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("client_id", prop.getProperty("client_id"));
        map.add("client_secret", prop.getProperty("client_secret"));
        map.add("grant_type", prop.getProperty("grant_type"));
        map.add("redirect_uri", prop.getProperty("redirect_uri"));
        map.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, null);
        return request;
    }

    public String getUrlToRedirect(){
        String uri = prop.getProperty("auth_rediret_uri");

        uri=uri.replace("{REDIRECT-URI}",prop.getProperty("redirect_uri"));
        uri=uri.replace("{CLIENT-ID}",prop.getProperty("client_id"));

        return uri;

    }

    public String getDeleteCommentUrl(String mediaId, String commentId, String access_token){
        String uri = prop.getProperty("instagram_route") +
                prop.getProperty("comments") +
                "/"+commentId+
                prop.getProperty("access_token_api") +
                access_token;

        uri=uri.replace("{media-id}", mediaId);

        return uri;
    }

}
