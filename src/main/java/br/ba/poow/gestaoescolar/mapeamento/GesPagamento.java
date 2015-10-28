/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poow.gestaoescolar.mapeamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego Sabino
 */
@Entity
@Table(name = "ges_pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GesPagamento.findAll", query = "SELECT g FROM GesPagamento g"),
    @NamedQuery(name = "GesPagamento.findByPagCod", query = "SELECT g FROM GesPagamento g WHERE g.pagCod = :pagCod"),
    @NamedQuery(name = "GesPagamento.findByPagNumero", query = "SELECT g FROM GesPagamento g WHERE g.pagNumero = :pagNumero"),
    @NamedQuery(name = "GesPagamento.findByPagPlano", query = "SELECT g FROM GesPagamento g WHERE g.pagPlano = :pagPlano"),
    @NamedQuery(name = "GesPagamento.findByPagRegular", query = "SELECT g FROM GesPagamento g WHERE g.pagRegular = :pagRegular"),
    @NamedQuery(name = "GesPagamento.findByPagForma", query = "SELECT g FROM GesPagamento g WHERE g.pagForma = :pagForma"),
    @NamedQuery(name = "GesPagamento.findByPesValor", query = "SELECT g FROM GesPagamento g WHERE g.pesValor = :pesValor")})
public class GesPagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAG_COD")
    private Integer pagCod;
    @Column(name = "PAG_NUMERO")
    private Integer pagNumero;
    @Column(name = "PAG_PLANO")
    private Character pagPlano;
    @Column(name = "PAG_REGULAR")
    private Character pagRegular;
    @Size(max = 20)
    @Column(name = "PAG_FORMA")
    private String pagForma;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PES_VALOR")
    private BigDecimal pesValor;
    @JoinColumn(name = "CLI_COD", referencedColumnName = "CLI_COD")
    @ManyToOne
    private GesCliente cliCod;

    public GesPagamento() {
    }

    public GesPagamento(Integer pagCod) {
        this.pagCod = pagCod;
    }

    public Integer getPagCod() {
        return pagCod;
    }

    public void setPagCod(Integer pagCod) {
        this.pagCod = pagCod;
    }

    public Integer getPagNumero() {
        return pagNumero;
    }

    public void setPagNumero(Integer pagNumero) {
        this.pagNumero = pagNumero;
    }

    public Character getPagPlano() {
        return pagPlano;
    }

    public void setPagPlano(Character pagPlano) {
        this.pagPlano = pagPlano;
    }

    public Character getPagRegular() {
        return pagRegular;
    }

    public void setPagRegular(Character pagRegular) {
        this.pagRegular = pagRegular;
    }

    public String getPagForma() {
        return pagForma;
    }

    public void setPagForma(String pagForma) {
        this.pagForma = pagForma;
    }

    public BigDecimal getPesValor() {
        return pesValor;
    }

    public void setPesValor(BigDecimal pesValor) {
        this.pesValor = pesValor;
    }

    public GesCliente getCliCod() {
        return cliCod;
    }

    public void setCliCod(GesCliente cliCod) {
        this.cliCod = cliCod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.pagCod);
        hash = 29 * hash + Objects.hashCode(this.pagNumero);
        hash = 29 * hash + Objects.hashCode(this.pagPlano);
        hash = 29 * hash + Objects.hashCode(this.pagRegular);
        hash = 29 * hash + Objects.hashCode(this.pagForma);
        hash = 29 * hash + Objects.hashCode(this.pesValor);
        hash = 29 * hash + Objects.hashCode(this.cliCod);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GesPagamento other = (GesPagamento) obj;
        if (!Objects.equals(this.pagCod, other.pagCod)) {
            return false;
        }
        if (!Objects.equals(this.pagNumero, other.pagNumero)) {
            return false;
        }
        if (!Objects.equals(this.pagPlano, other.pagPlano)) {
            return false;
        }
        if (!Objects.equals(this.pagRegular, other.pagRegular)) {
            return false;
        }
        if (!Objects.equals(this.pagForma, other.pagForma)) {
            return false;
        }
        if (!Objects.equals(this.pesValor, other.pesValor)) {
            return false;
        }
        if (!Objects.equals(this.cliCod, other.cliCod)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ba.poow.gestaoescolar.mapeamento.GesPagamento[ pagCod=" + pagCod + " ]";
    }
    
}
