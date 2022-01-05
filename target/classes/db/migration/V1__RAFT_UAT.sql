CREATE DATABASE  IF NOT EXISTS `raft_uat` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `raft_uat`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: raft_uat
-- ------------------------------------------------------
-- Server version	5.7.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `configuration`
--

DROP TABLE IF EXISTS `configuration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `configuration` (
  `ConfigurationKey` varchar(200) CHARACTER SET utf8mb4 NOT NULL,
  `ConfigurationValue` longtext CHARACTER SET utf8mb4,
  PRIMARY KEY (`ConfigurationKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuration`
--

LOCK TABLES `configuration` WRITE;
/*!40000 ALTER TABLE `configuration` DISABLE KEYS */;
INSERT INTO `configuration` VALUES ('Log4netXML','<log4net>\r\n<appender name=\"AdoNetAppender_SqlServer\" type=\"log4net.Appender.AdoNetAppender\">\r\n<bufferSize value=\"1\" />\r\n<connectionType value=\"System.Data.SqlClient.SqlConnection, System.Data, Version=1.0.3300.0, Culture=neutral, PublicKeyToken=b77a5c561934e089\"/>\r\n<connectionString value=\"<connectionstring>\"/>\r\n<commandText value=\"INSERT INTO Log ([Username],[ModuleName],[MethodName],[LineNumber],[LevelName],[Message],[Exception],[LoggedDate]) VALUES (@log_username, @logger,@method,@line, @log_level, @message,@exception,@log_date)\"/>\r\n<parameter>\r\n<parameterName value=\"@log_username\"/>\r\n<dbType value=\"String\"/>\r\n<size value=\"255\"/>\r\n<layout type=\"log4net.Layout.PatternLayout\" value=\"%username\"/>\r\n</parameter>\r\n<parameter>\r\n<parameterName value=\"@logger\"/>\r\n<dbType value=\"String\"/>\r\n<size value=\"255\"/>\r\n<layout type=\"log4net.Layout.PatternLayout\" value=\"%logger\"/>\r\n</parameter>\r\n<parameter>\r\n<parameterName value=\"@method\"/>\r\n<dbType value=\"String\"/>\r\n<size value=\"255\"/>\r\n<layout type=\"log4net.Layout.PatternLayout\" value=\"%method\"/>\r\n</parameter>\r\n<parameter>\r\n<parameterName value=\"@line\"/>\r\n<dbType value=\"String\"/>\r\n<size value=\"255\"/>\r\n<layout type=\"log4net.Layout.PatternLayout\" value=\"%line\"/>\r\n</parameter>\r\n<parameter>\r\n<parameterName value=\"@log_level\"/>\r\n<dbType value=\"String\"/>\r\n<size value=\"50\"/>\r\n<layout type=\"log4net.Layout.PatternLayout\" value=\"%level\"/>\r\n</parameter>\r\n<parameter>\r\n<parameterName value=\"@message\"/>\r\n<dbType value=\"String\"/>\r\n<size value=\"4000\"/>\r\n<layout type=\"log4net.Layout.PatternLayout\" value=\"%message\"/>\r\n</parameter>\r\n<parameter>\r\n<parameterName value=\"@exception\"/>\r\n<dbType value=\"String\"/>\r\n<size value=\"4000\"/>\r\n<layout type=\"log4net.Layout.PatternLayout\">\r\n<conversionPattern value=\"%exception\" />\r\n</layout>\r\n</parameter>\r\n<parameter>\r\n<parameterName value=\"@log_date\"/>\r\n<dbType value=\"DateTime\"/>\r\n<layout type=\"log4net.Layout.PatternLayout\" value=\"%date{yyyy\'-\'MM\'-\'dd HH\':\'mm\':\'ss\'.\'fff}\"/>\r\n</parameter>\r\n<filter type=\"log4net.Filter.LevelRangeFilter\">\r\n<levelMin value=\"Debug\"/>\r\n<levelMax value=\"ERROR\"/>\r\n\r\n</filter>\r\n\r\n</appender>\r\n<root>\r\n<level value=\"All\"/>\r\n<appender-ref ref=\"AdoNetAppender_SqlServer\"/>\r\n</root>\r\n</log4net>');
/*!40000 ALTER TABLE `configuration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fulltextrequestinfo`
--

DROP TABLE IF EXISTS `fulltextrequestinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fulltextrequestinfo` (
  `PMID` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `JournalTitle` longtext CHARACTER SET utf8mb4,
  `Title` longtext CHARACTER SET utf8mb4,
  `Citation` longtext CHARACTER SET utf8mb4,
  `Instructions` longtext CHARACTER SET utf8mb4,
  `Priority` char(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `CreationDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `RequestedBy` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `RequestID` int(11) NOT NULL,
  `NESID` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `Status` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `FTRetrievedFrom` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `FulltextURL` longtext CHARACTER SET utf8mb4,
  `FulltextFile` longtext CHARACTER SET utf8mb4,
  `SupplementMaterial` longtext CHARACTER SET utf8mb4,
  `Notes` longtext CHARACTER SET utf8mb4,
  `IsReviewed` tinyint(1) DEFAULT NULL,
  `ReviewedBy` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `ReviewedOn` datetime(6) DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  `DeletedOn` datetime(6) DEFAULT NULL,
  `DeletedBy` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `DeleteRequestFrom` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `IsRequested` tinyint(1) DEFAULT NULL,
  `PurchaseorSubscriptionType` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `Cost` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `AutoRenewalURL` longtext CHARACTER SET utf8mb4,
  `AutoRenewal` tinyint(1) DEFAULT '0',
  `PubMedFTURL` longtext CHARACTER SET utf8mb4,
  `EhostFTLink` longtext CHARACTER SET utf8mb4,
  `isslamrecord` tinyint(1) DEFAULT '0',
  `costcenter` varchar(50) CHARACTER SET utf8mb4 DEFAULT '',
  `Reopened` tinyint(1) DEFAULT '0',
  `FirstCreationDate` datetime(6) DEFAULT NULL,
  `FirstRequestedBy` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `FirstReviewedOn` datetime(6) DEFAULT NULL,
  `FirstReviewedBy` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `apiRequest` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`RequestID`),
  KEY `Idx-PMID` (`PMID`),
  KEY `idx_slam` (`isslamrecord`,`PMID`),
  KEY `idx_createdDate` (`CreationDate`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fulltextrequestinfo`
--

LOCK TABLES `fulltextrequestinfo` WRITE;
/*!40000 ALTER TABLE `fulltextrequestinfo` DISABLE KEYS */;
INSERT INTO `fulltextrequestinfo` VALUES ('12975657','PLoS biology','From gene trees to organismal phylogeny in prokaryotes: the case of the gamma-Proteobacteria','PLoS Biol. 2003 Oct;1(1):E19. doi: 10.1371/journal.pbio.0000019.','Free article, please download and attach PDF','Normal','2020-08-18 02:28:10','admin',1,'202008181','Fulfilled','PDF Viewer','','','','',1,'admin','2020-08-19 07:32:34.827000',NULL,NULL,NULL,NULL,1,'Single Article Purchase','','',0,'','http://search.ebscohost.com/login.aspx?authtype=uid&user=dmeditors&password=medicine19!&direct=true&db=mdc&AN=12975657&site=ehost-live',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('12975658','PLoS biology','Drosophila free-running rhythms require intercellular communication','PLoS Biol. 2003 Oct;1(1):E13. doi: 10.1371/journal.pbio.0000013.','Free article, please download and attach PDF','Normal','2020-08-25 00:02:44','admin',2,'202008252','In Progress','PDF Viewer','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','http://search.ebscohost.com/login.aspx?authtype=uid&user=dmeditors&password=medicine19!&direct=true&db=mdc&AN=12975658&site=ehost-live',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('12359809','Pediatrics','Heliox therapy;\"Pediatrics. 2002 Jan;109(1):68-73\"','Pediatrics. 2002 Oct;110(4):847-8; author reply 847-8. doi: 10.1542/peds.110.4.847.','','Normal','2020-10-27 03:15:58','admin',4,'202010274','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('1242','East African medical journal','Report on the occurrence and habitat of mosquitoes in two locations in Machakos District, Kenya','East Afr Med J. 1975 Oct;52(10):589-95. ','','Normal','2020-11-08 21:28:50','admin',30,'2020110930','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('30631041','Cell death &amp; disease','Gene expression, proteome and calcium signaling alterations in immortalized hippocampal astrocytes from an Alzheimer&#39;s disease mouse model;\"Cell Death Dis. 2020 Apr 16;11(4):236\"','Cell Death Dis. 2019 Jan 10;10(1):24. doi: 10.1038/s41419-018-1264-8.','Free article, please download and attach PDF','Normal','2020-11-09 00:24:30','admin',52,'2020110952','In Progress','PubMed','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6328590/pdf/41419_2018_Article_1264.pdf','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('15182824','Critical reviews in oncology/hematology','Targeting non-small cell lung cancer with epidermal growth factor tyrosine kinase inhibitors: where do we stand, where do we go','Crit Rev Oncol Hematol. 2004 Jun;50(3):175-86. doi: 10.1016/j.critrevonc.2004.02.004.','','Normal','2020-11-09 00:24:37','admin',53,'2020110953','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('15182826','Critical reviews in oncology/hematology','Adult acute myeloid leukaemia','Crit Rev Oncol Hematol. 2004 Jun;50(3):197-222. doi: 10.1016/j.critrevonc.2003.11.002.','','Normal','2020-11-09 00:24:43','admin',54,'2020110954','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('24018540','CNS drugs','Extended-release intramuscular naltrexone (VIVITROLÂ®): a review of its use in the prevention of relapse to opioid dependence in detoxified patients','CNS Drugs. 2013 Oct;27(10):851-61. doi: 10.1007/s40263-013-0110-x.','','Normal','2020-11-09 00:24:49','admin',55,'2020110955','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('27285345','The Journal of sports medicine and physical fitness','A randomized controlled trial on the effects of combined aerobic-resistance exercise on muscle strength and fatigue, glycemic control and health-related quality of life of type 2 diabetes patients','J Sports Med Phys Fitness. 2016 May;56(5):572-8. ','','Normal','2020-11-09 00:24:53','admin',56,'2020110956','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('27607444','Current opinion in hematology','Whole blood: back to the future','Curr Opin Hematol. 2016 Nov;23(6):536-542. doi: 10.1097/MOH.0000000000000284.','','Normal','2020-11-09 00:25:01','admin',57,'2020110957','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('28640324','Thrombosis and haemostasis','New paradigms in venous thromboprophylaxis of medically ill patients','Thromb Haemost. 2017 Aug 30;117(9):1662-1670. doi: 10.1160/TH17-03-0168.','','Normal','2020-11-09 00:25:06','admin',58,'2020110958','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('24568146','Journal of gerontological nursing','The health of grandparents raising grandchildren: a literature review','J Gerontol Nurs. 2014 Apr;40(4):32-42; quiz 44-5. doi: 10.3928/00989134-20140219-01.','','Normal','2020-11-09 00:25:12','admin',59,'2020110959','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('28379927','Current opinion in pediatrics','Grandparents raising grandchildren: a primer for pediatricians','Curr Opin Pediatr. 2017 Jun;29(3):379-384. doi: 10.1097/MOP.0000000000000501.','','Normal','2020-11-09 00:25:19','admin',60,'2020110960','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('30188305','Creative nursing','Neonatal Abstinence Syndrome: The Experience of Infant Massage','Creat Nurs. 2016 Feb 1;22(1):45-50. doi: 10.1891/1078-4535.22.1.45.','','Normal','2020-11-09 00:25:24','admin',61,'2020110961','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('29032757','Current drug discovery technologies','An Evidence-based Review of Medicinal Herbs for the Treatment of Gastroesophageal Reflux Disease (GERD)','Curr Drug Discov Technol. 2018;15(4):305-314. doi: 10.2174/1570163814666171010113517.','','Normal','2020-11-09 00:25:31','admin',62,'2020110962','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('26729037','Nature reviews. Endocrinology','The role of the intestinal microbiota in type 1 diabetes mellitus','Nat Rev Endocrinol. 2016 Mar;12(3):154-67. doi: 10.1038/nrendo.2015.218.','','Normal','2020-11-09 00:25:38','admin',63,'2020110963','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('21887732','Inflammatory bowel diseases','Double-blind, placebo-controlled trial of oral tacrolimus (FK506) in the management of hospitalized patients with steroid-refractory ulcerative colitis;\"Inflamm Bowel Dis. 2012 May;18(5):809-11\"','Inflamm Bowel Dis. 2012 May;18(5):803-8. doi: 10.1002/ibd.21853.','','Normal','2020-11-09 00:25:46','admin',64,'2020110964','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('25010665','Annals of surgery','Recurrence of hepatocellular cancer after resection: patterns, treatments, and prognosis;\"Chirurg. 2015 Sep;86(9):899\"','Ann Surg. 2015 May;261(5):947-55. doi: 10.1097/SLA.0000000000000710.','','Normal','2020-11-09 00:25:51','admin',65,'2020110965','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('27490614','Pediatric critical care medicine : a journal of the Society of Critical Care Medicine and the World Federation of Pediatric Intensive and Critical Care Societies','Shunt Lesions Part I: Patent Ductus Arteriosus, Atrial Septal Defect, Ventricular Septal Defect, and Atrioventricular Septal Defect','Pediatr Crit Care Med. 2016 Aug;17(8 Suppl 1):S302-9. doi: 10.1097/PCC.0000000000000786.','','Normal','2020-11-09 00:25:57','admin',66,'2020110966','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('29936548','Current treatment options in neurology','Management of Subdural Hematomas: Part I. Medical Management of Subdural Hematomas','Curr Treat Options Neurol. 2018 Jun 23;20(8):28. doi: 10.1007/s11940-018-0517-2.','','Normal','2020-11-09 00:26:02','admin',67,'2020110967','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('16816234','The American journal of psychiatry','Prevalence of the metabolic syndrome among patients receiving clozapine;\"Am J Psychiatry. 2006 Jul;163(7):1132-4\"','Am J Psychiatry. 2006 Jul;163(7):1273-6. doi: 10.1176/appi.ajp.163.7.1273.','','Normal','2020-11-09 00:26:09','admin',68,'2020110968','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('27307054','Thrombosis and haemostasis','External validation of the IMPROVE Bleeding Risk Assessment Model in medical patients;\"Thromb Haemost. 2016 Aug 30;116(3):403-4\"','Thromb Haemost. 2016 Aug 30;116(3):530-6. doi: 10.1160/TH16-01-0003.','','Normal','2020-11-09 00:26:16','admin',69,'2020110969','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('31167894','Diabetes care','The Influence of Type 2 Diabetes-Associated Factors on Type 1 Diabetes','Diabetes Care. 2019 Aug;42(8):1357-1364. doi: 10.2337/dc19-0102.','Free article, please download and attach PDF','Normal','2020-11-09 00:26:27','admin',70,'2020110970','In Progress','PDF Viewer','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6647039/pdf/dc190102.pdf','http://search.ebscohost.com/login.aspx?authtype=uid&user=dmeditors&password=medicine19!&direct=true&db=mdc&AN=31167894&site=ehost-live',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('30556249','Pediatric diabetes','Diabetic ketoacidosis at diagnosis of type 1 diabetes and glycemic control over time: The SEARCH for diabetes in youth study','Pediatr Diabetes. 2019 Mar;20(2):172-179. doi: 10.1111/pedi.12809.','Free article, please download and attach PDF','Normal','2020-11-09 00:26:38','admin',71,'2020110971','In Progress','PubMed','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6361710/pdf/nihms-1004047.pdf','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('30002365','Nature communications','Predicting marsh vulnerability to sea-level rise using Holocene relative sea-level data','Nat Commun. 2018 Jul 12;9(1):2687. doi: 10.1038/s41467-018-05080-0.','Free article, please download and attach PDF','Normal','2020-11-12 00:27:43','admin',73,'2020111273','In Progress','PDF Viewer','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6043595/pdf/41467_2018_Article_5080.pdf','http://search.ebscohost.com/login.aspx?authtype=uid&user=dmeditors&password=medicine19!&direct=true&db=mdc&AN=30002365&site=ehost-live',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('30002369','Nature communications','A molecular neuromorphic network device consisting of single-walled carbon nanotubes complexed with polyoxometalate','Nat Commun. 2018 Jul 12;9(1):2693. doi: 10.1038/s41467-018-04886-2.','Free article, please download and attach PDF','Normal','2020-11-12 00:56:56','admin',74,'2020111274','In Progress','PDF Viewer','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6043547/pdf/41467_2018_Article_4886.pdf','http://search.ebscohost.com/login.aspx?authtype=uid&user=dmeditors&password=medicine19!&direct=true&db=mdc&AN=30002369&site=ehost-live',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,NULL),('30631069','Nature communications','A metamaterial-enabled design enhancing decades-old short backfire antenna technology for space applications','Nat Commun. 2019 Jan 10;10(1):108. doi: 10.1038/s41467-018-08032-w.','Free article, please download and attach PDF','Medium','2020-12-08 08:27:32','plavita',75,'','In Progress','PDF Viewer','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6328586/pdf/41467_2018_Article_8032.pdf','http://search.ebscohost.com/login.aspx?authtype=uid&user=dmeditors&password=medicine19!&direct=true&db=mdc&AN=30631069&site=ehost-live',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1),('30631070','Nature communications','Precision ultrasound sensing on a chip','Nat Commun. 2019 Jan 10;10(1):132. doi: 10.1038/s41467-018-08038-4.','Free article, please download and attach PDF','','2020-12-08 10:00:30','plavita',76,'','In Progress','PDF Viewer','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6328601/pdf/41467_2018_Article_8038.pdf','http://search.ebscohost.com/login.aspx?authtype=uid&user=dmeditors&password=medicine19!&direct=true&db=mdc&AN=30631070&site=ehost-live',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1),('21740842','Chinese medical journal','A new mutation in the thyroid hormone receptor gene of a Chinese family with resistance to thyroid hormone','Chin Med J (Engl). 2011 Jun;124(12):1835-9. ','','','2020-12-08 03:52:57','plavita',77,'','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1),('17399848','Journal of hepatology','Psoriasis patients with diabetes type 2 are at high risk of developing liver fibrosis during methotrexate treatment;\"J Hepatol. 2007 Jun;46(6):995-8\"','J Hepatol. 2007 Jun;46(6):1111-8. doi: 10.1016/j.jhep.2007.01.024.','','','2020-12-08 03:52:57','plavita',78,'','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1),('30569344','Archives of gynecology and obstetrics','Thyroid function and thyroid disorders during pregnancy: a review and care pathway','Arch Gynecol Obstet. 2019 Feb;299(2):327-338. doi: 10.1007/s00404-018-5018-8.','Free article, please download and attach PDF','','2020-12-08 03:52:57','plavita',79,'','In Progress','PDF Viewer','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','http://search.ebscohost.com/login.aspx?authtype=uid&user=dmeditors&password=medicine19!&direct=true&db=mdc&AN=30569344&site=ehost-live',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1),('30659573','JAMA neurology','Worldwide Incidence of Aneurysmal Subarachnoid Hemorrhage According to Region, Time Period, Blood Pressure, and Smoking Prevalence in the Population: A Systematic Review and Meta-analysis','JAMA Neurol. 2019 May 1;76(5):588-597. doi: 10.1001/jamaneurol.2019.0006.','Free article, please download and attach PDF','','2020-12-08 03:52:57','plavita',80,'','In Progress','PDF Viewer','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','http://search.ebscohost.com/login.aspx?authtype=uid&user=dmeditors&password=medicine19!&direct=true&db=mdc&AN=30659573&site=ehost-live',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1),('31081871','JAMA neurology','Frequency of Intracranial Hemorrhage With Low-Dose Aspirin in Individuals Without Symptomatic Cardiovascular Disease: A Systematic Review and Meta-analysis','JAMA Neurol. 2019 May 13;76(8):906-914. doi: 10.1001/jamaneurol.2019.1120.','Free article, please download and attach PDF','','2020-12-08 03:52:57','plavita',81,'','In Progress','PDF Viewer','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','http://search.ebscohost.com/login.aspx?authtype=uid&user=dmeditors&password=medicine19!&direct=true&db=mdc&AN=31081871&site=ehost-live',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1),('29762121','Journal of surgical orthopaedic advances','Friction Syndromes of the Knee: The Iliotibial Band and Anterior Fat Pads','J Surg Orthop Adv. Spring 2018;27(1):77-80. ','','','2020-12-08 03:52:57','plavita',82,'','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1),('30532079','Nature reviews. Genetics','Risk loci for ADHD;\"Nat Genet. 2019 Jan;51(1):63-75\"','Nat Rev Genet. 2019 Feb;20(2):69. doi: 10.1038/s41576-018-0084-0.','','','2020-12-08 03:52:57','plavita',83,'','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1),('27901552','Obstetrical &amp; gynecological survey','Diagnosis and Management of Hyperthyroidism in Pregnancy: A Review','Obstet Gynecol Surv. 2016 Nov;71(11):675-685. doi: 10.1097/OGX.0000000000000367.','','','2020-12-08 03:52:57','plavita',84,'','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1),('45786','Immunopharmacology','Modulation of the acquisition and expression of immunity by Tilorone: I. Delayed-type hypersensitivity responses','Immunopharmacology. 1978 Dec;1(1):21-8. doi: 10.1016/0162-3109(78)90005-x.','','Normal','2020-12-08 20:13:44','plavita',85,'','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1),('7810787','The American journal of sports medicine','Fate of the ACL-injured patient. A prospective outcome study;\"Am J Sports Med. 1995 May-Jun;23(3):372-3\"','Am J Sports Med. Sep-Oct 1994;22(5):632-44. doi: 10.1177/036354659402200511.','','Normal','2020-12-08 20:19:20','plavita',86,'','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1),('123456','Boletin de la Oficina Sanitaria Panamericana. Pan American Sanitary Bureau','[The laboratory in programs for enteric infection control]','Bol Oficina Sanit Panam. 1975 Apr;78(4):318-22. ','','Normal','2020-12-09 00:21:24','plavita',87,'','In Progress','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,0,'','',0,'DynaMed Editorial',0,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `fulltextrequestinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
  `UserName` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `ModuleName` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `MethodName` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `LineNumber` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  `LevelName` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  `Message` longtext CHARACTER SET utf8mb4,
  `Exception` longtext CHARACTER SET utf8mb4,
  `LoggedDate` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES ('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin with IP ::1','','2020-08-25 15:01:52.257000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin with IP ::1','','2020-08-25 15:03:10.470000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin - ::1','','2020-08-25 15:16:53.867000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin - ::1','','2020-08-25 15:17:12.267000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin - ::1','','2020-08-25 15:17:49.927000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin - ::1','','2020-08-25 15:22:13.497000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin - ::1','','2020-08-25 15:27:23.907000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin - ::1','','2020-08-25 15:28:57.533000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin - ::1','','2020-08-25 15:29:29.760000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin - ::1','','2020-08-25 15:30:28.903000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin - ::1','','2020-08-25 15:30:42.650000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin - ::1','','2020-08-25 15:31:02.567000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','14','INFO','admin - ::1','','2020-08-25 15:32:04.047000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','admin - ::1','','2020-08-25 15:35:47.380000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','admin - ::1','','2020-08-25 15:38:53.007000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','admin - ::1','','2020-08-25 15:41:33.463000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','cdunbar-masterson - ::1','','2020-08-25 15:42:36.777000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - cdunbar-masterson - ::1','','2020-08-25 15:51:57.667000'),('CORP\\aarepelly','RAFT.Admin','lnklogOut_Click','174','INFO','Logged out - cdunbar-masterson','','2020-08-25 15:52:15.323000'),('IIS APPPOOL\\DefaultAppPool','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - fe80::9d94:2058:4bc:a97d%3','','2020-08-27 18:52:33.187000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-09-14 10:40:51.347000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 16:30:07.270000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 16:59:13.420000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 17:18:39.797000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 17:45:23.260000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 17:46:28.907000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 18:04:45.113000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 19:02:06.237000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 19:18:24.603000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 19:20:44.303000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 19:53:51.573000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 20:01:44.653000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 20:02:28.717000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 20:03:38.503000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 20:03:53.027000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 20:05:10.137000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 11:16:21.993000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 11:34:10.470000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 11:54:44.107000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 12:10:09.350000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 18:09:25.037000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-10-27 18:23:54.767000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 10:49:05.937000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 12:22:15.010000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 12:22:31.617000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 12:23:17.453000'),('IIS APPPOOL\\DefaultAppPool','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 12:26:17.383000'),('IIS APPPOOL\\DefaultAppPool','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - fe80::9d94:2058:4bc:a97d%3','','2020-11-09 12:28:46.550000'),('IIS APPPOOL\\DefaultAppPool','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - fe80::9d94:2058:4bc:a97d%3','','2020-11-09 12:31:40.207000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 12:32:13.677000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 12:38:55.880000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 19:57:21.947000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 19:58:25.707000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 19:58:34.810000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 19:58:53.740000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 20:00:58.847000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 20:01:17.837000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 20:02:40.980000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 20:03:36.870000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 20:03:54.307000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 20:18:11.333000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 20:22:01.763000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 20:23:02.630000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 20:23:22.797000'),('CORP\\aarepelly','RAFT.Admin','lnklogOut_Click','176','INFO','Logged out - admin - ::1','','2020-11-09 20:26:00.650000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 19:26:40.907000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 19:26:50.447000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 19:27:52.060000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 19:32:08.333000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 19:45:53.213000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 19:46:09.207000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 19:46:22.580000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 19:50:03.803000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 20:06:45.217000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 20:06:47.430000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 20:06:52.577000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 20:06:56.450000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-10 20:07:02.367000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 12:18:18.460000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 12:20:40.657000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 13:04:44.927000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 13:09:20.337000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','FetchPubMedEhostData','713','ERROR','::1 - admin - |://../.?===19===30002365=-|://../.?===19===30002369=-\"','System.Net.WebException: The remote server returned an error: (404) Not Found.\r\n   at System.Net.WebClient.DownloadDataInternal(Uri address, WebRequest& request)\r\n   at System.Net.WebClient.DownloadString(Uri address)\r\n   at System.Net.WebClient.DownloadString(String address)\r\n   at RAFT.Master.FullPageRequestService.FetchPubMedEhostData(String pmid) in D:\\GitHub\\Work\\discover.medical.raft\\RAFT\\RAFT\\Master\\FullPageRequestService.asmx.cs:line 487\r\n','2020-11-09 13:09:30.720000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-09 13:16:57.913000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','FetchPubMedEhostData','713','ERROR','::1 - admin - 30002369','System.Net.WebException: The operation has timed out\r\n   at System.Net.WebClient.DownloadDataInternal(Uri address, WebRequest& request)\r\n   at System.Net.WebClient.DownloadString(Uri address)\r\n   at System.Net.WebClient.DownloadString(String address)\r\n   at RAFT.Master.FullPageRequestService.FetchPubMedEhostData(String pmid) in D:\\GitHub\\Work\\discover.medical.raft\\RAFT\\RAFT\\Master\\FullPageRequestService.asmx.cs:line 487\r\n','2020-11-09 13:20:33.797000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','FetchPubMedEhostData','713','ERROR','::1 - admin - 30002369','System.Net.WebException: The remote name could not be resolved: \'pubmed.ncbi.nlm.nih.gov\'\r\n   at System.Net.WebClient.DownloadDataInternal(Uri address, WebRequest& request)\r\n   at System.Net.WebClient.DownloadString(Uri address)\r\n   at System.Net.WebClient.DownloadString(String address)\r\n   at RAFT.Master.FullPageRequestService.FetchPubMedEhostData(String pmid) in D:\\GitHub\\Work\\discover.medical.raft\\RAFT\\RAFT\\Master\\FullPageRequestService.asmx.cs:line 487\r\n','2020-11-09 13:22:09.753000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','FetchPubMedEhostData','713','ERROR','::1 - admin - 30002369','System.Net.WebException: The remote name could not be resolved: \'pubmed.ncbi.nlm.nih.gov\'\r\n   at System.Net.WebClient.DownloadDataInternal(Uri address, WebRequest& request)\r\n   at System.Net.WebClient.DownloadString(Uri address)\r\n   at System.Net.WebClient.DownloadString(String address)\r\n   at RAFT.Master.FullPageRequestService.FetchPubMedEhostData(String pmid) in D:\\GitHub\\Work\\discover.medical.raft\\RAFT\\RAFT\\Master\\FullPageRequestService.asmx.cs:line 487\r\n','2020-11-09 13:22:20.360000'),('IIS APPPOOL\\DefaultAppPool','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - fe80::9d94:2058:4bc:a97d%3','','2020-11-09 15:56:44.827000'),('IIS APPPOOL\\DefaultAppPool','RAFT.Admin','lnklogOut_Click','176','INFO','Logged out - admin - fe80::9d94:2058:4bc:a97d%3','','2020-11-09 16:28:59.590000'),('IIS APPPOOL\\DefaultAppPool','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - fe80::9d94:2058:4bc:a97d%3','','2020-11-09 19:49:13.777000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-12 16:56:16.530000'),('CORP\\aarepelly','RAFT.Admin','lnklogOut_Click','176','INFO','Logged out - admin - ::1','','2020-11-12 16:57:12.823000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-07 17:36:44.407000'),('CORP\\aarepelly','RAFT.Admin','lnklogOut_Click','202','INFO','Logged out - plavita - ::1','','2020-12-07 17:38:04.173000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-10 11:39:28.597000'),('CORP\\aarepelly','RAFT.Admin','lnklogOut_Click','202','INFO','Logged out - plavita - ::1','','2020-12-10 11:39:54.657000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-10 11:40:03.710000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','18','INFO','Logged in - admin - ::1','','2020-11-12 16:23:54.837000'),('CORP\\aarepelly','RAFT.Admin','lnklogOut_Click','202','INFO','Logged out - plavita - ::1','','2020-12-10 11:41:20.897000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-10 11:41:32.607000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-10 11:44:12.870000'),('CORP\\aarepelly','RAFT.Admin','lnklogOut_Click','202','INFO','Logged out - plavita - ::1','','2020-12-10 11:48:05.957000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-10 11:48:16.227000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-10 11:51:34.363000'),('CORP\\aarepelly','RAFT.Admin','lnklogOut_Click','202','INFO','Logged out - plavita - ::1','','2020-12-10 11:51:43.697000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-10 11:53:14.530000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-23 16:15:24.050000'),('CORP\\aarepelly','RAFT.Admin','LnklogOut_Click','97','INFO','Logged out - plavita - ::1','','2020-12-23 16:15:31.747000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-23 17:49:09.057000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-10 12:19:12.083000'),('CORP\\aarepelly','RAFT.Admin','lnklogOut_Click','202','INFO','Logged out - plavita - ::1','','2020-12-10 12:19:17.547000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - PLAVITA - ::1','','2020-12-21 19:24:16.427000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-21 19:31:25.533000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-21 19:45:00.210000'),('CORP\\aarepelly','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - ::1','','2020-12-21 19:47:56.910000'),('IIS APPPOOL\\DefaultAppPool','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - plavita - fe80::9d94:2058:4bc:a97d%3','','2020-12-23 18:19:51.737000'),('IIS APPPOOL\\DefaultAppPool','RAFT.Admin','LnklogOut_Click','97','INFO','Logged out - plavita - fe80::9d94:2058:4bc:a97d%3','','2020-12-23 18:20:22.903000'),('IIS APPPOOL\\DefaultAppPool','RAFT.Master.FullPageRequestService','Page_Load','36','INFO','Logged in - admin - fe80::9d94:2058:4bc:a97d%3','','2020-12-23 18:24:30.747000');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modules`
--

DROP TABLE IF EXISTS `modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modules` (
  `ModuleId` int(11) NOT NULL,
  `ModuleName` varchar(100) NOT NULL,
  `ParentID` int(11) DEFAULT NULL,
  `ModulePath` varchar(200) DEFAULT NULL,
  `ImagePath` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `IconName` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  `OrderNumber` int(11) DEFAULT NULL,
  `OpenInChildWindow` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ModuleId`),
  KEY `FK_Modules_ParentID` (`ParentID`),
  CONSTRAINT `FK_Modules_ParentID` FOREIGN KEY (`ParentID`) REFERENCES `modules` (`ModuleId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modules`
--

LOCK TABLES `modules` WRITE;
/*!40000 ALTER TABLE `modules` DISABLE KEYS */;
INSERT INTO `modules` VALUES (1,'Home',NULL,'../Master/Home.aspx',NULL,NULL,NULL,NULL),(2,'Manage',NULL,'',NULL,NULL,NULL,NULL),(4,'Reports',NULL,'',NULL,NULL,NULL,NULL),(5,'FullText',NULL,'',NULL,NULL,NULL,NULL),(6,'User',2,'../Master/UserCreation.aspx','../Images/Manage-Users.png','Manage Users',3,NULL),(7,'Role',2,'../Master/RoleCreation.aspx','../Images/Manage-Roles.png','Manage Roles',2,NULL),(8,'Menu',2,'../Master/ModuleCreation.aspx','../Images/Manage-Menus.png','Manage Menus',1,NULL),(9,'Full Text Request',5,'../Master/FullTextRequesterFulfiller.aspx','../Images/FT-Request.png','FullText Request',4,NULL),(10,'Full Text FullFiller',5,'../Master/FullTextFullFiller.aspx','../Images/FT-Fulfill.png','Full Text FullFiller',5,NULL),(11,'Full Text Requests Report',4,'../Master/FullTextRequestsReport.aspx','../Images/FT_Report.png','Full Text Requests Report',6,NULL);
/*!40000 ALTER TABLE `modules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passwordreset`
--

DROP TABLE IF EXISTS `passwordreset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passwordreset` (
  `Email` varchar(250) CHARACTER SET utf8mb4 DEFAULT NULL,
  `oldPassword` varchar(250) CHARACTER SET utf8mb4 DEFAULT NULL,
  `newpassword` varchar(250) CHARACTER SET utf8mb4 DEFAULT NULL,
  `requestdate` datetime(6) DEFAULT NULL,
  `resetdate` datetime(6) DEFAULT NULL,
  `Isactive` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passwordreset`
--

LOCK TABLES `passwordreset` WRITE;
/*!40000 ALTER TABLE `passwordreset` DISABLE KEYS */;
INSERT INTO `passwordreset` VALUES ('aarepelly@ebsco.com','admin','anil','2020-12-12 15:40:10.290000','2020-12-11 05:15:16.150000',0),('aarepelly@ebsco.com','admin','aarepelly','2020-12-11 03:20:06.690000','2020-12-11 03:36:23.473000',0),('aarepelly@ebsco.com','anil',NULL,'2020-12-11 05:16:31.577000',NULL,0),('aarepelly@ebsco.com','anil',NULL,'2020-12-14 01:34:09.460000',NULL,0),('aarepelly@ebsco.com','anil',NULL,'2020-12-14 01:35:27.720000',NULL,0),('aarepelly@ebsco.com','anil',NULL,'2020-12-23 08:48:22.650000',NULL,0),('aarepelly@ebsco.com','anil','anil','2020-12-23 07:50:27.610000','2020-12-23 07:53:56.460000',0),('aarepelly@ebsco.com','anil',NULL,'2020-12-23 08:35:17.030000',NULL,0),('aarepelly@ebsco.com','anil',NULL,'2020-12-24 01:39:41.537000',NULL,0),('aarepelly@ebsco.com','anil','Admin','2021-01-04 23:00:39.780000','2021-01-04 23:02:01.050000',0);
/*!40000 ALTER TABLE `passwordreset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pmidfiledetails`
--

DROP TABLE IF EXISTS `pmidfiledetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pmidfiledetails` (
  `FileID` bigint(20) NOT NULL,
  `RequestID` bigint(20) DEFAULT NULL,
  `PMID` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `FileName` varchar(1000) CHARACTER SET utf8mb4 DEFAULT NULL,
  `FileSize` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `UploadedDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Type` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `ContentType` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `DeletedBy` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `DeletedDate` datetime(6) DEFAULT NULL,
  `IsDeleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`FileID`),
  KEY `Idx-PMID` (`PMID`),
  KEY `Idx-Type` (`Type`),
  KEY `Idx-Filename` (`FileName`(255)),
  KEY `Idx-RequestID` (`RequestID`),
  KEY `idx_pmidfiles` (`RequestID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pmidfiledetails`
--

LOCK TABLES `pmidfiledetails` WRITE;
/*!40000 ALTER TABLE `pmidfiledetails` DISABLE KEYS */;
INSERT INTO `pmidfiledetails` VALUES (3,1,'12975657','12975657-ContentServer (1).pdf','222050','2020-08-19 10:53:31','fulltext','application/pdf',NULL,NULL,NULL);
/*!40000 ALTER TABLE `pmidfiledetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolemodules`
--

DROP TABLE IF EXISTS `rolemodules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rolemodules` (
  `RoleID` int(11) NOT NULL,
  `ModuleID` int(11) NOT NULL,
  KEY `FK_RoleModules_ModuleId` (`ModuleID`),
  KEY `FK_RoleModules_RoleID` (`RoleID`),
  CONSTRAINT `FK_RoleModules_ModuleId` FOREIGN KEY (`ModuleID`) REFERENCES `modules` (`ModuleId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_RoleModules_RoleID` FOREIGN KEY (`RoleID`) REFERENCES `roles` (`RoleID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolemodules`
--

LOCK TABLES `rolemodules` WRITE;
/*!40000 ALTER TABLE `rolemodules` DISABLE KEYS */;
INSERT INTO `rolemodules` VALUES (1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(2,9),(3,10),(3,11),(4,9),(4,10),(4,11);
/*!40000 ALTER TABLE `rolemodules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `RoleID` int(11) NOT NULL,
  `RoleName` varchar(100) NOT NULL,
  `ISADMIN` tinyint(1) DEFAULT NULL,
  `isTeamAdmin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Administrator',1,1),(2,'Requestor',0,0),(3,'Fulfiller',0,0),(4,'FullTextUser',0,0);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `smtp_details`
--

DROP TABLE IF EXISTS `smtp_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `smtp_details` (
  `SMTPID` int(11) NOT NULL,
  `SMTPHost` varchar(100) DEFAULT NULL,
  `Port` varchar(50) DEFAULT NULL,
  `SSL` tinyint(1) DEFAULT NULL,
  `EmailID` varchar(500) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `POPHost` varchar(50) DEFAULT NULL,
  `POPPort` varchar(50) DEFAULT NULL,
  `POPEmailID` varchar(50) DEFAULT NULL,
  `POPEmailPassword` varchar(50) DEFAULT NULL,
  `POPSSL` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`SMTPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `smtp_details`
--

LOCK TABLES `smtp_details` WRITE;
/*!40000 ALTER TABLE `smtp_details` DISABLE KEYS */;
INSERT INTO `smtp_details` VALUES (1,'smtp.office365.com','587',1,'dynamednotification@nes.co.in','NESDM@2019','outlook.office365.com','993','dynamednotification@nes.co.in','NESDM@2019',1);
/*!40000 ALTER TABLE `smtp_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sysdiagrams`
--

DROP TABLE IF EXISTS `sysdiagrams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sysdiagrams` (
  `name` varchar(160) NOT NULL,
  `principal_id` int(11) NOT NULL,
  `diagram_id` int(11) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `definition` longblob,
  PRIMARY KEY (`diagram_id`),
  UNIQUE KEY `UK_principal_name` (`principal_id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sysdiagrams`
--

LOCK TABLES `sysdiagrams` WRITE;
/*!40000 ALTER TABLE `sysdiagrams` DISABLE KEYS */;
/*!40000 ALTER TABLE `sysdiagrams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdetails`
--

DROP TABLE IF EXISTS `userdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdetails` (
  `UserID` int(11) NOT NULL,
  `EMPID` varchar(100) DEFAULT NULL,
  `Password` varchar(1000) DEFAULT NULL,
  `IsActive` tinyint(1) DEFAULT NULL,
  `EMPName` varchar(100) DEFAULT NULL,
  `IsTeamhead` tinyint(1) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `costcenter` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetails`
--

LOCK TABLES `userdetails` WRITE;
/*!40000 ALTER TABLE `userdetails` DISABLE KEYS */;
INSERT INTO `userdetails` VALUES (1,'abauskar','fulltext',1,'Aditi Bauskar',0,'abauskar@ebsco.com','DynaMed Editorial'),(2,'abutterworth','fulltext',1,'Aimee Butterworth',0,'abutterworth@ebsco.com','DynaMed Editorial'),(3,'aehrlich','fulltext',1,'Alan Ehrlich',0,'aehrlich@EBSCO.COM','DynaMed Editorial'),(4,'araegrant','fulltext',1,'Alex Rae-Grant',0,'araegrant@ebsco.com','DynaMed Editorial'),(5,'adaviano','fulltext',1,'Alexjandro Daviano',0,'adaviano@ebsco.com','DynaMed Editorial'),(6,'athomason','fulltext',1,'Amanda Thomason',0,'athomason@ebsco.com','DynaMed Editorial'),(7,'aelewis','fulltext',1,'Amy E. Lewis',0,'aelewis@ebsco.com','DynaMed Editorial'),(8,'alombara','fulltext',1,'Amy Lombara',0,'alombara@EBSCO.COM','DynaMed Editorial'),(9,'aries','fulltext',1,'Amy Ries',0,'aries@ebsco.com','DynaMed Editorial'),(10,'ashanahan','fulltext',1,'Andrea Shanahan',0,'ashanahan@ebsco.com','DynaMed Editorial'),(11,'amercier','fulltext',1,'Andrew Mercier',0,'amercier@EBSCO.COM','DynaMed Editorial'),(12,'asimonelli','fulltext',1,'Angela Simonelli',0,'asimonelli@ebsco.com','DynaMed Editorial'),(13,'aolivier-mason','fulltext',1,'Anique Olivier-Mason',0,'aolivier-mason@ebsco.com','DynaMed Editorial'),(14,'AFowler','fulltext',1,'Anne Fowler',0,'AFowler@EBSCO.COM','DynaMed Editorial'),(15,'a.selig','fulltext',1,'Anne Selig',0,'a.selig@ebsco.com','DynaMed Editorial'),(16,'aanthony','fulltext',1,'Ashley V. Anthony',0,'a.anthony@ebsco.com','DynaMed Editorial'),(17,'ashah','fulltext',1,'Ashvin Shah',0,'ashah@EBSCO.COM','DynaMed Editorial'),(18,'bjones','fulltext',1,'Betsy Jones',0,'bjones@EBSCO.COM','DynaMed Editorial'),(19,'bjohnson2','fulltext',1,'Bonnie Johnson',0,'bjohnson2@ebsco.com','DynaMed Editorial'),(20,'bdenker','fulltext',1,'Brad Denker',0,'bdenker@bidmc.harvard.edu','DynaMed Editorial'),(21,'drweiner','fulltext',1,'Brian Weiner',0,'drweiner@optonline.net','DynaMed Editorial'),(22,'bmartel','fulltext',1,'Brittany Martel',0,'bmartel@EBSCO.COM','DynaMed Editorial'),(23,'cappel','fulltext',1,'Caroline Appel',0,'cappel@ebsco.com','DynaMed Editorial'),(24,'cdunbar-masterson','fulltext',1,'Carolyn Dunbar-Masterson',0,'cdunbar-masterson@ebsco.com','DynaMed Editorial'),(25,'cnutt','fulltext',1,'Catherine Nutt',0,'cnutt@ebsco.com','DynaMed Editorial'),(26,'ctalsness','fulltext',1,'Chris Talsness',0,'ctalsness@ebsco.com','DynaMed Editorial'),(27,'cfessenden','fulltext',1,'Christine Fessenden',1,'cfessenden@ebsco.com','DynaMed Editorial'),(28,'CColpitts','fulltext',1,'Christine McLellan',0,'CColpitts@EBSCO.COM','DynaMed Editorial'),(29,'cchalk','fulltext',1,'Christopher Chalk',0,'cchalk@ebsco.com','DynaMed Editorial'),(30,'claushamannmd','fulltext',1,'Claus Hamann',0,'claushamannmd@gmail.com','DynaMed Editorial'),(31,'colson','fulltext',1,'Colby Olson',0,'colson@ebsco.com','DynaMed Editorial'),(32,'cncolpitts','fulltext',1,'Corinne Colpitts',0,'cncolpitts@EBSCO.COM','DynaMed Editorial'),(33,'cmahoney','fulltext',1,'Corinne Mahoney',0,'cmahoney@ebsco.com','DynaMed Editorial'),(34,'cdellisanti','fulltext',1,'Cosma Dellisanti',0,'cdellisanti@ebsco.com','DynaMed Editorial'),(35,'ccummins','fulltext',1,'Courtney Cummins',0,'ccummins@ebsco.com','DynaMed Editorial'),(36,'cmjohnson','fulltext',1,'Cynthia Johnson',0,'cmjohnson@EBSCO.COM','DynaMed Editorial'),(37,'drandall','fulltext',1,'Dan Randall',0,'drandall@ebsco.com','DynaMed Editorial'),(38,'dbai','fulltext',1,'David Bai',0,'dbai@ebsco.com','DynaMed Editorial'),(39,'ddoroquez','fulltext',1,'David Doroquez',0,'ddoroquez@ebsco.com','DynaMed Editorial'),(40,'dianehanson','fulltext',1,'Diane Hanson',0,'dianehanson@ebsco.com','DynaMed Editorial'),(41,'eyoshida','fulltext',1,'Eileen Yoshida',0,'eyoshida@ebsco.com','DynaMed Editorial'),(42,'etoglia','fulltext',1,'Elizabeth Toglia',0,'etoglia@ebsco.com','DynaMed Editorial'),(43,'ekontos','fulltext',1,'Emily Kontos',0,'ekontos@ebsco.com','DynaMed Editorial'),(44,'flin','fulltext',1,'Fenny Lin',0,'flin@EBSCO.COM','DynaMed Editorial'),(45,'gsulik','fulltext',1,'Gayle Sulik',0,'gsulik@ebsco.com','DynaMed Editorial'),(46,'gcamelia','fulltext',1,'Genna Camelia',1,'gcamelia@ebsco.com','DynaMed Editorial'),(47,'hmarshall','fulltext',1,'Heather Marshall',0,'hmarshall@ebsco.com','DynaMed Editorial'),(48,'jforgione','fulltext',1,'James Forgione',0,'jforgione@EBSCO.COM','DynaMed Editorial'),(49,'jlarue','fulltext',1,'James LaRue',0,'jlarue@EBSCO.COM','DynaMed Editorial'),(50,'jmclellan','fulltext',1,'James McLellan',0,'jmclellan@EBSCO.COM','DynaMed Editorial'),(51,'jtitus','fulltext',1,'Janel Titus',0,'jtitus@EBSCO.COM','DynaMed Editorial'),(52,'jardizzone','fulltext',1,'Jason Ardizzone',0,'jardizzone@ebsco.com','DynaMed Editorial'),(53,'jeffgrant','fulltext',1,'Jeff Grant',0,'jeffgrant@ebsco.com','DynaMed Editorial'),(54,'jmagee','fulltext',1,'Jennifer Magee',0,'jmagee@ebsco.com','DynaMed Editorial'),(55,'jwolff','fulltext',1,'Jennifer Wolff',0,'jwolff@ebsco.com','DynaMed Editorial'),(56,'jbartell','fulltext',1,'Jessica Bartell',0,'jbartell@ebsco.com','DynaMed Editorial'),(57,'jangelosanto','fulltext',1,'Jill Angelosanto',0,'jangelosanto@EBSCO.COM','DynaMed Editorial'),(58,'jmserrano','fulltext',1,'Jill M. Serrano',0,'jmserrano@EBSCO.COM','DynaMed Editorial'),(59,'JDeRosa','fulltext',1,'Jimmy DeRosa',0,'JDeRosa@ebsco.com','DynaMed Editorial'),(60,'JWilkinsonIV','fulltext',1,'John Wilkinson IV',0,'JWilkinsonIV@ebsco.com','DynaMed Editorial'),(61,'jmayette','fulltext',1,'Jonathan Mayette',0,'jmayette@ebsco.com','DynaMed Editorial'),(62,'jdamore','fulltext',1,'Joseph D\'Amore',0,'jdamore@ebsco.com','DynaMed Editorial'),(63,'jerkman','fulltext',1,'Judy Erkmann',0,'jerkman@EBSCO.COM','DynaMed Editorial'),(64,'jcolpitts','fulltext',1,'Julia Colpitts',0,'jcolpitts@EBSCO.COM','DynaMed Editorial'),(65,'jbellet','fulltext',1,'Julie Bellet',0,'jbellet@EBSCO.COM','DynaMed Editorial'),(66,'knagpal','fulltext',1,'Kamalpreet Nagpal',0,'knagpal@ebsco.com','DynaMed Editorial'),(67,'kclarke','fulltext',1,'Karen Clarke',0,'kclarke@EBSCO.COM','DynaMed Editorial'),(68,'krosolowski','fulltext',1,'Karie Rosolowski',0,'krosolowski@ebsco.com','DynaMed Editorial'),(69,'kalsup','fulltext',1,'Kate Alsup',0,'kalsup@ebsco.com','DynaMed Editorial'),(70,'keliot','fulltext',1,'Kate Eliot',0,'keliot@EBSCO.COM','DynaMed Editorial'),(71,'kdegeorge','fulltext',1,'Katharine DeGeorge',0,'kdegeorge@EBSCO.COM','DynaMed Editorial'),(72,'kmiller2','fulltext',1,'Kelly Miller',0,'kmiller2@ebsco.com','DynaMed Editorial'),(73,'kchurch','fulltext',1,'Kendra Church',0,'kchurch@ebsco.com','DynaMed Editorial'),(74,'kloughlin','fulltext',1,'Kevin Loughlin',0,'kloughlin@EBSCO.COM','DynaMed Editorial'),(75,'kshahin','fulltext',1,'Khalid Shahin',0,'kshahin@ebsco.com','DynaMed Editorial'),(76,'LJWilliams','fulltext',1,'Laurie Williams',0,'LJWilliams@EBSCO.COM','DynaMed Editorial'),(77,'LWelch','fulltext',1,'Lisa Welch',0,'LWelch@EBSCO.COM','DynaMed Editorial'),(78,'msivanan','fulltext',1,'Mala Sivanandy',0,'msivanan@bidmc.harvard.edu','DynaMed Editorial'),(79,'mgrant','fulltext',1,'Marianne Grant',0,'mgrant@ebsco.com','DynaMed Editorial'),(80,'mmayer','fulltext',1,'Martin Mayer',0,'mmayer@ebsco.com','DynaMed Editorial'),(81,'mwoodbury','fulltext',1,'Mary Woodbury Hooper',0,'mwoodbury@EBSCO.COM','DynaMed Editorial'),(82,'masmith','fulltext',1,'Maureen A. Smith',0,'masmith@EBSCO.COM','DynaMed Editorial'),(83,'mmcmahon','fulltext',1,'Maureen McMahon',0,'mmcmahon@EBSCO.COM','DynaMed Editorial'),(84,'mwanek','fulltext',1,'Megan Wanek',0,'mwanek@ebsco.com','DynaMed Editorial'),(85,'mawal','fulltext',1,'Mehraj Awal',0,'mawal@ebsco.com','DynaMed Editorial'),(86,'mmott','fulltext',1,'Melanie Mott',0,'mmott@ebsco.com','DynaMed Editorial'),(87,'mmiller','fulltext',1,'Melecia Miller',0,'mmiller@ebsco.com','DynaMed Editorial'),(88,'mvidoni','fulltext',1,'Michelle Vidoni',0,'mvidoni@ebsco.com','DynaMed Editorial'),(89,'mzangwill','fulltext',1,'Monica Zangwill',0,'mzangwill@EBSCO.COM','DynaMed Editorial'),(90,'mherd','fulltext',1,'Muriel Herd',0,'mherd@ebsco.com','DynaMed Editorial'),(91,'nvaidya','fulltext',1,'Neel Vaidya',0,'nvaidya@ebsco.com','DynaMed Editorial'),(92,'nannapareddy','fulltext',1,'Neelima Annapareddy',0,'nannapareddy@ebsco.com','DynaMed Editorial'),(93,'nsansone','fulltext',1,'Nicholas Sansone',0,'nsansone@EBSCO.COM','DynaMed Editorial'),(94,'nbaritot','fulltext',1,'Nicole Baritot',0,'nbaritot@ebsco.com','DynaMed Editorial'),(95,'pmjones','fulltext',1,'Pamela Jones',0,'pmjones@ebsco.com','DynaMed Editorial'),(96,'pkavanagh','fulltext',1,'Patricia L. Kavanagh',0,'pkavanagh@ebsco.com','DynaMed Editorial'),(97,'plavita','fulltext',1,'Peter LaVita',1,'plavita@EBSCO.COM','DynaMed Editorial'),(98,'poettgen','fulltext',1,'Peter Oettgen',0,'poettgen@EBSCO.COM','DynaMed Editorial'),(99,'rbrady','fulltext',1,'Rachel Brady',0,'rbrady@EBSCO.COM','DynaMed Editorial'),(100,'rwalker','fulltext',1,'Rachel Walker',0,'rwalker@EBSCO.COM','DynaMed Editorial'),(101,'rvanlith','fulltext',1,'Robert van Lith',0,'rvanlith@ebsco.com','DynaMed Editorial'),(102,'rguerriero','fulltext',1,'Rosanne Guerriero',0,'rguerriero@ebsco.com','DynaMed Editorial'),(103,'sjjones','fulltext',1,'Samantha J. Jones',0,'sjjones@ebsco.com','DynaMed Editorial'),(104,'sknight','fulltext',1,'Sara Knight',0,'sknight@EBSCO.COM','DynaMed Editorial'),(105,'sfitzpatrick','fulltext',1,'Sarah J. Fitzpatrick',0,'sfitzpatrick@ebsco.com','DynaMed Editorial'),(106,'saoyagi','fulltext',1,'Sayura Aoyagi',0,'saoyagi@ebsco.com','DynaMed Editorial'),(107,'sbarron','fulltext',1,'Scott A. Barron',0,'sbarron@ebsco.com','DynaMed Editorial'),(108,'sniles','fulltext',1,'Shanon Niles',0,'sniles@EBSCO.COM','DynaMed Editorial'),(109,'sboehringer','fulltext',1,'Sherri Boehringer',0,'sboehringer@ebsco.com','DynaMed Editorial'),(110,'sshen','fulltext',1,'Shirley Shen',0,'sshen@ebsco.com','DynaMed Editorial'),(111,'srobson','fulltext',1,'Simon Robson',0,'srobson@ebsco.com','DynaMed Editorial'),(112,'stsmith','fulltext',1,'Stephanie Smith',0,'stsmith@ebsco.com','DynaMed Editorial'),(113,'stroyan','fulltext',1,'Susan Troyan',0,'stroyan@ebsco.com','DynaMed Editorial'),(114,'ttupper','fulltext',1,'Tanya Tupper',0,'ttupper@ebsco.com','DynaMed Editorial'),(115,'ttrow','fulltext',1,'Terence Trow',0,'ttrow@ebsco.com','DynaMed Editorial'),(116,'tlevine','fulltext',1,'Terri Levine',0,'tlevine@ebsco.com','DynaMed Editorial'),(117,'thilts','fulltext',1,'Thomas Hilts',0,'thilts@EBSCO.COM','DynaMed Editorial'),(118,'vbrahver','fulltext',1,'Val Brahver',0,'vbrahver@ebsco.com','DynaMed Editorial'),(119,'vlemaitre','fulltext',1,'Vincent Lemaitre',0,'vlemaitre@ebsco.com','DynaMed Editorial'),(120,'wyip','fulltext',1,'Vincent Yip',0,'wyip@ebsco.com','DynaMed Editorial'),(121,'viacoviello','fulltext',1,'Vito Iacoviello',0,'viacoviello@ebsco.com','DynaMed Editorial'),(122,'waird','fulltext',1,'William Aird',0,'waird@ebsco.com','DynaMed Editorial'),(123,'xcao','fulltext',1,'Xiaoyan Cao',0,'xcao@ebsco.com','DynaMed Editorial'),(124,'sxing','fulltext',1,'Sifei Xing',0,'sxing@ebsco.com','DynaMed Editorial'),(125,'jlevy','fulltext',1,'June Levy',0,'jlevy@ebsco.com','Dynamic Health'),(126,'cseebercombs','fulltext',1,'Colleen Seeber-Combs',0,'cseebercombs@ebsco.com','Dynamic Health'),(127,'juliebrown','fulltext',1,'Julie Brown',0,'juliebrown@ebsco.com','Dynamic Health'),(128,'mlavoie','fulltext',1,'Matthew Lavoie',0,'mlavoie@ebsco.com','Dynamic Health'),(129,'pneal','fulltext',1,'Penelope Neal',0,'pneal@ebsco.com','Dynamic Health'),(130,'rstables','fulltext',1,'Rob Stables',0,'rstables@EBSCO.COM','Dynamic Health'),(131,'agreenblatt','fulltext',1,'Aaron Greenblatt',0,'agreenblatt@ebsco.com','PM Medical Option Grids'),(132,'ecollins','fulltext',1,'Erin Collins',0,'ecollins@ebsco.com','PM Medical Option Grids'),(133,'jkeevil','fulltext',1,'Jon Keevil',0,'jkeevil@ebsco.com','PM Medical Option Grids'),(134,'jwislar','fulltext',1,'Joseph Wislar',0,'jwislar@ebsco.com','PM Medical Option Grids'),(135,'keisenberg','fulltext',1,'Katherine Eisenberg',0,'keisenberg@ebsco.com','PM Medical Option Grids'),(136,'mmcphee','fulltext',1,'Meghan McPhee',0,'mmcphee@ebsco.com','PM Medical Option Grids'),(137,'rhasnain','fulltext',1,'Ridda Hasnain',0,'rhasnain@ebsco.com','PM Medical Option Grids'),(138,'admin','Admin',1,'Admin',NULL,'aarepelly@ebsco.com','DynaMed Editorial'),(139,'kumar','kumar',1,'Anil Kumar',NULL,'aarepelly@nes.co.in','DynaMed Editorial');
/*!40000 ALTER TABLE `userdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroles`
--

DROP TABLE IF EXISTS `userroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userroles` (
  `UserID` int(11) NOT NULL,
  `RoleID` int(11) NOT NULL,
  KEY `FK_UserRoles_UserID` (`UserID`),
  KEY `FK_UserRoles_RoleID` (`RoleID`),
  CONSTRAINT `FK_UserRoles_RoleID` FOREIGN KEY (`RoleID`) REFERENCES `roles` (`RoleID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_UserRoles_UserID` FOREIGN KEY (`UserID`) REFERENCES `userdetails` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroles`
--

LOCK TABLES `userroles` WRITE;
/*!40000 ALTER TABLE `userroles` DISABLE KEYS */;
INSERT INTO `userroles` VALUES (1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(21,2),(22,2),(23,2),(24,2),(25,2),(26,2),(28,2),(29,2),(30,2),(31,2),(32,2),(33,2),(34,2),(35,2),(36,2),(37,2),(38,2),(39,2),(40,2),(41,2),(42,2),(43,2),(44,2),(45,2),(47,2),(48,2),(49,2),(50,2),(51,2),(52,2),(53,2),(54,2),(55,2),(56,2),(57,2),(58,2),(59,2),(60,2),(61,2),(62,2),(63,2),(64,2),(65,2),(66,2),(67,2),(68,2),(69,2),(70,2),(71,2),(72,2),(73,2),(74,2),(75,2),(76,2),(77,2),(78,2),(79,2),(80,2),(81,2),(82,2),(83,2),(84,2),(85,2),(86,2),(87,2),(88,2),(89,2),(90,2),(91,2),(92,2),(93,2),(94,2),(95,2),(96,2),(98,2),(99,2),(100,2),(101,2),(102,2),(103,2),(104,2),(105,2),(106,2),(107,2),(108,2),(109,2),(110,2),(111,2),(112,2),(113,2),(114,2),(115,2),(116,2),(117,2),(118,2),(119,2),(120,2),(121,2),(122,2),(123,2),(124,2),(125,2),(126,2),(127,2),(128,2),(129,2),(130,2),(131,2),(132,2),(133,2),(134,2),(135,2),(136,2),(137,2),(27,1),(46,1),(97,1),(138,1),(139,3);
/*!40000 ALTER TABLE `userroles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'raft_uat'
--

--
-- Dumping routines for database 'raft_uat'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-05 15:33:28
