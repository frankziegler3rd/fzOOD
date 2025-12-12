# Frank Ziegler OOD Final Exam
## To compile and run

In root directory:
- To compile run the command: `javac -cp lib/json.jar -d out Main.java model/*.java service/*.java`
- To execute run the command: `java -cp out:lib/json.jar Main`
## Design Choices and UML
### Template Method Design Pattern

Assignment prompt states:
"3. Please use the template method (behavior design pattern) to read the data in from XML and JSON (so a total of 4 subclasses)."

I designed one abstract class `ChartGetter` with the following:
- `fetch`: the template method, calls the below three methods in succession which grabs the data from the data source and converts it from raw string data to a generic `ChartCollection`
- `download`: saves the data source text as a raw string
- `abstract parse`: implemented by subclasses to parse the raw text into XML or JSON
- `abstract extract`: implemented by subclasses to extract the XML or JSON into the appropriate collection

With four subclasses: 
1. Fetcher for the top 100 songs in XML
2. Fetcher for the top 100 songs in JSON
3. Fetcher for the top 25 albums in XML
4. Fetcher for the top 25 albums in JSON

This should appropriately follow the template method. 

### Iterator Design Pattern

Assignment prompt states:
"4. Please use the iterator method (behavior design pattern) to create collections for the top 100 songs and top 25 albums from step 3."

I designed two interfaces:
1. `ChartCollection` with a single function `iterator` that returns a `ChartIterator`
2. `ChartIterator` with two functions: `hasNext` and `next`

With four implementing subclasses:
1. `AlbumCollection` which implements `ChartCollection`
2. `SongCollection` which implements `ChartCollection`
3. `AlbumsIterator` that implements `ChartIterator` and iterates over the `AlbumCollection`
4. `SongsIterator` that implements `ChartIterator` and iterates over the `SongCollection`

These iterators allow the client to traverse the collections (and are one-to-one with the collections, though this may not be necessary) without exposing the underlying implementation of the collections, which is the point of the Iterator pattern.

### UML Diagram
![Final Exam UML Diagram](UML%20Diagram/Frank%20Ziegler%20Final%20Exam%20UML.svg)
#### Explanation

These two patterns actually very seamlessly work in tandem. The Template Method is responsible for grabbing the data, cleaning it, and converting into the collections, which store the data iterable by the implemented iterators. So, `ChartGetter` makes a `ChartCollection` which is iterable by `ChartIterator`. To be more accurate:
- `XMLSongsGetter`/`JSONSongsGetter` make a `SongCollection` which is iterable by `SongsIterator`
- `XMLAlbumsGetter`/`JSONAlbumsGetter` make an `AlbumCollection` which is iterable by `AlbumsIterator`

This is because song fetchers can't make album collections, and vice versa. 

## Miscellaneous
### Packages

To parse XML, I used `DocumentBuilderFactory` and `DocumentBuilder`. These are XML parsing tools in the JDK. To parse JSON, I used `JSONObject` and `JSONArray` from `org.json`, which needed to be downloaded and is part of the `lib/` directory. 
### Output

To format the table output, I used `System.out.format` and formatting patterns. They internally call Java's `Formatter`. 
### Structure

I structured this repository like a typical backend.
- `service/` contains fetcher classes, collection classes, and iterator classes.
- `model/` contains entity classes `Song` and `Album`.
- The `Main` class is in the root directory.
- Two sample runs in `SampleRunBasic.txt` and `SampleRunWithCustomParams.txt`
- The UML diagram is inserted above and all the source files are in the `UML Diagram/` directory.
### Extra

The assignment prompt was:
"2. Your goal is to produce two charts (text format is fine) of the following:
- chart 1: top 10 songs, artist name and their album name
- chart 2: top 10 albums, each listing out the songs from the top 100 songs"

The first prompt the user gets when running this application asks whether or not they want to customize these numbers. If they choose no, then the application prints these charts to the spec listed above. Otherwise, each print requires the user to choose how many songs they want printed or how many albums they want printed (and how many songs per album). 

This was not a requirement by the assignment, but I wanted to test the chart formatting to its limits so I designed this mechanism.

Thanks for a great semester!
