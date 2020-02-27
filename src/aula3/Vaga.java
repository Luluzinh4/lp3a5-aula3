package aula3;

public class Vaga {

	public void compraRapida() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " procurando vaga no estacionamento");
		
		synchronized (this) {
			System.out.println(nome + " entrou na vaga");
			System.out.println(nome + " fazendo compra rápida!");
			
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + " colocando as compras no carro");
			System.out.println(nome + " entrando no carro");
			System.out.println(nome + " saindo da vaga");
			
			limpeza();
		}
		
	}
	
	public void compraDemorada() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " procurando vaga no estacionamento");
		
		synchronized (this) {
			System.out.println(nome + " entrou na vaga");
			System.out.println(nome + " fazendo compra demorada!");
			
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + " colocando as compras no carro");
			System.out.println(nome + " entrando no carro");
			System.out.println(nome + " saindo da vaga");
			
			limpeza();
		}
		
	}
	
	public void limpeza() {
		System.out.println("Realizando limpeza da vaga");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Limpeza realizada. Vaga liberada!");
	}
}
