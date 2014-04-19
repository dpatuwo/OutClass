package edu.vt.vthacks.outclass.model;

import java.util.Date;

public interface IEvent {

    public void setDescription(String desc);
    public void setCourse(ICourse theCourse);
    public void setDate(Date d);
    public void setLocation(ILocation loc);
    public ICourse getCourse();
    public Date getDate();
    public String getDescription();
    public ILocation getLocation();
}
