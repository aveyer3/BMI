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
  public int height;
  public int startingWeight;

  @OneToMany(cascade = CascadeType.ALL)
  //public List<Todo> todolist = new ArrayList<Todo>();
  public List<Assessment> assessmentList = new ArrayList<Assessment>();


  public Member(String name, String gender, String email, String password, String address, int height, int startingWeight)
  {
    this.name = name;
    this.gender = gender;
    this.email = email;
    this.password = password;
    this.address = address;
    this.height = height;
    this.startingWeight = startingWeight;
  }

  public static Member findByEmail(String email)
  {
    return find("email", email).first();
  }

  public boolean checkPassword(String password)
  {
    return this.password.equals(password);
  }
}
