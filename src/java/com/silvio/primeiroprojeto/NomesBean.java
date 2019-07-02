package com.silvio.primeiroprojeto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author SILVIO
 */
@SessionScoped//vai manter essa classe ativa enquanto a sessao estiver aberta(ver tempo de sessao em web.xml)
@ManagedBean(name="nomesBean")//nota a classe como gerenciador bean(pega as variaveis diretamente do xhtml)
public class NomesBean {
    
    private String nome;
    private String sobreNome;
    private String mensagem;
    
    public void dizerOla(){
        setMensagem("Ola " + nome + " " + sobreNome);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    private void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
    
}
