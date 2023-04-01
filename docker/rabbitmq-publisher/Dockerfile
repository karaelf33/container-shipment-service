FROM rabbitmq:3-management-alpine

RUN apk add --no-cache coreutils

COPY script.sh .
RUN chmod 700 script.sh

CMD ["./script.sh"]
