How to
------
1. docker build test-postgres -t test-postgres
2. docker run -p 5432:5432 -d --name test-postgres test-postgres
3. docker attach test-postgres