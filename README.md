## Circuit Breaker Pattern

The circuit breaker pattern is a design pattern used to enhance the resilience of a system. It is based on the idea of disabling a service or component to prevent further load when it is experiencing continuous failures.

### How It Works

1. **Monitoring**: The circuit breaker continuously monitors the failure rate of a service. If a certain number of failures occur within a specified time frame, the circuit breaker is triggered.

2. **Open State**: When failures exceed a certain threshold, the circuit breaker transitions to the "open" state. In this state, requests are returned with an error and do not reach the underlying service.

3. **Half-Open State**: After a defined period, the circuit breaker enters the "half-open" state. At this stage, a limited number of requests are allowed to pass through to the service. If these requests succeed, the circuit breaker returns to the "closed" state and the system resumes normal operation. If failures continue, the circuit breaker reverts to the "open" state.

### Advantages

- **Resource Management**: Instead of continuously sending requests to a failing service, resources can be utilized more efficiently.
- **System Resilience**: Failures in one service can be contained without affecting other components.
- **Error Management**: It provides a more controlled error management approach, returning immediate errors instead of overwhelming the user.

### Use Cases

- Microservices architectures
- Distributed systems
- API integrations


Sure! Here’s the information translated into English and formatted in Markdown:


## Resilience4j Circuit Breaker Configuration Settings

### 1. `slidingWindowSize`
- **Description**: This setting determines the total number of calls that the Circuit Breaker will use to calculate the failure rate. It considers the most recent `slidingWindowSize` calls to assess the failure rate.
- **Example**: When set to `10`, it looks at the last 10 calls to determine the failure rate.

### 2. `permittedNumberOfCallsInHalfOpenState`
- **Description**: When the Circuit Breaker is in a "half-open" state, it allows a certain number of requests to be routed to the service. This is used to check whether the service has recovered.
- **Example**: When set to `5`, a maximum of 5 requests will be sent while in the half-open state.

### 3. `minimumNumberOfCalls`
- **Description**: This setting specifies the minimum number of calls required to calculate the failure rate. It is the minimum number of calls that must be collected within a certain period. If this number is not met, the failure rate will not be calculated.
- **Example**: When set to `5`, the failure rate will not be calculated unless at least 5 calls have been made.

### 4. `waitDurationInOpenState`
- **Description**: This setting defines the duration the Circuit Breaker should wait while in the open state. After this duration, the Circuit Breaker transitions to the half-open state and sends a certain number of requests to check the service again.
- **Example**: When set to `10000ms`, it will wait for 10 seconds before transitioning to the half-open state.

### 5. `failureRateThreshold`
- **Description**: This is the threshold used to determine the failure rate. If the failure rate of the requests exceeds this threshold, the Circuit Breaker will transition to the open state.
- **Example**: When set to `50`, if more than 50% of the requests fail, the Circuit Breaker will open.


