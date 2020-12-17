package com.config.constants.table;

public class AppellationConstants {

    public static final Short VOICE_TYPE_SURNAME = 1;
    public static final Short VOICE_TYPE_APPELLATION = 2;

    public static final String APPELLATION_GENTLEMAN = "GENTLEMAN";
    public static final String APPELLATION_GENTLEMAN_TRANS = "先生";


    public static final String APPELLATION_LADY = "LADY";
    public static final String APPELLATION_LADY_TRANS = "女士";


    public enum SOUNDER {

        MAN(2),
        WOMAN(1);

        private int code;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        SOUNDER(int code) {
            this.code = code;
        }

        public static SOUNDER getValue(int code) {
            for (SOUNDER sounder : values())
                if (sounder.getCode() == code)
                    return sounder;
            return null;
        }

    }

    public enum VALIDORINVALID {
        VALID(0),
        INVALID(1);

        private int code;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        VALIDORINVALID(int code) {
            this.code = code;
        }

        public static VALIDORINVALID getValue(int code) {
            for (VALIDORINVALID validorinvalid : values())
                if (validorinvalid.getCode() == code)
                    return validorinvalid;
            return null;
        }

    }
}
