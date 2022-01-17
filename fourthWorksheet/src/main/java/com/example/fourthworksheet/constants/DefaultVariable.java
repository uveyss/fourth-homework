package com.example.fourthworksheet.constants;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigDecimal;

public class DefaultVariable  {

    public static final BigDecimal dailyLatedDebitAmount = BigDecimal.valueOf(1.5);

    public static final BigDecimal dailyLatedDebitAfterRefrenceDate=BigDecimal.valueOf(2.0);

    public  final  Date refdate=getRefrenceDate("2018/01/01");

    private Date getRefrenceDate(String refrenceDate)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
        Date date =null;
        try {

         date = formatter.parse(refrenceDate);

        } catch (
        ParseException e) {
            e.printStackTrace();
        }
            return  date;
        }

}
