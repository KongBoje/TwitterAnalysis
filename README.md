# TwitterAnalysis
## Setup in Docker:
1. docker run --rm -v $(pwd)/data:/data/db --publish=27017:27017 --name dbms -d mongo:latest
2. docker exec -it {id fra sidste kommando} bash
3. apt-get update
4. apt-get install -y wget
5. apt-get install -y unzip
6. apt-get install -y git
7. apt-get install -y default-jdk
8. apt-get install -y maven
9. wget http://cs.stanford.edu/people/alecmgo/trainingandtestdata.zip
10. unzip trainingandtestdata.zip
11. sed -i '1s;^;polarity,id,date,query,user,text\n;' training.1600000.processed.noemoticon.csv
12. mongoimport --drop --db social_net --collection tweets --type csv --headerline --file training.1600000.processed.noemoticon.csv
13. git clone https://github.com/KongBoje/TwitterAnalysis && cd TwitterAnalysis

run it by using the command:
mvn exec:java -Dexec.args="{Kommando}"

Replace "{Kommando}" with either one of the following command:
*TotalAmount
*Top10Linkers
*Top5Mentioned
*Top10Active
*Top5Negative
*Top5Positive
