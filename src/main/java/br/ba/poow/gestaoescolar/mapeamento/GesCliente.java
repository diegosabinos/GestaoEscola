/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poow.gestaoescolar.mapeamento;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego Sabino
 */
@Entity
@Table(name = "ges_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GesCliente.findAll", query = "SELECT g FROM GesCliente g"),
    @NamedQuery(name = "GesCliente.findByCliCod", query = "SELECT g FROM GesCliente g WHERE g.cliCod = :cliCod"),
    @NamedQuery(name = "GesCliente.findByCliNumero", query = "SELECT g FROM GesCliente g WHERE g.cliNumero = :cliNumero")})
public class GesCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLI_COD")
    private Integer cliCod;
    @Column(name = "CLI_NUMERO")
    private Integer cliNumero;
    @OneToMany(mappedBy = "cliCod")
    private List<GesPagamento> gesPagamentoList;
    @JoinColumn(name = "CLI_PES_COD", referencedColumnName = "PES_COD")
    @ManyToOne
    private GesPessoa cliPesCod;
    @JoinColumn(name = "CLI_ALU_COD", referencedColumnName = "ALU_COD")
    @ManyToOne
    private GesAluno cliAluCod;

    public GesCliente() {
    }

    public GesCliente(Integer cliCod) {
        this.cliCod = cliCod;
    }

    public Integer getCliCod() {
        return cliCod;
    }

    public void setCliCod(Integer cliCod) {
        this.cliCod = cliCod;
    }

    public Integer getCliNumero() {
        return cliNumero;
    }

    public void setCliNumero(Integer cliNumero) {
        this.cliNumero = cliNumero;
    }

    @XmlTransient
    public List<GesPagamento> getGesPagamentoList() {
        return gesPagamentoList;
    }

    public void setGesPagamentoList(List<GesPagamento> gesPagamentoList) {
        this.gesPagamentoList = gesPagamentoList;
    }

    public GesPessoa getCliPesCod() {
        return cliPesCod;
    }

    public void setCliPesCod(GesPessoa cliPesCod) {
        this.cliPesCod = cliPesCod;
    }

    public GesAluno getCliAluCod() {
        return cliAluCod;
    }

    public void setCliAluCod(GesAluno cliAluCod) {
        this.cliAluCod = cliAluCod;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.cliCod);
        hash = 53 * hash + Objects.hashCode(this.cliNumero);
        hash = 53 * hash + Objects.hashCode(this.gesPagamentoList);
        hash = 53 * hash + Objects.hashCode(this.cliPesCod);
        hash = 53 * hash + Objects.hashCode(this.cliAluCod);
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
        final GesCliente other = (GesCliente) obj;
        if (!Objects.equals(this.cliCod, other.cliCod)) {
            return false;
        }
        if (!Objects.equals(this.cliNumero, other.cliNumero)) {
            return false;
        }
        if (!Objects.equals(this.gesPagamentoList, other.gesPagamentoList)) {
            return false;
        }
        if (!Objects.equals(this.cliPesCod, other.cliPesCod)) {
            return false;
        }
        if (!Objects.equals(this.cliAluCod, other.cliAluCod)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ba.poow.gestaoescolar.mapeamento.GesCliente[ cliCod=" + cliCod + " ]";
    }
    
}
