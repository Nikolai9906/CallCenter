package com.masiv.callcenter.service;

import com.masiv.callcenter.model.Agent;
import com.masiv.callcenter.persistence.exceptions.CallCenterException;
import com.masiv.callcenter.persistence.exceptions.CallCenterNotFoundException;
import com.masiv.callcenter.persistence.exceptions.CallCenterPersistenceException;

import java.util.ArrayList;

public interface CallCenterServices {
    ArrayList<Agent> GetAllAgents() throws CallCenterNotFoundException;

    Agent addNewAgent(Agent ag) throws CallCenterPersistenceException;

    String setLockAgent(int number) throws CallCenterPersistenceException;

    String unlockAgent(int id) throws CallCenterPersistenceException;
}
