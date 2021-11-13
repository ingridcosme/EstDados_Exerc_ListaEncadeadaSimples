/*
 * Escreva uma função que verifique se uma lista encadeada que contém
 * números inteiros está em ordem crescente.
 *
 * Escreva uma função que faça uma busca em uma lista encadeada crescente.
 * Faça uma versão recursiva e outra iterativa.
 */

package controller;

import br.edu.fateczl.ingridcosme.listaencadeadaint.ListaEncadeadaSimples;

public class OpController {

	public OpController() {
		super();
	}
	
	public void insere(int numero, ListaEncadeadaSimples l) {
		l.insertAtBack(numero);
		System.out.println(l.toString());
	}
	
	public boolean verificaOrdem(ListaEncadeadaSimples l) throws Exception {
		boolean ordenado = true;
		int posicao = l.size() - 1;
		
		while(posicao >= 1) {
			int atual = l.getValue(posicao);
			int anterior = l.getValue(posicao - 1);
			
			if(atual < anterior) {
				return false;
			}
			posicao--;
		}
		
		return ordenado;
	}
	
	public boolean buscaIterativa(int numero, ListaEncadeadaSimples l) throws Exception {
		int inicio = 0;
		int fim = l.size() - 1;
		boolean achou = false;
		
		while(inicio <= fim && achou == false) {
			int meio = (inicio + fim) / 2;
			int elementoLista = l.getValue(meio);
			
			if(elementoLista == numero) {
				achou = true;
			} else {
				if(numero < elementoLista) {
					fim = meio - 1;
				} else {
					inicio = meio + 1;
				}
			}
		}
		
		return achou;
	}
	
	public boolean buscaRecursiva(int numero, ListaEncadeadaSimples l) throws Exception {
		int tamanho = l.size();
		
		if(tamanho == 0) {
			return false;
		} else {
			int meio = tamanho / 2;
			if(l.getValue(meio) == numero) {
				return true;
			} else {
				if(numero < l.getValue(meio)) {
					ListaEncadeadaSimples auxiliar = new ListaEncadeadaSimples();
					for(int i = 0; i < meio; i++) {
						auxiliar.insertAtFront(l.getValue(i));
					}
					return buscaRecursiva(numero, auxiliar);
				} else {
					ListaEncadeadaSimples auxiliar = new ListaEncadeadaSimples();
					for(int i = meio; i < tamanho; i++) {
						auxiliar.insertAtFront(l.getValue(i));
					}
					return buscaRecursiva(numero, auxiliar);
				}
			}
		}
	}

	
}
