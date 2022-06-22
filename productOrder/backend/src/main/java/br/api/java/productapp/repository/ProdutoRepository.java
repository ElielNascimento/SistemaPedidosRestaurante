package br.api.java.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.api.java.productapp.dto.ProdutoDTO;
import br.api.java.productapp.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	//ORDERNAR DO MAIOR PARA O MENOR VALOR
	public List<Produto> findAllByOrderByPrecoDesc();

}
