FROM postgres:9.6

ENV POSTGRES_USER root
ENV POSTGRES_PASSWORD 123
ENV POSTGRES_DB test

COPY /tmp/pgcustomconfig.conf /etc/postgresql

CMD ["postgres", "-c", "config_file=/etc/postgresql/pgcustomconfig.conf"]