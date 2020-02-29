package pe.edu.utp.service;

import com.toddfast.util.convert.TypeConverter;
import java.time.LocalDate;

public class TypeService {
    public static String breakLine(String phrase, int chars){
        return phrase.replaceAll("(.{"+ chars +"})", "$1\n");
    }
    public static double roundNormal(double numero, int decimales){
        double dec = Math.pow(10,decimales);
        return Math.round(numero*dec)/dec;
    }
    public static java.sql.Date toSqlDate(LocalDate localFecha) {
        if (localFecha != null){
            return java.sql.Date.valueOf(localFecha);
        }else{
            return null;
        }
    }
    public static LocalDate toLocalDate(java.sql.Date sqlFecha) {
        if (sqlFecha != null){
            return new java.sql.Date(sqlFecha.getTime()).toLocalDate();
        }else{
            return null;
        }
    }
    public static Integer toInteger(Object num) {
        if (num != null){
            try{
                return TypeConverter.convert(Integer.class, num);
            }catch(Exception e){
                return Integer.valueOf("0");
            }
        }else{
            return null;
        }
    }
    public static Integer toIntegerZero(Object num) {
        if (num != null){
            try{
                return TypeConverter.convert(Integer.class, num);
            }catch(Exception e){
                return Integer.valueOf("0");
            }
        }else{
            return Integer.valueOf("0");
        }
    }
    public static Double toDouble(Object num) {
        if (num != null){
            try{
                return TypeConverter.convert(Double.class, num);
            }catch(Exception e){
                return Double.valueOf("0.0");
            }
        }else{
            return null;
        }
    }
    public static Double toDoubleZero(Object num) {
        if (num != null){
            try{
                return TypeConverter.convert(Double.class, num);
            }catch(Exception e){
                return Double.valueOf("0.0");
            }
        }else{
            return Double.valueOf("0.0");
        }
    }
    public static String toString(Object text) {
        if (text != null){
            try{
                return TypeConverter.convert(String.class, text);
            }catch(Exception e){
                return "";
            }
        }else{
            return null;
        }
    }
    public static String toStringBlank(Object text) {
        if (text != null){
            try{
                return TypeConverter.convert(String.class, text);
            }catch(Exception e){
                return "";
            }
        }else{
            return "";
        }
    }
}
