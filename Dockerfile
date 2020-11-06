# Start with a base image containing Java runtime
FROM openjdk

#Make /home/app as our working directory
WORKDIR /home/app/

#Copy all files and folders to the docker image
COPY . /home/app

# Add the application's jar to the container
ADD build/libs/word-trainer-0.0.1-SNAPSHOT.jar /home/app/word-trainer.jar

#When the docker image is run, that will call this entrypoint command and executes the JAR file.
ENTRYPOINT [ "sh", "-c", "java -Xmx2000m -jar /home/app/word-trainer.jar" ]
