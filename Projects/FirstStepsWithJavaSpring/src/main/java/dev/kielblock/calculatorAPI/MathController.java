package dev.kielblock.calculatorAPI;

import dev.kielblock.calculatorAPI.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/calculator")
public class MathController {

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
                               @PathVariable(value = "numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                                 @PathVariable(value = "numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @GetMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable(value = "numberOne") String numberOne,
                          @PathVariable(value = "numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @GetMapping("/squareroot/{number}")
    private Double squareRoot(@PathVariable(value = "number") String number) {
        if(!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return Math.sqrt(convertToDouble(number));
    }

    private Double convertToDouble(String strNumber) {
        if(strNumber == null) {
            return 0D;
        }

        String treatedNumber = strNumber.replaceAll(",", ".");

        if(isNumeric(treatedNumber)) {
            return Double.parseDouble(treatedNumber);
        }

        return 0D;
    }

    /*private Integer convertToInteger(String strNumber) {
        if(strNumber == null) {
            return 1;
        }

        String treatedNumber = strNumber.replaceAll(",", ".");

        if(isNumeric(treatedNumber)) {
            return Integer.parseInt(treatedNumber);
        }

        return 0;
    }*/

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) {
            return false;
        }

        String treatedNumber = strNumber.replaceAll(",", ".");

        return treatedNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
