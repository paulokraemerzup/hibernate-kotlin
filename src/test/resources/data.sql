insert into author(id, name) values
('793e9c40-e395-4f51-ad22-81ed5f6195f3', 'Léo Millon');

insert into article(id, content) values
('1f72f77b-9079-426d-ba17-1772627065e5', 'Some article content');

insert into comment(id, content, author_id, article_id) values
('f9ae67e7-6064-4034-8fc6-462c127498df', 'Some comment...', '793e9c40-e395-4f51-ad22-81ed5f6195f3', '1f72f77b-9079-426d-ba17-1772627065e5');