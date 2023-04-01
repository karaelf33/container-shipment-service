#!/bin/bash

#while :
#do
  SHIPMENT="{
      \"shipmentId\": $(date +%s),
      \"origin\": \"Frankfurt\",
      \"destination\" : \"Hamburg\",
      \"customerId\": \"customer$((1000 + $RANDOM % 10))\",
      \"createdDate\": $(date +%s),
      \"fragile\": true,
      \"notifyCustomer\": true,
      \"transportType\": \"AIR\",
      \"temperature\": {
          \"min\": -20,
          \"max\": -10
      }
  }"
  echo $SHIPMENT
#	amqp-publish --server="${RABBITMQ_HOST}" --username="kn" --password="kn" --port=5672 --exchange="amq.fanout" --routing-key="shipment" --body="$SHIPMENT"
#	sleep ${PUBLISH_FREQUENCY}
#done

