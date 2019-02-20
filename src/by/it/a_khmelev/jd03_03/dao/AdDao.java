package by.it.a_khmelev.jd03_03.dao;

import by.it.a_khmelev.jd03_03.beans.Ad;

public class AdDao extends UniversalDao<Ad>{
    public AdDao() {
        super(Ad.class, "ads");
    }
}
