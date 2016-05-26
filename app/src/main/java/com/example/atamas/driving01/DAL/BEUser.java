package com.example.atamas.driving01.DAL;

import java.io.Serializable;

/**
 * Created by a.tamas on 23/05/2016.
 */
public class BEUser implements Serializable{

    private String m_id;
    private String m_firstName;
    private String m_lastName;
    private String m_name;
    private String m_email;
    private String m_telNum;
    private String m_course;
    //private Address m_address;

    public BEUser(String id, String name, String course, String firstName, String lastName, String email, String telNum)
    {
        setId(id);
        setName(name);
        setCourse(course);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setTelNum(telNum);


    }

    public BEUser(String id, String name, String course)
    {
        setId(id);
        setName(name);
        setCourse(course);
    }

    public void setId(String id) {
        this.m_id = id;
    }

    public String getId() { return m_id; }

    public void setName(String m_name) {
        this.m_name = m_name;
    }

    public String getName() {
        return m_name;
    }

    public String  getCourse(){ return m_course;}

    public void setCourse(String m_course)
    {
        this.m_course = m_course;
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

    public String getTelNum() {
        return m_telNum;
    }
    public void setTelNum(String m_telNum) {
        this.m_telNum = m_telNum;
    }
}
