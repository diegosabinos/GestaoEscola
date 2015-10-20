/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poow.gestaoescolar.mapeamento;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
        int hash = 0;
        hash += (cliCod != null ? cliCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GesCliente)) {
            return false;
        }
        GesCliente other = (GesCliente) object;
        if ((this.cliCod == null && other.cliCod != null) || (this.cliCod != null && !this.cliCod.equals(other.cliCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ba.poow.gestaoescolar.mapeamento.GesCliente[ cliCod=" + cliCod + " ]";
    }
    
}
