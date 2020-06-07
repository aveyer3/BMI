package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends Model
{
  public String name;
  public String gender;
  public String email;
  public String password;
  public String address;
  public double height;
  public double startingWeight;
  public double BMI;
  public String BMIResult;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Assessment> assessmentList = new ArrayList<Assessment>();


  public Member(String name, String gender, String email, String password, String address, double height, double startingWeight)
  {
    this.name = name;
    this.gender = gender;
    this.email = email;
    this.password = password;
    this.address = address;
    this.height = height;
    this.startingWeight = startingWeight;
    this.BMI = BMI;
    getBMI();
    getBMIResult();
  }

  public static Member findByEmail(String email)
  {
    return find("email", email).first();
  }

  public boolean checkPassword(String password)
  {
    return this.password.equals(password);
  }

  public double getBMI()
  {
    BMI = startingWeight / Math.pow(height, 2.0);

    return (int)BMI;
  }

  public String getBMIResult()
  {

    if(BMI < 18.5)
    {
      BMIResult = "Under Weight";
    }
    else if( (BMI >= 18.5) && (BMI <= 24.9) )
    {
      BMIResult = "Normal";
    }
    else if(BMI > 24.9)
    {
      BMIResult = "Overweight";
    }

    return BMIResult;
  }

}
