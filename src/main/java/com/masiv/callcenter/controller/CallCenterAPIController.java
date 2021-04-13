package com.masiv.callcenter.controller;

import com.masiv.callcenter.model.Agent;
import com.masiv.callcenter.persistence.exceptions.CallCenterNotFoundException;
import com.masiv.callcenter.persistence.exceptions.CallCenterPersistenceException;
import com.masiv.callcenter.service.impl.CallCenterServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/agents")
public class CallCenterAPIController {

    @Autowired
    CallCenterServicesImpl ccs = null;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetAllAgents(){
        try {
            return new ResponseEntity<>(ccs.GetAllAgents(),HttpStatus.ACCEPTED);
        } catch (CallCenterNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/assignment/{priority}" , method = RequestMethod.GET)
    public ResponseEntity<?> setLockAgent(@PathVariable int priority){
        try {
            return new ResponseEntity<>(ccs.setLockAgent(priority),HttpStatus.OK);
        } catch (CallCenterPersistenceException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/unlock/{id}" , method = RequestMethod.GET)
    public ResponseEntity<?> unlockAgent(@PathVariable int id){
        try {
            return new ResponseEntity<>(ccs.unlockAgent(id),HttpStatus.OK);
        } catch (CallCenterPersistenceException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> AddNewAgent(@RequestBody Agent newAg){
        try {
            return new ResponseEntity<>(ccs.addNewAgent(newAg),HttpStatus.CREATED);
        } catch (CallCenterPersistenceException ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }



}
