package ru.ifmo.cet.javabasics;

import java.util.ArrayList;
import java.util.Collections;
import java.math.BigDecimal;

/**
 * <br/> * Класс для работы с деньгами<br/> * @author runcore<br/>
 */
public class Translator {

    /**
     * <br/>     * Сумма денег<br/>
     */
    private BigDecimal amount;

    /**
     * <br/>     * Конструктор из Long<br/>
     */
    public Translator(long l) {
        String s = String.valueOf(l);
        if (!s.contains("."))
            s += ".0";
        this.amount = new BigDecimal(s);
    }

    /**
     * <br/>     * Конструктор из Double<br/>
     */
    public Translator(double l) {
        String s = String.valueOf(l);
        if (!s.contains("."))
            s += ".0";
        this.amount = new BigDecimal(s);
    }

    /**
     * <br/>     * Конструктор из String<br/>
     */
    public Translator(String s) {
        if (!s.contains("."))
            s += ".0";
        this.amount = new BigDecimal(s);
    }

    /**
     * <br/>     * Вернуть сумму как строку<br/>
     */
    public String asString() {
        return amount.toString();
    }

    /**
     * <br/>     * Вернуть сумму прописью, с точностью до копеек<br/>
     */
    public String num2str() {
        return num2str(false);
    }

    /**
     * <br/>     * Выводим сумму прописью<br/>     * @param stripkop boolean флаг - показывать копейки или нет<br/>     * @return String Сумма прописью<br/>
     */
    public String num2str(boolean stripkop) {
        String[][] sex = {
                {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"},
                {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"},
        };
        String[] str100 = {"", "one hundred", "two hundred", "three hundred", "four hundred", "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"};
        String[] str11 = {"", "ten", "eleven", "twelve", "thirtheen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
        String[] str10 = {"", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[][] forms = {
                {"копейка", "копейки", "копеек", "1"},
                {"bottle", "bottles", "bottles", "0"},
                {"тысяча", "тысячи", "тысяч", "1"},
                {"миллион", "миллиона", "миллионов", "0"},
                {"миллиард", "миллиарда", "миллиардов", "0"},
                {"триллион", "триллиона", "триллионов", "0"},
                // можно добавлять дальше секстиллионы и т.д.
        };
        // получаем отдельно рубли и копейки
        long rub = amount.longValue();
        String[] moi = amount.toString().split("\\.");
        long kop = Long.valueOf(moi[1]);
        if (!moi[1].substring(0, 1).equals("0")) {// начинается не с нуля
            if (kop < 10)
                kop *= 10;
        }
        String kops = String.valueOf(kop);
        if (kops.length() == 1)
            kops = "0" + kops;
        long rub_tmp = rub;
        // Разбиватель суммы на сегменты по 3 цифры с конца
        ArrayList segments = new ArrayList();
        while (rub_tmp > 999) {
            long seg = rub_tmp / 1000;
            segments.add(rub_tmp - (seg * 1000));
            rub_tmp = seg;
        }
        segments.add(rub_tmp);
        Collections.reverse(segments);
        // Анализируем сегменты
        String o = "";
        if (rub == 0) {// если Ноль
            o = "ноль " + morph(0, forms[1][0], forms[1][1], forms[1][2]);
            if (stripkop)
                return o;
            else
                return o + " " + kop + " " + morph(kop, forms[0][0], forms[0][1], forms[0][2]);
        }
        // Больше нуля
        int lev = segments.size();
        for (int i = 0; i < segments.size(); i++) {// перебираем сегменты
            int sexi = (int) Integer.valueOf(forms[lev][3].toString());// определяем род
            int ri = (int) Integer.valueOf(segments.get(i).toString());// текущий сегмент
            if (ri == 0 && lev > 1) {
                lev--;
                continue;
            }
            String rs = String.valueOf(ri); // число в строку
            // нормализация
            if (rs.length() == 1) rs = "00" + rs;// два нулика в префикс?
            if (rs.length() == 2) rs = "0" + rs; // или лучше один?
            // получаем циферки для анализа
            int r1 = (int) Integer.valueOf(rs.substring(0, 1)); //первая цифра
            int r2 = (int) Integer.valueOf(rs.substring(1, 2)); //вторая
            int r3 = (int) Integer.valueOf(rs.substring(2, 3)); //третья
            int r22 = (int) Integer.valueOf(rs.substring(1, 3)); //вторая и третья
            // Супер-нано-анализатор циферок
            if (ri > 99) o += str100[r1] + " "; // Сотни
            if (r22 > 20) {// >20
                o += str10[r2] + " ";
                o += sex[sexi][r3] + " ";
            } else { // <=20
                if (r22 > 9) o += str11[r22 - 9] + " "; // 10-20
                else o += sex[sexi][r3] + " "; // 0-9
            }
            // Единицы измерения (рубли...)
            o += morph(ri, forms[lev][0], forms[lev][1], forms[lev][2]) + " ";
            lev--;
        }
        // Копейки в цифровом виде
        if (stripkop) {
            o = o.replaceAll(" {2,}", " ");
        } else {
            o = o + "" + kops + " " + morph(kop, forms[0][0], forms[0][1], forms[0][2]);
            o = o.replaceAll(" {2,}", " ");
        }
        return o;
    }

    /**
     * <br/>     * Склоняем словоформу<br/>     * @param n Long количество объектов<br/>     * @param f1 String вариант словоформы для одного объекта<br/>     * @param f2 String вариант словоформы для двух объектов<br/>     * @param f5 String вариант словоформы для пяти объектов<br/>     * @return String правильный вариант словоформы для указанного количества объектов<br/>
     */
    public static String morph(long n, String f1, String f2, String f5) {
        n = Math.abs(n) % 100;
        long n1 = n % 10;
        if (n > 10 && n < 20) return f5;
        if (n1 > 1 && n1 < 5) return f2;
        if (n1 == 1) return f1;
        return f5;
    }
}