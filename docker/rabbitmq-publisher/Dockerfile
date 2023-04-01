FROM ubuntu
RUN apt-get update && \
    apt-get install -y amqp-tools

COPY script.sh .
RUN chmod 700 script.sh
CMD ["./script.sh"]