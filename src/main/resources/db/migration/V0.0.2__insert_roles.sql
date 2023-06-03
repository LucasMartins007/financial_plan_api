INSERT INTO role (id, role, include_date, update_date, active)
VALUES
(nextval('role_seq'), 'USER', '2023-01-01', '2023-01-01', true),
(nextval('role_seq'), 'ADMIN', '2023-01-02', '2023-01-02', true);
