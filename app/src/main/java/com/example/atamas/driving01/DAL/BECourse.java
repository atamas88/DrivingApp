package com.example.atamas.driving01.DAL;

/**
 * Created by a.tamas on 25/05/2016.
 */
public class BECourse {
    private String m_description;
    private BEUser m_user;
    private int m_week;
    private int m_capacity;
    private int m_occupied;
    private String m_id;

    public BECourse(String id, String description, int week)
    {
        setId(id);
        setDescription(description);
       // setUser(user);
        setWeek(week);
    }

    public void setId(String id) {
        this.m_id = id;
    }

    public String getId() { return m_id; }

    public void setDescription(String description) {
        this.m_description = description;
    }

    public String getDescription() { return m_description; }
/*
    public BEUser getUser(){return m_user;}

    public void setUser(BEUser user)
    {
        this.m_user = user;
    }
*/
    public int getWeek(){return m_week;}

    public void setWeek(int week)
    {
        this.m_week = week;
    }


}
