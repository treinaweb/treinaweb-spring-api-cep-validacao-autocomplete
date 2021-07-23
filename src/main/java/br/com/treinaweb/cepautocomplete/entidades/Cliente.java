package br.com.treinaweb.cepautocomplete.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 255)
    private String nome;

    @Column(nullable = false, unique = true)
    @NotNull
    @Size(min = 3, max = 255)
    private String email;

    @Column(nullable = false)
    @NotNull
    @Size(min = 9, max = 9)
    private String cep;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 255)
    private String logradouro;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 255)
    private String bairro;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 255)
    private String cidade;

    @Column(nullable = false)
    @NotNull
    @Size(min = 2, max = 2)
    private String estado;

}
