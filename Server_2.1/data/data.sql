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
COMMIT;
