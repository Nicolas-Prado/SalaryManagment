package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import vo.Tabela;
public class TabelaDAO {
 EntityManager em;
 public TabelaDAO() {
 em = EntityManagerProvider.getEM();
 }
 public void salva(Tabela p) {
 em.getTransaction().begin();
 if (p.getId() == 0) {
 em.persist(p);
 } else { em.merge(p);
 }
 em.getTransaction().commit();
 }
 
 public Tabela localiza(int id) {
 Tabela p = em.find(Tabela.class, id);
 return p;
 }
 public void exclui(Tabela p) {
 em.getTransaction().begin();
 em.remove(p);
 em.getTransaction().commit();
 }
 public List<Tabela> pesquisa() {
 Query q = em.createQuery("select p from Tabela p order by p.matricula");
 List<Tabela> lista = q.getResultList();
 return lista;
 }
} 
