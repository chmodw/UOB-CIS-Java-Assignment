BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "questions" (
	"id"	INTEGER PRIMARY KEY AUTOINCREMENT,
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
CREATE TABLE IF NOT EXISTS "participent_data" (
	"id"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"full_name"	TEXT,
	"email"	TEXT,
	"country"	TEXT,
	"device_manufacturer"	TEXT,
	"device_os"	TEXT,
	"participated_on"	TEXT
);
INSERT INTO "questions" VALUES (1,'Overall look and feel of the app is innovative and updated','true','2018/12/15 09:02:01');
INSERT INTO "questions" VALUES (2,'I can access information quickly on this app','true','2018/12/15 09:02:01');
INSERT INTO "questions" VALUES (3,'It is easy to remember where to find things','true','2018/12/15 09:02:01');
INSERT INTO "questions" VALUES (4,'User Interfaces have the right amount of information','true','2018/12/15 09:02:01');
INSERT INTO "questions" VALUES (5,'The app’s content would keep me coming back','true','2018/12/15 09:02:01');
INSERT INTO "questions" VALUES (6,'The App work without freezing up','true','2018/12/15 09:02:01');
INSERT INTO "questions" VALUES (7,'The app is well-suited for first-time visitors','true','2018/12/15 09:02:01');
INSERT INTO "questions" VALUES (8,'I would pay for this app','true','2018/12/15 09:02:01');
INSERT INTO "developers" VALUES (1,'admin','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8',NULL);
COMMIT;
