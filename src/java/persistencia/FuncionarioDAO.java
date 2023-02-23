package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Funcionario;

public class FuncionarioDAO {

    EntityManager em;

    public FuncionarioDAO() {
        em = EntityManagerProvider.getEM();
    }

    public void salva(Funcionario p) {
        em.getTransaction().begin();
        if (p.getMatricula() == 0) {
            em.persist(p);
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
    }

    public Funcionario localiza(int id) {
        Funcionario p = em.find(Funcionario.class, id);
        return p;
    }

    public void exclui(Funcionario p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public List<Funcionario> pesquisa() {
        Query q = em.createQuery("select p from Funcionario p order by p.matricula");
        List<Funcionario> lista = q.getResultList();
        return lista;
    }
}
