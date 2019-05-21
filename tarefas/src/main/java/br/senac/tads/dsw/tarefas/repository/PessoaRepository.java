
package br.senac.tads.dsw.tarefas.repository;

import br.senac.tads.dsw.tarefas.entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    
}
