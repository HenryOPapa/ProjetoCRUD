package modelo;

public class teste {
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setCpf("111");
		cliente.setEndereco("hhhhh");
		System.out.println(cliente.getCpf());
		System.out.println(cliente.getEndereco());
	}

}
