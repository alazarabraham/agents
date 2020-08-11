package com.capstone;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class AgentControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AgentDao agentDao;
    private Policy_HolderDao policy_holderDao;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        agentDao = new AgentDao(jdbcURL, jdbcUsername, jdbcPassword);
        policy_holderDao = new Policy_HolderDao(jdbcURL, jdbcUsername,jdbcPassword);
 
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/newagent":
                showNewForm(request, response);
                break;
            case "/insertagent":
                insertAgent(request, response);
                break;
            case "/deleteagent":
                deleteAgent(request, response);
                break;
            case "/editagent":
                showEditForm(request, response);
                break;
            case "/updateagent":
                updateAgent(request, response);
                break;
            case "/policyholderlist":
            	listPolicy_Holder(request, response);
                break;
            case "/newpolicyholder":
            	showNewPolicy_HolderForm(request, response);
                break;
            case "/insertpolicyholder":
                insertPolicy_Holder(request, response);
                break;
            case "/deletepolicyholder":
                deletePolicy_Holder(request, response);
                break;
            case "/editpolicyholder":
                showPolicy_HolderEditForm(request, response);
                break;
            case "/updatepolicyholder":
                updatePolicy_Holder(request, response);
                break;
            default:
                listAgent(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listAgent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Agent> listAgent = agentDao.listAllAgents();
        request.setAttribute("listAgent", listAgent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("agentslist.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("agentsform.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int agent_id = Integer.parseInt(request.getParameter("agent_id"));
        Agent existingAgent = agentDao.getAgent(agent_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("agentsform.jsp");
        request.setAttribute("agent", existingAgent);
        dispatcher.forward(request, response);
 
    }
 
    private void insertAgent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String emailAddress = request.getParameter("emailAddress");
 
        Agent newAgent = new Agent(firstName,middleName,lastName,password,phone, emailAddress);
        agentDao.insertAgent(newAgent);
        response.sendRedirect("listAgent");
    }
 
    private void updateAgent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int agent_id = Integer.parseInt(request.getParameter("agent_id"));
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String emailAddress = request.getParameter("emailAddress");


        Agent agent = new Agent(agent_id, firstName, middleName, lastName,  password,  phone,  emailAddress);
        agentDao.updateAgent(agent);
        response.sendRedirect("listAgent");
    }
 
    private void deleteAgent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int agent_id = Integer.parseInt(request.getParameter("agent_id"));
        Agent agent = new Agent(agent_id);
        agentDao.deleteAgent(agent);
        response.sendRedirect("listAgent");
 
    }
    private void listPolicy_Holder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Policy_Holder> listPolicy_Holder = policy_holderDao.listAllPolicy_Holders();
        request.setAttribute("listPolicy_Holder", listPolicy_Holder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("policyholderlist.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewPolicy_HolderForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("policyholderform.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showPolicy_HolderEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int PH_key = Integer.parseInt(request.getParameter("PH_key"));
        Policy_Holder existingPolicy_Holder = policy_holderDao.getPolicy_Holder(PH_key);
        RequestDispatcher dispatcher = request.getRequestDispatcher("policyholderform.jsp");
        request.setAttribute("policy_holder", existingPolicy_Holder);
        dispatcher.forward(request, response);
 
    }
 
    private void insertPolicy_Holder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String DOB = request.getParameter("DOB");
        String password = request.getParameter("password");   
        String emailAddress = request.getParameter("emailAddress");
        int policy_key = Integer.parseInt(request.getParameter("policy_key"));
        Policy_Holder policy_holder = new Policy_Holder(firstName,middleName,lastName,DOB,password, emailAddress, policy_key);
        policy_holderDao.insertPolicy_Holder(policy_holder);
        response.sendRedirect("policyholderlist");
        
    }
 
    private void updatePolicy_Holder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int PH_key = Integer.parseInt(request.getParameter("PH_key"));
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String DOB = request.getParameter("DOB");
        String password = request.getParameter("password");
        String emailAddress = request.getParameter("emailAddress");
        int policy_key = Integer.parseInt(request.getParameter("policy_key"));
        String type = request.getParameter("type");


 
        Policy_Holder policy_holder = new Policy_Holder(PH_key, firstName, middleName, lastName,  password, DOB,  emailAddress,policy_key);
        policy_holderDao.updatePolicy_Holder(policy_holder);
        response.sendRedirect("policyholderlist");
    }
 
    private void deletePolicy_Holder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int PH_key = Integer.parseInt(request.getParameter("PH_key"));
 
        Policy_Holder policy_holder = new Policy_Holder(PH_key);
        policy_holderDao.deletePolicy_Holder(policy_holder);
        response.sendRedirect("policyholderlist");
 
    }
    
 
   
}
