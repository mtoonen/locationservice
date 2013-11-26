/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.meine.locationservice.entities;

import java.util.Date;

/**
 *
 * @author Meine Toonen <toonen.meine@gmail.com>
 */
public class Location {
    
    private Integer id;
    private String group;
    private Integer x;
    private Integer y;
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
}
