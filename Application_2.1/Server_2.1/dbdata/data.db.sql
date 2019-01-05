BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "question" (
	"index"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"id"	TEXT,
	"question"	TEXT,
	"is_active"	TEXT,
	"created_on"	TEXT
);
CREATE TABLE IF NOT EXISTS "sentiment_analysis_results" (
	"id"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"email"	TEXT,
	"sa_result"	TEXT,
	"created_on"	TEXT
);
CREATE TABLE IF NOT EXISTS "results" (
	"id"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"question_id"	TEXT,
	"participent_email"	TEXT,
	"answer"	TEXT,
	"answerd_on"	TEXT
);
CREATE TABLE IF NOT EXISTS "developers" (
	"id"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"username"	TEXT,
	"password"	TEXT,
	"created_on"	TEXT
);
CREATE TABLE IF NOT EXISTS "participant_data" (
	"id"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"full_name"	TEXT,
	"email"	TEXT,
	"country"	TEXT,
	"device_manufacturer"	TEXT,
	"device_os"	TEXT,
	"participated_on"	TEXT
);
INSERT INTO "question" VALUES (1,'1','Overall look and feel of the app is innovative and updated','true','2018/12/15 09:02:01');
INSERT INTO "question" VALUES (2,'2','I can access information quickly on this app','true','2018/12/15 09:02:01');
INSERT INTO "question" VALUES (3,'3','It is easy to remember where to find things','true','2018/12/15 09:02:01');
INSERT INTO "question" VALUES (4,'4','User Interfaces have the right amount of information','true','2018/12/15 09:02:01');
INSERT INTO "question" VALUES (5,'5','The app’s content would keep me coming back','true','2018/12/15 09:02:01');
INSERT INTO "question" VALUES (6,'6','The App work without freezing up','true','2018/12/15 09:02:01');
INSERT INTO "question" VALUES (7,'7','The app is well-suited for first-time visitors','true','2018/12/15 09:02:01');
INSERT INTO "question" VALUES (8,'8','I would pay for this app','true','2018/12/15 09:02:01');
INSERT INTO "question" VALUES (9,'thisisatestquestion','this is a test question','false','2019/01/04 20:54:54');
INSERT INTO "question" VALUES (10,'good','test','test','test');
INSERT INTO "sentiment_analysis_results" VALUES (1,'chamodya@gmail.com','joy','2019/01/04 08:52:33');
INSERT INTO "sentiment_analysis_results" VALUES (2,'chamodya@gmail.com','joy','2019/01/04 08:54:25');
INSERT INTO "sentiment_analysis_results" VALUES (3,'kjn','joy','2019/01/04 20:51:23');
INSERT INTO "results" VALUES (1,'1','chamodya@gmail.com','Strongly Agree','2019/01/04 08:52:13');
INSERT INTO "results" VALUES (2,'2','chamodya@gmail.com','Disagree','2019/01/04 08:52:18');
INSERT INTO "results" VALUES (3,'3','chamodya@gmail.com','Strongly Disagree','2019/01/04 08:52:19');
INSERT INTO "results" VALUES (4,'4','chamodya@gmail.com','Disagree','2019/01/04 08:52:21');
INSERT INTO "results" VALUES (5,'5','chamodya@gmail.com','Agree','2019/01/04 08:52:23');
INSERT INTO "results" VALUES (6,'6','chamodya@gmail.com','Strongly Agree','2019/01/04 08:52:24');
INSERT INTO "results" VALUES (7,'7','chamodya@gmail.com','Strongly Disagree','2019/01/04 08:52:25');
INSERT INTO "results" VALUES (8,'8','chamodya@gmail.com','Disagree','2019/01/04 08:52:26');
INSERT INTO "results" VALUES (9,'usercomment','chamodya@gmail.com','it was good','2019/01/04 08:52:33');
INSERT INTO "results" VALUES (10,'1','chamodya@gmail.com','Strongly Agree','2019/01/04 08:53:59');
INSERT INTO "results" VALUES (11,'2','chamodya@gmail.com','Disagree','2019/01/04 08:54:00');
INSERT INTO "results" VALUES (12,'3','chamodya@gmail.com','Strongly Disagree','2019/01/04 08:54:02');
INSERT INTO "results" VALUES (13,'4','chamodya@gmail.com','Agree','2019/01/04 08:54:04');
INSERT INTO "results" VALUES (14,'5','chamodya@gmail.com','Strongly Agree','2019/01/04 08:54:05');
INSERT INTO "results" VALUES (15,'6','chamodya@gmail.com','Disagree','2019/01/04 08:54:06');
INSERT INTO "results" VALUES (16,'7','chamodya@gmail.com','Strongly Disagree','2019/01/04 08:54:09');
INSERT INTO "results" VALUES (17,'8','chamodya@gmail.com','Agree','2019/01/04 08:54:10');
INSERT INTO "results" VALUES (18,'usercomment','chamodya@gmail.com','it was good','2019/01/04 08:54:25');
INSERT INTO "results" VALUES (19,'1','kjn','Disagree','2019/01/04 20:50:45');
INSERT INTO "results" VALUES (20,'2','kjn','Strongly Agree','2019/01/04 20:50:47');
INSERT INTO "results" VALUES (21,'3','kjn','Disagree','2019/01/04 20:50:54');
INSERT INTO "results" VALUES (22,'4','kjn','Strongly Agree','2019/01/04 20:50:57');
INSERT INTO "results" VALUES (23,'5','kjn','Strongly Disagree','2019/01/04 20:50:59');
INSERT INTO "results" VALUES (24,'6','kjn','Agree','2019/01/04 20:51:01');
INSERT INTO "results" VALUES (25,'7','kjn','Strongly Agree','2019/01/04 20:51:03');
INSERT INTO "results" VALUES (26,'8','kjn','Disagree','2019/01/04 20:51:13');
INSERT INTO "results" VALUES (27,'usercomment','kjn','good, i guess','2019/01/04 20:51:23');
INSERT INTO "developers" VALUES (1,'admin','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8',NULL);
INSERT INTO "participant_data" VALUES (1,'chamodya wimansha','chamodya@gmail.com','SL','samsung','and','2019/01/04 08:54:32');
INSERT INTO "participant_data" VALUES (2,'chamodaund','kjn','kj','kj','jkn','2019/01/04 20:51:46');
COMMIT;
