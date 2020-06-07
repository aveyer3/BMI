package controllers;

import models.Assessment;
import models.Member;
import models.Todo;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    //List<Todo> todolist = member.todolist;
    List<Assessment> assessmentList = member.assessmentList;
    render("dashboard.html", member, assessmentList);
  }

  public static void addAssessment(int weight, int chest, int thigh, int upperArm, int waist, int hips, String comment)
  {
    Member member = Accounts.getLoggedInMember();
    Assessment assessment = new Assessment(weight, chest, thigh, upperArm, waist, hips, comment);
    member.assessmentList.add(assessment);
    member.save();
    Logger.info("Adding Todo" + weight + chest + thigh + upperArm + waist + hips + comment);
    redirect("/dashboard");
  }

  /**
  public static void deleteTodo(Long id, Long todoid)
  {
    Member member = Member.findById(id);
    Todo todo = Todo.findById(todoid);
    member.assessmentList.remove(todo);
    member.save();
    todo.delete();
    Logger.info("Deleting " + todo.title);
    redirect("/dashboard");
  }
  **/
}
