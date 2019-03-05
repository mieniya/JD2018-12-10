package by.it.zagurskaya.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class Form {

    public static boolean isPost(HttpServletRequest req){
        return req.getMethod().
                equalsIgnoreCase("post");
        }

    public  static String getString(HttpServletRequest req, String name) throws SiteException {
        return getString(req,name,".*");
    }

    public static String getString(HttpServletRequest req, String name, String pattern) throws SiteException {
        String value = req.getParameter(name);
        if (value.matches(pattern))
            return value;
        else
            throw new SiteException("Value "+value+" incorrect");

    }

    static int getInt(HttpServletRequest req, String name){
        String value = req.getParameter(name);
        return Integer.parseInt(value);
    }

    static long getLong(HttpServletRequest req, String name){
        String value = req.getParameter(name);
        return Long.parseLong(value);
    }

    static double getDouble(HttpServletRequest req, String name){
        String value = req.getParameter(name);
        return Double.parseDouble(value);
    }

//    public static long[] getLongArray(HttpServletRequest req, String name){
////        String[] value = req.getParameterValues(name);
//        long[] longs = new long[req.getParameterValues(name).length];
//        for (int i = 0 ; i < req.getParameterValues(name).length; i++) {
//            longs[i] = Long.parseLong(req.getParameterValues(name)[i]);
//        }
//        return longs;
//    }
    public static long[] getLongArray(HttpServletRequest req, String name){
        String[] value = req.getParameterValues(name);
        long[] longs = new long[value.length];
        for (int i = 0 ; i < value.length; i++) {
            longs[i] = Long.parseLong(value[i]);
        }
        return longs;
    }

    public static String[] getStringArray(HttpServletRequest req, String name){
        String[] value = req.getParameterValues(name);
        return value;
    }
}
