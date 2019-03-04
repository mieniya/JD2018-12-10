package by.it.a_khmelev.project08.java.controller;

import by.it.a_khmelev.project08.java.beans.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Util {

    static User findUser(HttpServletRequest req) {
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

    public static String getHash(User user) {
        //хеш можно получить проще, на занятии
        //я что-то перемудрил.
        String key = user.getEmail() + user.getLogin() + user.getPassword() + "это как бы соль";
        return DigestUtils.md5Hex(key);
    }

    static void setCookie(HttpServletRequest req, Cookie cookie) {
        HttpServletResponse resp =
                (HttpServletResponse) req.getAttribute("resp");
        resp.addCookie(cookie);
    }

    static void loadImage(HttpServletRequest req, String filename) {
        String fileReal = req.getServletContext().getRealPath(filename);
        try (InputStream fileimg = req.getPart("fileimg").getInputStream();
             OutputStream fileout = new FileOutputStream(fileReal);
        ) {
            byte[] bytes=new byte[100000];
            while (fileimg.available()>0){
                int size = fileimg.read(bytes);
                fileout.write(bytes,0,size);
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }


    }


}
