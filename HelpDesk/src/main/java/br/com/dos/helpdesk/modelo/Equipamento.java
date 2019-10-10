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
public class Equipamento implements Serializable {
    
    @Id // o codigo
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "numeroPatrimonio", nullable = false)
    private String numeroPatrimonio;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dtFimGarantia", nullable = false) // NÃO ACEITA O CAMPO COMO NULO (NULLLABLE = FALSE)
    private Date dtFimGarantia;
    
    private Boolean ativo;
    
    @Column(name = "dadosComplementares", nullable = false)
    private String dadosComplementares;
    
    private String observacao;
    
   // @Column(name = "localInstalacao", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER) // seja preguiçoso usar "lazy" - // recupere usar "eager" forma de recuperar o atributo, POR PADRAO SERIA SOMENTE @ManyToOne
    private Local localInstalacao;
    
   // @Column(name = "tipoEquipamento", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER) // seja preguiçoso usar "lazy" - // recupere usar "eager" forma de recuperar o atributo, POR PADRAO SERIA SOMENTE @ManyToOne
    private TipoEquipamento tipoEquipamento;
    
   // @Column(name = "modelo", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER) // seja preguiçoso usar "lazy" - // recupere usar "eager" forma de recuperar o atributo, POR PADRAO SERIA SOMENTE @ManyToOne
    private Modelo modelo;
    
   // @Column(name = "fabricante", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER) // seja preguiçoso usar "lazy" - // recupere usar "eager" forma de recuperar o atributo, POR PADRAO SERIA SOMENTE @ManyToOne
    private Fabricante fabricante;

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public Date getDtFimGarantia() {
        return dtFimGarantia;
    }

    public void setDtFimGarantia(Date dtFimGarantia) {
        this.dtFimGarantia = dtFimGarantia;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getDadosComplementares() {
        return dadosComplementares;
    }

    public void setDadosComplementares(String dadosComplementares) {
        this.dadosComplementares = dadosComplementares;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Local getLocalInstalacao() {
        return localInstalacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.numeroPatrimonio);
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
        final Equipamento other = (Equipamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public void setLocalInstalacao(Local localInstalacao) {
        this.localInstalacao = localInstalacao;
    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
