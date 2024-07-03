package br.com.erudio.Controller;
import br.com.erudio.Exceptions.ResourceNotFoundException;
import br.com.erudio.Services.NumberConverterService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

	NumberConverterService service = new NumberConverterService();

	@RequestMapping(value= "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberone,
					  @PathVariable(value = "numberTwo") String numberTwo){
			if(!service.isNumeric(numberone) || !service.isNumeric(numberTwo)){
				throw new ResourceNotFoundException("Por favor insira um valor numérico");
			}
			return service.convertToDouble(numberone) + service.convertToDouble(numberTwo);
	}

	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo) {
		if(!service.isNumeric(numberOne)|| !service.isNumeric(numberTwo)){
			throw new ResourceNotFoundException("Por favor insira um valor numérico");
		}
		return service.convertToDouble(numberOne) - service.convertToDouble(numberTwo);
	}

	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo) {
		if(!service.isNumeric(numberOne)|| !service.isNumeric(numberTwo)){
			throw new ResourceNotFoundException("Por favor insira um valor numérico");
		}
		return service.convertToDouble(numberOne) * service.convertToDouble(numberTwo);
	}

	@RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double average(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo) {
		if(!service.isNumeric(numberOne)|| !service.isNumeric(numberTwo)){
			throw new ResourceNotFoundException("Por favor insira um valor numérico");
		}
		return (service.convertToDouble(numberOne) + service.convertToDouble(numberTwo)) /2;
	}

	@RequestMapping(value = "/square/{numberOne}", method = RequestMethod.GET)
	public Double square(@PathVariable(value = "numberOne") String numberOne) {
		if(!service.isNumeric(numberOne)){
			throw new ResourceNotFoundException("Por favor insira um valor numérico");
		}
		return Math.sqrt(service.convertToDouble(numberOne));
	}



}
