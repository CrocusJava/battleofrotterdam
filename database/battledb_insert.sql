
USE battledb;

INSERT INTO Role  VALUES
(1, 'admin'),
(2, 'user'),
(3, 'guest');

INSERT INTO Address VALUES
(1, 'town 10', 'postcode 15', 'street 20', 'houseNumber 30', 'apartment 40');

INSERT INTO User VALUES
(1, 'Test', 'Test', 'Test', 'test', '098f6bcd4621d373cade4e832627b4f6', 'path', 'test@gmail.com', '0501010101', '1960-01-01', 1, 2, 0, 0, 0);

INSERT INTO CompetitionType VALUES
(1, 'year'),
(2, 'month');

INSERT INTO Competition VALUES
(1, 'Year Competition Name','description of Year Competition','2013-12-01','2014-12-01','2014-01-01',1,NULL),
(2, 'First Month Competition Name','description of First Month Competition','2013-12-01','2014-01-01','2013-12-10',2,NULL),
(3, 'Second Month Competition Name','description of Second Month Competition','2014-01-01','2014-02-01','2014-01-10',2,NULL),
(4, 'Third Month Competition Name','description of Third Month Competition','2014-02-01','2014-03-01','2014-02-10',2,NULL);

INSERT INTO Text VALUES
(1, 100, 'Your new password will be sent to your email', 'Uw nieuwe wachtwoord zal naar uw e-mail worden verzonden'),
(2, 200, 'Please check your email to complete your registration', 'Controleer uw e-mail om uw registratie te voltooien'),
(3, 300, 'Thank you! Now you can login and try create your first project', 'Dank je wel! Nu kunt u inloggen en probeer maak uw eerste project'),
(4, 310, 'Something WRONG. Please check your email again', 'Iets mis. Controleer uw e-mail opnieuw'),
(5, 500, 'Some general information about the site','Wat algemene informatie over de site'),
(6, 510, 'Some description of the video','Enkele beschrijving van de video');


INSERT INTO URL VALUES
(1, 100, 'Name of Battle video url', 'Value of Battle video url'),
(2, 110, 'Name of Link1 on Home-page', 'Value of Link1 on Home-page'),
(3, 120, 'Name of Link2 on Home-page', 'Value of Link2 on Home-page'),
(4, 130, 'Name of Link3 on Home-page', 'Value of Link3 on Home-page'),
(5, 140, 'Name of Link4 on Home-page', 'Value of Link4 on Home-page');