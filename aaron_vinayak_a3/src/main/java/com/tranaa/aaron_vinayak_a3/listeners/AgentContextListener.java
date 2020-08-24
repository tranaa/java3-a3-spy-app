
package com.tranaa.aaron_vinayak_a3.listeners;

import com.tranaa.aaron_vinayak_a3.model.Gadget;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * AgentContextListener to load gadgets and agents on context initialized
 * @author Aaron Tran,Vinayak Pavate
 */
public class AgentContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       
        ServletContext context = sce.getServletContext();
        //We get the predefined agents into the listener
        String rawAgents = context.getInitParameter("agents");
        String[] agentsArray = rawAgents.split(":");
        
        ArrayList<String> agents = new ArrayList<>(Arrays.asList(agentsArray));
        
        context.setAttribute("agents", agents);
         //We get the predefined gadgets into the listener       
        String spyGadgets = context.getInitParameter("gadgets");
        String[] gadgetsArray = spyGadgets.split(":");
        
        ArrayList<Gadget> gadgets = new ArrayList<>();
        //Input to the gadget array
        for (String gadget : gadgetsArray) {
            gadgets.add(new Gadget(gadget));
        }
        context.setAttribute("gadgets", gadgets);
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //do nothing
    }

}