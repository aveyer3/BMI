package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Assessment extends Model
{
    public int weight;
    public int chest;
    public int thigh;
    public int upperArm;
    public int waist;
    public int hips;
    public String comment;

    public Assessment(int weight)
    {
        this.weight = weight;
    }
}
