/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tranaa.aaron_vinayak_a3.servlets;

import com.tranaa.aaron_vinayak_a3.model.Gadget;
import com.tranaa.aaron_vinayak_a3.model.Mission;
import com.tranaa.aaron_vinayak_a3.model.MissionList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet to Create Mission
 * @author Aaron Tan,Vinayak Pavate
 */
public class CreateMission extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //getting the parameter values from the JSP page      
        String missionTitle = request.getParameter("missionTitle");
        String[] selectedGadgets = request.getParameterValues("gadgets");
        String agent = request.getParameter("agent");
        //creating a new session to follow up with the data
        HttpSession session = request.getSession();
        
        ArrayList<Gadget> gadgets = new ArrayList<>();
        
        for (String gadget : selectedGadgets) {
            if(gadget.trim().length() > 0) {
                gadgets.add(new Gadget(gadget.trim()));
            }
        }
        //creating a new mission with the gadget and the title 
        Mission mission = new Mission(missionTitle, gadgets);
        
        //get session agent's missionList
        MissionList missionList = 
                (MissionList)session.getAttribute(agent);
        
        //check if agent mission list exist else initialize
        if(missionList == null){
            missionList = new MissionList(agent, new ArrayList<Mission>());
        }
        
        // add new mission to missionList
        missionList.addMission(mission);
        // update session attribute
        session.setAttribute(agent, missionList);
        //we then dispatch it to the vivewmission.jsp 
        RequestDispatcher rd = request.getRequestDispatcher("viewMissions.jsp");
        rd.forward(request, response);
    }


}
