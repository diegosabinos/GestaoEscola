/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poow.gestaoescolar.DAO;

import br.ba.poow.gestaoescolar.listener.AlunoDAOListener;
import org.hibernate.Session;

/**
 *
 * @author Diego Sabino
 */
public class AlunoDAO implements AlunoDAOListener {
    private Session sessao;


    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
}
