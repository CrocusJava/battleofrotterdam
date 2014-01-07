
USE battledb;

INSERT INTO Role  VALUES
(1, 'admin'),
(2, 'user'),
(3, 'guest');

INSERT INTO Address VALUES
(1, 'town 10', 'postcode 15', 'street 20', 'houseNumber 30', 'apartment 40');

INSERT INTO User VALUES
(1, 'Test', 'Test', 'Test', 'test', '098f6bcd4621d373cade4e832627b4f6', 'path', 'test@gmail.com', '0501010101', '1960-01-01', 1, 2, 0, 0, 0),
(11, 'Ray', 'O’', 'Sun', 'ray_login', '1111', 'c1.jpg', 'ray@gmail.com', '0501012020', '1985-02-02', 1, 2, 1, 1, 1),
(12, 'Joe', '', 'Morton', 'joe_login', '1111', 'c2.jpg', 'joe@gmail.com', '0501013030', '1979-03-03', 1, 2, 1, 1, 1),
(13, 'Jenny', '', 'Flex',  'jenny_login', '1111', 'c3.jpg', 'jenny@gmail.com', '0501014040', '1988-04-04', 1, 2, 1, 1, 1),
(14, 'Lupe', '', 'Lamora',  'lupe_login', '1111', 'c4.jpg', 'lupe@gmail.com', '0501015050', '1977-05-05', 1, 2, 1, 1, 1);

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
(1, 'remont1.jpg','2014-01-01','description of Rays_month_project_photo',1),
(2, 'remont11.jpg','2014-01-01','description of Rays_year_project_photo',2),
(3, 'remont3.jpg','2014-01-03','description of Joes month project',3),
(4, 'remont5.jpg','2014-01-03','description of JoesJoes_year_project_photo',4),
(5, 'remont13.jpg','2014-01-04','description of Jennys_year_project_photo',5),
(6, 'remont14.jpg','2014-01-05','description of Lupes_year_project_photo',6);

INSERT INTO Comment VALUES
(1, 'Lets go!','2014-01-01',11,1,1),
(2, 'Do it!','2014-01-01',11,2,2),
(3, 'It will be something... :)','2014-01-03',12,3,3),
(4, 'Hello!!!','2014-01-03',12,4,4),
(5, 'Nice try!','2014-01-04',13,5,5),
(6, 'I hope it is possible...','2014-01-05',14,6,6);

INSERT INTO Text VALUES
(1, 100, 'Your new password will be sent to your email', 'Uw nieuwe wachtwoord zal naar uw e-mail worden verzonden'),
(2, 200, 'Please check your email to complete your registration', 'Controleer uw e-mail om uw registratie te voltooien'),
(3, 300, 'Thank you! Now you can login and try create your first project', 'Dank je wel! Nu kunt u inloggen en probeer maak uw eerste project'),
(4, 310, 'Something WRONG. Please check your email again', 'Iets mis. Controleer uw e-mail opnieuw'),
(5, 500, 'Some general information about the site','Wat algemene informatie over de site'),
(6, 510, 'Some description of the video','Enkele beschrijving van de video'),
(7, 210, 'Dear, user thank you for registration on the Battle of Rotterdam site, please click on the link to complete your registration','Geachte, gebruiker bedankt voor registratie op de Battle of Rotterdam site, klik op de link om uw registratie te voltooien'),
(8, 110,'Your login: ','Uw loginnaam: '),
(9, 111,'Your new password: ','Uw nieuwe wachtwoord: '),
(10, 120,'Email not exist in the database','E-mail niet in de database');


INSERT INTO URL VALUES
(1, 100, 'Name of Battle video url', 'Value of Battle video url'),
(2, 110, 'Name of Link1 on Home-page', 'Value of Link1 on Home-page'),
(3, 120, 'Name of Link2 on Home-page', 'Value of Link2 on Home-page'),
(4, 130, 'Name of Link3 on Home-page', 'Value of Link3 on Home-page'),
(5, 140, 'Name of Link4 on Home-page', 'Value of Link4 on Home-page');