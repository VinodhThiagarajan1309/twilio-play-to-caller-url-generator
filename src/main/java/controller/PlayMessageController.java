package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.twiml.Play;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;

/**
 * Created by vthiagarajan on 9/6/17.
 */
@RestController
public class PlayMessageController {

    @RequestMapping("/playmessage")
    public void greeting(HttpServletResponse response, @RequestParam(value="recordFilePath") String recordFilePath){

// Create a TwiML response and add our friendly message.
        VoiceResponse twiml = new VoiceResponse.Builder()
            .play(new Play.Builder(recordFilePath).build())
            .build();

        response.setContentType("application/xml");
        try {
            response.getWriter().print(twiml.toXml());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
