# TwitterAnalysis
## Setup in Docker:
1. `docker run --rm -v $(pwd)/data:/data/db --publish=27017:27017 --name dbms -d mongo:latest`
2. `docker exec -it {id fra sidste kommando} bash`
3. `apt-get update`
4. `apt-get install -y wget`
5. `apt-get install -y unzip`
6. `apt-get install -y git`
7. `apt-get install -y default-jdk`
8. `apt-get install -y maven`
9. `wget http://cs.stanford.edu/people/alecmgo/trainingandtestdata.zip`
10. `unzip trainingandtestdata.zip`
11. `sed -i '1s;^;polarity,id,date,query,user,text\n;' training.1600000.processed.noemoticon.csv`
12. `mongoimport --drop --db social_net --collection tweets --type csv --headerline --file training.1600000.processed.noemoticon.csv`
13. `git clone https://github.com/KongBoje/TwitterAnalysis && cd TwitterAnalysis`

## Setup for local machine:
1. `download the zip file from: - http://cs.stanford.edu/people/alecmgo/trainingandtestdata.zip`
4. `manually unzip trainingandtestdata.zip`
5. `Open terminal on the unzipped trainingandtestdata.zip fil`
6. `Write: - sed -i '1s;^;polarity,id,date,query,user,text\n;' training.1600000.processed.noemoticon.csv`
7. `import it: - mongoimport --drop --db social_net --collection tweets --type csv --headerline --file training.1600000.processed.noemoticon.csv`
8. `Clone the project: - git clone https://github.com/KongBoje/TwitterAnalysis && cd TwitterAnalysis`

run it by using the command:
- `mvn exec:java -Dexec.args="{Kommando}"`

Replace "{Kommando}" with one of the following commands:
- `TotalAmount`
- `Top10Linkers`
- `Top5Mentioned`
- `Top10Active`
- `Top5Negative`
- `Top5Positive`


## My results:
### How many Twitter users are in the database?
- `659774`

### Which Twitter users link the most to other Twitter users? (Provide the top ten.)
- `{ "_id" : "lost_dog" , "count" : 546}`
- `{ "_id" : "tweetpet" , "count" : 302}`
- `{ "_id" : "VioletsCRUK" , "count" : 251}`
- `{ "_id" : "what_bugs_u" , "count" : 244}`
- `{ "_id" : "SallytheShizzle" , "count" : 226}`
- `{ "_id" : "Karen230683" , "count" : 216}`
- `{ "_id" : "mcraddictal" , "count" : 214}`
- `{ "_id" : "keza34" , "count" : 211}`
- `{ "_id" : "TraceyHewins" , "count" : 202}`
- `{ "_id" : "DarkPiano" , "count" : 199}`

### Who are the most mentioned Twitter users? (Provide the top five.)
- `{ "_id" : "@mileycyrus" , "count" : 4310}`
- `{ "_id" : "@tommcfly" , "count" : 3837}`
- `{ "_id" : "@ddlovato" , "count" : 3349}`
- `{ "_id" : "@Jonasbrothers" , "count" : 1263}`
- `{ "_id" : "@DavidArchie" , "count" : 1222}`

### Who are the most active Twitter users (top ten)?
- `{ "_id" : "lost_dog" , "count" : 549}`
- `{ "_id" : "webwoke" , "count" : 345}`
- `{ "_id" : "tweetpet" , "count" : 310}`
- `{ "_id" : "SallytheShizzle" , "count" : 281}`
- `{ "_id" : "VioletsCRUK" , "count" : 279}`
- `{ "_id" : "mcraddictal" , "count" : 276}`
- `{ "_id" : "tsarnick" , "count" : 248}`
- `{ "_id" : "what_bugs_u" , "count" : 246}`
- `{ "_id" : "Karen230683" , "count" : 238}`
- `{ "_id" : "DarkPiano" , "count" : 236}`

### Who are the five most grumpy (most negative tweets)
- `{ "_id" : "lost_dog" , "count" : 549}`
- `{ "_id" : "tweetpet" , "count" : 310}`
- `{ "_id" : "webwoke" , "count" : 264}`
- `{ "_id" : "mcraddictal" , "count" : 210}`
- `{ "_id" : "wowlew" , "count" : 210}`

### Who are the five most happy (most poitive tweets)
- `{ "_id" : "what_bugs_u" , "count" : 246}`
- `{ "_id" : "DarkPiano" , "count" : 231}`
- `{ "_id" : "VioletsCRUK" , "count" : 218}`
- `{ "_id" : "tsarnick" , "count" : 212}`
- `{ "_id" : "keza34" , "count" : 211}`
