/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.gov.health.hr.java;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author pdhs-sp
 */
public class Functions {

    public static Date firstDateOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DATE, 1);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date firstDateOfYear() {
        return firstDateOfYear(new Date());
    }
    
    public static Date lastDateOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DATE, 1);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.YEAR, 1);
        c.add(Calendar.MILLISECOND, -1);
        return c.getTime();
    }

    public static Date lastDateOfYear() {
        return lastDateOfYear(new Date());
    }
    
    
}
