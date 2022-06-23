INSERT INTO tbl_produto(produto_nome, produto_preco, produto_descricao) VALUES 
('Pizza Bacon', 50.0, 'Pizza de bacon com mussarela, orégano, molho especial e tempero da casa.');

INSERT INTO tbl_produto(produto_nome, produto_preco, produto_descricao) VALUES 
('Pizza Portuguesa ', 70.0, 'Pizza Portuguesa com molho especial, mussarela, presunto, ovos e especiarias.');


INSERT INTO tbl_produto(produto_nome, produto_preco, produto_descricao) VALUES 
('Promocao do dia', 29.0, 'Pizza da Casa com mussarela, orégano, bacon, ovo, molho especial e tempero da casa.');


INSERT INTO tbl_produto(produto_nome, produto_preco, produto_descricao) VALUES 
('Pizza Frango', 49.0, 'Pizza frango, com mussarela, orégano, molho especial e tempero da casa.');



INSERT INTO tbl_pedido(pedido_endereco, pedido_moment, pedido_status) VALUES
('Av Cuiaba 1818', TIMESTAMP WITH TIME ZONE '2022-01-01T22:00:00Z', 'PENDENTE');

INSERT INTO tbl_pedido(pedido_endereco, pedido_moment, pedido_status) VALUES
('Av Maringa 817', TIMESTAMP WITH TIME ZONE '2022-01-01T16:00:00Z', 'PENDENTE');

INSERT INTO tbl_pedido(pedido_endereco, pedido_moment, pedido_status) VALUES
('Rua das Violetas 718', TIMESTAMP WITH TIME ZONE '2022-01-01T18:00:00Z', 'PENDENTE');

INSERT INTO tbl_pedido(pedido_endereco, pedido_moment, pedido_status) VALUES
('Av Tamandare 1456', TIMESTAMP WITH TIME ZONE '2022-01-01T10:00:00Z', 'PENDENTE');


INSERT INTO tbl_pedido_produto (pedido_id, produto_id)
VALUES (1, 2);

INSERT INTO tbl_pedido_produto (pedido_id, produto_id)
VALUES (1, 1);

INSERT INTO tbl_pedido_produto (pedido_id, produto_id)
VALUES (2, 3);

INSERT INTO tbl_pedido_produto (pedido_id, produto_id)
VALUES (2, 1);


INSERT INTO tbl_pedido_produto (pedido_id, produto_id)
VALUES (2, 4);


INSERT INTO tbl_pedido_produto (pedido_id, produto_id)
VALUES (3, 2);





