package examp5.bean;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class Expresso implements Coffe {

	@Override
	public String makeCoffe() {
		return "make Expresso";
	}

}
