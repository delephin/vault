-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-01-2019 a las 22:30:16
-- Versión del servidor: 5.5.36
-- Versión de PHP: 5.4.25

--
-- Base de datos: `vault`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `regions`
--

CREATE TABLE IF NOT EXISTS `regions` (
  `REGION_ID` decimal(10,0) NOT NULL,
  `REGION_NAME` varchar(25) DEFAULT NULL
) ;

--
-- Estructura de tabla para la tabla `locations`
--

CREATE TABLE IF NOT EXISTS `locations` (
  `LOCATION_ID` decimal(4,0) NOT NULL,
  `STREET_ADDRESS` varchar(40) DEFAULT NULL,
  `POSTAL_CODE` varchar(12) DEFAULT NULL,
  `CITY` varchar(30) NOT NULL,
  `STATE_PROVINCE` varchar(25) DEFAULT NULL,
  `COUNTRY_ID` char(2) DEFAULT NULL,
  PRIMARY KEY (`LOCATION_ID`)
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `countries`
--

CREATE TABLE IF NOT EXISTS `countries` (
  `COUNTRY_ID` char(2) NOT NULL,
  `COUNTRY_NAME` varchar(40) DEFAULT NULL,
  `REGION_ID` decimal(10,0) DEFAULT NULL
) ;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departments`
--

CREATE TABLE IF NOT EXISTS `departments` (
  `DEPARTMENT_ID` int(4) NOT NULL AUTO_INCREMENT,
  `DEPARTMENT_NAME` varchar(30) NOT NULL,
  `MANAGER_ID` decimal(6,0) DEFAULT NULL,
  `LOCATION_ID` decimal(4,0) DEFAULT NULL,
  PRIMARY KEY (`DEPARTMENT_ID`),
  FOREIGN KEY (`LOCATION_ID`) references LOCATIONS (`LOCATION_ID`)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employees`
--

CREATE TABLE IF NOT EXISTS `employees` (
  `EMPLOYEE_ID` int(6) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(20) DEFAULT NULL,
  `LAST_NAME` varchar(25) NOT NULL,
  `EMAIL` varchar(25) NOT NULL,
  `PHONE_NUMERIC` varchar(20) DEFAULT NULL,
  `HIRE_DATE` date NOT NULL,
  `JOB_ID` varchar(10) NOT NULL,
  `SALARY` decimal(8,2) DEFAULT NULL,
  `COMMISSION_PCT` decimal(2,2) DEFAULT NULL,
  `MANAGER_ID` decimal(6,0) DEFAULT NULL,
  `DEPARTMENT_ID` decimal(4,0) DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`)
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobs`
--

CREATE TABLE IF NOT EXISTS `jobs` (
  `JOB_ID` varchar(10) NOT NULL,
  `JOB_TITLE` varchar(35) NOT NULL,
  `MIN_SALARY` decimal(6,0) DEFAULT NULL,
  `MAX_SALARY` decimal(6,0) DEFAULT NULL
) ;

--
-- Estructura de tabla para la tabla `job_history`
--

CREATE TABLE IF NOT EXISTS `job_history` (
  `EMPLOYEE_ID` decimal(6,0) NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `JOB_ID` varchar(10) NOT NULL,
  `DEPARTMENT_ID` decimal(4,0) DEFAULT NULL
) ;

-- --------------------------------------------------------

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `departments`
--
ALTER TABLE `departments`
  ADD CONSTRAINT `departments_ibfk_1` FOREIGN KEY (`LOCATION_ID`) REFERENCES `locations` (`LOCATION_ID`);
  
-- --------------------------------------------------------

--
-- Volcado de datos para la tabla `regions`
--

INSERT INTO `regions` (`REGION_ID`, `REGION_NAME`) VALUES
('1', 'AMERICA DEL SUR');

--
-- Volcado de datos para la tabla `countries`
--

INSERT INTO `countries` (`COUNTRY_ID`, `COUNTRY_NAME`, `REGION_ID`) VALUES
('AR', 'ARGENTINA', '1'),
('BR', 'BRASIL', '1');

--
-- Volcado de datos para la tabla `locations`
--

INSERT INTO `locations` (`LOCATION_ID`, `STREET_ADDRESS`, `POSTAL_CODE`, `CITY`, `STATE_PROVINCE`, `COUNTRY_ID`) VALUES
('1', 'Corrientes 000', 'AB1014', 'Buenos Aires', 'Buenos Aires', 'AR'),
('2', 'Lacroze 000', 'AB2242', 'Buenos Aires', 'Buenos Aires', 'AR'),
('3', 'Sarmiento 300', 'BA1019', 'Buenos Aires', 'Buenos Aires', 'AR');

--
-- Volcado de datos para la tabla `departments`
--

INSERT INTO `departments` (`DEPARTMENT_ID`, `DEPARTMENT_NAME`, `MANAGER_ID`, `LOCATION_ID`) VALUES
(1, 'DEPTO_1', '3', '1'),
(2, 'DEPTO_2', '11', '2'),
(3, 'DEPTO_3', '4', '1'),
(4, 'DEPTO_4', '3', '1'),
(5, 'DEPTO_5', '3', '3');

--
-- Volcado de datos para la tabla `jobs`
--

INSERT INTO `jobs` (`JOB_ID`, `JOB_TITLE`, `MIN_SALARY`, `MAX_SALARY`) VALUES
('J-JOR', 'JOURNALIST', '10000', '20000'),
('J-REP', 'Reporter', '10000', '20000'),
('J-ANA', 'Analysts', '10000', '20000'),
('J-ANN', 'Announcers', '10000', '20000');
  
--
-- Volcado de datos para la tabla `employees`
--

INSERT INTO `employees` (`EMPLOYEE_ID`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PHONE_NUMERIC`, `HIRE_DATE`, `JOB_ID`, `SALARY`, `COMMISSION_PCT`, `MANAGER_ID`, `DEPARTMENT_ID`) VALUES
(5, 'Zhang', 'Wu', 'actualizado@gmail.com', '1010101', '2018-12-30', 'J-ANN', '2.00', '0.91', null, '2'),
(1, 'Abe', 'Rodriguez', 'a@gmail.com', '111111', '2010-10-21', 'J-JOR', '10000.00', '0.12', '5', '1'),
(2, 'Carl', 'Sanchez', 'a@gmail.com', '111111', '2014-01-01', 'J-JOR', '5000.00', '0.33', '5', '1'),
(3, 'Ada', 'Araoz', 'a@gmail.com', '111111', '2018-11-21', 'J-REP', '5000.00', '0.13', '5', '2'),
(6, 'Tay', 'Rojo', 'viejo@gmail.com', '1010101', '2018-12-30', 'J-ANN', '1500.00', '0.91', '5', '1');

--
-- Volcado de datos para la tabla `job_history`
--

INSERT INTO `job_history` (`EMPLOYEE_ID`, `START_DATE`, `END_DATE`, `JOB_ID`, `DEPARTMENT_ID`) VALUES
('1', '2008-01-30', '2010-08-20', 'J-REP', '1');
