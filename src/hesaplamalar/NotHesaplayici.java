package hesaplamalar;

public class NotHesaplayici {

        public static double ortalamaHesapla(double vize, double finalNotu) {
            return vize * 0.4 + finalNotu * 0.6;
        }

        public static String harfNotuHesapla(double ortalama) {
            if (ortalama >= 90) return "AA";
            else if (ortalama >= 85) return "BA";
            else if (ortalama >= 80) return "BB";
            else if (ortalama >= 70) return "CB";
            else if (ortalama >= 60) return "CC";
            else if (ortalama >= 50) return "DC";
            else if (ortalama >= 40) return "DD";
            else return "FF";

        }
    }


