package com.kung;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UniqIDGeneral {
    public static String generalUUID(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        Random random = new Random();
        return sdf.format(new Date())+Math.round(random.nextDouble()*10000);
    }
}
