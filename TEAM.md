# IDE  

Code format -> Ctrl-Schift-F  
Import organizing -> Ctrl-Shift-O

# Environments  

- JUnit testing
- Constructor in Java

# Organization setup

# Learning
- TLS  
	- [JCrypTool](https://www.cryptool.org/de/jct/)  
- OpenSSL  
	- [OpenSSL manpage](https://linux.die.net/man/1/openssl)  
- Git  
	- `C:\Program Files\Git\usr\bin` should exists on system  
	- [Git](https://git-scm.com/downloads)  
- sBOM
	- [CycloneDX](https://github.com/CycloneDX/cyclonedx-maven-plugin)  

# Targets
	- TLS Fuzzer
	- white hacking technologies
	- find implementation errors in TLS

# Maven

`mvn clean install` - refresh project  
`mvn org.cyclonedx:cyclonedx-maven-plugin:makeAggregateBom` - generate sBOM  
`mvn package` - create jar