
package br.ba.poow.gestaoescolar.util;

import br.ba.poow.gestaoescolar.DAO.AlunoDAO;
import br.ba.poow.gestaoescolar.listener.AlunoDAOListener;

public class FabricaDAO {
    public static AlunoDAOListener criarAlunoDAO(){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return alunoDAO;
    }
}
