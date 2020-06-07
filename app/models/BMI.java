package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class BMI extends Model
{
    public String title;

    public BMI(String title)
    {
        this.title = title;
    }
}
