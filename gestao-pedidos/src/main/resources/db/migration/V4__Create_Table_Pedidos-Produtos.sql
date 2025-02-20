CREATE TABLE `pedidos_produtos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pedido_id` bigint NOT NULL,
  `produto_id` bigint NOT NULL,
  `quantidade` int NOT NULL,
  `subtotal` decimal(38,2) NOT NULL,

  PRIMARY KEY (`id`),
  KEY `FKmcyhbdaci37l7s9skm41bldr1` (`pedido_id`),
  KEY `FK24dyao58qmif7bgoeq50jqdgx` (`produto_id`),
  CONSTRAINT `FK24dyao58qmif7bgoeq50jqdgx` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`id`),
  CONSTRAINT `FKmcyhbdaci37l7s9skm41bldr1` FOREIGN KEY (`pedido_id`) REFERENCES `pedidos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


