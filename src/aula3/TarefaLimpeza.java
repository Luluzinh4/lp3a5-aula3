package aula3;

public class TarefaLimpeza implements Runnable {

	private Vaga vaga;
	
	public TarefaLimpeza(Vaga vaga) {
		this.vaga = vaga;
	}

	@Override
	public void run() {
		
		while(true) {
			this.vaga.limpeza();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
