
INSERT INTO PUBLIC.MEMBER (ID, CREATED_DATE, EMAIL, INPUT_NAME, MODIFIED_DATE, PASSWORD) VALUES (1, '2021-03-12 14:12:51.503000', 'admin', 'adminA', '2021-03-12 14:12:51.503000', '$2a$10$nMh5luklO0zJCCZDtrDbB.ZDDBJunY8tzzu1AamlMT4FyprebX7I2');
INSERT INTO PUBLIC.MEMBER (ID, CREATED_DATE, EMAIL, INPUT_NAME, MODIFIED_DATE, PASSWORD) VALUES (2, '2021-03-13 01:22:31.137000', 'user1@naver.com', 'user1', '2021-03-13 01:22:31.137000', '$2a$10$jKauT49aL.0U9pM78uqP6./HVmKjCHXdhyj1TvaX3/OxIux/Z7mlC');

INSERT INTO PUBLIC.BOARD (ID, CONTENT,  INSERT_TIME, TITLE, UPDATE_TIME, WRITER) VALUES (1, 'TEST', '2021-03-13 01:23:04.153000', 'TEST', '2021-03-13 01:23:04.153000', 'user1');
INSERT INTO PUBLIC.BOARD (ID, CONTENT,  INSERT_TIME, TITLE, UPDATE_TIME, WRITER) VALUES (2, 'Test2',  '2021-03-13 01:23:25.129000', 'TEST2', '2021-03-13 01:23:25.129000', 'user1');

INSERT INTO PUBLIC.BOARDFILE (ID, FILE_PATH, FILENAME, BOARDID,ORIG_FILENAME) VALUES (1, '/Users/ddinggo/Project_N/ddingoboard\files\557fcf0916d49608d8b553be09ede20a', '557fcf0916d49608d8b553be09ede20a', 1,'TEST.docx');
INSERT INTO PUBLIC.BOARDFILE (ID, FILE_PATH, FILENAME, BOARDID,ORIG_FILENAME) VALUES (2, '/Users/ddinggo/Project_N/ddingoboard\files\229c988d45ce0222bd5e710056a58de7', '229c988d45ce0222bd5e710056a58de7', 2,'test.pptx');