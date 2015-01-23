-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Machine: localhost
-- Genereertijd: 23 jan 2015 om 16:10
-- Serverversie: 5.6.13
-- PHP-versie: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databank: `filmsdb`
--
CREATE DATABASE IF NOT EXISTS `filmsdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `filmsdb`;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `tbl_acteurs`
--

CREATE TABLE IF NOT EXISTS `tbl_acteurs` (
  `acteur_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Naam` varchar(250) NOT NULL,
  PRIMARY KEY (`acteur_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

--
-- Gegevens worden uitgevoerd voor tabel `tbl_acteurs`
--

INSERT INTO `tbl_acteurs` (`acteur_ID`, `Naam`) VALUES
(1, 'Mel Gibson'),
(2, 'George Clooney'),
(3, 'Daniel Day-Lewis'),
(4, 'Madeleine Stowe'),
(5, 'Jodhi May'),
(6, 'Jason statham'),
(7, 'Amy Smart'),
(8, 'Clifton Collins Jr.'),
(9, 'David Carradine'),
(10, 'Daniel Radcliffe'),
(11, 'Rupert Grint'),
(12, 'Emma Watson'),
(13, 'Robbie Coltrane'),
(14, 'Micheal Gambon'),
(15, 'Gary Oldman'),
(16, 'Alan Rickman'),
(17, 'Maggie Smith'),
(18, 'Emma Thompson'),
(19, 'Sean Connery'),
(20, 'F. Murray Abraham'),
(21, 'Ron Perlman'),
(22, 'Wesley Snipes'),
(23, 'Christian Slater'),
(24, 'Valentina Vargas'),
(25, 'Angelina Jolie'),
(26, 'Morgan Freeman'),
(27, 'James McAvoy'),
(28, 'Danny Glover'),
(29, 'Gary Busey'),
(30, 'Harrison Ford'),
(31, 'Rutger Hauer'),
(32, 'Sean Young'),
(33, 'Edward James Olmos');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `tbl_films`
--

CREATE TABLE IF NOT EXISTS `tbl_films` (
  `film_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Titel` varchar(250) NOT NULL,
  `Genre` varchar(250) NOT NULL,
  `Omschrijving` varchar(3000) NOT NULL,
  `Jaar` int(11) NOT NULL,
  `Acteurs` varchar(255) NOT NULL,
  `Uitgeleend` tinyint(1) NOT NULL,
  PRIMARY KEY (`film_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Gegevens worden uitgevoerd voor tabel `tbl_films`
--

INSERT INTO `tbl_films` (`film_ID`, `Titel`, `Genre`, `Omschrijving`, `Jaar`, `Acteurs`, `Uitgeleend`) VALUES
(1, 'Blade Runner', 'Sci-Fi/Fantasy', 'Rick Deckard (Harrison Ford) sluipt door de jungle van staal en microships in Los Angeles in de 21e eeuw. Hij is een ''blade runner'' die op genetisch gemodificeerde criminele ''replicants'' jaagt. Zijn opdracht: ze doden. Hun misdaad: menselijk willen zijn. De visie van regisseur Ridley Scott op deze science fiction klassieker verschilt interessant genoeg van wat filmbezoekers in 1982 te zien kregen. Dit is een visueel spektakel, bewerkt om beter thuis te kunnen bekijken. Deze versie bevat niet het voice-over commentaar van Deckard, de romance tussen Deckard en Rachael (Sean Young) wordt meer in detail belicht en het "verheffende" einde is verwijderd. Het meest intrigerende element is een nieuw toegevoegde eenhoornvisie dei suggereert dat Deckard een androïde zou kunnen zijn. Het resultaat is een groter emotioneel effect: een geweldige film die nog beter is geworden.', 1991, 'Harrison Ford, Sean Young, Rutger Hauer, Edward James Olmos', 0),
(2, 'Lethal Weapon', 'Actie', 'Met meer dan zeven minuten nog niet eerder uitgebrachte scènes, is de director''s cut van Lethal Weapon een geschenk voor de fans. Riggs'' eenzame huiselijke leven en het tragische verlies dat hem aanzet tot een roekeloze onverschilligheid voor zijn eigen veiligheid, worden nu scherperin beeld gebracht. We zien die roekeloosheid in nieuwe scènes die de verschillen tussen de twee agenten onderstrepen. Murtaugh, net 50 geworden, zoekt bevestiging van zijn vaardigheden op de schietbaan. Riggs, die er niet mee zit of hij zijn volgende verjaardag al of niet zal halen, loopt onverstoorbaar in het schootsveld van een sluipschutter op een schoolplein. De humor en de spanning, die van de originele versie een mijlpaal in de amusementssector maakten, zijn ook hier aanwezig. Er werden geen scènes geschrapt. Maar nieuwe actie en een nieuwe inzicht in de personages werden toegevoegd. Beleef zelf de sensatie.', 1987, 'Mel Gibson, Danny Glover, Gary Busey', 0),
(3, 'Wanted', 'Actie', 'Wesley Gibson (James McAvoy) slijt zijn troosteloze bestaan in een benauwende kantoortuin, met een baas die hem vernedert en een vriendinnetje dat hem bedriegt. Zijn leven is een puinhoop. Dan ontdekt Wesley dat de vader, die hij nooit heeft gekend, op brutale wijze vermoord is en sluit hij zich, tegen wil en dank, aan bij een geheim genootschap van sluipmoordenaars: De Broederschap. Tijdens zijn opleiding door zijn getalenteerde mentor Fox (Angelina Jolie), ontpopt de saaie kantoorpiet zich tot een moordwapen met bliksemsnelle reflexen en een bovenmenselijke behendigheid. Bij het aanvaarden van zijn eerste missie ontdekt Wesley echter nog iets anders: iemand van het leven beroven is niet makkelijk, mar je eigen leven weer in handen nemen is nog een stuk moeilijker.', 2008, 'James McAvoy, Angelina Jolie, Morgan Freeman', 0),
(4, 'The Name of the Rose', 'Drama', 'Het is het werk van de duivel. Althans, dat beweren enkele kwaadsprekers wanneer een 14de-eeuwse klooster wordt opgeschrikt door een reeks bizarre sterfgevallen. Anderen leggen een verband tussen de doden en het Boek Openbaring. Maar Broeder William van Baskerville denkt er het zijne van. Hij is vastbesloten een moordenaar te pakken aan de hand van feiten en denkwerk, de werktuigen van een ketter. Sean Connery, die voor zijn vertolking van de geslepen William een BAFTA - de Britse Oscar - in de wacht sleepte, schittert in deze meeslepende bewerking van de bestseller van Umberto Eco. Christian Slater speelt de rol van Adso, het hulpje van de religieuze speurneus, een jongen knaap die zich in het schemergebied van zijn intellectueel enseksueel ontluiken bevindt. F. Murray Abraham, de Inquisiteur, is de vleesgeworden arrogantie. Regisseur Jean-Jacques Annaud verfilmde dit sfeervolle misdaadverhaal in een authentiek 12de-eeuws klooster, waar scherpgesneden gezichten uit het onverwachte duister opdoemen.', 1986, 'Sean Connery, F. Murray Abraham, Christian Slater, Ron Perlman', 0),
(5, 'Crank, High Voltage', 'Actie', 'Huurmoordenaar Chev Chellios is terug. Chev overleefde de duik uit een helikopter en voelt zich goed ... tot hij ontdekt dat zijn onverwoestbare hart werd vervangen door een kunstmatige pomp op batterijen. Voor de tijd om is en de batterijen plat, moet Chev en zijn vriendin (Amy Smart) het hoofd bieden aan Chinese gangsters, Mexicaanse bendelenden en boze pornosterren in deze polsversnellende, op adrenaline lopende actiethriller.', 2009, 'Jason statham, Amy Smart, Clifton Collins Jr., David Carradine', 0),
(6, 'The Last of the Mohicans', 'Speelfilm', 'The Last of the Mohicans van regisseur/co-schrijver Micheal Mann is een schitterend verhaal over een alles overstijgende liefde, een authentiek gedetailleerde beschrijving van een turbulent tijdperk in de koloniale geschiedenis van de VS en een spannend relaas over een oorlog die werd beslecht met vuursteengeweren en tomahawks. Daniel Day-Lewis (als Hawkeye) en Madeleine Stowe (als de Britse Cora) zijn geliefden die betrokken raken in het tumult van de Frans-Indiaanse Oorlog, in deze film uit 1992 die een Oscar won en waarvan de meeslepende muziek werd geschreven door Trevor Jones en Randy Edelman. Het verhaal zelf is een persoonlijke maatstaf voor Mann (Heat, The insider): de versie uit 1936 is de eerste film die hij zag in zijn kinderjaren. Het is moeiliijk om de bewondering uit zijn jeugdjaren niet te bespeuren in Hawkeye''s grootste heroïsche daden. Hier vergroot Mann dat dankzij een meesterlijke stijl die aantoont waarom hij een van de meest geestdriftige filmmakers is.', 1992, 'Daniel Day-Lewis, Madeleine Stowe, Jodhi May', 0);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `tbl_genres`
--

CREATE TABLE IF NOT EXISTS `tbl_genres` (
  `genre_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Naam` varchar(250) NOT NULL,
  PRIMARY KEY (`genre_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

--
-- Gegevens worden uitgevoerd voor tabel `tbl_genres`
--

INSERT INTO `tbl_genres` (`genre_ID`, `Naam`) VALUES
(5, 'Actie'),
(6, 'Actie/Thriller'),
(7, 'Actie/Komedie'),
(8, 'Thriller'),
(9, 'Komedie'),
(10, 'Drama'),
(11, 'Avonturenfilm'),
(12, 'Sci-Fi/Fantasy'),
(13, 'Horror'),
(14, 'Oorlogsfilm'),
(15, 'Misdaadfilm'),
(16, 'Historisch drama'),
(17, 'Musicalfilm'),
(18, 'Psychologische thriller'),
(19, 'Rampenfilm'),
(20, 'Western'),
(21, 'Romantiek'),
(22, 'Romantiek/Komedie'),
(23, 'Sportfilm'),
(24, 'Roadmovie'),
(29, 'TestGenre'),
(30, ''),
(31, ''),
(32, 'GenreTestJPA'),
(33, 'test again'),
(34, 'Speelfilm');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
