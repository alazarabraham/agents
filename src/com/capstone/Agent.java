package com.capstone;

public class Agent {
    protected int agent_id;
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected String password;
    protected String phone;
    protected String emailAddress;
    
    public Agent() {
    }
 
    public Agent(int agent_id) {
        this.agent_id = agent_id;
    }
 
    public Agent(int agent_id, String firstName,String middleName,String lastName, String password, String phone, String emailAddress) {
        this(firstName,middleName,lastName, password, phone, emailAddress);
        this.agent_id = agent_id;
    }
     
    public Agent(String firstName, String middleName, String lastName, String password, String phone, String emailAddress) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.emailAddress = emailAddress;

    }

    public int getAgent_id(){
        return agent_id;
    }

    public void setAgent_id(int agent_id){
        this.agent_id = agent_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


}



