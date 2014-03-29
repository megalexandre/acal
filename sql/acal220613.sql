-- MySQL dump 10.13  Distrib 5.5.28, for Win64 (x86)
--
-- Host: localhost    Database: acal
-- ------------------------------------------------------
-- Server version	5.5.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoriasocio`
--

DROP TABLE IF EXISTS `categoriasocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoriasocio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` text,
  `nome` varchar(255) NOT NULL,
  `taxasId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK271F6B9AA011B865` (`taxasId`),
  CONSTRAINT `FK271F6B9AA011B865` FOREIGN KEY (`taxasId`) REFERENCES `taxa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoriasocio`
--

LOCK TABLES `categoriasocio` WRITE;
/*!40000 ALTER TABLE `categoriasocio` DISABLE KEYS */;
INSERT INTO `categoriasocio` VALUES (1,'','Categoria fixa',1),(2,'','Teste',1);
/*!40000 ALTER TABLE `categoriasocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheque`
--

DROP TABLE IF EXISTS `cheque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataPagamento` datetime DEFAULT NULL,
  `dataVencimento` datetime NOT NULL,
  `numero` int(11) NOT NULL,
  `observacoes` text,
  `valor` decimal(19,2) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `idMotivoDespesa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAED8F221EE3FA458` (`idMotivoDespesa`),
  KEY `FKAED8F221E196A484` (`idFuncionario`),
  CONSTRAINT `FKAED8F221E196A484` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FKAED8F221EE3FA458` FOREIGN KEY (`idMotivoDespesa`) REFERENCES `motivodespesa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheque`
--

LOCK TABLES `cheque` WRITE;
/*!40000 ALTER TABLE `cheque` DISABLE KEYS */;
/*!40000 ALTER TABLE `cheque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chequeslog`
--

DROP TABLE IF EXISTS `chequeslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chequeslog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataAlteracao` datetime DEFAULT NULL,
  `dataPagamento` datetime DEFAULT NULL,
  `dataVencimento` datetime DEFAULT NULL,
  `idFuncionarioAlteracao` int(11) DEFAULT NULL,
  `idMotivoDepesa` int(11) DEFAULT NULL,
  `idOriginal` int(11) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `observacoes` text,
  `tipo` varchar(255) DEFAULT NULL,
  `usuariobanco` varchar(255) DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chequeslog`
--

LOCK TABLES `chequeslog` WRITE;
/*!40000 ALTER TABLE `chequeslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `chequeslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataGerada` datetime DEFAULT NULL,
  `dataPag` datetime DEFAULT NULL,
  `dataVence` datetime NOT NULL,
  `observacoes` text,
  `idEnderecoPessoa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5A7376F50A7B5D2` (`idEnderecoPessoa`),
  CONSTRAINT `FK5A7376F50A7B5D2` FOREIGN KEY (`idEnderecoPessoa`) REFERENCES `enderecopessoa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contaslog`
--

DROP TABLE IF EXISTS `contaslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contaslog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataPag` datetime DEFAULT NULL,
  `dataVence` datetime DEFAULT NULL,
  `horaRegristro` datetime DEFAULT NULL,
  `idNumeroSocio` int(11) DEFAULT NULL,
  `idOriginal` int(11) DEFAULT NULL,
  `observacoes` text,
  `taxaRelogio` decimal(19,2) DEFAULT NULL,
  `taxaSocio` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `usuarioAlteracao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contaslog`
--

LOCK TABLES `contaslog` WRITE;
/*!40000 ALTER TABLE `contaslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `contaslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contrato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `corpo` text,
  `descricao` text NOT NULL,
  `nome` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` text,
  `nome` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'','Maria Emília','TRAVESSA');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enderecopessoa`
--

DROP TABLE IF EXISTS `enderecopessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enderecopessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Numero` int(11) DEFAULT NULL,
  `idEndereco` int(11) NOT NULL,
  `idPessoa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK80ECBCB0E2CAEDC0` (`idPessoa`),
  KEY `FK80ECBCB0F1E3C984` (`idEndereco`),
  CONSTRAINT `FK80ECBCB0E2CAEDC0` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `FK80ECBCB0F1E3C984` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enderecopessoa`
--

LOCK TABLES `enderecopessoa` WRITE;
/*!40000 ALTER TABLE `enderecopessoa` DISABLE KEYS */;
INSERT INTO `enderecopessoa` VALUES (1,343,1,1);
/*!40000 ALTER TABLE `enderecopessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `observacao` text,
  `valor` decimal(19,2) NOT NULL,
  `idCedente` int(11) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `idMotivoEntrada` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA122665776E134DC` (`idMotivoEntrada`),
  KEY `FKA1226657FDA06717` (`idCedente`),
  KEY `FKA1226657E196A484` (`idFuncionario`),
  CONSTRAINT `FKA122665776E134DC` FOREIGN KEY (`idMotivoEntrada`) REFERENCES `motivoentrada` (`id`),
  CONSTRAINT `FKA1226657E196A484` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FKA1226657FDA06717` FOREIGN KEY (`idCedente`) REFERENCES `socio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entradaslog`
--

DROP TABLE IF EXISTS `entradaslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entradaslog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataAlteracao` datetime DEFAULT NULL,
  `dataOriginal` date DEFAULT NULL,
  `idCedente` int(11) DEFAULT NULL,
  `idFuncionario` int(11) DEFAULT NULL,
  `idMotivoEntrada` int(11) DEFAULT NULL,
  `idOriginal` int(11) DEFAULT NULL,
  `observacao` text,
  `tipo` varchar(255) DEFAULT NULL,
  `usuarioAlteracao` varchar(255) DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entradaslog`
--

LOCK TABLES `entradaslog` WRITE;
/*!40000 ALTER TABLE `entradaslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `entradaslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(255) NOT NULL,
  `dataContratacao` datetime NOT NULL,
  `matricula` int(11) NOT NULL,
  `observacao` text,
  `salario` decimal(19,2) NOT NULL,
  `idPessoa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idPessoa` (`idPessoa`),
  KEY `FK50401DDBE2CAEDC0` (`idPessoa`),
  CONSTRAINT `FK50401DDBE2CAEDC0` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'programador','2013-06-19 00:00:00',343,'',5000.00,1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hidrometro`
--

DROP TABLE IF EXISTS `hidrometro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hidrometro` (
  `idhidrometro` int(11) NOT NULL AUTO_INCREMENT,
  `Consumo` double DEFAULT NULL,
  `idconta` int(11) NOT NULL,
  PRIMARY KEY (`idhidrometro`),
  UNIQUE KEY `idconta` (`idconta`),
  KEY `FKF3FD0019D45F0A2C` (`idconta`),
  CONSTRAINT `FKF3FD0019D45F0A2C` FOREIGN KEY (`idconta`) REFERENCES `conta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hidrometro`
--

LOCK TABLES `hidrometro` WRITE;
/*!40000 ALTER TABLE `hidrometro` DISABLE KEYS */;
/*!40000 ALTER TABLE `hidrometro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivodespesa`
--

DROP TABLE IF EXISTS `motivodespesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motivodespesa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` text NOT NULL,
  `nome` varchar(255) NOT NULL,
  `observacao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivodespesa`
--

LOCK TABLES `motivodespesa` WRITE;
/*!40000 ALTER TABLE `motivodespesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `motivodespesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivoentrada`
--

DROP TABLE IF EXISTS `motivoentrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motivoentrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` text,
  `nome` varchar(255) NOT NULL,
  `observacao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivoentrada`
--

LOCK TABLES `motivoentrada` WRITE;
/*!40000 ALTER TABLE `motivoentrada` DISABLE KEYS */;
/*!40000 ALTER TABLE `motivoentrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apelido` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `dataNasc` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `nomeMae` varchar(255) DEFAULT NULL,
  `nomePai` varchar(255) DEFAULT NULL,
  `numeroEndereco` varchar(255) DEFAULT NULL,
  `numeroMatricula` int(11) DEFAULT NULL,
  `observacoes` text,
  `rgEmissao` date DEFAULT NULL,
  `rgExpedidor` varchar(255) DEFAULT NULL,
  `rgNumero` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `sobrenome` varchar(255) NOT NULL,
  `status` bit(1) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `idEndereco` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC4E40FA7F1E3C984` (`idEndereco`),
  CONSTRAINT `FKC4E40FA7F1E3C984` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'','','','','444.444.444-44',NULL,'','Alisson','','','343',NULL,NULL,NULL,'','','Masculino','Davis','','','BA',1);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saida`
--

DROP TABLE IF EXISTS `saida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `favorecido` varchar(255) NOT NULL,
  `observacao` text,
  `valor` decimal(19,2) NOT NULL,
  `idfuncionario` int(11) NOT NULL,
  `idmotivosaida` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6823D98A2D1CD1B` (`idmotivosaida`),
  KEY `FK6823D98E196A484` (`idfuncionario`),
  CONSTRAINT `FK6823D98A2D1CD1B` FOREIGN KEY (`idmotivosaida`) REFERENCES `motivodespesa` (`id`),
  CONSTRAINT `FK6823D98E196A484` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saida`
--

LOCK TABLES `saida` WRITE;
/*!40000 ALTER TABLE `saida` DISABLE KEYS */;
/*!40000 ALTER TABLE `saida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saidaslog`
--

DROP TABLE IF EXISTS `saidaslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saidaslog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataalteracao` datetime DEFAULT NULL,
  `dataoriginal` date DEFAULT NULL,
  `favorecido` varchar(255) DEFAULT NULL,
  `idFuncionarioAltercao` int(11) DEFAULT NULL,
  `idfuncionario` int(11) DEFAULT NULL,
  `idmotivosaida` int(11) DEFAULT NULL,
  `idoriginal` int(11) DEFAULT NULL,
  `observacao` text,
  `tipo` varchar(255) DEFAULT NULL,
  `usuarioAlteracao` varchar(255) DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saidaslog`
--

LOCK TABLES `saidaslog` WRITE;
/*!40000 ALTER TABLE `saidaslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `saidaslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataAprovacao` datetime DEFAULT NULL,
  `dataMatricula` datetime NOT NULL,
  `dataVence` date DEFAULT NULL,
  `numeroSocio` int(11) NOT NULL,
  `observacao` text,
  `idCategoriaSocio` int(11) NOT NULL,
  `idPessoa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idPessoa` (`idPessoa`),
  KEY `FK68884ED9D0D13A6` (`idCategoriaSocio`),
  KEY `FK68884EDE2CAEDC0` (`idPessoa`),
  CONSTRAINT `FK68884ED9D0D13A6` FOREIGN KEY (`idCategoriaSocio`) REFERENCES `categoriasocio` (`id`),
  CONSTRAINT `FK68884EDE2CAEDC0` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES (1,'2013-06-21 23:18:48','2013-06-21 00:00:00','2014-06-21',545,NULL,1,1);
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxa`
--

DROP TABLE IF EXISTS `taxa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `observacao` text,
  `valor` decimal(19,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxa`
--

LOCK TABLES `taxa` WRITE;
/*!40000 ALTER TABLE `taxa` DISABLE KEYS */;
INSERT INTO `taxa` VALUES (1,'',' Fixa',NULL,20.00);
/*!40000 ALTER TABLE `taxa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxasconta`
--

DROP TABLE IF EXISTS `taxasconta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxasconta` (
  `idtaxasConta` int(11) NOT NULL AUTO_INCREMENT,
  `contaid` int(11) NOT NULL,
  `taxaid` int(11) NOT NULL,
  PRIMARY KEY (`idtaxasConta`),
  KEY `FK65E35472AA5C0BC2` (`contaid`),
  KEY `FK65E35472C6F1071E` (`taxaid`),
  CONSTRAINT `FK65E35472AA5C0BC2` FOREIGN KEY (`contaid`) REFERENCES `conta` (`id`),
  CONSTRAINT `FK65E35472C6F1071E` FOREIGN KEY (`taxaid`) REFERENCES `taxa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxasconta`
--

LOCK TABLES `taxasconta` WRITE;
/*!40000 ALTER TABLE `taxasconta` DISABLE KEYS */;
/*!40000 ALTER TABLE `taxasconta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-22 10:14:53
