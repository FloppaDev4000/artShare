PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "File" (
	"fileId"	INTEGER,
	"postId"	INTEGER,
	"userId"	INTEGER,
	"path"	TEXT,
	PRIMARY KEY("fileId" AUTOINCREMENT)
);
INSERT INTO File VALUES(1,1,1,'res/userFiles/images/auctioneer.png');
INSERT INTO File VALUES(2,2,1,'res/userFiles/images/qbert.JPG');
INSERT INTO File VALUES(3,12,1,'res/userFiles/images\Water_002_NORM.jpg');
INSERT INTO File VALUES(4,11,1,'res/userFiles/images\Leather027_4K-JPG_NormalDX.jpg');
INSERT INTO File VALUES(7,2,1,'res/userFiles/images\GDTlL1_XAAApWzD.jpg');
INSERT INTO File VALUES(8,17,1,'res/userFiles/images\GDTlL1_XAAApWzD.jpg');
INSERT INTO File VALUES(9,18,1,'res/userFiles/images\qbert.JPG');
INSERT INTO File VALUES(10,19,1,'res/userFiles/images\allen.png');
INSERT INTO File VALUES(11,20,1,'res/userFiles/images\pacman.jpg');
INSERT INTO File VALUES(12,21,1,'res/userFiles/images\leather_normal_map.jpg');
INSERT INTO File VALUES(13,22,1,'res/userFiles/images\cat.png');
INSERT INTO File VALUES(14,23,2,'res/userFiles/images\boat.png');
INSERT INTO File VALUES(15,24,6,'res/userFiles/images\folks.png');
INSERT INTO File VALUES(16,25,1,'res/userFiles/images\face.png');
INSERT INTO File VALUES(17,26,1,'res/userFiles/images\sun.png');
INSERT INTO File VALUES(18,27,1,'res/userFiles/images\face2.png');
INSERT INTO File VALUES(19,28,1,'res/userFiles/images\face2.png');
CREATE TABLE IF NOT EXISTS "Interaction" (
	"interactionId"	INTEGER,
	"postId"	INTEGER,
	"userId"	INTEGER,
	"type"	INTEGER,
	"comment"	TEXT,
	PRIMARY KEY("interactionId" AUTOINCREMENT)
);
INSERT INTO Interaction VALUES(115,23,1,2,'I love this image!');
INSERT INTO Interaction VALUES(116,22,2,2,'nice cat');
INSERT INTO Interaction VALUES(117,24,2,2,'cool guys');
INSERT INTO Interaction VALUES(118,26,2,2,'its awesome');
INSERT INTO Interaction VALUES(119,24,1,2,'this is cool');
INSERT INTO Interaction VALUES(120,25,1,0,NULL);
INSERT INTO Interaction VALUES(121,24,1,0,NULL);
INSERT INTO Interaction VALUES(125,22,1,0,NULL);
INSERT INTO Interaction VALUES(127,23,1,2,'test comment');
INSERT INTO Interaction VALUES(128,25,1,1,NULL);
CREATE TABLE IF NOT EXISTS "User" (
	"userId"	INTEGER,
	"username"	TEXT,
	"password"	TEXT,
	"email"	TEXT,
	"isVerified"	INTEGER DEFAULT 0,
	"bio"	TEXT DEFAULT 'What''s good, G?',
	PRIMARY KEY("userId" AUTOINCREMENT)
);
INSERT INTO User VALUES(1,'Adam','password','c00299231@setu.ie',0,'I am adam');
INSERT INTO User VALUES(2,'- Bird -','password','dummy@lameass.com',0,'My name is Bird');
INSERT INTO User VALUES(6,'Dave','alvin','dave@mail.com',0,'i am dave');
INSERT INTO User VALUES(7,'Hughie','Password1!','fdglkjk.ghfdjkhgjdf@fkjghjkdsfhgdf.com',0,'i am hugihie');
INSERT INTO User VALUES(9,'seville','paswold','sev@mail.com',0,'i am seville');
CREATE TABLE IF NOT EXISTS "Post" (
	"postId"	INTEGER,
	"title"	TEXT,
	"description"	TEXT,
	"userId"	INTEGER,
	"reported"	INTEGER DEFAULT 0,
	PRIMARY KEY("postId" AUTOINCREMENT)
);
INSERT INTO Post VALUES(22,'Cat!','I drew my cat.',1,0);
INSERT INTO Post VALUES(23,'- Boat Scene -','landscape of a boat on the water',2,1);
INSERT INTO Post VALUES(24,'FOLKS','Just some guys',6,1);
INSERT INTO Post VALUES(25,'The Face','image of a face',1,0);
INSERT INTO Post VALUES(26,'The Sun','this thing is awesome',1,0);
INSERT INTO sqlite_sequence VALUES('File',19);
INSERT INTO sqlite_sequence VALUES('Interaction',128);
INSERT INTO sqlite_sequence VALUES('User',13);
INSERT INTO sqlite_sequence VALUES('Post',28);
COMMIT;
