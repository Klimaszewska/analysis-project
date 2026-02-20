public enum ScreeningType {
    TWO_D("2D"),
    THREE_D("3D"),
    VIP("VIP");

    private final String label;

    ScreeningType(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
