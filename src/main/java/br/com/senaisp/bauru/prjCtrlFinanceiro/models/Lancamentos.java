package br.com.senaisp.bauru.prjCtrlFinanceiro.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lancamentos")
public class Lancamentos {
	// Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(nullable = false, precision = 12, scale = 2)
    private Double valor;

    @Column(name = "data_lancamento", nullable = false)
    private LocalDate dataLancamento;

    @Column(length = 500)
    private String observacao;

    // Relacionamento com Categoria (referente a categoria_id)
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // Se preferir apenas o ID do usuário ou mapear a entidade Usuario posteriormente:
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    // Constructors
    public Lancamentos() {}

    public Lancamentos(String descricao, Double valor, LocalDate dataLancamento, String observacao, Categoria categoria, Long usuarioId) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataLancamento = dataLancamento;
        this.observacao = observacao;
        this.categoria = categoria;
        this.usuarioId = usuarioId;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}