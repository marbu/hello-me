# Hello for Java ME

This is just a simple hello world Java ME application.

## Development

To build the midlet via [maven](http://maven.apache.org/), run:

	$ cd ~/projects/hello-me
	$ mvn clean package

This default build uses Microemulator API implementation to simplify the build
process, but it's only MIDP-2.0 implementation.

### How to run it in the Microemulator

Just use `exec:java` goal after you've successfully built the project:

	$ mvn exec:java

## Acknowledgement

Project structure, maven build configuration and other Java plumbing related
details (including build instructions in this README file) are based on code of
[topt-me](https://github.com/kwart/totp-me) project.

## License

Distributed under the terms of the
[Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
