package B2BCalculator;

import B2BCalculator.Model.InputData;

import java.math.BigDecimal;

public interface TAXcalculationService {
    BigDecimal calculate(InputData inputData);
}
