/*
 * Copyright 2008 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * Created at: 30/03/2008 - 18:19:49
 * 
 * ================================================================================
 * 
 * Direitos autorais 2008 JRimum Project
 * 
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode usar
 * esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que
 * haja exigência legal ou acordo por escrito, a distribuição de software sob
 * esta LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER
 * TIPO, sejam expressas ou tácitas. Veja a LICENÇA para a redação específica a
 * reger permissões e limitações sob esta LICENÇA.
 * 
 * Criado em: 30/03/2008 - 18:19:49
 * 
 */


package br.com.nordestefomento.jrimum.vallia;



/**
 * 
 * Descrição:
 * 
 * 
 * @author Gabriel Guimarães
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author Misael Barreto 
 * @author Rômulo Augusto
 * @author <a href="http://www.nordeste-fomento.com.br">Nordeste Fomento Mercantil</a>
 * 
 * @since JMatryx 1.0
 * 
 * @version 1.0
 */
class Validator4CNPJ extends AValidator4CadastroDePessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7818892654534965062L;


	/**
	 * @see br.com.nordestefomento.jrimum.vallia.AValidator4CadastroDePessoa#isValido()
	 */
	@Override
	public boolean isValido() {
		
		boolean isValido = false;
		int dv = 0;
		int dvCalculado = -1;
		
		dv = Integer.parseInt(getCodigoDoCadastro().substring(12, 14));

		dvCalculado = digitoVerificador.calcule(getCodigoDoCadastro().substring(0, 12));
		
		isValido = (dv == dvCalculado);	
			
		return isValido;
	}
	
	
	/**
	 * @see br.com.nordestefomento.jrimum.vallia.AValidator4CadastroDePessoa#removeFormatacao()
	 */
	@Override
	protected void removeFormatacao() {
		
		String codigo = codigoDoCadastro.toString();
		
		codigo = codigo.replace(".", "");
		codigo = codigo.replace("/", "");
		codigo = codigo.replace("-", "");

		codigoDoCadastro.delete(0, codigoDoCadastro.length());
		
		codigoDoCadastro.append(codigo);
	}

}
