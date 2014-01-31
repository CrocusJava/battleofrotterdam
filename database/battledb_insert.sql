
USE battledb;

INSERT INTO Role  VALUES
(1, 'admin'),
(2, 'user'),
(3, 'guest');

INSERT INTO Address VALUES
(1, 'town 10', 'postcode 15', 'street 20', 'houseNumber 30', 'apartment 40');

INSERT INTO User VALUES
(1, 'Test', 'Test', 'Test', 'test', '098f6bcd4621d373cade4e832627b4f6', 'path', 'test@gmail.com', '0501010101', '1960-01-01', 1, 1, 1, 1, 1),
(2, 'Root', 'Root', 'Root', 'root', '111', 'path', 'root@gmail.com', '0501010101', '1960-01-01', 1, 1, 1, 1, 1),
(11, 'Ray', 'O’', 'Sun', 'ray_login', '1111', 'img/c1.jpg', 'ray@gmail.com', '0501012020', '1985-02-02', 1, 1, 1, 1, 1),
(12, 'Joe', '', 'Morton', 'joe_login', '1111', 'img/c2.jpg', 'joe@gmail.com', '0501013030', '1979-03-03', 1, 2, 1, 1, 1),
(13, 'Jenny', '', 'Flex',  'jenny_login', '1111', 'img/c3.jpg', 'jenny@gmail.com', '0501014040', '1988-04-04', 1, 2, 1, 1, 1),
(14, 'Lupe', '', 'Lamora',  'lupe_login', '1111', 'img/c4.jpg', 'lupe@gmail.com', '0501015050', '1977-05-05', 1, 2, 1, 1, 1);

INSERT INTO CompetitionType VALUES
(1, 'year'),
(2, 'month');

INSERT INTO Competition VALUES
(1, 'Year Competition Name','description of Year Competition','2013-12-01','2014-12-01','2014-01-01',1,NULL),
(2, 'First Month Competition Name','description of First Month Competition','2013-12-01','2014-01-01','2013-12-10',2,NULL),
(3, 'Second Month Competition Name','description of Second Month Competition','2014-01-01','2014-02-01','2014-01-10',2,NULL),
(4, 'Third Month Competition Name','description of Third Month Competition','2014-02-01','2014-03-01','2014-02-10',2,NULL);

INSERT INTO Project VALUES
(1, 'Rays month project','description of Rays month project','2014-01-01',11,3,1),
(2, 'Rays year project','description of Rays year project','2014-01-01',11,1,1),
(3, 'Joes month project','description of Joes month project','2014-01-03',12,3,1),
(4, 'Joes year project','description of Joes year project','2014-01-03',12,1,1),
(5, 'Jennys year project','description of Jennys year project','2014-01-04',13,1,1),
(6, 'Lupes year project','description of Lupes year project','2014-01-05',14,1,1);

INSERT INTO Photo VALUES
(1, 'img/remont1.jpg','2014-01-01','description of Rays_month_project_photo',1),
(2, 'img/remont11.jpg','2014-01-01','description of Rays_year_project_photo',2),
(3, 'img/remont3.jpg','2014-01-03','description of Joes month project',3),
(4, 'img/remont5.jpg','2014-01-03','description of JoesJoes_year_project_photo',4),
(5, 'img/remont13.jpg','2014-01-04','description of Jennys_year_project_photo',5),
(6, 'img/remont14.jpg','2014-01-05','description of Lupes_year_project_photo',6),
(7, 'img/remont8.jpg','2014-01-06','description of Rays_month_project_photo',1),
(8, 'img/remont12.jpg','2014-01-07','description of Rays_year_project_photo',2),
(9, 'img/remont2.jpg','2014-01-08','description of Joes month project',3),
(10, 'img/remont4.jpg','2014-01-09','description of JoesJoes_year_project_photo',4),
(11, 'img/remont9.jpg','2014-01-10','description of Jennys_year_project_photo',5),
(12, 'img/remont10.jpg','2014-01-11','description of Lupes_year_project_photo',6),
(13, 'img/remont15.jpg','2014-01-11','description of Rays_year_project_photo',2),
(14, 'img/remont16.jpg','2014-01-12','description of Joes month project',3),
(15, 'img/remont17.jpg','2014-01-13','description of JoesJoes_year_project_photo',4),
(16, 'img/remont18.jpg','2014-01-14','description of Jennys_year_project_photo',5),
(17, 'img/remont19.gif','2014-01-15','description of Lupes_year_project_photo',6),
(18, '/controller?command=getphoto&photoname=photo114year.jpg', '2014-01-18 18:12:38', 'photo114year.jpg', 2),
(19, '/controller?command=getphoto&photoname=photo115year.jpg', '2014-01-18 18:26:00', 'photo115year.jpg', 2);


INSERT INTO Comment VALUES
(1, 'Lets go!','2014-01-01',11,1,1),
(2, 'Do it!','2014-01-01',11,2,2),
(3, 'It will be something... :)','2014-01-03',12,3,3),
(4, 'Hello!!!','2014-01-03',12,4,4),
(5, 'Nice try!','2014-01-04',13,5,5),
(6, 'I hope it is possible...','2014-01-05',14,6,6),
(7, 'blabla111', '2014-01-22 18:27:22', 1, 2, null);

INSERT INTO Text VALUES
(1, 100, 'Your new password will be sent to your email', 'Uw nieuwe wachtwoord zal naar uw e-mail worden verzonden'),
(2, 200, 'Please check your email to complete your registration', 'Controleer uw e-mail om uw registratie te voltooien'),
(3, 300, 'Thank you! Now you can login and try create your first project', 'Dank je wel! Nu kunt u inloggen en probeer maak uw eerste project'),
(4, 310, 'Something WRONG. Please check your email again', 'Iets mis. Controleer uw e-mail opnieuw'),
(5, 500, 'Welcome to the website of the Battle of Rotterdam. On this website you can upload pictures of the renovation and you could win a cash prize!\r\nAfter you have created an account, you can upload photos and view the current position on the ranking page.\r\nShould you have any questions, please look first at the FAQ page.\r\nUnder "Links" you will find a variety of relevant websites to make your renovation a success.\r\n Good luck with the Battle of Rotterdam!', 'Welkom op de website van de Battle of Rotterdam. Op deze website kunt u uw foto’s van de verbouwing insturen en maakt u kans op een geldprijs!\r\nNadat u een account aangemaakt heeft kunt u foto’s uploaden en de huidige plaats bekijken op de ranking page.\r\nMocht u nog vragen hebben kijkt u dan eerst even bij de FAQ pagina.\r\nOnder “links” vind u diverse relevante websites om uw verbouwing tot een succes te maken.\r\n Veel succes met de Battle of Rotterdam!'),
(6, 510, 'Some description of the video', 'Enkele beschrijving van de video'),
(7, 210, 'Dear, user thank you for registration on the Battle of Rotterdam site, please click on the link to complete your registration', 'Geachte, gebruiker bedankt voor registratie op de Battle of Rotterdam site, klik op de link om uw registratie te voltooien'),
(8, 110, 'Your login: ', 'Uw loginnaam: '),
(9, 111, 'Your new password: ', 'Uw nieuwe wachtwoord: '),
(10, 120, 'Email not exist in the database', 'E-mail niet in de database'),
(11, 520, 'If you participate in the Battle of Rotterdam the remodelling you submit should be done by yourself. When it turns out that this is not the case, you will be disqualified and you will not be able to participate in the future.\r\nYou can only participate once in the battle of Rotterdam with a certain renovation. If this is not the case it will be seen as fraud and you’ll be disqualified. ', 'Als u deelneemt aan de Battle of Rotterdam moet de verbouwing door uzelf gedaan zijn. Wanneer blijkt dat dit niet het geval is zal u gediskwalificeerd worden en u zal in de toekomst ook niet meer deel kunnen nemen. \r\nU kan slechts eenmaal deelnemen aan de Battle of Rotterdam met een betreffende verbouwing. Als dit niet het geval is zal dit worden gezien als fraude. '),
(12, 530, 'The city of Rotterdam is struggling with overdue maintenance of houses in the city. People often do not know how to redecorate their home and when they know it''s often been a problem. In addition, people do not see the need of redecorating their home, often because they do not live the rest of their lives in the same house. The consequence of this is that the houses remain. This damages the image of Rotterdam as a city and cost the municipality a lot of money.', 'De gemeente Rotterdam kampt met achterstallig onderhoud van huizen in de stad. Mensen weten vaak niet hoe ze hun huis moeten opknappen en wanneer ze het wel weten is tijd vaak een probleem. Daarnaast zien mensen de noodzaak niet van het opknappen van hun huis, vaak omdat ze er niet de rest van hun leven blijven wonen. Het gevolg hiervan is dat de huizen er lelijk bij blijven staan. Dit beschadigt het beeld van Rotterdam als stad en kost de gemeente ook een hoop geld, aangezien zij op het moment de huizen laten opknappen via makelaars.  ')
,
(13, 540, 'For these problems to get the municipality of Rotterdam teamed up with students from the Business IT & Management at University of Applied Sciences Rotterdam. The municipality wants to encourage the population to renovate their houses through a number of projects.', 'Om deze problemen toe te komen is de gemeente Rotterdam een samenwerking aangegaan met studenten van de opleiding Business IT & Management van de Hogeschool Rotterdam. De gemeente wil met verschillende projecten de huizen van Rotterdam in status verbeteren door ze op te laten knappen door de bevolking zelf. '),
(14, 600, 'Why would I compete?', 'Waarom zou ik meedoen met de Battle? '),
(15, 605, 'There are a number of reasons such as: sharing your remodelling with people from your neighbourhood, winning the prize money and the thrill of the competition.', 'Er zijn een aantal redenen zoals: het delen van uw verbouwing met mensen uit de buurt, het winnen van de geldprijs en de spanning van de strijd. '),
(16, 610, 'What can I win?', 'Wat kan ik winnen? '),
(17, 615, 'That depends on the competition. For the annual competition it is 10.000,- Euro and for the monthly 1.000,- Euro.', 'Dat verschilt aan de competitie waaraan in mee doet. Voor je jaarlijkse competitie is dit 10.000,- euro en voor de maandelijkse 1.000,- euro.'),
(18, 620, 'Who organises this competition?', 'Wie organiseert de competitie?'),
(19, 625, 'The Battle of Rotterdam organized by employees of the municipality of Rotterdam in collaboration with students of the University of Applied Sciences Rotterdam.', 'The Battle of Rotterdam wordt georganiseerd door medewerkers van de gemeente Rotterdam in samenwerking met studenten van de Hogeschool Rotterdam.'),
(20, 630, 'Where can I find information about renovation? ', 'Waar kan ik informatie vinden over verbouwen en renoveren? '),
(21, 635, 'On our website you can find several links that direct you to various informative site pages. ', 'Op onze website kunt u verschillende links vinden die u doorverwijzen naar diverse informatieve sites.'),
(22, 640, 'Where can I report fraud? ', 'Waar kan ik fraude vermelden?'),
(23, 645, 'You can mark an entry as fraud in the submission itself. ', 'U kunt een inzending markeren als fraude bij de inzending zelf. '),
(24, 521, 'Rules and regulations', 'Regels en voorschriften'),
(25, 531, 'Information about the Battle of Rotterdam ', 'Informatie over the Battle of Rotterdam'),
(26, 541, 'About those who made it', 'Over de ontwikkelaars'),
(27, 551, 'General Information', 'Algemene informatie'),
(28, 550, 'On this website you can upload pictures of the renovation and you could win a cash prize!\r\nAfter you have created an account, you can upload photos and view the current position on the ranking page.\r\nShould you have any questions, please look first at the FAQ page.\r\nUnder "Links" you will find a variety of relevant websites to make your renovation a success.', 'Op deze website kunt u uw foto’s van de verbouwing insturen en maakt u kans op een geldprijs!\r\nNadat u een account aangemaakt heeft kunt u foto’s uploaden en de huidige plaats bekijken op de ranking page.\r\nMocht u nog vragen hebben kijkt u dan eerst even bij de FAQ pagina.\r\nOnder “links” vind u diverse relevante websites om uw verbouwing tot een succes te maken.'),
(29, 700, 'Some short text "about us"', 'Sommige korte tekst "over ons"'),
(30, 710, '12345 / Some Street\r\nPortland, USA', '12345 / Sommige Straat\r\nPortland, USA'),
(34, 720, 'mail@must.be.here ', 'mail@must.be.here'),
(35, 730, 'phone: +1 (44) 123-45-67 ', 'telefoon: +1 (44) 123-45-67'),
(36, 740, 'fax: +1 (44) 123-45-63 ', 'fax: +1 (44) 123-45-63'),
(37, 750, 'Skype Me ', 'Skype Me'),
(38, 800, 'Нour project is registered','Uw project is geregistreerd'),
(39, 10, 'Battle of Rotterdam will start soon!','Battle of Rotterdam zal binnenkort beginnen!'),
(40, 20, 'Celebration in honor of the opening of the "Battle of Rotterdam!"','Viering ter ere van de opening van de "Slag van Rotterdam!"'),
(41, 30, 'Lets make our city more beautiful!','Laten we onze stad mooier!'),
(42, 40, '',''),
(43, 50, '',''),
(44, 60, '',''),
(45, 70, '',''),
(60, 80, '',''),
(61, 90, '',''),
(46, 1000, 'e-mail sent', 'e-mail verzonden'),
(47, 1010, 'Changes are made', 'Wijzigingen worden aangebracht'),
(48, 560, 'Terms & Conditions information', 'Voorwaarden informatie'),
(49, 561, 'Terms & Conditions', 'Algemene Voorwaarden'),
(50, 650, '', ''),
(51, 655, '', ''),
(52, 660, '', ''),
(53, 665, '', ''),
(54, 670, '', ''),
(55, 675, '', ''),
(56, 680, '', ''),
(57, 685, '', ''),
(58, 690, '', ''),
(59, 695, '', ''),
(62, 1100, 'Your opportunity to comment on disabled. Please contact the administration.', 'Uw kans om opmerkingen te maken over een handicap. Neem contact op met de administratie.'),
(63, 1110, 'Your account is blocked. Please contact the administration.', 'Uw account is geblokkeerd. Neem contact op met de administratie.'),
(64, 1120, 'Wrong login or password', 'Verkeerde login of wachtwoord');


INSERT INTO URL VALUES
(1, 100, 'Name of Battle video url', 'Value of Battle video url'),
(2, 110, 'Name of Link1 on Home-page', 'Value of Link1 on Home-page'),
(3, 120, 'Name of Link2 on Home-page', 'Value of Link2 on Home-page'),
(4, 130, 'Name of Link3 on Home-page', 'Value of Link3 on Home-page'),
(5, 140, 'Name of Link4 on Home-page', 'Value of Link4 on Home-page');

INSERT INTO News VALUES
(1, 'img/news1.jpg','2014-01-15', 'Battle of Rotterdam will start soon!','Battle of Rotterdam zal binnenkort beginnen!', 'Battle of Rotterdam will start soon!','Battle of Rotterdam zal binnenkort beginnen!'),
(2, 'img/news2.jpg','2014-01-16', 'Celebration in honor of the opening of the "Battle of Rotterdam!"','Viering ter ere van de opening van de "Slag van Rotterdam!"', 'Celebration in honor of the opening of the "Battle of Rotterdam!"','Viering ter ere van de opening van de "Slag van Rotterdam!"'),
(3, 'img/news3.jpg','2014-01-17', 'Lets make our city more beautiful!','Laten we onze stad mooier!', 'Lets make our city more beautiful!','Laten we onze stad mooier!');
