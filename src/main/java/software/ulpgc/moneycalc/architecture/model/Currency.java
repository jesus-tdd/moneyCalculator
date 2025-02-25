package software.ulpgc.moneycalc.architecture.model;

public record Currency(String name, String code, String symbol) {
    @Override
    public String toString() {
        return code;
    }
}
