INSERT INTO book (id, name, category, sell_count, create_at) VALUES
('7c9649e3-944a-4bfc-a332-e77c3ce517af', '열 번의 산책', '인문', 9000, NOW()),
('c164e06d-a57c-4045-a03d-43ce3b33d09a', '숲길', '인문', 12000, NOW()),
('f60dfe05-ba02-4f18-b663-eb0f0d2be4c9', '바닷마을 인문학', '인문', 13500, NOW()),
('bf4f57d6-f2bd-4c04-9138-2d214a943019', '트렌드 코리아 2020', '경제', 25400, NOW()),
('0918b305-093c-4d83-bcdf-49ec86a701ed', '부의 인문학', '경제', 14500, NOW()),
('faaacd46-240a-434c-a210-a3de0d6d9292', '넛지', '경제', 13500, NOW()),
('d02f77b1-51de-4505-ad87-5e6dc3dfa4c2', '일의 기쁨과 슬픔', '소설', 11000, NOW()),
('d41b537f-3f0b-4d84-9e7f-d33668c4a3bc', '아몬드', '소설', 12000, NOW()),
('875125be-c1a4-4496-a7b5-9b2cbf39a2b3', '한국단편소설 40', '소설', 14700, NOW()),
('70afb424-7223-42df-9881-96a6284eacc2', '대한민국 요즘 여행', '여행', 16920, NOW());


INSERT INTO PUBLIC.MEMBER (ID, CREATED_DATE, EMAIL, INPUT_NAME, MODIFIED_DATE, PASSWORD) VALUES (1, '2021-03-12 14:12:51.503000', 'admin', 'adminA', '2021-03-12 14:12:51.503000', '$2a$10$nMh5luklO0zJCCZDtrDbB.ZDDBJunY8tzzu1AamlMT4FyprebX7I2');