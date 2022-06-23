package br.api.java.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.api.java.productapp.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findAllByOrderByPrecoDesc();
	
	@Query(value = "select u from Produto u where u.nome like %?1%")
	public List<Produto> findByNome(String nome);

}
