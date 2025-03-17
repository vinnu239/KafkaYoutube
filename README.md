# KafkaYoutube
Kafka realtime wikimedia stream of data

/// Kafka///

Event-driven architecture (EDA) is a design pattern in software architecture where the flow of the program is determined by events. These events can be anything from user actions, sensor outputs, or messages from other programs.

 **Serialization**
Serialization is the process of converting an object into a byte stream. This byte stream can then be transmitted over a network or stored in a file or database. In Kafka, serialization is used to convert the key and value of a message into a byte stream before sending it to a Kafka topic.

**Deserialization**
Deserialization is the reverse process of serialization. It involves converting a byte stream back into an object. In Kafka, deserialization is used to convert the byte stream received from a Kafka topic back into a key and value that can be processed by the consumer application.

KafkaTemplate is a key component in the Spring Kafka library, designed to simplify the interaction with Apache Kafka.
EventSource library which is use to process the real time events example like newsfeed,livestrem etc.

**EventSource**
Purpose: EventSource is a web API that allows servers to push updates to the client in real-time. It is used for server-sent events (SSE), where the server sends updates to the client over a single, long-lived HTTP connection.
Usage: Typically used in web applications to receive real-time updates from the server.
Example: Receiving live updates for a news feed or stock ticker in a web browser.
Threading: Runs on the main thread, which can be a limitation if you need to handle events in the background.

**EventHandler**
Purpose: EventHandler is a delegate in .NET that defines a method signature for handling events. It specifies the method that will be called when an event is raised.
Usage: Used in scenarios where you need to handle specific events within an application, such as button clicks, form submissions, or custom events in a desktop application.
Example: Handling a button click event in a Windows Forms application to perform an action like saving data or updating the UI.

**Difference between Eventsourcing and Websockets?**

EventSourcing: it is the unidirection flow of data
Websockets: bidirectional

Jackson core and Jackson bind : These dependecnies are helpful to read and write the JSON data and bind help us to convert JSON to java(POJO) object.

**Producers --> Topics --> Partitions --> Brokers --> Cluster --> ZooKeeper/KRaft --> Consumers

    |            |            |            |            |            |            |
    v            v            v            v            v            v            v    
  Send         Organize      Subdivide     Store &     Group &     Manage        Read
 Messages      Messages      Messages      Manage     Coordinate  Metadata     Messages**

Kafka Connect <--> External Systems
Kafka Streams <--> Stream Processing
Schema Registry <--> Schema Management
Offsets <--> Track Message Position
Detailed Flow with Clusters

**Producers**:

Send messages to Kafka topics.
Messages are assigned to specific partitions within the topics.

**Topics**:
Assume as a folder or a DB only difference is by querying we cant get the data
Logical channels that organize messages.
Each topic can have multiple partitions.
we can create n number of topics
and each topic must have the unique name

**Partitions**:

Subdivisions of topics that allow for parallel processing.
Each partition is an ordered sequence of messages with unique offsets.

**Offsets**:
Offset is a sequence of ids given to messages as the arrive at a partition.
Unique identifiers for each message within a partition.Once it assigned it will never be changed.
Used by consumers to track which messages have been processed.
Consumers commit offsets to Kafka to ensure reliable message processing.
The first message gets an offset zero and the next message receives an offset one and so on

**Brokers**:
Role: Brokers are responsible for storing and managing the data within topics and partitions.
Function: They handle the creation, deletion, and maintenance of topics and partitions. Brokers also manage the replication of partitions to ensure fault tolerance.
Store and manage messages in partitions.
Handle replication of messages for fault tolerance.
Serve requests from producers and consumers.

**Cluster**:
Role: The Kafka cluster, which is a group of brokers, collectively manages the distribution and redundancy of topics and partitions.
Function: The cluster ensures that data is evenly distributed across brokers and that partitions are replicated to provide high availability and fault tolerance.
Group of brokers working together to manage and distribute data.
Ensures data is evenly distributed across brokers and provides redundancy.
Allows for horizontal scaling and high availability.

**ZooKeeper/KRaft**:

Manages metadata of the Kafka cluster.
Keeps track of broker information, topic configurations, and partition assignments.
Handles leader election for partitions and monitors cluster health.
ZooKeeper: Manages metadata, handles leader election, stores configuration, and monitors cluster health.
KRaft: Replaces ZooKeeper by integrating metadata management within Kafka, using a quorum-based consensus protocol, simplifying the architecture, and improving scalability.

Admin Tools
Role: Kafka provides various administrative tools and APIs for managing topics and partitions.
Function: These tools allow administrators to create, delete, and configure topics and partitions. They also provide monitoring and management capabilities to ensure the health and performance of the Kafka cluster.

**Consumers**:

Subscribe to topics and read messages from partitions.
Use offsets to track which messages have been processed.
Commit offsets to Kafka to ensure reliable message processing.
Kafka Connect:

Integrates Kafka with external systems.
Uses connectors to stream data between Kafka and other data sources/sinks.
Kafka Streams:

Client library for building real-time stream processing applications.
Allows for transforming, aggregating, and analyzing data stored in Kafka topics.
Schema Registry:

Manages and enforces schemas for Kafka messages.
Ensures data consistency and compatibility across different systems.
Summary
Producers send messages to topics.
Messages are divided into partitions with unique offsets.
Brokers store and manage these messages.
Cluster groups brokers for data distribution and redundancy.
ZooKeeper/KRaft coordinates and manages the cluster's metadata.
Consumers read messages from partitions and use offsets to track their progress.
Kafka Connect integrates Kafka with external systems.
Kafka Streams enables real-time stream processing.
Schema Registry manages schemas for data consistency.
