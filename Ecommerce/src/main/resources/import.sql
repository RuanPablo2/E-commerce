#SEED DO BANCO

INSERT INTO tb_roles(id_role, NOME_ROLE) VALUES (1, 'ROLE_ADMIN');
INSERT INTO tb_roles(id_role, NOME_ROLE) VALUES (2, 'ROLE_CLIENTE');


INSERT INTO tb_PRODUTOS(id_produto, nome_produto,valor,descricao_tecnica) VALUES (1, 'celular LG',3000, 'meio capenga mas dá pro gasto');
INSERT INTO tb_PRODUTOS(id_produto, nome_produto,valor,descricao_tecnica) VALUES (2, 'Computador Positivo',10000.00, 'dá nem pra baixar o google');
INSERT INTO tb_PRODUTOS(id_produto, nome_produto,valor,descricao_tecnica) VALUES (3, 'geladeira que congela',2000.00, 'dá pra gelar a carne');
INSERT INTO tb_PRODUTOS(id_produto, nome_produto,valor,descricao_tecnica) VALUES (4, 'Caneca',20.00, 'dá pra tomar café');
INSERT INTO tb_PRODUTOS(id_produto, nome_produto,valor,descricao_tecnica) VALUES (5, 'placa de vídeo',2220.00, 'RTX 2060');
INSERT INTO tb_PRODUTOS(id_produto, nome_produto,valor,descricao_tecnica) VALUES (6, 'processador',1200.00, 'Ryzen 5 3600');
INSERT INTO tb_PRODUTOS(id_produto, nome_produto,valor,descricao_tecnica) VALUES (7, 'mouse',150.00, 'Redragon king cobra');
INSERT INTO tb_PRODUTOS(id_produto, nome_produto,valor,descricao_tecnica) VALUES (8, 'teclado',350.00, 'Gfallen falcão peregrino');
INSERT INTO tb_PRODUTOS(id_produto, nome_produto,valor,descricao_tecnica) VALUES (9, 'notebook',3000.00, 'Asus Nitro 5');


INSERT INTO tb_categorias(id_categoria, nome) VALUES (1, 'eletrodomésticos');
INSERT INTO tb_categorias(id_categoria, nome) VALUES (2, 'para casa');
INSERT INTO tb_categorias(id_categoria, nome) VALUES (3, 'celulares');
INSERT INTO tb_categorias(id_categoria, nome) VALUES (4, 'informática');

INSERT INTO tb_produtos_categorias(id_produto, id_categoria) VALUES (1, 3);
INSERT INTO tb_produtos_categorias(id_produto, id_categoria) VALUES (2, 4);
INSERT INTO tb_produtos_categorias(id_produto, id_categoria) VALUES (3, 1);
INSERT INTO tb_produtos_categorias(id_produto, id_categoria) VALUES (4, 2);
INSERT INTO tb_produtos_categorias(id_produto, id_categoria) VALUES (5, 4);
INSERT INTO tb_produtos_categorias(id_produto, id_categoria) VALUES (6, 4);
INSERT INTO tb_produtos_categorias(id_produto, id_categoria) VALUES (7, 4);
INSERT INTO tb_produtos_categorias(id_produto, id_categoria) VALUES (8, 4);
INSERT INTO tb_produtos_categorias(id_produto, id_categoria) VALUES (9, 4);


INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (1, 'https://criticalhits.com.br/wp-content/uploads/2021/07/jotaro_kujo3.jpeg', 1);
INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (2, 'https://sm.ign.com/ign_br/tv/o/one-piece-/one-piece-2_1xby.jpg', 2);
INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (3, 'https://sucodemanga.com.br/wp-content/uploads/2021/04/jojos-bizarre-adventure-image.jpg', 3);
INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (4, 'https://img.olhardigital.com.br/wp-content/uploads/2021/09/one-piece-scaled.jpg', 4);
INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (5, 'https://cdn.ome.lt/AGtMp6IIvx6K2iRVZTZ9xjY6rbg=/770x0/smart/uploads/conteudo/fotos/Jojos_Bizarre_Adventure.jpg', 4);
INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (6, 'https://cdn.ome.lt/AGtMp6IIvx6K2iRVZTZ9xjY6rbg=/770x0/smart/uploads/conteudo/fotos/Jojos_Bizarre_Adventure.jpg', 6);
INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (7, 'https://cdn.ome.lt/AGtMp6IIvx6K2iRVZTZ9xjY6rbg=/770x0/smart/uploads/conteudo/fotos/Jojos_Bizarre_Adventure.jpg', 7);
INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (8, 'https://cdn.ome.lt/AGtMp6IIvx6K2iRVZTZ9xjY6rbg=/770x0/smart/uploads/conteudo/fotos/Jojos_Bizarre_Adventure.jpg', 8);
INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (9, 'https://cdn.ome.lt/AGtMp6IIvx6K2iRVZTZ9xjY6rbg=/770x0/smart/uploads/conteudo/fotos/Jojos_Bizarre_Adventure.jpg', 9);

INSERT INTO tb_administradores(ID_USUARIO, EMAIL, NOME, PASSWORD) VALUES(1, 'adm1@gmail.com', 'admin1', '12345');
INSERT INTO tb_administradores(ID_USUARIO, EMAIL, NOME, PASSWORD) VALUES(2, 'adm2@gmail.com', 'admin2', '12345');
INSERT INTO tb_administradores(ID_USUARIO, EMAIL, NOME, PASSWORD) VALUES(3, 'adm3@gmail.com', 'admin3', '12345');
INSERT INTO tb_administradores(ID_USUARIO, EMAIL, NOME, PASSWORD) VALUES(4, 'adm4@gmail.com', 'admin4', '12345');

INSERT INTO tb_clientes(ID_USUARIO, EMAIL, NOME, PASSWORD, TELEFONE) VALUES (5, 'singed@gmail.com', 'Singed', '12345', '(11)91234-5678');
INSERT INTO tb_clientes(ID_USUARIO, EMAIL, NOME, PASSWORD, TELEFONE) VALUES (6, 'grongos@gmail.com', 'Gragas', '12345', '(11)92234-5678');
INSERT INTO tb_clientes(ID_USUARIO, EMAIL, NOME, PASSWORD, TELEFONE) VALUES (7, 'zedao@gmail.com', 'Zed', '12345', '(11)93234-5678');
INSERT INTO tb_clientes(ID_USUARIO, EMAIL, NOME, PASSWORD, TELEFONE) VALUES (8, 'tristana@gmail.com', 'Tristana', '12345', '(11)94234-5678');
INSERT INTO tb_clientes(ID_USUARIO, EMAIL, NOME, PASSWORD, TELEFONE) VALUES (9, 'caitlyn@gmail.com', 'caitlyn', '12345', '(11)95234-5678');
INSERT INTO tb_clientes(ID_USUARIO, EMAIL, NOME, PASSWORD, TELEFONE) VALUES (10, 'lux@gmail.com', 'Lux', '12345', '(11)96234-5678');

INSERT INTO tb_pessoa_fisica(CPF, ID_USUARIO) VALUES ('123.456.789-11', 5);
INSERT INTO tb_pessoa_fisica(CPF, ID_USUARIO) VALUES ('123.456.789-12', 6);
INSERT INTO tb_pessoa_fisica(CPF, ID_USUARIO) VALUES ('123.456.789-22', 7);

INSERT INTO tb_pessoa_juridica(RAZAO_SOCIAL, CNPJ, ID_USUARIO) VALUES ('empresa1','31.406.344/0001-29', 8);
INSERT INTO tb_pessoa_juridica(RAZAO_SOCIAL, CNPJ, ID_USUARIO) VALUES ('empresa2','77.343.787/0001-19', 9);
INSERT INTO tb_pessoa_juridica(RAZAO_SOCIAL, CNPJ, ID_USUARIO) VALUES ('empresa3','00.162.796/0001-89', 10);

INSERT INTO tb_usuarios_roles(ID_USUARIO, ID_ROLE) VALUES(1, 1);
INSERT INTO tb_usuarios_roles(ID_USUARIO, ID_ROLE) VALUES(2, 1);
INSERT INTO tb_usuarios_roles(ID_USUARIO, ID_ROLE) VALUES(3, 1);
INSERT INTO tb_usuarios_roles(ID_USUARIO, ID_ROLE) VALUES(4, 1);
INSERT INTO tb_usuarios_roles(ID_USUARIO, ID_ROLE) VALUES(5, 2);
INSERT INTO tb_usuarios_roles(ID_USUARIO, ID_ROLE) VALUES(6, 2);
INSERT INTO tb_usuarios_roles(ID_USUARIO, ID_ROLE) VALUES(7, 2);
INSERT INTO tb_usuarios_roles(ID_USUARIO, ID_ROLE) VALUES(8, 2);
INSERT INTO tb_usuarios_roles(ID_USUARIO, ID_ROLE) VALUES(9, 2);
INSERT INTO tb_usuarios_roles(ID_USUARIO, ID_ROLE) VALUES(10, 2);