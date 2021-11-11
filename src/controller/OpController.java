/*
 * Escreva uma função que verifique se uma lista encadeada que contém
 * números inteiros está em ordem crescente.
 *
 * Escreva uma função que faça uma busca em uma lista encadeada crescente.
 * Faça uma versão recursiva e outra iterativa.
 */

package controller;

import br.edu.fateczl.ingridcosme.listaencadeadaint.ListaEncadeada;

public class OpController {

	public OpController() {
		super();
	}
	
	public boolean verificaOrdem(ListaEncadeada l) throws Exception {
		boolean ordenado = true;
		int posicao = l.size() - 1;
		
		while(!ordenado || posicao >= 1) {
			int atual = l.pegaElemento(posicao);
			int anterior = l.pegaElemento(posicao - 1);
			
			if(atual < anterior) {
				ordenado = false;
			}
			posicao--;
		}
		
		return ordenado;
	}
	
	public boolean buscaIterativa(int numero, ListaEncadeada l) throws Exception {
		int inicio = 0;
		int fim = l.size() - 1;
		boolean achou = false;
		
		while(inicio <= fim && achou == false) {
			int meio = (inicio + fim) / 2;
			int elementoLista = l.pegaElemento(meio);
			
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
	
	public boolean buscaRecursiva(int numero, ListaEncadeada l) throws Exception {
		int tamanho = l.size();
		
		if(tamanho == 0) {
			return false;
		} else {
			int meio = tamanho / 2;
			if(l.pegaElemento(meio) == numero) {
				return true;
			} else {
				if(numero < l.pegaElemento(meio)) {
					ListaEncadeada auxiliar = new ListaEncadeada();
					for(int i = 0; i < meio; i++) {
						auxiliar.insertAtFront(l.pegaElemento(i));
					}
					return buscaRecursiva(numero, auxiliar);
				} else {
					ListaEncadeada auxiliar = new ListaEncadeada();
					for(int i = meio; i < tamanho; i++) {
						auxiliar.insertAtFront(l.pegaElemento(i));
					}
					return buscaRecursiva(numero, auxiliar);
				}
			}
		}
	}

	
}
