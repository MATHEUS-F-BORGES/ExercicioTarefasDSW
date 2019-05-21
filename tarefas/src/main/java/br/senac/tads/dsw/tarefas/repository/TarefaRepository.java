
package br.senac.tads.dsw.tarefas.repository;

import br.senac.tads.dsw.tarefas.entidade.Tarefa;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    //List<Produto> findByName(String name);

    public Optional<Tarefa> findById(Long id);
}
