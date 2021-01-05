# job-management
job-management

##Configuration of Job and Prepare & Lunch Job based on parameters
The Current Job is simple and basic, It can be extended eventually depending on requirement, 
like multiple requirement order & Payment processing, scheduled and Rest based triggering 
considering the factors 

## Job start/restart time improvement
## Job Hierarchy
## JobInstance
## JobParameters
## JobExecution
## Steps & StepExecution
## JobRepository
## JobLauncher
## Restartability
## Intercepting Job Execution
## JobParametersValidator
## Transaction Configuration for the JobRepository
## Running Jobs from within a Web Container

### Batch Processing Strategies
Concurrent batch or on-line processing 
Parallel Processing
Partitioning
Partitioning Approaches
Fixed and Even Break-Up of Record Set
Break up by a Key Column
Breakup by Views
Addition of a Processing Indicator
Extract Table to a Flat File
Use of a Hashing Column

# Minimizing Deadlocks
When applications run in parallel or are partitioned, contention in database resources and deadlocks may occur. It is critical that the database design team eliminates potential contention situations as much as possible as part of the database design.
Also, the developers must ensure that the database index tables are designed with deadlock prevention and performance in mind.
To minimize the impact of conflicts on data, the architecture should provide services such as wait-and-retry intervals when attaching to a database or when encountering a deadlock. This means a built-in mechanism to react to certain database return codes and, instead of issuing an immediate error, waiting a predetermined amount of time and retrying the database operation.
