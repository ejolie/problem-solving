-- Create a new table called 'ANIMAL_INS' in schema 'PG'
-- Drop the table if it already exists
IF OBJECT_ID('PG.ANIMAL_INS', 'U') IS NOT NULL
DROP TABLE PG.ANIMAL_INS
GO
-- Create the table in the specified schema
CREATE TABLE PG.ANIMAL_INS
(
    ANIMAL_INSId [NVARCHAR](50) NOT NULL PRIMARY KEY, -- primary key column
    ANIMAL_TYPE [NVARCHAR](50) NOT NULL,
    DATETIME DATETIME NOT NULL,
    INTAKE_CONDITION [NVARCHAR](50) NOT NULL,
    NAME [NVARCHAR](50) NOT NULL,
    SEX_UPON_INTAKE [NVARCHAR](50) NOT NULL,
);
GO