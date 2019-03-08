package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Util {

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return null;
        }
        Object oUser = session.getAttribute("user");
        if (oUser == null) {
            return null;
        } else {
            return (User) oUser;
        }
    }

    static Account findAccount(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return null;
        }
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            return null;
        } else {
            return account;
        }
    }

    public static String getHash(User user){
        String key = user.getEmail() + user.getLogin() + user.getPassword();
        key = key +"qqqqqqqq";
        byte[] hash = DigestUtils.md5(key);
        StringBuilder sb = new StringBuilder();
        for (byte aHash : hash) {
            sb.append(aHash);
        }
        return sb.toString();
    }

    static void setCookie(HttpServletRequest req, Cookie cookie){
        HttpServletResponse resp = (HttpServletResponse) req.getAttribute("resp");
        resp.addCookie(cookie);
    }

}
