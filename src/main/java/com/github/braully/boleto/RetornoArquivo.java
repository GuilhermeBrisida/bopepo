/*
 * Copyright 2019 Projeto JRimum.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.braully.boleto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author braully
 */
public class RetornoArquivo extends ArquivoFacade {

    public RetornoArquivo(TagLayout template) {
        this.template = template;
    }

    public RegistroArquivo cabecalho() {
        return this.get("cabecalho");
    }

    public RegistroArquivo cabecalhoLote() {
        return this.get("cabecalhoLote");
    }

    public List<RegistroArquivo> detalhes() {
        List<RegistroArquivo> regs = new ArrayList<>();
        //Melhorar isso, indexar via Map
        for (RegistroArquivo reg : registros) {
            if (reg.getName().toLowerCase().startsWith("detalhe")) {
                regs.add(reg);
            }
        }
        return regs;
    }

    public List<TituloArquivo> detalhesAsTitulos() {
        List<TituloArquivo> regs = new ArrayList<>();
        //Melhorar isso, indexar via Map
        for (RegistroArquivo reg : registros) {
            if (reg.getName().toLowerCase().startsWith("detalhe")) {
                regs.add(new TituloArquivo(reg));
            }
        }
        return regs;
    }

    public RegistroArquivo rodapeLote() {
        return this.get("rodapeLote");
    }

    public RegistroArquivo rodape() {
        return this.get("rodape");
    }
}
