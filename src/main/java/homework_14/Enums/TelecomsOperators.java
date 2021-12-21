package homework_14.Enums;

public enum TelecomsOperators {
    REDLINE("111"),
    BEELINK("222"),
    TELECOURSE("333"),
    GREENLINE("444");

    private String code;

    /**
     * @param code Оператор связи.
     */
    TelecomsOperators(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
