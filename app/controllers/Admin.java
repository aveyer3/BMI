package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Admin extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Admin");
    List<Member> memberList = Member.findAll();
    render("admin.html", memberList);
  }

  public static void deleteMember(Long id)
  {
    Member member = Member.findById(id);
    //Member.memberList.remove(member);
    member.delete();
    Logger.info("Deleting " + member.name);
    redirect("/dashboard");
  }

}
