/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dos.helpdesk.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sala302b
 */

@Entity
public class Chamado implements Serializable {
    
    @Id // o codigo
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
   
    @ManyToOne(fetch = FetchType.EAGER) // seja preguiçoso usar "lazy" - // recupere usar "eager" forma de recuperar o atributo, POR PADRAO SERIA SOMENTE @ManyToOn
    private Usuario usuarioAbertura;
    
   
    @ManyToOne(fetch = FetchType.EAGER) // seja preguiçoso usar "lazy" - // recupere usar "eager" forma de recuperar o atributo, POR PADRAO SERIA SOMENTE @ManyToOn
    private Usuario tecnicoResponsavel;
    
    @Temporal(TemporalType.DATE)
    private Date dataAbertura;
    
    @Temporal(TemporalType.DATE)
    private Date limiteAtendimento;
    
    private String descricao;
    
    private String solucao;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @ManyToOne(fetch = FetchType.EAGER) // seja preguiçoso usar "lazy" - // recupere usar "eager" forma de recuperar o atributo, POR PADRAO SERIA SOMENTE @ManyToOn
    private TipoChamado tipoChamado;
    
    @ManyToOne(fetch = FetchType.EAGER) // seja preguiçoso usar "lazy" - // recupere usar "eager" forma de recuperar o atributo, POR PADRAO SERIA SOMENTE @ManyToOn
    private Equipamento equipamento;

    public Usuario getUsuarioAbertura() {
        return usuarioAbertura;
    }

    public void setUsuarioAbertura(Usuario usuarioAbertura) {
        this.usuarioAbertura = usuarioAbertura;
    }

    public Usuario getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    public void setTecnicoResponsavel(Usuario tecnicoResponsavel) {
        this.tecnicoResponsavel = tecnicoResponsavel;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getLimiteAtendimento() {
        return limiteAtendimento;
    }

    public void setLimiteAtendimento(Date limiteAtendimento) {
        this.limiteAtendimento = limiteAtendimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TipoChamado getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(TipoChamado tipoChamado) {
        this.tipoChamado = tipoChamado;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.usuarioAbertura);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chamado other = (Chamado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }
    
}
