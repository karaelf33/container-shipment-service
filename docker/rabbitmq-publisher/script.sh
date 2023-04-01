#!/bin/bash

while true; do
    SHIPMENT="{\"shipmentId\": $(date +%s%N), \"origin\": \"Frankfurt\", \"destination\": \"Hamburg\", \"customerId\": \"customer$RANDOM\", \"createdDate\": $(date +%s%N), \"fragile\": true, \"notifyCustomer\": true, \"transportType\": \"AIR\", \"temperature\": { \"min\": -20, \"max\": -10 } }"
    echo $SHIPMENT
    amqp-publish --server="rabbitmq" --username="yusufbestas" --password="1234" --port=5672 --exchange="amq.fanout" --routing-key="shipment" --body="$SHIPMENT"
    sleep $PUBLISH_FREQUENCY
done
