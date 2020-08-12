package com.capstone;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class AgentDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public AgentDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
	    
	    protected void disconnect() throws SQLException {
	        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
	            jdbcConnection.close();
	        }
	    }
	     
	    public boolean insertAgent(Agent agent) throws SQLException {
	        String sql = "INSERT INTO agent (firstName, middleName, lastName,password,phone,emailAddress) VALUES (?, ? , ? , ? , ? , ?)";
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, agent.getFirstName());
	        statement.setString(2, agent.getMiddleName());
	        statement.setString(3, agent.getMiddleName());
	        statement.setString(4, agent.getPassword());
	        statement.setString(5, agent.getPhone());
	        statement.setString(6, agent.getEmailAddress());

	        System.out.println("insert " + agent.getAgent_id());
	        boolean rowInserted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowInserted;
	    }
	     
	    public List<Agent> listAllAgents() throws SQLException {
	        List<Agent> listAgent = new ArrayList<>();
	         
	        String sql = "SELECT * FROM agent";
	         
	        connect();
	         
	        Statement statement = jdbcConnection.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	         
	        while (resultSet.next()) {
	            int agent_id = resultSet.getInt("agent_id");
	            String firstName = resultSet.getString("firstName");
	            String middleName = resultSet.getString("middleName");
	            String lastName = resultSet.getString("lastName");
	            String password = resultSet.getString("password");
	            String phone = resultSet.getString("phone");
	            String emailAddress = resultSet.getString("emailAddress");
	            

	            Agent agent = new Agent(agent_id,firstName,middleName,lastName,password,phone,emailAddress);
	            listAgent.add(agent);
	            agent.setAgent_id(agent_id);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        disconnect();
	         
	        return listAgent;
	    }
	     
	    public boolean deleteAgent(Agent agent) throws SQLException {
	        String sql = "DELETE FROM agent where agent_id = ?";
	         
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, agent.getAgent_id());
	        System.out.println(" delete agent " + agent.getAgent_id()); 
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowDeleted;     
	    }
	     
	    public boolean updateAgent(Agent agent) throws SQLException {
	        String sql = "UPDATE agent SET firstName = ?, middleName = ?, lastName = ?, password = ?, phone = ?, emailAddress = ? ";
	        sql+= "WHERE emailAddress = ?";
	        connect();
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, agent.getFirstName());
	        statement.setString(2, agent.getMiddleName());
	        statement.setString(3, agent.getLastName());
	        statement.setString(4, agent.getPassword());
	        statement.setString(5, agent.getPhone());
	        statement.setString(6, agent.getEmailAddress());
	        
	        statement.setString(7, agent.getEmailAddress());
	       
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowUpdated;     
	    }
	     
	    public Agent getAgent(int agent_id) throws SQLException {
	        Agent agent = null;
	        String sql = "SELECT * FROM agent WHERE agent_id = ?";
	         
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, agent_id);
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	        if (resultSet.next()) {
	        	String firstName = resultSet.getString("firstName");
	            String middleName = resultSet.getString("middleName");
	            String lastName = resultSet.getString("lastName");
	            String password = resultSet.getString("password");
	            String phone = resultSet.getString("phone");
	            String emailAddress = resultSet.getString("emailAddress");
	             
	            agent = new Agent(firstName,middleName,lastName,password,phone,emailAddress);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        return agent;
	    }





}
