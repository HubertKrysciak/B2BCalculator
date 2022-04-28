package B2BCalculator;

import B2BCalculator.Model.InputData;
import B2BCalculator.Service.VATcalculationService;
import B2BCalculator.Service.ZUScalculationService;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxcalculationServiceImplementation implements TAXcalculationService {

    private VATcalculationService vatcalculationService;
    private ZUScalculationService zuscalculationService;

    public TaxcalculationServiceImplementation(VATcalculationService vatcalculationService, ZUScalculationService zuscalculationService) {
        this.vatcalculationService = vatcalculationService;
        this.zuscalculationService = zuscalculationService;
    }



    @Override
    public BigDecimal calculate(InputData inputData) {
        return ((inputData.getNetValue().subtract(BigDecimal.valueOf(2500)).subtract(zuscalculationService.calculate(inputData).getSkladki_do_odliczenia()).multiply(BigDecimal.valueOf(0.17)))).setScale(0, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
    }
}
