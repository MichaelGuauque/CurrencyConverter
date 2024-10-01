package model;

public class Change {

    private String monedaBase;
    private String monedaCambiar;
    private double montoAConvertir;
    private double conversion;

    public Change() {
    }

    public Change(String monedaBase, String monedaCambiar, double montoAConvertir, double conversion) {
        this.monedaBase = monedaBase;
        this.monedaCambiar = monedaCambiar;
        this.montoAConvertir = montoAConvertir;
        this.conversion = conversion;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaCambiar() {
        return monedaCambiar;
    }

    public void setMonedaCambiar(String monedaCambiar) {
        this.monedaCambiar = monedaCambiar;
    }

    public double getMontoAConvertir() {
        return montoAConvertir;
    }

    public void setMontoAConvertir(double montoAConvertir) {
        this.montoAConvertir = montoAConvertir;
    }

    public double getConversion() {
        return conversion;
    }

    public void setConversion(ChangeDTO changeDTO) {
        this.conversion = changeDTO.conversion_result();
    }

    @Override
    public String toString() {
        return  "Moneda Base = '" + monedaBase + '\'' +
                ", Moneda a Cambiar = '" + monedaCambiar + '\'' +
                ", Monto A Convertir = " + montoAConvertir +
                ", Conversion = " + conversion;
    }
}
