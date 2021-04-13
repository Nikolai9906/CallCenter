package com.masiv.callcenter.persistence;


import com.masiv.callcenter.model.Agent;
import com.masiv.callcenter.persistence.exceptions.CallCenterNotFoundException;
import com.masiv.callcenter.persistence.exceptions.CallCenterPersistenceException;

import java.util.ArrayList;

public interface CallCenterPersistence{

    ArrayList<Agent> GetAllAgents() throws CallCenterNotFoundException ;
    void saveAgent(Agent ag) throws CallCenterPersistenceException ;
    String setLockAgent(int number) throws CallCenterPersistenceException;
    String unlockAgent(int id) throws CallCenterPersistenceException ;
}
