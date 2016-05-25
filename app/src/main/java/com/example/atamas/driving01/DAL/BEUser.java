package com.example.atamas.driving01.DAL;

/**
 * Created by a.tamas on 23/05/2016.
 */
public class BEUser {

    private String m_id;
    private String m_firstName;
    private String m_lastName;
    private String m_name;
    private String m_email;
    private String m_telNum;
    //private Address m_address;

    public BEUser(String id, String name, String firstName, String lastName, String email)
    {
        setId(id);
        setName(name);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);

    }

    public BEUser(String id, String name)
    {
        setId(id);
        setName(name);
    }

    public void setId(String id) {
        this.m_id = id;
    }

    public String getId() { return m_id; }

    public void setName(String m_name) {
        this.m_firstName = m_name;
    }

    public String getName() {
        return m_firstName;
    }

    public void setFirstName(String m_firstName) {
        this.m_firstName = m_firstName;
    }

    public String getFirstName() {
        return m_firstName;
    }

    public void setLastName(String m_lastName) {
        this.m_lastName = m_lastName;
    }

    public String getLastName() {
        return m_lastName;
    }

    public void setEmail(String m_email) {
        this.m_email = m_email;
    }

    public String getEmail() {
        return m_email;
    }


}
