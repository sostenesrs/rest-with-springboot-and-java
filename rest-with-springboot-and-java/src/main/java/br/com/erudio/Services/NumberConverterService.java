package br.com.erudio.Services;

import org.springframework.stereotype.Service;

@Service
public class NumberConverterService {


    public Double convertToDouble(String strNumber) {
        if(strNumber==null){
            return 0D; //retorna zero
        }
        String number = strNumber.replaceAll(",", "."); //regex que subsittui a virgula por ponto
        if(isNumeric(number)) {
            return Double.parseDouble(number);
        }
        return 0D;
    }

    public boolean isNumeric (String strNumber){
        if(strNumber==null){
            return false;
        }
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+"); //verifica se positivo ou negativo e de zero a nove (veriifca se é númerico)
    }
}
