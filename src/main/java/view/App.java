package view;

import controller.ClJpaDAO;
import model.Cliente;

public class App {
	
	public static void main (String[] args) {
		
		Cliente c = new Cliente();
		c.setCpf("292.670.318-05");
		c.setId(1);
		c.setNome("Eduardo Lima");
		c.setRg("26.719.813-9");
		ClJpaDAO.getInstance().merge(c);
		System.out.println("Parabéns tu é bixão!");
	}

}
