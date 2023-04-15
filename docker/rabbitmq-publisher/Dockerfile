FROM ubuntu
RUN apt-get update && \
    apt-get install -y amqp-tools rabbitmq-server


COPY script.sh .
RUN chmod 700 script.sh
CMD ["./script.sh"]