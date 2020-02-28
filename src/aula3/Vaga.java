package aula3;

public class Vaga {

	private boolean estaSujo = true;
	
	public void compraRapida() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " procurando vaga no estacionamento");
		
		synchronized (this) {
			System.out.println(nome + " entrou na vaga");
			
			while(this.estaSujo) {
				espera(nome);
				System.out.println(nome + " entrou na vaga");
			}
			
			System.out.println(nome + " fazendo compra rápida!");
				
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
			System.out.println(nome + " colocando as compras no carro");
				
			this.estaSujo = true;
				
			System.out.println(nome + " entrando no carro");
			System.out.println(nome + " saindo da vaga");
			
		}
		
	}
	
	

	public void compraDemorada() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " procurando vaga no estacionamento");
		
		synchronized (this) {
			System.out.println(nome + " entrou na vaga");
			
			while(this.estaSujo) {
				espera(nome);
				System.out.println(nome + " entrou na vaga");
			}
				
			System.out.println(nome + " fazendo compra demorada!");
				
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
			System.out.println(nome + " colocando as compras no carro");
				
			this.estaSujo = true;
				
			System.out.println(nome + " entrando no carro");
			System.out.println(nome + " saindo da vaga");
			
		}
		
	}
	
	public void limpeza() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " procurando vaga para limpar");
		
		synchronized (this) {
			System.out.println(nome + " entrou na vaga");
			
			if (!estaSujo) {
				System.out.println("Não está sujo. " + nome + " sai da vaga");
				return;
			}
			
			System.out.println("Realizando limpeza da vaga");
			this.estaSujo = false;
			
			try {
				Thread.sleep(9000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Limpeza realizada. Vaga liberada!");
			this.notifyAll();
		}
		
	}
	
	private void espera(String nome) {
		System.out.println(nome + " sai da vaga. A vaga está suja!");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
