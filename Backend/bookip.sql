-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-10-2022 a las 13:50:07
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bookip`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `nombrecliente` varchar(100) NOT NULL,
  `nombreusuario` varchar(100) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `activo` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`nombrecliente`, `nombreusuario`, `ciudad`, `activo`) VALUES
('Bozza S.A', 'abozza', 'Venado Tuerto', b'1'),
('Britos S.R.L', 'nikolab', 'Venado Tuerto', b'1'),
('Di Miscia´s', 'mdimiscia', 'Rufino', b'1'),
('Piancatelli Inc.', 'tpianca', 'Santa Isabel', b'1'),
('Prueba 1 SRL', 'pruba1', 'Tu vieja', b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registros`
--

CREATE TABLE `registros` (
  `id` int(5) NOT NULL,
  `nombrecliente` varchar(100) DEFAULT NULL,
  `numcliente` varchar(5) DEFAULT NULL,
  `maccpe` varchar(15) DEFAULT NULL,
  `direccionip` varchar(15) DEFAULT NULL,
  `activo` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registros`
--

INSERT INTO `registros` (`id`, `nombrecliente`, `numcliente`, `maccpe`, `direccionip`, `activo`) VALUES
(1, 'Bozza S.A', '002', '0012.25da.dada', '190.11.130.12', b'1'),
(2, 'Bozza S.A', '003', '0012.25da.dadb', '190.11.130.15', b'1'),
(3, 'Piancatelli Inc.', '021', '0012.25da.dade', '190.11.130.34', b'1'),
(4, 'Di Miscia´s', '033', '0012.25da.dadl', '190.11.130.57', b'1'),
(5, 'Britos S.R.L', '046', '0012.25da.dadr', '190.11.130.78', b'1'),
(6, 'Piancatelli Inc.', '023', '0012.25da.dad', '190.11.130.38', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nivelacceso` bit(1) NOT NULL,
  `nombreusuario` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `direccioncorreo` varchar(50) DEFAULT NULL,
  `activo` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`nivelacceso`, `nombreusuario`, `password`, `direccioncorreo`, `activo`) VALUES
(b'1', 'abozza', 'abozza123098', 'abozza@gmail.com', b'1'),
(b'0', 'mdimiscia', 'dimi123458', 'dimiscia123@gmail.com.ar', b'1'),
(b'0', 'nikolab', 'niko9870321', 'nikolabri@hotmail.com', b'1'),
(b'0', 'pruba1', 'prueba123', 'prueba123@hotmail.com.ar', b'0'),
(b'1', 'tpianca', 'pianca123098', 'tiagopianca16060@gmail.com', b'1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`nombrecliente`),
  ADD KEY `fk_usuarios` (`nombreusuario`);

--
-- Indices de la tabla `registros`
--
ALTER TABLE `registros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_clientes` (`nombrecliente`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`nombreusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `registros`
--
ALTER TABLE `registros`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `fk_usuarios` FOREIGN KEY (`nombreusuario`) REFERENCES `usuarios` (`nombreUsuario`);

--
-- Filtros para la tabla `registros`
--
ALTER TABLE `registros`
  ADD CONSTRAINT `fk_clientes` FOREIGN KEY (`nombrecliente`) REFERENCES `clientes` (`nombrecliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
