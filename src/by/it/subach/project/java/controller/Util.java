//package by.it.subach.project.java.controller;
//
//import by.it.subach.project.java.beans.User;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//public class Util {
//
//    static User find(HttpServletRequest req){
//        HttpSession session = req.getSession(false);
//        if(session != null){
//        Object oUser = req.getSession().getAttribute("user");
//        if(oUser != null)
//            return (User) oUser;
//        else
//            return null;
//
//
//}
