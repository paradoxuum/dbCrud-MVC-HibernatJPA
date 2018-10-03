package view;

import controller.ClienteJpaDAO;
import controller.VendasJpaDAO;
import model.Cliente;
import model.Vendas;

public class App {
	
	public static void main (String[] args) {
		
		Cliente c = new Cliente();
		c.setCpf("292.670.318-05");
		c.setId_cliente(1);
		c.setNome("Eduardo Lima");
		c.setRg("26.719.813-9");
		ClienteJpaDAO.getInstance().merge(c);
		System.out.println("Parabéns tu é bixão!");
		
		Vendas v = new Vendas();
		v.setCliente(c);
		v.setData("02/10/2018");
		v.setDesconto(0.10);
		v.setValorPago(1990.99);
		v.setValorTotal(1190.00);
		VendasJpaDAO.getInstance().merge(v);
		
	}
}
