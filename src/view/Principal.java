package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.ingridcosme.listaencadeadaint.ListaEncadeadaSimples;
import controller.OpController;

public class Principal {

	public static void main(String[] args) {
		ListaEncadeadaSimples l = new ListaEncadeadaSimples();
		OpController opCont = new OpController();
		
		int opc = 0;
		while(opc != 9) {
			String opcao = JOptionPane.showInputDialog(null, menu());
			opc = Integer.parseInt(opcao);
			switch(opc) {
			case 0:
				int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um n�mero"));
				opCont.insere(numero, l);
				break;
			case 1:
				try {
					if(!opCont.verificaOrdem(l)) {
						System.out.println("Os n�meros da lista n�o est�o em ordem crescente.");
					} else {
						System.out.println("Os n�meros da lista est�o em ordem crescente.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor"));
				try {
					if(!opCont.buscaIterativa(numero, l)) {
						System.out.println("O "+numero+" n�o est� na lista.");
					} else {
						System.out.println("O "+numero+" est� na lista.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor"));
				try {
					if(!opCont.buscaRecursiva(numero, l)) {
						System.out.println("O "+numero+" n�o est� na lista.");
					} else {
						System.out.println("O "+numero+" est� na lista.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Digite uma op��o v�lida", "ERRO", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
	}

	private static String menu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Digite uma op��o:\n");
		buffer.append("0 - Inserir um n�mero � lista\n");
		buffer.append("1 - Verificar a ordem da lista\n");
		buffer.append("2 - Buscar um valor na lista de modo iterativo\n");
		buffer.append("3 - Buscar um valor na lista de modo recursivo\n");
		buffer.append("9 - Encerra a aplica��o\n");

		return buffer.toString();
	}

}
