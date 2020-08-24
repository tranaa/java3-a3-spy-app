
package com.tranaa.aaron_vinayak_a3.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class for Mission
 * @author Aaron Tran,Vinayak Pavate
 */
public class Mission implements Serializable {

    private String name;
    private ArrayList<Gadget> gadgets;

    //no args constructor
    public Mission() {
    }

    //args constructor
    public Mission(String name, ArrayList<Gadget> gadgets) {
        this.name = name;
        this.gadgets = gadgets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Gadget> getGadgets() {
        return gadgets;
    }

    public void setGadgets(ArrayList<Gadget> gadgets) {
        this.gadgets = gadgets;
    }
}
