package pe.edu.utp.util;

public class TypesUtil {
    public static String breakLine(String phrase, int chars){
        return phrase.replaceAll("(.{"+ chars +"})", "$1\n");
    }
    public static double roundNormal(double numero, int decimales){
        double dec = Math.pow(10,decimales);
        return Math.round(numero*dec)/dec;
    }
}
