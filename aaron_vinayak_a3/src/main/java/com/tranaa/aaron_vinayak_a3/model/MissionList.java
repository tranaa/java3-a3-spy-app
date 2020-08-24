
package com.tranaa.aaron_vinayak_a3.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class for MissionList
 * @author Aaron Tran,Vinayak Pavate
 */
public class MissionList implements Serializable{
    
    private ArrayList<Mission> missions;
    private String agent;

    //no args constructor
    public MissionList() {
    }

    //args constructor
    public MissionList(String agent, ArrayList<Mission> missions) {
        this.agent = agent;
        this.missions = missions;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public ArrayList<Mission> getMissions() {
        return missions;
    }

    public void setMissions(ArrayList<Mission> missions) {
        this.missions = missions;
    }
    
    public void addMission(Mission mission) {
        missions.add(mission);
    }

}
