package by.it.zagurskaya.project.java.controller;

import by.it.zagurskaya.project.java.beans.*;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

    //    static User findUser(HttpServletRequest req) {
    public static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oUser = session.getAttribute("user");
        if (oUser == null) {
            return null;
        } else {
            return (User) oUser;
        }
    }

    public static Account findAccount(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oAccount = session.getAttribute("account");
        if (oAccount == null) {
            return null;
        } else {
            return (Account) oAccount;
        }
    }

    public static Currency findCurrency(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oCurrency = session.getAttribute("currency");
        if (oCurrency == null) {
            return null;
        } else {
            return (Currency) oCurrency;
        }
    }

    public static Duties findDuties(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oDuties = session.getAttribute("duties");
        if (oDuties == null) {
            return null;
        } else {
            return (Duties) oDuties;
        }
    }

    public static Kassa findKassa(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oKassa = session.getAttribute("kassa");
        if (oKassa == null) {
            return null;
        } else {
            return (Kassa) oKassa;
        }
    }

    public static RateCB findRateCB(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oRateCB = session.getAttribute("ratecb");
        if (oRateCB == null) {
            return null;
        } else {
            return (RateCB) oRateCB;
        }
    }

    public static RateNB findRateNB(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oRateNB = session.getAttribute("ratenb");
        if (oRateNB == null) {
            return null;
        } else {
            return (RateNB) oRateNB;
        }
    }

    public static Role findRole(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oRole = session.getAttribute("role");
        if (oRole == null) {
            return null;
        } else {
            return (Role) oRole;
        }
    }

    public static SprEntries findSprEntries(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oSprEntries = session.getAttribute("sprentries");
        if (oSprEntries == null) {
            return null;
        } else {
            return (SprEntries) oSprEntries;
        }
    }

    public static SprOperations findSprOperations(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oSprOperations = session.getAttribute("sproperations");
        if (oSprOperations == null) {
            return null;
        } else {
            return (SprOperations) oSprOperations;
        }
    }

    public static UserEntry findUserEntry(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oUserEntry = session.getAttribute("userentry");
        if (oUserEntry == null) {
            return null;
        } else {
            return (UserEntry) oUserEntry;
        }
    }

    public static UserOperation findUserOperation(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null)
            return null;
        Object oUserOperation = session.getAttribute("useroperation");
        if (oUserOperation == null) {
            return null;
        } else {
            return (UserOperation) oUserOperation;
        }
    }
    public static String getHash(User user){
//        String key=user.getRoleId()+user.getLogin()+user.getPassword();
        String key=user.getLogin()+user.getPassword();
        key=key+"qqqqqqqq";
        byte[] hash = DigestUtils.md5(key);
        StringBuilder sb=new StringBuilder();
        for (byte b : hash) {
            sb.append(b);
        }
        return sb.toString();
    }

    static void setCookie(HttpServletRequest req, Cookie cookie){
        HttpServletResponse resp =
                (HttpServletResponse) req.getAttribute("resp");
        resp.addCookie(cookie);
    }

    public static String getFormattedLocalDateStartDateTime(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00.000"));
    }

    public static String getFormattedLocalDateOnlyDate(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
