-- Inserindo produtos para a categoria 'Teclados'
INSERT INTO public.produto (id, quantidade_disponivel, descricao, nome, preco, categoria_id)
VALUES
    (nextval('produto_seq'), 10, 'Teclado mecânico com iluminação RGB', 'Teclado Mecânico 1', 99.99, (SELECT id FROM categoria WHERE nome = 'Teclados')),
    (nextval('produto_seq'), 15, 'Teclado compacto sem fio', 'Teclado Compacto Sem Fio 1', 79.99, (SELECT id FROM categoria WHERE nome = 'Teclados')),
    (nextval('produto_seq'), 20, 'Teclado gamer com retroiluminação e teclas personalizáveis', 'Teclado Gamer 1', 129.99, (SELECT id FROM categoria WHERE nome = 'Teclados')),
    (nextval('produto_seq'), 25, 'Teclado mecânico com apoio para pulso', 'Teclado Ergonômico 1', 109.99, (SELECT id FROM categoria WHERE nome = 'Teclados')),
    (nextval('produto_seq'), 18, 'Combo teclado e mouse sem fio', 'Combo Sem Fio 1', 69.99, (SELECT id FROM categoria WHERE nome = 'Teclados'));

-- Inserindo produtos para a categoria 'Monitores'
INSERT INTO public.produto (id, quantidade_disponivel, descricao, nome, preco, categoria_id)
VALUES
    (nextval('produto_seq'), 30, 'Monitor IPS de 27 polegadas com resolução 4K', 'Monitor 4K 1', 399.99, (SELECT id FROM categoria WHERE nome = 'Monitores')),
    (nextval('produto_seq'), 25, 'Monitor gamer ultrawide com suporte a HDR', 'Monitor Gamer Ultrawide 1', 499.99, (SELECT id FROM categoria WHERE nome = 'Monitores')),
    (nextval('produto_seq'), 22, 'Monitor LED de 24 polegadas para escritório', 'Monitor Escritório 1', 179.99, (SELECT id FROM categoria WHERE nome = 'Monitores')),
    (nextval('produto_seq'), 28, 'Monitor curvo de 32 polegadas com AMD FreeSync', 'Monitor Curvo 1', 329.99, (SELECT id FROM categoria WHERE nome = 'Monitores')),
    (nextval('produto_seq'), 35, 'Monitor portátil USB-C para notebooks', 'Monitor Portátil 1', 249.99, (SELECT id FROM categoria WHERE nome = 'Monitores'));

-- Inserindo produtos para a categoria 'Telas'
INSERT INTO public.produto (id, quantidade_disponivel, descricao, nome, preco, categoria_id)
VALUES
    (nextval('produto_seq'), 15, 'Tela gamer OLED curva com taxa de atualização de 240Hz', 'Tela Gamer OLED Curva 1', 799.99, (SELECT id FROM categoria WHERE nome = 'Telas')),
    (nextval('produto_seq'), 18, 'Monitor QLED plano com resolução 1440p', 'Monitor QLED 1', 599.99, (SELECT id FROM categoria WHERE nome = 'Telas')),
    (nextval('produto_seq'), 22, 'Tela touch de 27 polegadas para trabalhos criativos', 'Tela Touch 1', 699.99, (SELECT id FROM categoria WHERE nome = 'Telas')),
    (nextval('produto_seq'), 20, 'Tela 4K HDR ultrafina para multimídia', 'Tela 4K HDR Ultrafina 1', 449.99, (SELECT id FROM categoria WHERE nome = 'Telas')),
    (nextval('produto_seq'), 25, 'Projetor gamer com baixo tempo de resposta', 'Projetor Gamer 1', 899.99, (SELECT id FROM categoria WHERE nome = 'Telas'));

-- Inserindo produtos para a categoria 'Mouses'
INSERT INTO public.produto (id, quantidade_disponivel, descricao, nome, preco, categoria_id)
VALUES
    (nextval('produto_seq'), 30, 'Mouse gamer sem fio com iluminação RGB personalizável', 'Mouse Gamer RGB 1', 59.99, (SELECT id FROM categoria WHERE nome = 'Mouses')),
    (nextval('produto_seq'), 28, 'Mouse com fio ergonômico para produtividade', 'Mouse Ergonômico com Fio 1', 29.99, (SELECT id FROM categoria WHERE nome = 'Mouses')),
    (nextval('produto_seq'), 32, 'Mouse gamer ambidestro com alta DPI', 'Mouse Gamer Ambidestro 1', 69.99, (SELECT id FROM categoria WHERE nome = 'Mouses')),
    (nextval('produto_seq'), 26, 'Mouse compacto para viagem', 'Mouse Compacto 1', 19.99, (SELECT id FROM categoria WHERE nome = 'Mouses')),
    (nextval('produto_seq'), 35, 'Mouse ergonômico vertical para reduzir esforço', 'Mouse Ergonômico Vertical 1', 39.99, (SELECT id FROM categoria WHERE nome = 'Mouses'));

-- Inserindo produtos para a categoria 'Acessórios'
INSERT INTO public.produto (id, quantidade_disponivel, descricao, nome, preco, categoria_id)
VALUES
    (nextval('produto_seq'), 25, 'Suporte ajustável para notebook com ventilação', 'Suporte Ajustável 1', 34.99, (SELECT id FROM categoria WHERE nome = 'Acessórios')),
    (nextval('produto_seq'), 20, 'Base de carregamento sem fio para smartphones', 'Carregador Sem Fio 1', 24.99, (SELECT id FROM categoria WHERE nome = 'Acessórios')),
    (nextval('produto_seq'), 28, 'Suporte para headset gamer com iluminação RGB', 'Suporte Headset RGB 1', 49.99, (SELECT id FROM categoria WHERE nome = 'Acessórios')),
    (nextval('produto_seq'), 22, 'Teclado mecânico Bluetooth para tablets', 'Teclado Bluetooth 1', 39.99, (SELECT id FROM categoria WHERE nome = 'Acessórios')),
    (nextval('produto_seq'), 30, 'Case para HD externo com USB-C', 'Case HD Externo 1', 29.99, (SELECT id FROM categoria WHERE nome = 'Acessórios'));
