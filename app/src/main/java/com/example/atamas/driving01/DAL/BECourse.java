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
    private String m_startDate;
    private String m_endDate;
    private String m_date;

    public BECourse(String id, String description, int week)
    {
        setId(id);
        setDescription(description);
       // setUser(user);
        setWeek(week);
    }

    public BECourse(String id, String description, int week, String startDate, String endDate) {
        setId(id);
        setDescription(description);
        setWeek(week);
        setStartDate(startDate);
        setEndDate(endDate);
        // setUser(user);

    }
    public BECourse(String id, String description, int week, String date) {
        setId(id);
        setDescription(description);
        setWeek(week);
        setDate(date);

        // setUser(user);

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

    public String getStartDate(){return m_startDate;}
    public void setStartDate(String startDate) {
        this.m_startDate = startDate;
    }

    public String getEndDate(){return m_endDate;}
    public void setEndDate(String endDate) {
        this.m_endDate = endDate;
    }

    public String getDate(){return m_date;}
    public void setDate(String date) {
        this.m_date = date;
    }
}
