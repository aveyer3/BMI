package controllers;

import models.Assessment;
import models.Member;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Assessment> assessmentList = member.assessmentList;
    render("dashboard.html", member, assessmentList);
  }

  public static void addAssessment(float weight, float chest, float thigh, float upperArm, float waist, float hips, String comment)
  {
    Member member = Accounts.getLoggedInMember();
    Assessment assessment = new Assessment(weight, chest, thigh, upperArm, waist, hips, comment);
    member.assessmentList.add(assessment);
    member.save();
    Logger.info("Adding Assessment" + weight + chest + thigh + upperArm + waist + hips + comment);
    redirect("/dashboard");
  }

/**
  public static void deleteAssessment(Long id, Long assessmentId)
  {
    Member member = Member.findById(id);
    Assessment assessment = Assessment.findById(assessmentId);
    member.assessmentList.remove(assessment);
    member.save();
    assessment.delete();
    Logger.info("Deleting " + assessment.weight + assessment.chest + assessment.thigh + assessment.upperArm + assessment.waist + assessment.hips + assessment.comment);
    redirect("/dashboard");
  }
 **/
}
