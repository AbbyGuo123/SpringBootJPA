CREATE TABLE user_group
(
    id BIGINT auto_increment primary key,
    user_id BIGINT,
    group_id BIGINT,
    create_date TIMESTAMP
);