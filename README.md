# JavaPlayground
A place where I can play with various coding problems and paradigms


_____________________________
TO RUN:

1. Open directory from command line
2. mvn exec:java

_____________________________
Some infrastructure design assumptions:

1. Each menu will specify a format that user input data should be in. If bad input is received, user will be re-prompted.
2. All methods and classes that receive data from the driver class in each package will assume user input is in said format, and will not receive data from outside of their package.