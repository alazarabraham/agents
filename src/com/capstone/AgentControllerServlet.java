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
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        agentDao = new AgentDao(jdbcURL, jdbcUsername, jdbcPassword);
 
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
        request.setAttribute("list", listAgent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("agentlist.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("agentform.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int agent_id = Integer.parseInt(request.getParameter("agent_id"));
        Agent existingAgent = agentDao.getAgent(agent_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("agentform.jsp");
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
        response.sendRedirect("list");
    }
 
    private void updateAgent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int agent_id = Integer.parseInt(request.getParameter("agent_id"));
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String emailAddress = request.getParameter("firstName");

 
        Agent agent = new Agent(agent_id, firstName, middleName, lastName,  password,  phone,  emailAddress);
        agentDao.updateAgent(agent);
        response.sendRedirect("list");
    }
 
    private void deleteAgent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int agent_id = Integer.parseInt(request.getParameter("agent_id"));
 
        Agent agent = new Agent(agent_id);
        agentDao.deleteAgent(agent);
        response.sendRedirect("list");
 
    }
}
