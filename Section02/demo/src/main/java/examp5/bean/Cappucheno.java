package examp5.bean;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class Cappucheno implements Coffe {

	@Override
	public String makeCoffe() {
		return "make Cappucheno";
	}

}
