
package com.tranaa.aaron_vinayak_a3.model;

import java.io.Serializable;

/**
 * Class for Gadget
 * @author Aaron Tran,Vinayak Pavate
 */
public class Gadget implements Serializable {

    private String name;
    
    //no args constructor
    public Gadget() { 
    }
    
    //args constructor
    public Gadget(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
