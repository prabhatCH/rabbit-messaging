# rabbit-messaging
A test Repo to test different kinds of exchanges and messaging strategies with RabbitMQ and Spring

The app contains two profiles. "receiver" and "sender"
Deploy the same code with these profiles to demonstrate the producer consumer behaviour.

Just set the profile while deploying the app as `-Dspring.profiles.active=receiver`

Receiver gets deployed at port 8181
Sender gets deployed at the default port 8080

APIs to send the message are:
http://localhost:8080/send/{routingKey}/direct
http://localhost:8080/send/{routingKey}/topic
http://localhost:8080/send/fanout

All APIs are POST calls, accepting `application/json` type of body.

The app uses default rabbit exchanges - `amq.direct`, `amq.fanout`, `amq.topic`

Find the various bindings of the queues in the code.
