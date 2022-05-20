package lab1.observer;

public enum FigureEnum {
    LEFT_EYE("left_eye"),
    RIGHT_EYE("right_eye"),
    MOUTH("mouth"),
    NOSE("nose"),
    NONE("");

    private String nameFigure;

    FigureEnum(String envUrl) {
        this.nameFigure = envUrl;
    }

    public String getNameFigure() {
        return nameFigure;
    }

    public static FigureEnum fromString(String text) {
        for (FigureEnum nameFigure : FigureEnum.values()) {
            if (nameFigure.nameFigure.equalsIgnoreCase(text)) {
                return nameFigure;
            }
        }
        return null;
    }
}
