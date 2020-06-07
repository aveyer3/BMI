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

    public Assessment(int weight, int chest, int thigh, int upperArm, int waist, int hips, String comment)
    {
        this.weight = weight;
        this.chest = chest;
        this.thigh = thigh;
        this.upperArm = upperArm;
        this.waist = waist;
        this.hips = hips;
        this.comment = comment;
    }
}
