package com.masiv.callcenter.persistence.impl;

import com.masiv.callcenter.model.Agent;
import com.masiv.callcenter.persistence.exceptions.CallCenterNotFoundException;
import com.masiv.callcenter.persistence.CallCenterPersistence;
import com.masiv.callcenter.persistence.exceptions.CallCenterPersistenceException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class CallCenterPersistenceImpl implements CallCenterPersistence {

    private ArrayList<Agent> agents = new ArrayList<Agent>();

    @Override
    public ArrayList<Agent> GetAllAgents() throws CallCenterNotFoundException {
        return agents;
    }

    @Override
    public void saveAgent(Agent ag) throws CallCenterPersistenceException {
        for(int i = 0; i< agents.size(); i++) {
            if (agents.get(i).getId() == ag.getId()) {
                throw new CallCenterPersistenceException("El agente dado ya existe");
            }
        }
        if(ag.getPriority()>5 || ag.getPriority()<1){
            throw new CallCenterPersistenceException("El rango de prioridad esta entre 1 y 5");
        }
        agents.add(ag);
    }

    @Override
    public String setLockAgent(int number) throws CallCenterPersistenceException {
        String message = "";
        Collections.sort(agents);
        Boolean isNotAsigned = true;
        if(number>5 || number<1) throw new CallCenterPersistenceException("El rango de prioridad debe estar esta entre 1 y 5, intente nuevamente");

        for( int i = 0; i< agents.size(); i++ ){
            if(agents.get(i).getLock() == 0 && isNotAsigned){
                agents.get(i).setLock(1);
                message = "El id del agente asignado es el siguiente: " + agents.get(i).getId();
                isNotAsigned = false;
            } else if ( i == agents.size()-1 && isNotAsigned){
                message = "No hay agentes disponibles";
            }
        }
        return message;
    }

    @Override
    public String unlockAgent(int id) throws CallCenterPersistenceException {
        String message = "";
        Boolean isNotAsigned = true;

        for(int i = 0; i< agents.size(); i++){
            if(agents.get(i).getId() == id && isNotAsigned && agents.get(i).getLock() == 1){
                agents.get(i).setLock(0);
                message = "La operacion fue exitosa";
                isNotAsigned = false;
            }else if(isNotAsigned){
                message = "La operacion no tuvo exito, revise los datos suministrados e intente nuevamente";
            }
        }
        return message;
    }

}
