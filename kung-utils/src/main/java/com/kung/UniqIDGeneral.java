package com.kung;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UniqIDGeneral {
    public static String generalUUID(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMDDHH24MMSS");
        Random random = new Random();
        return sdf.format(new Date())+Math.round(random.nextDouble()*10000);
    }
}
