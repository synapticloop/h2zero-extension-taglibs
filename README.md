 <a name="#documentr_top"></a>

> **This project requires JVM version of at least 1.7**






<a name="documentr_heading_0"></a>

# h2zero-extension-taglibs <sup><sup>[top](documentr_top)</sup></sup>



> Taglib extension for h2zero






<a name="documentr_heading_1"></a>

# Table of Contents <sup><sup>[top](documentr_top)</sup></sup>



 - [h2zero-extension-taglibs](#documentr_heading_0)
 - [Table of Contents](#documentr_heading_1)
 - [Building the Package](#documentr_heading_2)
   - [*NIX/Mac OS X](#documentr_heading_3)
   - [Windows](#documentr_heading_4)
 - [Running the Tests](#documentr_heading_5)
   - [*NIX/Mac OS X](#documentr_heading_6)
   - [Windows](#documentr_heading_7)
   - [Dependencies - Gradle](#documentr_heading_8)
   - [Dependencies - Maven](#documentr_heading_9)
   - [Dependencies - Downloads](#documentr_heading_10)






<a name="documentr_heading_2"></a>

# Building the Package <sup><sup>[top](documentr_top)</sup></sup>



<a name="documentr_heading_3"></a>

## *NIX/Mac OS X <sup><sup>[top](documentr_top)</sup></sup>

From the root of the project, simply run

`./gradlew build`




<a name="documentr_heading_4"></a>

## Windows <sup><sup>[top](documentr_top)</sup></sup>

`./gradlew.bat build`


This will compile and assemble the artefacts into the `build/libs/` directory.

Note that this may also run tests (if applicable see the Testing notes)



<a name="documentr_heading_5"></a>

# Running the Tests <sup><sup>[top](documentr_top)</sup></sup>



<a name="documentr_heading_6"></a>

## *NIX/Mac OS X <sup><sup>[top](documentr_top)</sup></sup>

From the root of the project, simply run

`gradle --info test`

if you do not have gradle installed, try:

`gradlew --info test`



<a name="documentr_heading_7"></a>

## Windows <sup><sup>[top](documentr_top)</sup></sup>

From the root of the project, simply run

`gradle --info test`

if you do not have gradle installed, try:

`./gradlew.bat --info test`


The `--info` switch will also output logging for the tests



<a name="documentr_heading_8"></a>

## Dependencies - Gradle <sup><sup>[top](documentr_top)</sup></sup>



```
dependencies {
	runtime(group: 'synapticloop', name: 'h2zero-extension-taglibs', version: '1.3.0', ext: 'jar')

	compile(group: 'synapticloop', name: 'h2zero-extension-taglibs', version: '1.3.0', ext: 'jar')
}
```



or, more simply for versions of gradle greater than 2.1



```
dependencies {
	runtime 'synapticloop:h2zero-extension-taglibs:1.3.0'

	compile 'synapticloop:h2zero-extension-taglibs:1.3.0'
}
```





<a name="documentr_heading_9"></a>

## Dependencies - Maven <sup><sup>[top](documentr_top)</sup></sup>



```
<dependency>
	<groupId>synapticloop</groupId>
	<artifactId>h2zero-extension-taglibs</artifactId>
	<version>1.3.0</version>
	<type>jar</type>
</dependency>
```





<a name="documentr_heading_10"></a>

## Dependencies - Downloads <sup><sup>[top](documentr_top)</sup></sup>


You will also need to download the following dependencies:



### cobertura dependencies

  - `net.sourceforge.cobertura:cobertura:2.1.1`: (It may be available on one of: [bintray](https://bintray.com/net.sourceforge.cobertura/maven/cobertura/2.1.1/view#files/net.sourceforge.cobertura/cobertura/2.1.1) [mvn central](http://search.maven.org/#artifactdetails|net.sourceforge.cobertura|cobertura|2.1.1|jar))


### compile dependencies

  - `synapticloop:h2zero:3.1.6`: (It may be available on one of: [bintray](https://bintray.com/synapticloop/maven/h2zero/3.1.6/view#files/synapticloop/h2zero/3.1.6) [mvn central](http://search.maven.org/#artifactdetails|synapticloop|h2zero|3.1.6|jar))
  - `javax.servlet.jsp:jsp-api:2.2`: (It may be available on one of: [bintray](https://bintray.com/javax.servlet.jsp/maven/jsp-api/2.2/view#files/javax.servlet.jsp/jsp-api/2.2) [mvn central](http://search.maven.org/#artifactdetails|javax.servlet.jsp|jsp-api|2.2|jar))
  - `javax.servlet:javax.servlet-api:3.1.0`: (It may be available on one of: [bintray](https://bintray.com/javax.servlet/maven/javax.servlet-api/3.1.0/view#files/javax.servlet/javax.servlet-api/3.1.0) [mvn central](http://search.maven.org/#artifactdetails|javax.servlet|javax.servlet-api|3.1.0|jar))


### runtime dependencies

  - `synapticloop:h2zero:3.1.6`: (It may be available on one of: [bintray](https://bintray.com/synapticloop/maven/h2zero/3.1.6/view#files/synapticloop/h2zero/3.1.6) [mvn central](http://search.maven.org/#artifactdetails|synapticloop|h2zero|3.1.6|jar))
  - `javax.servlet.jsp:jsp-api:2.2`: (It may be available on one of: [bintray](https://bintray.com/javax.servlet.jsp/maven/jsp-api/2.2/view#files/javax.servlet.jsp/jsp-api/2.2) [mvn central](http://search.maven.org/#artifactdetails|javax.servlet.jsp|jsp-api|2.2|jar))
  - `javax.servlet:javax.servlet-api:3.1.0`: (It may be available on one of: [bintray](https://bintray.com/javax.servlet/maven/javax.servlet-api/3.1.0/view#files/javax.servlet/javax.servlet-api/3.1.0) [mvn central](http://search.maven.org/#artifactdetails|javax.servlet|javax.servlet-api|3.1.0|jar))


### testCompile dependencies

  - `junit:junit:4.12`: (It may be available on one of: [bintray](https://bintray.com/junit/maven/junit/4.12/view#files/junit/junit/4.12) [mvn central](http://search.maven.org/#artifactdetails|junit|junit|4.12|jar))
  - `org.mockito:mockito-all:1.10.19`: (It may be available on one of: [bintray](https://bintray.com/org.mockito/maven/mockito-all/1.10.19/view#files/org.mockito/mockito-all/1.10.19) [mvn central](http://search.maven.org/#artifactdetails|org.mockito|mockito-all|1.10.19|jar))
  - `com.github.stefanbirkner:system-rules:1.16.1`: (It may be available on one of: [bintray](https://bintray.com/com.github.stefanbirkner/maven/system-rules/1.16.1/view#files/com.github.stefanbirkner/system-rules/1.16.1) [mvn central](http://search.maven.org/#artifactdetails|com.github.stefanbirkner|system-rules|1.16.1|jar))
  - `commons-io:commons-io:2.5`: (It may be available on one of: [bintray](https://bintray.com/commons-io/maven/commons-io/2.5/view#files/commons-io/commons-io/2.5) [mvn central](http://search.maven.org/#artifactdetails|commons-io|commons-io|2.5|jar))
  - `com.mashape.unirest:unirest-java:1.4.9`: (It may be available on one of: [bintray](https://bintray.com/com.mashape.unirest/maven/unirest-java/1.4.9/view#files/com.mashape.unirest/unirest-java/1.4.9) [mvn central](http://search.maven.org/#artifactdetails|com.mashape.unirest|unirest-java|1.4.9|jar))


### testRuntime dependencies

  - `junit:junit:4.12`: (It may be available on one of: [bintray](https://bintray.com/junit/maven/junit/4.12/view#files/junit/junit/4.12) [mvn central](http://search.maven.org/#artifactdetails|junit|junit|4.12|jar))
  - `org.mockito:mockito-all:1.10.19`: (It may be available on one of: [bintray](https://bintray.com/org.mockito/maven/mockito-all/1.10.19/view#files/org.mockito/mockito-all/1.10.19) [mvn central](http://search.maven.org/#artifactdetails|org.mockito|mockito-all|1.10.19|jar))
  - `com.github.stefanbirkner:system-rules:1.16.1`: (It may be available on one of: [bintray](https://bintray.com/com.github.stefanbirkner/maven/system-rules/1.16.1/view#files/com.github.stefanbirkner/system-rules/1.16.1) [mvn central](http://search.maven.org/#artifactdetails|com.github.stefanbirkner|system-rules|1.16.1|jar))
  - `mysql:mysql-connector-java:6.0.6`: (It may be available on one of: [bintray](https://bintray.com/mysql/maven/mysql-connector-java/6.0.6/view#files/mysql/mysql-connector-java/6.0.6) [mvn central](http://search.maven.org/#artifactdetails|mysql|mysql-connector-java|6.0.6|jar))
  - `org.xerial:sqlite-jdbc:3.21.0.1`: (It may be available on one of: [bintray](https://bintray.com/org.xerial/maven/sqlite-jdbc/3.21.0.1/view#files/org.xerial/sqlite-jdbc/3.21.0.1) [mvn central](http://search.maven.org/#artifactdetails|org.xerial|sqlite-jdbc|3.21.0.1|jar))
  - `commons-io:commons-io:2.5`: (It may be available on one of: [bintray](https://bintray.com/commons-io/maven/commons-io/2.5/view#files/commons-io/commons-io/2.5) [mvn central](http://search.maven.org/#artifactdetails|commons-io|commons-io|2.5|jar))
  - `com.mashape.unirest:unirest-java:1.4.9`: (It may be available on one of: [bintray](https://bintray.com/com.mashape.unirest/maven/unirest-java/1.4.9/view#files/com.mashape.unirest/unirest-java/1.4.9) [mvn central](http://search.maven.org/#artifactdetails|com.mashape.unirest|unirest-java|1.4.9|jar))

**NOTE:** You may need to download any dependencies of the above dependencies in turn (i.e. the transitive dependencies)

--

> `This README.md file was hand-crafted with care utilising synapticloop`[`templar`](https://github.com/synapticloop/templar/)`->`[`documentr`](https://github.com/synapticloop/documentr/)

--
