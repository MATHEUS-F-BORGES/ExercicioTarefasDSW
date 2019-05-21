
package br.senac.tads.dsw.tarefas.controller;

import br.senac.tads.dsw.tarefas.entidade.Pessoa;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.senac.tads.dsw.tarefas.entidade.Tarefa;
import br.senac.tads.dsw.tarefas.repository.PessoaRepository;
import br.senac.tads.dsw.tarefas.repository.TarefaRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @GetMapping
    public ModelAndView lista() {
        List<Tarefa> tarefa = tarefaRepository.findAll();
        return new ModelAndView("/lista").addObject("tarefa", tarefa);
        
    }

    @GetMapping("/novo")
    public ModelAndView adicionarNovo() {   
        List<Pessoa> p = pessoaRepository.findAll();
        return new ModelAndView("/formulario").addObject("pessoa", p);
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute("tarefa")Tarefa tarefa, 
            RedirectAttributes ra) {
        
        if (tarefa.getId() == null) {
            tarefa.setDataUltimaAlteracao(LocalDateTime.now());
        }
        tarefaRepository.save(tarefa);
        ra.addFlashAttribute("mensagemSucesso",
         "A tarefa  " + tarefa.getNome() + " foi salva com sucesso");
        return new ModelAndView("redirect:/tarefas");
    }

   
    
    @GetMapping("/{id}/editar")
    public ModelAndView editar(
        @PathVariable(name = "id") Integer id) {
        Optional<Tarefa> optional = tarefaRepository.findById(id);
        Tarefa tarefa = optional.get();
        return new ModelAndView("/formulario").addObject("tarefa", tarefa);
    }
    
 
    
//     @RequestMapping(value = "/tarefa/concluir", method = RequestMethod.POST)
//        public ModelAndView concluirTarefa(@RequestParam("nota") int nota,
//            Tarefa tarefa) {
//
//                Optional<Tarefa> t = tarefaRepository.findById(tarefa.getId());
//               tarefa = t.get();
//                tarefa.setStatus(2);
//               tarefa.setNota(nota);
//                tarefa.setDataUltimaAlteracao(tarefa.getLocalDateTime());
//                tarefa.setDataTerminoReal(tarefa.getLocalDateTime());
//        tarefaRepository.save(tarefa);
//        ModelAndView modelAndView = new ModelAndView("redirect:/index");
//        return modelAndView;
//    }
    
//    @RequestMapping(value = "tarefa/iniciar", method = RequestMethod.POST)
//      public ModelAndView iniciarTarefa(@RequestParam("id") int id){
//        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
//        Tarefa t = new Tarefa();
//        t = tarefa.get();
//        t.setStatus(1);
//        t.setDataUltimaAlteracao(t.getLocalDateTime());
//        t.setDataInicioReal(t.getLocalDateTime());
//        tarefaRepository.save(t);
//        ModelAndView modelAndView = new ModelAndView("redirect:/index");
//        return modelAndView;
//
//    }
    
    
    
}
