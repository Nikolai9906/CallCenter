package com.masiv.callcenter.service.impl;


import com.masiv.callcenter.model.Agent;
import com.masiv.callcenter.persistence.CallCenterPersistence;
import com.masiv.callcenter.persistence.exceptions.CallCenterNotFoundException;
import com.masiv.callcenter.persistence.exceptions.CallCenterPersistenceException;
import com.masiv.callcenter.service.CallCenterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CallCenterServicesImpl implements CallCenterServices {

    @Autowired
    CallCenterPersistence ccp = null;

    @Override
    public ArrayList<Agent> GetAllAgents() throws CallCenterNotFoundException{
        return ccp.GetAllAgents();
    }

    @Override
    public Agent addNewAgent(Agent ag) throws CallCenterPersistenceException {
        ccp.saveAgent(ag);
        return ag;
    }
    @Override
    public String setLockAgent(int number) throws CallCenterPersistenceException{
        return ccp.setLockAgent(number);
    }
    @Override
    public String unlockAgent(int id) throws CallCenterPersistenceException{
        return ccp.unlockAgent(id);
    }
}
