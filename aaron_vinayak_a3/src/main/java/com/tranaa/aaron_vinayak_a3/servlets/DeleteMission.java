/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tranaa.aaron_vinayak_a3.servlets;

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
 * This servlet will be used to delete the mission
 * @author Aaron tran,Vinayak Pavate
 */
public class DeleteMission extends HttpServlet {

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

        HttpSession session = request.getSession();
        
        String agent = request.getParameter("agent");
        
        MissionList missionList = 
                (MissionList)session.getAttribute(agent);

        //removes the agents missions and creates an empty mission arraylist
        missionList.setMissions(new ArrayList<Mission>());
        session.setAttribute(agent, missionList);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

}
