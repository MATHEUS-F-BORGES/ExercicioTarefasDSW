
package br.senac.tads.dsw.tarefas.entidade;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "TAREFA")
public class Tarefa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 1000)
    private String descricao;
    
    // Status pode ser:
    // 0 - Não iniciado
    // 1 - Em andamento
    // 2 - Concluido
    private int status = 0;

    @Column(nullable = false)
    private String dataInicioPrevisto;

    @Column(nullable = false)
    private String dataTerminoPrevisto;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    // Configurada quando o status passar de 0 para 1.
    private LocalDateTime dataInicioReal;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    // Configurada quando o status passar de 1 para 2 (Conclusão da tarefa)
    private String dataTerminoReal;

    // Nota pode ser valor de 1 a 5
    private int nota;

    @Column(nullable = false)
    private LocalDateTime dataUltimaAlteracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private Pessoa responsavel;

    public Tarefa() {
    }

    public Tarefa(int id, String nome, String descricao, String dataInicioPrevisto, String dataTerminoPrevisto, Pessoa responsavel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicioPrevisto = dataInicioPrevisto;
        this.dataTerminoPrevisto = dataTerminoPrevisto;
        this.responsavel = responsavel;   

    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDataInicioPrevisto() {
        return dataInicioPrevisto;
    }

    public void setDataInicioPrevisto(String dataInicioPrevisto) {
        this.dataInicioPrevisto = dataInicioPrevisto;
    }

    public String getDataTerminoPrevisto() {
        return dataTerminoPrevisto;
    }

    public void setDataTerminoPrevisto(String dataTerminoPrevisto) {
        this.dataTerminoPrevisto = dataTerminoPrevisto;
    }

    public LocalDateTime getDataInicioReal() {
        return dataInicioReal;
    }

    public void setDataInicioReal(LocalDateTime dataInicioReal) {
        this.dataInicioReal = dataInicioReal;
    }

    public String getDataTerminoReal() {
        return dataTerminoReal;
    }

    public void setDataTerminoReal(String dataTerminoReal) {
        this.dataTerminoReal = dataTerminoReal;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public LocalDateTime getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }
    
    @Override
    public String toString() {
        return "Tarefa{" + "id=" + id + 
                ", nome=" + nome +
                ", descricao=" + descricao + 
                ", dataInicioPrevisto=" + dataInicioPrevisto +
                ", dataTerminoPrevisto=" + dataTerminoPrevisto +
                ", responsavel=" + responsavel + '}';
    }
}
