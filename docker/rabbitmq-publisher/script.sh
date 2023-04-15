#!/bin/bash

rabbitmqadmin declare queue --username=guest --password=guest --host="${RABBITMQ_HOST}" --port=15672 name=shipment

rabbitmqadmin declare binding --username=guest --password=guest --host="${RABBITMQ_HOST}" --port=15672 source=amq.fanout destination_type=queue destination=shipment routing_key=shipment


while :; do
  SHIPMENT="{\"shipmentId\": $(date +%s%N), \"origin\": \"Frankfurt\", \"destination\": \"Hamburg\", \"customerId\": \"customer$RANDOM\", \"createdDate\": $(date +%s%N), \"fragile\": true, \"notifyCustomer\": true, \"transportType\": \"AIR\", \"temperature\": { \"min\": -20, \"max\": -10 } }"

  echo $SHIPMENT
  amqp-publish --server="${RABBITMQ_HOST}" --username="guest" --password="guest" --port=5672 --exchange="amq.fanout" --routing-key="shipment" --body="$SHIPMENT"
  sleep ${PUBLISH_FREQUENCY}
done
