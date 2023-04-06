CREATE TABLE self_referencing_table (
  id INT PRIMARY KEY,
  name VARCHAR(50),
  parent_id INT,
  parent_name VARCHAR(50)
);

INSERT INTO self_referencing_table (id, name, parent_id, parent_name) VALUES (0, 'root', NULL, NULL);
INSERT INTO self_referencing_table (id, name, parent_id, parent_name) VALUES (1, 'root1', 0, 'root');
INSERT INTO self_referencing_table (id, name, parent_id, parent_name) VALUES (2, 'child1', 1, 'root1');
INSERT INTO self_referencing_table (id, name, parent_id, parent_name) VALUES (3, 'child2', 1, 'root1');
INSERT INTO self_referencing_table (id, name, parent_id, parent_name) VALUES (4, 'root2', 0, 'root');
INSERT INTO self_referencing_table (id, name, parent_id, parent_name) VALUES (5, 'child3', 4, 'root2');


WITH RECURSIVE tree AS (
  SELECT * FROM self_referencing_table WHERE id = 1
  UNION ALL
  SELECT s.* FROM self_referencing_table s
  JOIN tree ON s.parent_id = tree.id
)
SELECT * FROM tree;