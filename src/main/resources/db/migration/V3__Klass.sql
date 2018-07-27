CREATE TABLE klass
(
    id BIGINT auto_increment primary key,
    klass_name varchar(20),
    create_date TIMESTAMP,
    leader_id BIGINT
);