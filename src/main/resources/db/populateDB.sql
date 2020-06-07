DELETE FROM securities;
DELETE FROM histories;
ALTER SEQUENCE global_seq RESTART WITH 3;

INSERT INTO securities (id, secid, name, emitent_title)
VALUES
  (1, 'ABC', 'ABC ПАО ао', 'ABC ПАО ао'),
  (2, 'DEF', 'DEF 500', 'DEF 500');

INSERT INTO histories (trade_date, num_trades, open, close, secid, security_id)
VALUES
  ('2020-01-01', 100, 15.1, 15.3, 'ABC', 1),
  ('2020-01-02', 101, 15.2, 15.4, 'ABC', 1),
  ('2020-02-01', 110, 15.3, 15.5, 'DEF', 2);
