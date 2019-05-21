
package br.senac.tads.dsw.tarefas.controller;

import br.senac.tads.dsw.tarefas.entidade.Tarefa;
import br.senac.tads.dsw.tarefas.repository.TarefaRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
    
    @Autowired
    private TarefaRepository tarefaRepository;
    
    
    @PostMapping("**/concluido")
    public ModelAndView concluido(Tarefa tarefa) {
        
        if (tarefa.getId() != null) {
            tarefa.setDataInicioReal(LocalDateTime.now());
            tarefa.setStatus(2);
        }
        
        tarefaRepository.save(tarefa);
        
        return new ModelAndView("redirect:/index");
    }
    
    
    
}
