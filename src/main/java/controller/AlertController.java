package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AlertService;

//@Controller
@RequestMapping(value = "/alert")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> sendAlert(@RequestBody String message) {

        alertService.sendAlert(message);

//        alertService.receiveAlert();

        return new ResponseEntity<String>(HttpStatus.OK);

    }

}
