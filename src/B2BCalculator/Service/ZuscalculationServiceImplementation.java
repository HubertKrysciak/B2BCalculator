package B2BCalculator.Service;

import B2BCalculator.Model.InputData;
import B2BCalculator.Model.ZUS;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ZuscalculationServiceImplementation implements ZUScalculationService {

    private static final BigDecimal PODSTAWA_WYMIARU_PELNY = BigDecimal.valueOf(3553.20);
    private static final BigDecimal PODSTAWA_WYMIARU_MALY = BigDecimal.valueOf(903);
    private BigDecimal emerytalne;
    private BigDecimal rentowe;
    private BigDecimal wypadkowe;
    private BigDecimal chorobowe;
    private BigDecimal fpis;
    private BigDecimal zdrowotna;
    private BigDecimal koszty = BigDecimal.ZERO;
    private BigDecimal skladki_do_odliczenia;


    @Override
    public ZuscalculationServiceImplementation calculate(InputData inputData) {
        switch (inputData.getFormOfTaxation()) {
            case ZASADY_OGOLNE:
                switch (inputData.getZus()) {
                    case PELNY_ZUS:
                        ZuscalculationServiceImplementation z1 = new ZuscalculationServiceImplementation();
                        z1.emerytalne = PODSTAWA_WYMIARU_PELNY.multiply(BigDecimal.valueOf(0.1952)).setScale(2, RoundingMode.HALF_UP);
                        z1.rentowe = PODSTAWA_WYMIARU_PELNY.multiply(BigDecimal.valueOf(0.08)).setScale(2, RoundingMode.HALF_UP);
                        z1.wypadkowe = PODSTAWA_WYMIARU_PELNY.multiply(BigDecimal.valueOf(0.0167)).setScale(2, RoundingMode.HALF_UP);
                        if (inputData.isDobrowolna_chorobowa()) {
                            z1.chorobowe = PODSTAWA_WYMIARU_PELNY.multiply(BigDecimal.valueOf(0.0245)).setScale(2, RoundingMode.HALF_UP);
                        } else {
                            z1.chorobowe = BigDecimal.ZERO;
                        }
                        z1.fpis = PODSTAWA_WYMIARU_PELNY.multiply(BigDecimal.valueOf(0.0245)).setScale(2, RoundingMode.HALF_UP);
                        z1.skladki_do_odliczenia = z1.emerytalne.add(z1.chorobowe).add(z1.wypadkowe).add(z1.rentowe).add(z1.fpis);
                        z1.zdrowotna = (inputData.getNetValue().subtract(koszty).subtract(z1.emerytalne).subtract(z1.rentowe).subtract(z1.wypadkowe).subtract(z1.chorobowe)).multiply(BigDecimal.valueOf(0.09)).setScale(2, RoundingMode.HALF_UP);
                        return z1;
                    case MALY_ZUS:
                        ZuscalculationServiceImplementation z2 = new ZuscalculationServiceImplementation();
                        z2.emerytalne = PODSTAWA_WYMIARU_MALY.multiply(BigDecimal.valueOf(0.1952)).setScale(2, RoundingMode.HALF_UP);
                        z2.rentowe = PODSTAWA_WYMIARU_MALY.multiply(BigDecimal.valueOf(0.08)).setScale(2, RoundingMode.HALF_UP);
                        z2.wypadkowe = PODSTAWA_WYMIARU_MALY.multiply(BigDecimal.valueOf(0.0167)).setScale(2, RoundingMode.HALF_UP);
                        if (inputData.isDobrowolna_chorobowa()) {
                            z2.chorobowe = PODSTAWA_WYMIARU_PELNY.multiply(BigDecimal.valueOf(0.0245));
                        } else {
                            z2.chorobowe = BigDecimal.ZERO;
                        }
                        z2.skladki_do_odliczenia = z2.emerytalne.add(z2.chorobowe).add(z2.wypadkowe).add(z2.rentowe).add(z2.fpis);
                        z2.zdrowotna = (inputData.getNetValue().subtract(koszty).subtract(z2.emerytalne.add(z2.rentowe).add(z2.wypadkowe).add(z2.chorobowe))).multiply(BigDecimal.valueOf(0.09)).setScale(2, RoundingMode.HALF_UP);
                        return z2;
                    case ULGA_NA_START:
                        ZuscalculationServiceImplementation z3 = new ZuscalculationServiceImplementation();
                        z3.emerytalne = BigDecimal.ZERO;
                        z3.rentowe = BigDecimal.ZERO;
                        z3.wypadkowe = BigDecimal.ZERO;
                        z3.chorobowe = BigDecimal.ZERO;
                        z3.skladki_do_odliczenia = z3.emerytalne.add(z3.chorobowe).add(z3.wypadkowe).add(z3.rentowe).add(z3.fpis);
                        z3.zdrowotna = (inputData.getNetValue().subtract(koszty).subtract(z3.emerytalne.add(z3.rentowe).add(z3.wypadkowe).add(z3.chorobowe))).multiply(BigDecimal.valueOf(0.09)).setScale(2, RoundingMode.HALF_UP);
                        return z3;
                }
                break;
            default:
            }
        return new ZuscalculationServiceImplementation();
    }


    public BigDecimal getEmerytalne() {
        return emerytalne;
    }

    public BigDecimal getRentowe() {
        return rentowe;
    }

    public BigDecimal getWypadkowe() {
        return wypadkowe;
    }

    public BigDecimal getChorobowe() {
        return chorobowe;
    }

    public BigDecimal getFpis() {
        return fpis;
    }

    public BigDecimal getZdrowotna() {
        return zdrowotna;
    }

    public BigDecimal getSkladki_do_odliczenia() {
        return skladki_do_odliczenia;
    }
}
