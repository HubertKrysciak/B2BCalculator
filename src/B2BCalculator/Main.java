package B2BCalculator;

import B2BCalculator.Model.InputData;
import B2BCalculator.Service.VATcalculationService;
import B2BCalculator.Service.VatcalculationServiceImplementation;
import B2BCalculator.Service.ZUScalculationService;
import B2BCalculator.Service.ZuscalculationServiceImplementation;

public class Main {
    public static void main(String[] args) {
        InputData inputData = new InputData();

        VATcalculationService vaTcalculationService = new VatcalculationServiceImplementation();
        ZUScalculationService zuScalculationService = new ZuscalculationServiceImplementation();
        TAXcalculationService taxcalculationService =
                new TaxcalculationServiceImplementation(vaTcalculationService, zuScalculationService);

        System.out.println(taxcalculationService.calculate(inputData));
    }
}
