package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@SpringBootApplication
public class ServerApplication {
	public static void main(String[] args) {
	SpringApplication.run(ServerApplication.class, args);
      }

}
@RestController 
class ServerController{

    @RequestMapping("/hash")
    public String myHash(){
      try {
            String data = "Hello Ro Jackson";
            // Create MD5 MessageDigest instance
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Convert input string to bytes and update digest
            byte[] digest = md.digest(data.getBytes());

            // Convert byte array to hex string
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }

            //return sb.toString();
            return "<p>data:"+sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found.", e);
        }
      
       
        
    }
}